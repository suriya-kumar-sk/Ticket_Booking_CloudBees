package com.booking.controllers;

import com.booking.models.Receipt;
import com.booking.models.Seat;
import com.booking.models.User;
import com.booking.services.BookingService;
import com.booking.services.ReceiptService;
import com.booking.services.TrainService;
import com.booking.services.UserService;
import java.time.LocalDateTime;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class TicketBookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    ReceiptService receiptService;

    @Autowired
    UserService userService;

    @Autowired
    TrainService trainService;

    // Used to reserve seats for a particular screen
    @RequestMapping(method = RequestMethod.POST, value = "/reserve/ticket")
    public ResponseEntity reserveSeats(@RequestBody User user, @RequestBody String departure,
                                       @RequestBody String destination, @RequestBody LocalDateTime departureDate,
                                       @RequestBody LocalDateTime arrivalDate, @RequestBody Double price) {
        boolean reserved = bookingService.reserveSeats(user, departure, destination, departureDate, arrivalDate, price);
        if (reserved)
            return new ResponseEntity("All seats reserved successfully.", HttpStatus.OK);
        else
            return new ResponseEntity("Seats could not be reserved as some or all the seats specified by you were already reserved or not present.", HttpStatus.EXPECTATION_FAILED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/receipt/{userId}")
    public ResponseEntity getReceiptByUser(@PathVariable String userId) {
        Receipt receipt = receiptService.getReceiptByUser(userId);
        return new ResponseEntity(receipt, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/seats")
    public ResponseEntity getUsers() {
        Set<User> users = userService.getUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/remove/user/{userId}")
    public ResponseEntity removeUserFromTrain(@PathVariable String userId) {
        boolean removed = trainService.removeUserFromTrain(userId);
        return new ResponseEntity(removed, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/user/seats/{userId}")
    public ResponseEntity updateUserSeats(@PathVariable String userId, @RequestBody Set<Seat> seats) {
        boolean updated = userService.updateUserSeats(userId, seats);
        return new ResponseEntity(updated, HttpStatus.OK);
    }
}

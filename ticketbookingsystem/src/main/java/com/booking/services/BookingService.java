package com.booking.services;

import com.booking.models.Seat;
import com.booking.models.User;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    SeatsService seatsService;

    UserService userService;

    ReceiptService receiptService;

    TrainService trainService;

    public BookingService(SeatsService seatsService, UserService userService, ReceiptService receiptService, TrainService trainService) {
        this.seatsService = seatsService;
        this.userService = userService;
        this.receiptService = receiptService;
        this.trainService = trainService;
    }

    //reserves the seats specified by the user, false will be returned if the user wants to book a non-existent seat
    //or an already reserved seat, true is returned otherwise
    public boolean reserveSeats(User user, String departure, String destination,
                                LocalDateTime departureDate, LocalDateTime arrivalDate, Double price) {
        Map<String, Set<Seat>> availableSeatsBySeatNumber = trainService.getAvailableSeats(user.getTrainNumber());
        for (Seat seat : user.getSeats()) {
            if (!availableSeatsBySeatNumber.containsKey(seat.getSeatNumber())) {
                return false;
            }
        }

        seatsService.reserveSeats(user.getSeats());
        userService.saveUser(user);

        receiptService.saveReceipt(user, departure, destination, departureDate, arrivalDate, price);
        return true;
    }
}

package com.booking;

import com.booking.models.Receipt;
import com.booking.models.Seat;
import com.booking.models.Section;
import com.booking.models.Train;
import com.booking.models.User;
import com.booking.repository.ReceiptRepository;
import com.booking.repository.ReceiptRepositoryDao;
import com.booking.repository.SeatsRepository;
import com.booking.repository.SeatsRepositoryDao;
import com.booking.repository.TrainRepository;
import com.booking.repository.TrainRepositoryDao;
import com.booking.repository.UserRepository;
import com.booking.repository.UserRepositoryDao;
import com.booking.services.BookingService;
import com.booking.services.ReceiptService;
import com.booking.services.SeatsService;
import com.booking.services.TrainService;
import com.booking.services.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@SpringBootTest
public class TicketBookingServiceTests {

    private static LocalDateTime departureDate = LocalDateTime.of(LocalDate.of(2024, 1, 18), LocalTime.of(20, 30, 00));
    private static LocalDateTime arrivalDate = LocalDateTime.of(LocalDate.of(2024, 1, 18), LocalTime.of(21, 00, 00));
    private static String departure = "London";
    private static String arrival = "France";

    ReceiptRepository receiptRepository = new ReceiptRepositoryDao();
    SeatsRepository seatsRepository = new SeatsRepositoryDao();
    TrainRepository trainRepository = new TrainRepositoryDao();
    UserRepository userRepository = new UserRepositoryDao();

    SeatsService seatsService = new SeatsService(seatsRepository);
    ReceiptService receiptService = new ReceiptService(receiptRepository);
    UserService userService = new UserService(userRepository, seatsService);
    TrainService trainService = new TrainService(trainRepository, userRepository, seatsService, userService);
    BookingService bookingService = new BookingService(seatsService, userService, receiptService, trainService);

    @Test
    public void testAllCases() {
        trainService.addTrain(createTrain());
        seatsService.addSeats(createSeats());

        reserveSeatsTest();
        receiptOfUserTest();
        getAllUsersAndSeatsTest();
        updateUserSeat();
        removeUserFromTrainTest();
    }

    public void reserveSeatsTest() {
        User user = createUser();
        boolean reserved = bookingService.reserveSeats(user, departure, arrival, departureDate, arrivalDate, 5.00);
        Assert.assertTrue(reserved);
    }

    public void receiptOfUserTest() {
        Receipt receipt = receiptService.getReceiptByUser("userId1");
        Assert.assertNotNull(receipt);
        Assert.assertEquals("userId1", receipt.getUser().getId());
        Assert.assertEquals(departure, receipt.getDeparture());
        Assert.assertEquals(arrival, receipt.getDestination());
        Assert.assertEquals(departureDate, receipt.getDepartureDate());
        Assert.assertEquals(arrivalDate, receipt.getArrivalDate());
        Assert.assertEquals(Double.valueOf(5), receipt.getPrice());
    }

    public void getAllUsersAndSeatsTest() {
        Set<User> users = userService.getUsers();
        Assert.assertNotNull(users);
    }

    public void removeUserFromTrainTest() {
        boolean removed = trainService.removeUserFromTrain("userId1");
        User user = userService.getUserById("userId1");

        Seat seat1 = seatsService.getSeatById("seatIdB1");
        Seat seat2 = seatsService.getSeatById("seatIdB2");

        Assert.assertTrue(removed);
        Assert.assertNull(user);
        Assert.assertFalse(seat1.isReserved());
        Assert.assertFalse(seat2.isReserved());
    }

    public void updateUserSeat() {
        Set<Seat> seats = createSeatsToUpdate();
        userService.updateUserSeats("userId1", seats);

        User user = userService.getUserById("userId1");

        Map<String, Seat> map = user.getSeats().stream().collect(Collectors.toMap(Seat::getId, Function.identity()));
        Assert.assertEquals(map.get("seatIdB1").getSeatNumber(), "B1");
        Assert.assertEquals(map.get("seatIdB2").getSeatNumber(), "B2");
    }

    private User createUser() {
        User user = new User();
        user.setId("userId1");
        user.setFirstName("YYY");
        user.setLastName("ZZZ");
        user.setMailAddress("mail@com");
        user.setTrainNumber("PNR1234");
        user.setSeats(seatsOfUser());
        return user;
    }

    private Train createTrain() {
        Train train = new Train();
        train.setId("trainId1");
        train.setTrainNumber("PNR1234");
        train.setDeparture(departure);
        train.setDestination(arrival);
        train.setDepartureTime(departureDate);
        train.setArrivalTime(arrivalDate);
        Set<String> seatIds = new HashSet<>();
        seatIds.add("seatIdA1");
        seatIds.add("seatIdA2");
        seatIds.add("seatIdB1");
        seatIds.add("seatIdB2");
        train.setSeatsIds(seatIds);
        return train;
    }

    private Set<Seat> createSeats() {
        Seat seat1 = new Seat("seatIdA1", "A1", false, Section.A);
        Seat seat2 = new Seat("seatIdA2", "A2", false, Section.A);

        Seat seat3 = new Seat("seatIdB1", "B1", false, Section.B);
        Seat seat4 = new Seat("seatIdB2", "B2", false, Section.B);
        Set<Seat> seats = new HashSet<>();
        seats.add(seat1);
        seats.add(seat2);
        seats.add(seat3);
        seats.add(seat4);
        return seats;
    }

    private Set<Seat> createSeatsToUpdate() {
        Seat seat1 = new Seat("seatIdB1", "B1", false, Section.B);
        Seat seat2 = new Seat("seatIdB2", "B2", false, Section.B);
        Set<Seat> seats = new HashSet<>();

        seats.add(seat1);
        seats.add(seat2);
        return seats;
    }

    private Set<Seat> seatsOfUser() {
        Seat seat1 = new Seat("seatIdA1", "A1", false, Section.A);
        Seat seat2 = new Seat("seatIdA2", "A2", false, Section.A);

        Set<Seat> seats = new HashSet<>();
        seats.add(seat1);
        seats.add(seat2);
        return seats;
    }
}

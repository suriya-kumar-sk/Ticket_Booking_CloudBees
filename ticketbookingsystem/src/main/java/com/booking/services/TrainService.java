package com.booking.services;

import com.booking.models.Seat;
import com.booking.models.Train;
import com.booking.models.User;
import com.booking.repository.TrainRepository;
import com.booking.repository.UserRepository;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    TrainRepository trainRepository;

    UserRepository userRepository;

    SeatsService seatsService;

    UserService userService;

    public TrainService(TrainRepository trainRepository, UserRepository userRepository, SeatsService seatsService, UserService userService) {
        this.trainRepository = trainRepository;
        this.userRepository = userRepository;
        this.seatsService = seatsService;
        this.userService = userService;
    }

    public boolean removeUserFromTrain(String userId) {
        User user = userRepository.getUserById(userId);
        seatsService.unReserveSeats(user.getSeats());
        return userService.removeUserById(user.getId());
    }

    public Map<String, Set<Seat>> getAvailableSeats(String trainNumber) {
        Train train = trainRepository.getTrainByNumber(trainNumber);
        Set<Seat> seats = seatsService.getSeatsByIds(train.getSeatsIds());
        Map<String, Set<Seat>> availableSeatsBySeatNumber = seats.
                stream().
                filter(seat -> !seat.isReserved()).
                collect(Collectors.groupingBy(Seat::getSeatNumber, Collectors.toSet()));
        return availableSeatsBySeatNumber;
    }

    public boolean addTrain(Train train) {
        return trainRepository.addTrain(train);
    }
}

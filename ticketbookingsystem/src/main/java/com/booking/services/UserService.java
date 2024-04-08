package com.booking.services;

import com.booking.models.Seat;
import com.booking.models.User;
import com.booking.repository.UserRepository;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    SeatsService seatsService;

    public UserService(UserRepository userRepository, SeatsService seatsService) {
        this.userRepository = userRepository;
        this.seatsService = seatsService;
    }

    public Set<User> getUsers() {
        return userRepository.getAllUsers();
    }

    public boolean saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public boolean removeUser(User user) {
        return userRepository.removeUser(user);
    }

    public boolean removeUserById(String userId) {
        return userRepository.removeUserById(userId);
    }

    public boolean updateUserSeats(String userId, Set<Seat> seats) {
        User user = userRepository.getUserById(userId);
        seatsService.unReserveSeats(user.getSeats());
        seatsService.reserveSeats(seats);

        user.setSeats(seats);
        return userRepository.updateUserSeats(user);
    }

    public User getUserById(String userId) {
        return userRepository.getUserById(userId);
    }
}

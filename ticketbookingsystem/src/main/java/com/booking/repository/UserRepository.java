package com.booking.repository;

import com.booking.models.User;
import java.util.Set;


public interface UserRepository {
    boolean saveUser(User user);
    User getUserById(String userId);
    Set<User> getAllUsers();
    boolean removeUser(User user);
    boolean removeUserById(String userId);
    boolean updateUserSeats(User user);
}

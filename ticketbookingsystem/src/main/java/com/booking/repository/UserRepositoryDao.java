package com.booking.repository;

import com.booking.models.User;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryDao implements UserRepository {
    Set<User> userSet = new HashSet<>();

    @Override
    public boolean saveUser(User user) {
        return userSet.add(user);
    }

    @Override
    public User getUserById(String userId) {
        return userSet.
                stream().
                filter(user -> user.getId().equals(userId)).
                findFirst().orElse(null);
    }

    @Override
    public Set<User> getAllUsers() {
        return userSet;
    }

    @Override
    public boolean removeUser(User user) {
        return userSet.remove(user);
    }

    @Override
    public boolean removeUserById(String userId) {
        for (User user : userSet) {
            if (user.getId().equals(userId)) {
                return userSet.remove(user);
            }
        }
        return false;
    }

    @Override
    public boolean updateUserSeats(User user) {
        for (User user1 : userSet) {
            if (user1.getId().equals(user.getId())) {
                userSet.remove(user);
                return userSet.add(user);
            }
        }
        return false;
    }
}

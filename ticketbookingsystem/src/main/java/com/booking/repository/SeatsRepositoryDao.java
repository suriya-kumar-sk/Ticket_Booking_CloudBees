package com.booking.repository;

import com.booking.models.Seat;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class SeatsRepositoryDao implements SeatsRepository {
    Set<Seat> seatSet = new HashSet<>();

    @Override
    public boolean updateSeats(Set<Seat> seats) {
        for (Seat seat : seats) {
            removeSeatById(seat.getId());
            addSeat(seat);
        }
        return true;
    }

    @Override
    public Set<Seat> getSeatsByIds(Set<String> seatsIds) {
        return seatSet.
                stream().
                filter(seat -> seatsIds.contains(seat.getId())).
                collect(Collectors.toSet());
    }

    @Override
    public Seat getSeatById(String seatId) {
        return seatSet.
                stream().
                filter(seat -> seatId.contains(seat.getId())).findFirst().get();
    }

    @Override
    public boolean addSeat(Seat seat) {
        return seatSet.add(seat);
    }

    @Override
    public boolean addSeats(Set<Seat> seats) {
        return seatSet.addAll(seats);
    }

    @Override
    public boolean removeSeatById(String seatId) {
        for (Seat seat : seatSet) {
            if (seat.getId().equals(seatId)) {
                return seatSet.remove(seatId);
            }
        }
        return false;
    }
}

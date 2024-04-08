package com.booking.repository;

import com.booking.models.Seat;
import java.util.Set;

public interface SeatsRepository {
    boolean updateSeats(Set<Seat> seats);

    Set<Seat> getSeatsByIds(Set<String> seatsIds);

    Seat getSeatById(String seatId);

    boolean addSeat(Seat seat);

    boolean addSeats(Set<Seat> seats);

    boolean removeSeatById(String seatId);
}

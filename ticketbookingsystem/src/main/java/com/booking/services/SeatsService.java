package com.booking.services;

import com.booking.models.Seat;
import com.booking.repository.SeatsRepository;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class SeatsService {
    SeatsRepository seatsRepository;

    public SeatsService(SeatsRepository seatsRepository) {
        this.seatsRepository = seatsRepository;
    }

    public boolean reserveSeats(Set<Seat> seats) {
        seats.forEach(seat -> {
            seat.reserveSeat();
        });
        return seatsRepository.updateSeats(seats);
    }

    public boolean unReserveSeats(Set<Seat> seats) {
        seats.forEach(seat -> {
            seat.unReserveSeat();
        });
        return seatsRepository.updateSeats(seats);
    }

    public Set<Seat> getSeatsByIds(Set<String> seatsIds) {
        return seatsRepository.getSeatsByIds(seatsIds);
    }

    public boolean addSeat(Seat seat) {
        return seatsRepository.addSeat(seat);
    }

    public boolean addSeats(Set<Seat> seats) {
        return seatsRepository.addSeats(seats);
    }

    public Seat getSeatById(String seatId) {
        return seatsRepository.getSeatById(seatId);
    }
}

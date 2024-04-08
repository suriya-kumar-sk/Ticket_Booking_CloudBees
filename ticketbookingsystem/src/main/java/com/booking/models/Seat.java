package com.booking.models;

public class Seat {
    private String id;
    private String seatNumber;
    private boolean reserved;
    private Section section;

    public Seat(){}

    public Seat(String id, String seatNumber, boolean reserved, Section section) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.reserved = reserved;
        this.section = section;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserveSeat() {
        this.reserved = true;
    }

    public void unReserveSeat() {
        this.reserved = false;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}

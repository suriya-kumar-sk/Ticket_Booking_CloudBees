package com.booking.models;

import java.util.Set;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {
    private String id;

    private String firstName;

    private String lastName;

    private String mailAddress;

    private String trainNumber;

    private Set<Seat> seats;

    public User() {
    }

    public User(String id, String firstName, String lastName, String mailAddress, String trainNumber, Set<Seat> seats) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAddress = mailAddress;
        this.trainNumber = trainNumber;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

}

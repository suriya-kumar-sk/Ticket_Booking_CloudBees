package com.booking.models;

import java.time.LocalDateTime;
import java.util.Set;

public class Train {
    private String id;
    private String trainNumber;
    private Set<String> seatsIds;
    private String departure;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public Train(){}

    public Train(String id, String trainNumber, Set<String> seatsIds, String departure, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.seatsIds = seatsIds;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Set<String> getSeatsIds() {
        return seatsIds;
    }

    public void setSeatsIds(Set<String> seatsIds) {
        this.seatsIds = seatsIds;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}

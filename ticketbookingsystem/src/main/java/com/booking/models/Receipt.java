package com.booking.models;

import java.time.LocalDateTime;

public class Receipt {
    private String id;
    private String receiptNumber;
    private String departure;
    private String destination;
    private User user;
    private Double price;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

    public Receipt() {
    }

    public Receipt(String id, String receiptNumber, String departure, String destination, User user, Double price, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.id = id;
        this.receiptNumber = receiptNumber;
        this.departure = departure;
        this.destination = destination;
        this.user = user;
        this.price = price;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}

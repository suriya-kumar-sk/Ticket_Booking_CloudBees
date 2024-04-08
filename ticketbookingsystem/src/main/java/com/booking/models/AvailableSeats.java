package com.booking.models;

import java.util.ArrayList;
import java.util.HashMap;

public class AvailableSeats {
    private HashMap<String, ArrayList<Integer>> availableSeats;

    public AvailableSeats(HashMap<String, ArrayList<Integer>> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public HashMap<String, ArrayList<Integer>> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(HashMap<String, ArrayList<Integer>> availableSeats) {
        this.availableSeats = availableSeats;
    }
}

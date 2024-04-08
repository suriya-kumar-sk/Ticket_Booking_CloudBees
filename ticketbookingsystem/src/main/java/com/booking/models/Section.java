package com.booking.models;

public enum Section {
    A("A"),
    B("B");

    private String section;

    Section(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }

}

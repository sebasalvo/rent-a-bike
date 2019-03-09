package com.sebasalvo.rentabike.model;

public class RentalDTO {

    private RentalType rentalType;
    /**
     * Number of hours, days or weeks that the rental last.
     */
    private int duration;

    public RentalType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}

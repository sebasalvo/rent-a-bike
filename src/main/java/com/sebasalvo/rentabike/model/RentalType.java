package com.sebasalvo.rentabike.model;

public enum RentalType {

    HOUR(5), DAY(20), WEEK(60);

    private int price;

    RentalType(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}

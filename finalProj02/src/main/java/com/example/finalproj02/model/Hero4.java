package com.example.finalproj02.model;

public class Hero4 extends Hero{
    public Hero4(double x, double y, double width, double height) {
        super(10, 10, "", x, y, width, height);
    }

    public Hero4(){
        super(10, 10, "/com/example/finalproj02/images/kl8fcm29qpqjv11.jpg");
    }

    public Hero4 getCopy(){
        return new Hero4(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    @Override
    public String toString() {
        return "name: Hero4" + super.toString();
    }
}

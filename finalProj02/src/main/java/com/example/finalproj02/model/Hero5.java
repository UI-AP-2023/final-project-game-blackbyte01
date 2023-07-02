package com.example.finalproj02.model;

public class Hero5 extends Hero{
    public Hero5(double x, double y, double width, double height) {
        super(10, 10, "", x, y, width, height);
    }

    public Hero5(){
        super(10, 10, "/com/example/finalproj02/images/kl8fcm29qpqjv11.jpg");
    }

    public Hero5 getCopy(){
        return new Hero5(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    @Override
    public String toString() {
        return "name: Hero5" + super.toString();
    }
}

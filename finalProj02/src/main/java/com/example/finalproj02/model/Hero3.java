package com.example.finalproj02.model;

public class Hero3 extends Hero{
    public Hero3(double x, double y, double width, double height) {
        super(10, 10, "", x, y, width, height);
    }

    public Hero3(){
        super(10, 10, "/com/example/finalproj02/images/kl8fcm29qpqjv11.jpg");
    }

    public Hero3 getCopy(){
        return new Hero3(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    @Override
    public String toString() {
        return "name: Hero3" + super.toString();
    }
}

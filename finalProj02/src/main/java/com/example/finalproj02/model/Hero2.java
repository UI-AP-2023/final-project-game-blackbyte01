package com.example.finalproj02.model;

public class Hero2 extends Hero{
    public Hero2(double x, double y, double width, double height) {
        super(5, 1, "/com/example/finalproj02/images/1.png", x, y, width, height);
    }

    public Hero2(){
        super(5, 1, "/com/example/finalproj02/images/1.png");
    }

    public Hero2 getCopy(){
        return new Hero2(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    @Override
    public String toString() {
        return "name: Hero2" + super.toString();
    }
}

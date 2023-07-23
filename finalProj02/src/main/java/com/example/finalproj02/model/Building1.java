package com.example.finalproj02.model;

public class Building1 extends DBuilding {
    public Building1(double x, double y, double width, double height) {
        super("cannon", 6, 4, "/com/example/finalproj02/images/elements/statics/buildings/cannon.png", new Bomb(), 50, x, y, width, height);
    }

    public Building1() {
        super("cannon", 6, 2, "/com/example/finalproj02/images/elements/statics/buildings/cannon.png", 50);
    }

    public Building1 copy() {
        return new Building1(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

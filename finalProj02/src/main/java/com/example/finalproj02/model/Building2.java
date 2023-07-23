package com.example.finalproj02.model;

public class Building2 extends DBuilding {
    public Building2(double x, double y, double width, double height) {
        super("castle", 5, 3, "/com/example/finalproj02/images/elements/statics/buildings/castle.png", new Bomb(), 50, x, y, width, height);
    }

    public Building2() {
        super("castle", 5, 1, "/com/example/finalproj02/images/elements/statics/buildings/castle.png", 50);
    }

    public Building2 copy() {
        return new Building2(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

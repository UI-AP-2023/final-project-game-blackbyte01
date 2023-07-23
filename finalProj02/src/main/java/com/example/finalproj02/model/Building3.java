package com.example.finalproj02.model;

public class Building3 extends PbBuilding {
    public Building3(double x, double y, double width, double height) {
        super("barrack", 10, "/com/example/finalproj02/images/elements/statics/buildings/barrack.png", 0, x, y, width, height);
    }

    public Building3() {
        super("barrack", 10, "/com/example/finalproj02/images/elements/statics/buildings/barrack.png", 0);
    }

    public Building3 copy() {
        return new Building3(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

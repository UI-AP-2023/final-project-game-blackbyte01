package com.example.finalproj02.model;

public class Building4 extends PbBuilding {
    public Building4(double x, double y, double width, double height) {
        super("gold Mine", 10, "/com/example/finalproj02/images/elements/statics/buildings/gold-mine.png", 2, x, y, width, height);
    }

    public Building4() {
        super("gold Mine", 10, "/com/example/finalproj02/images/elements/statics/buildings/gold-mine.png", 2);
    }

    public Building4 copy() {
        return new Building4(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

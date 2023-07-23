package com.example.finalproj02.model;

public class Building5 extends PbBuilding {
    public Building5(double x, double y, double width, double height) {
        super("cottage", 30, "/com/example/finalproj02/images/elements/statics/buildings/cottage.png", 2, x, y, width, height);
    }

    public Building5() {
        super("cottage", 10, "/com/example/finalproj02/images/elements/statics/buildings/cottage.png", 2);
    }

    public Building5 copy() {
        return new Building5(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

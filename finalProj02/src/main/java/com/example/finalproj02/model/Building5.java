package com.example.finalproj02.model;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Building5 extends OBuilding{
    public Building5(double x, double y, double width, double height) {
        super(10, "/com/example/finalproj02/images/tyt67images-removebg-preview.png",2, x, y, width, height);
    }

    public Building5() {
        super(10, "/com/example/finalproj02/images/tyt67images-removebg-preview.png",2);
    }

    public Building5 copy(){
        return new Building5(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }
}

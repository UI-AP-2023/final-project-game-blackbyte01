package com.example.finalproj02.model;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Building3 extends OBuilding{
    public Building3(double x, double y, double width, double height) {
        super(10, "/com/example/finalproj02/images/Untitled(4)(1).png", 0, x, y, width, height);
    }

    public Building3() {
        super(10, "/com/example/finalproj02/images/Untitled(4)(1).png", 0);
    }

    public Building3 copy(){
        return new Building3(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }
}

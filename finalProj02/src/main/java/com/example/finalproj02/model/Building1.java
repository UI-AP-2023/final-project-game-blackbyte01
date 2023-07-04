package com.example.finalproj02.model;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Building1 extends DBuilding{
    public Building1(double x, double y, double width, double height) {
        super(8, 2, "/com/example/finalproj02/images/Untitled_3__1_-removebg-preview.png",50, x, y, width, height);
    }

    public Building1() {
        super(8, 2, "/com/example/finalproj02/images/Untitled_3__1_-removebg-preview.png",50);
    }

    public Building1 copy(){
        return new Building1(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }
}

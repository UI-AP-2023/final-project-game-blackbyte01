package com.example.finalproj02.model;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Building2 extends DBuilding{
    public Building2(double x, double y, double width, double height) {
        super(2, 1, "/com/example/finalproj02/images/Untitled_3__2_-removebg-preview.png",50,  x, y, width, height);
    }

    public Building2() {
        super(2, 1, "/com/example/finalproj02/images/Untitled_3__2_-removebg-preview.png",50);
    }

    public Building2 copy(){
        return new Building2(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }
}

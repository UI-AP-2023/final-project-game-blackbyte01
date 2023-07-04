package com.example.finalproj02.model;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Building4 extends OBuilding{
    public Building4(double x, double y, double width, double height) {
        super(10, "/com/example/finalproj02/images/787878images.png",2, x, y, width, height);
    }

    public Building4() {
        super(10, "/com/example/finalproj02/images/787878images.png",2);
    }

    public Building4 copy(){
        return new Building4(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }
}

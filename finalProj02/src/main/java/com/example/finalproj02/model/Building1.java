package com.example.finalproj02.model;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Building1 extends DBuilding{
    public Building1(double x, double y, double width, double height) {
        super(8, 2, "/com/example/finalproj02/images/787878images.png",2, x, y, width, height);
    }

    public Building1 copy(){
        return new Building1(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    /*
    public void method1(Pane pane, ArrayList<Building> buildings){
        AtomicReference<Building1> buildingAtomicReference=new AtomicReference<>();
        imageView.setOnMousePressed(e -> {
            buildingAtomicReference.set(this.copy());
            buildings.add(buildingAtomicReference.get());
            pane.getChildren().add(buildingAtomicReference.get().getImageView());
            mousePressedX=e.getSceneX()-buildingAtomicReference.get().getImageView().getTranslateX();
            mousePressedY=e.getSceneY()-buildingAtomicReference.get().getImageView().getTranslateY();
        });

        imageView.setOnMouseDragged(e->{
            buildingAtomicReference.get().getImageView().setTranslateX(e.getSceneX()-mousePressedX);
            buildingAtomicReference.get().getImageView().setTranslateY(e.getSceneY()-mousePressedY);
        });
    }
     */
}

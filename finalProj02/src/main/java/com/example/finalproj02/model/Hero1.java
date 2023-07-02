package com.example.finalproj02.model;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Hero1 extends Hero{
    public Hero1(double x, double y, double width, double height) {
        super(3, 2, "/com/example/finalproj02/images/56images(1).png", x, y, width, height);
    }

    public Hero1(){
        super(3, 2, "/com/example/finalproj02/images/56images(1).png");
    }

    public Hero1 getCopy(){
        return new Hero1(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    /*
    public void method1(Pane pane){
        AtomicReference<Hero> heroAtomicReference=new AtomicReference<>();
        imageView.setOnMousePressed(e -> {
            heroAtomicReference.set(this.getCopy());
            pane.getChildren().add(heroAtomicReference.get().getImageView());
            mousePressedX=e.getSceneX()-heroAtomicReference.get().getImageView().getTranslateX();
            mousePressedY=e.getSceneY()-heroAtomicReference.get().getImageView().getTranslateY();
        });

        imageView.setOnMouseDragged(e->{
            heroAtomicReference.get().getImageView().setTranslateX(e.getSceneX()-mousePressedX);
            heroAtomicReference.get().getImageView().setTranslateY(e.getSceneY()-mousePressedY);
        });
    }
     */

    @Override
    public String toString() {
        return "name: Hero1" + super.toString();
    }
}

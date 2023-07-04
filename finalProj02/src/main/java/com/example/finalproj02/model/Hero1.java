package com.example.finalproj02.model;

import com.example.finalproj02.database.Building1DB;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Hero1 extends Hero{
    public Hero1(double x, double y, double width, double height) {
        super(3, 2, "/com/example/finalproj02/images/jumper.png", x, y, width, height);
        setLevel(1);
    }

    public Hero1(){
        super(3, 2, "/com/example/finalproj02/images/jumper.png");
        setLevel(1);
    }

    public Hero1 getCopy(){
        return new Hero1(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    public void findBestBuilding(ArrayList<Building> buildings){
        ArrayList<Building> matchBuilding=new ArrayList<>();
        for(Building a: buildings){
            if(a.getRadius()==0){
                matchBuilding.add(a);
            }
        }
        setBuilding(findNeatestBuilding(matchBuilding));
    }

    public boolean isInArea(){
        double xDistance=Math.abs(getBuilding().getBounds().getCenterX()-this.getBounds().getCenterX());
        double yDistance=Math.abs(getBuilding().getBounds().getCenterY()-this.getBounds().getCenterY());
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2)) <= (getTargetRadius());
    }

    public void setTranslateTarget(TranslateTransition translateTransition){
        if(this.getBuilding()!=null){
            setTargetRadius(getBuilding().getRadius());
            super.setTranslateTarget(translateTransition);
        }
    }

    @Override
    public String toString() {
        return "name: Hero1" + super.toString();
    }
}

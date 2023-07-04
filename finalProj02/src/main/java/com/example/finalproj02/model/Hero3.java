package com.example.finalproj02.model;

import javafx.animation.TranslateTransition;

import java.util.ArrayList;

public class Hero3 extends Hero{
    public Hero3(double x, double y, double width, double height) {
        super(10, 10, "/com/example/finalproj02/images/swordsman.png", x, y, width, height);
        setLevel(2);
    }

    public Hero3(){
        super(10, 10, "/com/example/finalproj02/images/swordsman.png");
        setLevel(2);
    }

    public Hero3 getCopy(){
        return new Hero3(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    public void findBestBuilding(ArrayList<Building> buildings){
        ArrayList<Building> matchBuilding=new ArrayList<>();
        for(Building a: buildings){
            if((a instanceof Building3) || (a instanceof Building2)){
                matchBuilding.add(a);
            }
        }
        setBuilding(findNeatestBuilding(matchBuilding));
        //return getBuilding();
    }

    public void setTranslateTarget(TranslateTransition translateTransition){
        if(getBuilding()!=null){
            setTargetRadius(getBuilding().getRadius());
            super.setTranslateTarget(translateTransition);
        }
    }

    public boolean isInArea(){
        double xDistance=Math.abs(getBuilding().getBounds().getCenterX()-this.getBounds().getCenterX());
        double yDistance=Math.abs(getBuilding().getBounds().getCenterY()-this.getBounds().getCenterY());
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2)) <= (getTargetRadius());
    }

    @Override
    public String toString() {
        return "name: Hero3" + super.toString();
    }
}

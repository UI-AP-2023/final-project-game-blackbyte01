package com.example.finalproj02.model;

import javafx.animation.TranslateTransition;

import java.util.ArrayList;

public class Hero2 extends Hero{
    public Hero2(double x, double y, double width, double height) {
        super(5, 1, "/com/example/finalproj02/images/swordswoman.png", x, y, width, height);
        setLevel(1);
    }

    public Hero2(){
        super(5, 1, "/com/example/finalproj02/images/swordswoman.png");
        setLevel(1);
    }

    public Hero2 getCopy(){
        return new Hero2(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
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
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2)) <= (getTargetRadius()+50);
    }

    @Override
    public String toString() {
        return "name: Hero2" + super.toString();
    }
}

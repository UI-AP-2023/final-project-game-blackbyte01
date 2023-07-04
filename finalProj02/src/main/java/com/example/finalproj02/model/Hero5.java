package com.example.finalproj02.model;

import javafx.animation.TranslateTransition;

import java.util.ArrayList;

public class Hero5 extends Hero{
    public Hero5(double x, double y, double width, double height) {
        super(10, 10, "", x, y, width, height);
        setLevel(3);
    }

    public Hero5(){
        super(10, 10, "/com/example/finalproj02/images/kl8fcm29qpqjv11.jpg");
        setLevel(3);
    }

    public Hero5 getCopy(){
        return new Hero5(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    public void findBestBuilding(ArrayList<Building> buildings){
        ArrayList<Building> matchBuilding=new ArrayList<>();
        for(Building a: buildings){
            if((a instanceof Building1) || (a instanceof Building2)){
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

    @Override
    public String toString() {
        return "name: Hero5" + super.toString();
    }
}

package com.example.finalproj02.model;

public abstract class OBuilding extends Building{

    public OBuilding(int health, String path, double x, double y, double width, double height){
        super(BuildingType.ORDINARY_BUILDING, health, path, x, y, width, height);
    }
}
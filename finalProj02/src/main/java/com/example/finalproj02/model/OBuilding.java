package com.example.finalproj02.model;

public abstract class OBuilding extends Building{
    public OBuilding(int health, String path, double radius, double x, double y, double width, double height) {
        super(BuildingType.ORDINARY_BUILDING, health, path, radius, x, y, width, height);
    }

    public OBuilding(int health, String path, double radius) {
        super(BuildingType.ORDINARY_BUILDING, health, path, radius);
    }
}

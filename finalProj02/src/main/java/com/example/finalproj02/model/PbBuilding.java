package com.example.finalproj02.model;

public abstract class PbBuilding extends Building {
    public PbBuilding(String name, int health, String path, double radius, double x, double y, double width, double height) {
        super(name, BuildingType.PUBLIC_BUILDING, health, path, radius, x, y, width, height);
    }

    public PbBuilding(String name, int health, String path, double radius) {
        super(name, BuildingType.PUBLIC_BUILDING, health, path, radius);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

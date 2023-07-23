package com.example.finalproj02.model;

public abstract class PrBuilding extends Building {
    public PrBuilding(String name, int health, String path, double radius) {
        super(name, BuildingType.PRIVATE_BUILDING, health, path, radius);
    }

    public PrBuilding(String name, int health, String path, double radius, double x, double y, double width, double height) {
        super(name, BuildingType.PRIVATE_BUILDING, health, path, radius, x, y, width, height);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package com.example.finalproj02.model;

public abstract class Building extends GameElement {
    private final BuildingType buildingType;
    private final int health;

    public Building(BuildingType buildingType, int health, String path, double x, double y, double width, double height) {
        super(path, x, y, width, height);
        this.buildingType=buildingType;
        this.health=health;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public int getHealth() {
        return health;
    }
}

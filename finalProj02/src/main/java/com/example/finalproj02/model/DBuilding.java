package com.example.finalproj02.model;

public abstract class DBuilding extends Building{
    private final int damage;

    public DBuilding(int health, int damage, String path, double x, double y, double width, double height){
        super(BuildingType.DEFENSIVE_BUILDING, health, path, x, y, width, height);
        this.damage=damage;
    }

    public int getDamage() {
        return damage;
    }
}

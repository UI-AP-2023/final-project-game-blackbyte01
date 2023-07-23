package com.example.finalproj02.model;

import javafx.animation.Timeline;

public abstract class DBuilding extends Building{
    private final int damage;
    private Timeline attackTimeLine;
    private Hero hero;
    private DBuildingEquipment dBuildingEquipment;
    public DBuilding(String name, int health, int damage, String path, DBuildingEquipment dBuildingEquipment, double radius, double x, double y, double width, double height) {
        super(name, BuildingType.DEFENSIVE_BUILDING, health, path, radius, x, y, width, height);
        this.damage=damage;
        this.dBuildingEquipment=dBuildingEquipment;
        attackTimeLine=new Timeline();
    }

    public DBuilding(String name, int health, int damage, String path, double radius) {
        super(name, BuildingType.DEFENSIVE_BUILDING, health, path, radius);
        this.damage=damage;
    }

    public DBuildingEquipment getDBuildingEquipment() {
        return dBuildingEquipment;
    }

    public void setDBuildingEquipment(DBuildingEquipment dBuildingEquipment) {
        this.dBuildingEquipment = dBuildingEquipment;
    }

    public Timeline getAttackTimeLine() {
        return attackTimeLine;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "damage: " + damage + super.toString();
    }
}

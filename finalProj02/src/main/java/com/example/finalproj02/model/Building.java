package com.example.finalproj02.model;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Building extends GameElement {
    private final BuildingType buildingType;
    private int health;
    double mousePressedY, mousePressedX;
    double radius;

    public Building(String name, BuildingType buildingType, int health, String path, double radius, double x, double y, double width, double height) {
        super(name, path, x, y, width, height);
        this.buildingType = buildingType;
        this.health = health;
        this.radius = radius;
    }

    public Building(String name, BuildingType buildingType, int health, String path, double radius) {
        super(name, path);
        this.buildingType = buildingType;
        this.health = health;
        this.radius = radius;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void makeDraggable(Pane pane, ArrayList<Building> buildings) {
        AtomicReference<Building> buildingAtomicReference = new AtomicReference<>();
        imageView.setOnMousePressed(e -> {
            buildingAtomicReference.set(copyBuilding());
            buildings.add(buildingAtomicReference.get());
            pane.getChildren().add(buildingAtomicReference.get().getImageView());
            mousePressedX = e.getSceneX() - buildingAtomicReference.get().getImageView().getTranslateX();
            mousePressedY = e.getSceneY() - buildingAtomicReference.get().getImageView().getTranslateY();
        });

        imageView.setOnMouseDragged(e -> {
            buildingAtomicReference.get().getImageView().setTranslateX(e.getSceneX() - mousePressedX);
            buildingAtomicReference.get().getImageView().setTranslateY(e.getSceneY() - mousePressedY);
        });
    }

    private Building copyBuilding() {
        if (this instanceof Building1)
            return ((Building1) this).copy();
        else if (this instanceof Building2)
            return ((Building2) this).copy();
        else if (this instanceof Building3)
            return ((Building3) this).copy();
        else if (this instanceof Building4)
            return ((Building4) this).copy();
        else
            return ((Building5) this).copy();
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public int getHealth() {
        return health;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return  "\nname: " + super.getName() +
                "\nhealth: " + health +
                "\ntype: " + buildingType.toString().toLowerCase();
    }
}

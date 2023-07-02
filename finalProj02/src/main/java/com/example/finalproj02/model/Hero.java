package com.example.finalproj02.model;

import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Hero extends GameElement{
    private int health;
    private final int damage;
    double mousePressedY, mousePressedX;
    private boolean isAttacking;
    private boolean isWalking;
    private Building building;
    public Hero(int health, int damage, String path, double x, double y, double width, double height) {
        super(path, x, y, width, height);
        this.health=health;
        this.damage=damage;
    }

    public Hero(int health, int damage, String path){
        super(path);
        this.health=health;
        this.damage=damage;
    }

    public Building getBuilding() {
        return building;
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setWalking(boolean walking) {
        isWalking = walking;
    }

    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }

    public void method1(Pane pane, ArrayList<Hero> heroes){
        AtomicReference<Hero> heroAtomicReference=new AtomicReference<>();
        imageView.setOnMousePressed(e -> {
            heroAtomicReference.set(copyHero());
            pane.getChildren().add(heroAtomicReference.get().getImageView());
            mousePressedX=e.getSceneX()-heroAtomicReference.get().getImageView().getTranslateX();
            mousePressedY=e.getSceneY()-heroAtomicReference.get().getImageView().getTranslateY();
        });

        imageView.setOnMouseDragged(e->{
            heroAtomicReference.get().getImageView().setTranslateX(e.getSceneX()-mousePressedX);
            heroAtomicReference.get().getImageView().setTranslateY(e.getSceneY()-mousePressedY);
        });

        imageView.setOnMouseReleased(e->{  // check position released
            heroes.add(heroAtomicReference.get());
            //System.out.println(heroes);
        });
    }

    private Hero copyHero(){
        if(this instanceof Hero1)
            return ((Hero1) this).getCopy();
        else if(this instanceof Hero2)
            return ((Hero2) this).getCopy();
        else if(this instanceof Hero3)
            return ((Hero3) this).getCopy();
        else if(this instanceof Hero4)
            return ((Hero4) this).getCopy();
        else
            return ((Hero5) this).getCopy();
    }

    @Override
    public String toString() {
        return "\nhealth: " + health +
                "\ndamage: " + damage;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public boolean isWalking() {
        return isWalking;
    }
}

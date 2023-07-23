package com.example.finalproj02.model;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.geometry.NodeOrientation;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Hero extends GameElement {
    private int health;
    private final int damage;
    private final int speed;
    public double mousePressedY, mousePressedX;
    private boolean isAttacking;
    private boolean isWalking;
    private Building building;
    private double targetRadius;
    private int level;
    private ArrayList<ImageView> sprites;
    private ArrayList<ImageView> sprites0;
    private Timeline attackTimeLine;
    private Group group;
    private Group rotatedGroup;

    public Hero(String name, int health, int damage, int speed, String path, double x, double y, double width, double height) {
        super(name, path, x, y, width, height);
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        group = new Group();
        rotatedGroup = new Group();
        attackTimeLine = new Timeline();
    }

    public Hero(String name, int health, int damage, int speed, String path) {
        super(name, path);
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Group getGroup() {
        return group;
    }

    public Timeline getAttackTimeLine() {
        return attackTimeLine;
    }

    public Group getRotatedGroup() {
        return rotatedGroup;
    }

    public void setSprites0(ArrayList<ImageView> sprites0) {
        this.sprites0 = sprites0;
    }

    public void setSprites(ArrayList<ImageView> sprites) {
        this.sprites = sprites;
    }

    public Building getBuilding() {
        return building;
    }

    public int getSpeed() {
        return speed;
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

    public double getTargetRadius() {
        return targetRadius;
    }

    public void setTargetRadius(double targetRadius) {
        this.targetRadius = targetRadius;
    }

    @Override
    public String toString() {
        return  "\nname: " + super.getName() +
                "\nhealth: " + health +
                "\ndamage: " + damage +
                "\nspeed: " + speed;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public boolean isWalking() {
        return isWalking;
    }

    public Building findNeatestBuilding(ArrayList<Building> buildings) {
        double minDistance = 100000, distance;
        Building building = null;
        for (Building a : buildings) {
            distance = getDistance(a);
            if (distance < minDistance) {
                minDistance = distance;
                building = a;
            }
        }
        return building;
    }

    public abstract void findBestBuilding(ArrayList<Building> buildings);

    public void setTranslateTarget(TranslateTransition translateTransition) {
        if ((this.getBounds().getCenterX() < building.getBounds().getCenterX()) && (this.getBounds().getCenterY() < building.getBounds().getCenterY())) {
            translateTransition.setToX(building.getBounds().getCenterX() - this.centerX - targetRadius);
            translateTransition.setToY(building.getBounds().getCenterY() - this.centerY - targetRadius);
        } else if ((this.getBounds().getCenterX() > building.getBounds().getCenterX()) && (this.getBounds().getCenterY() < building.getBounds().getCenterY())) {
            translateTransition.setToX(building.getBounds().getCenterX() - this.centerX + targetRadius);
            translateTransition.setToY(building.getBounds().getCenterY() - this.centerY - targetRadius);
        } else if ((this.getBounds().getCenterX() > building.getBounds().getCenterX()) && (this.getBounds().getCenterY() > building.getBounds().getCenterY())) {
            translateTransition.setToX(building.getBounds().getCenterX() - this.centerX + targetRadius);
            translateTransition.setToY(building.getBounds().getCenterY() - this.centerY + targetRadius);
        } else {
            translateTransition.setToX(building.getBounds().getCenterX() - this.centerX - targetRadius);
            translateTransition.setToY(building.getBounds().getCenterY() - this.centerY + targetRadius);
        }
    }

    public double getDistance(Building building) {
        double xDistance = Math.abs(building.getBounds().getCenterX() - this.getBounds().getCenterX());
        double yDistance = Math.abs(building.getBounds().getCenterY() - this.getBounds().getCenterY());
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

    public ArrayList<Image> imagePaths(ArrayList<String> paths) {
        ArrayList<Image> images = new ArrayList<>();
        paths.forEach(n -> images.add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(n)))));
        return images;
    }

    public ArrayList<ImageView> imageViewImages(ArrayList<Image> images) {
        ArrayList<ImageView> imageViews = new ArrayList<>();
        for (Image a : images) {
            ImageView imageView = new ImageView(a);
            imageView.setFitWidth(80);
            imageView.setFitHeight(80);
            imageViews.add(imageView);
        }
        return imageViews;
    }

    public Timeline animateImageViews() {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        int i = 1;
        for (ImageView a : sprites) {
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(100 * i), (ActionEvent e) -> {
                if (this.getBounds().getMinX() <= this.getBuilding().getBounds().getMinX()) {
                    a.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
                    group.getChildren().setAll(a);
                } else {
                    a.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                    group.getChildren().setAll(a);
                }
            }));
            ++i;
        }
        return timeline;
    }

    public TranslateTransition translateAnimation(Building building) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(group);
        translateTransition.setDuration(Duration.millis(10000));
        setTranslateTarget0(translateTransition, building);
        translateTransition.setAutoReverse(false);
        return translateTransition;
    }

    public void setTranslateTarget0(TranslateTransition translateTransition, Building building) {
        translateTransition.setToX(building.getMinX() - group.getLayoutX());
        translateTransition.setToY(building.getMinY() - group.getLayoutY());
    }

    public boolean isInArea0() {
        return this.getGroup().getLayoutX() + this.getGroup().getTranslateX() == getBuilding().getMinX() && this.getGroup().getLayoutY() + this.getGroup().getTranslateY() == this.getBuilding().getMinY();
    }
}

package com.example.finalproj02.model;

import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.Objects;

public abstract class DBuilding extends Building{
    private final int damage;
    private ImageView arrow;
    public DBuilding(int health, int damage, String path, double radius, double x, double y, double width, double height) {
        super(BuildingType.DEFENSIVE_BUILDING, health, path, radius, x, y, width, height);
        this.damage=damage;
    }

    public DBuilding(int health, int damage, String path, double radius) {
        super(BuildingType.DEFENSIVE_BUILDING, health, path, radius);
        this.damage=damage;
    }

    public void setArrow(){
        arrow=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/finalproj02/images/89890Capture.PNG"))));
        arrow.setLayoutX(this.getBounds().getMaxX());
        arrow.setLayoutY(this.getBounds().getCenterY());
        arrow.setFitWidth(30);
        arrow.setFitHeight(30);
    }

    public ImageView getArrow() {
        return arrow;
    }

    public void shutArrow(Hero hero){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(this.getBounds().getCenterX(), this.getBounds().getCenterY());
        LineTo line1 = new LineTo(hero.getBounds().getCenterX(), hero.getBounds().getCenterY());
        path.getElements().addAll(moveTo, line1);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(arrow);
        pathTransition.setPath(path);
        pathTransition.setDuration(Duration.seconds(3));
        pathTransition.play();
    }


    public int getDamage() {
        return damage;
    }
}

package com.example.finalproj02.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Objects;

public abstract class DBuildingEquipment extends GameElement {
    double targetMinX, targetMinY;
    double originX, originY;
    private Timeline removeTimeline;
    private ArrayList<ImageView> sprites;
    private Group group;

    public DBuildingEquipment(String name, String path, double x, double y, double width, double height) {
        super(name, path, x, y, width, height);
        removeTimeline = new Timeline();
        group = new Group();
    }

    public Timeline getRemoveTimeline() {
        return removeTimeline;
    }

    public void setRemoveTimeline(Timeline removeTimeline) {
        this.removeTimeline = removeTimeline;
    }

    public double getTargetMinX() {
        return targetMinX;
    }

    public void setTargetMinX(double targetMinX) {
        this.targetMinX = targetMinX;
    }

    public double getTargetMinY() {
        return targetMinY;
    }

    public void setTargetMinY(double targetMinY) {
        this.targetMinY = targetMinY;
    }

    public ArrayList<ImageView> getSprites() {
        return sprites;
    }

    public void setSprites(ArrayList<ImageView> sprites) {
        this.sprites = sprites;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public double getOriginX() {
        return originX;
    }

    public void setOriginX(double originX) {
        this.originX = originX;
    }

    public double getOriginY() {
        return originY;
    }

    public void setOriginY(double originY) {
        this.originY = originY;
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
                group.getChildren().setAll(a);
            }));
            ++i;
        }
        return timeline;
    }

    public TranslateTransition translateAnimation(Hero hero) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(group);
        translateTransition.setDuration(Duration.millis(700));
        setTranslateTarget0(translateTransition, hero);
        translateTransition.setAutoReverse(false);
        return translateTransition;
    }

    public void setTranslateTarget0(TranslateTransition translateTransition, Hero hero) {   //
        translateTransition.setFromX(originX - group.getLayoutX());
        translateTransition.setFromY(originY - group.getLayoutY());
        translateTransition.setToX(hero.getGroup().getLayoutX() + hero.getGroup().getTranslateX() - group.getLayoutX());  //
        translateTransition.setToY(hero.getGroup().getLayoutY() + hero.getGroup().getTranslateY() - group.getLayoutY());  //
        this.setTargetMinX(hero.getGroup().getLayoutX() + hero.getGroup().getTranslateX());
        this.setTargetMinY(hero.getGroup().getLayoutY() + hero.getGroup().getTranslateY());
    }

    public Hero findNeatestHero(ArrayList<Hero> heroes) {
        double minDistance = 100000, distance;
        Hero hero = null;
        for (Hero a : heroes) {
            if (a.isAttacking()) {
                distance = getDistance(a);
                if (distance < minDistance) {
                    minDistance = distance;
                    hero = a;
                }
            }
        }
        return hero;
    }

    public double getDistance(Hero hero) {
        double xDistance = Math.abs(hero.getBounds().getCenterX() - this.getBounds().getCenterX());
        double yDistance = Math.abs(hero.getBounds().getCenterY() - this.getBounds().getCenterY());
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

    public boolean isReached() {
        Bounds bounds = this.getGroup().localToScene(imageView.getBoundsInLocal());
        System.out.println(bounds);
        return this.getGroup().getLayoutX() + this.getGroup().getTranslateX() == this.getTargetMinX() && this.getGroup().getLayoutY() + this.getGroup().getTranslateY() == this.getTargetMinY();
    }
}

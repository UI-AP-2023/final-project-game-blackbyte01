package com.example.finalproj02.model;

import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class GameElement {
    private double mousePressedX, mousePressedY;
    private String path;
    public ImageView imageView;
    double centerX, centerY;
    private final String name;

    public GameElement(String name, String path, double x, double y, double width, double height) {
        this.name = name;
        this.path = path;
        this.centerX = x + (width / 2);
        this.centerY = y + (height / 2);
        setImageView(x, y, width, height);
    }

    public GameElement(String name, String path) {
        this.name = name;
        this.path = path;
        setImageView0();
    }

    private void setImageView(double x, double y, double width, double height) {
        imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))));
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
    }

    private void setImageView0() {
        imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))));
        imageView.setFitWidth(85);
        imageView.setFitHeight(85);
    }

    public Bounds getBounds() {
        return this.getImageView().localToScene(imageView.getBoundsInLocal());
    }

    public double getMinX() {
        return imageView.localToScene(imageView.getBoundsInLocal()).getMinX();
    }

    public double getMinY() {
        return imageView.localToScene(imageView.getBoundsInLocal()).getMinY();
    }

    public double getMousePressedX() {
        return mousePressedX;
    }

    public void setMousePressedX(double mousePressedX) {
        this.mousePressedX = mousePressedX;
    }

    public double getMousePressedY() {
        return mousePressedY;
    }

    public void setMousePressedY(double mousePressedY) {
        this.mousePressedY = mousePressedY;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public GameElement getCopy() {
        return new GameElement(this.name, this.path, this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }
}

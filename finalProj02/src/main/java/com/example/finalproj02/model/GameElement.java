package com.example.finalproj02.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class GameElement {
    private double x, y, mousePressedX, mousePressedY, width, height;
    private String path;
    public ImageView imageView;

    public GameElement(String path, double x, double y, double width, double height){
        this.path=path;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        setImageView();
    }

    private void setImageView(){
        imageView=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)), width, height, false, false));
        imageView.setX(x);
        imageView.setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
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



    public void makeImageViewDraggable(){
        imageView.setOnMousePressed(mouseEvent -> {
            mousePressedX=mouseEvent.getSceneX()-imageView.getTranslateX();
            mousePressedY=mouseEvent.getSceneY()-imageView.getTranslateY();
        });

        imageView.setOnMouseDragged(mouseEvent->{
            imageView.setTranslateX(mouseEvent.getSceneX()-mousePressedX);
            imageView.setTranslateY(mouseEvent.getSceneY()-mousePressedY);
        });
    }
}

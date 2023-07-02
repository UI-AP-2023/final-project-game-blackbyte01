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
    private double mousePressedX, mousePressedY, mouseReleasedX, mouseReleasedY;
    private String path;
    public ImageView imageView;
    double centerX, centerY;

    public GameElement(String path, double x, double y, double width, double height){
        this.path=path;
        this.centerX=x+(width/2);
        this.centerY=y+(height/2);
        setImageView(x, y ,width, height);
    }

    public GameElement(String path){
        this.path=path;
    }

    private void setImageView(double x, double y, double width, double height){
        imageView=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))));
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
    }

    public Bounds getBounds(){
        return this.getImageView().localToScene(imageView.getBoundsInLocal());
    }

    public double getMinX(){
        return imageView.localToScene(imageView.getBoundsInLocal()).getMinX();
    }

    public double getMinY(){
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

    public GameElement getCopy(){
        return new GameElement(this.path, this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
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

    public void method(Pane pane){
        AtomicReference<GameElement> gameElementCopy=new AtomicReference<>();
        imageView.setOnMousePressed(e -> {
            gameElementCopy.set(this.getCopy());
            //System.out.println(gameElementCopy.get());
            //buildings.add((Building) (gameElementCopy.get()));
            pane.getChildren().add(gameElementCopy.get().getImageView());
            mousePressedY=e.getSceneX()-gameElementCopy.get().getImageView().getTranslateX();
            mousePressedY=e.getSceneY()-gameElementCopy.get().getImageView().getTranslateY();
        });

        imageView.setOnMouseDragged(e->{
            gameElementCopy.get().getImageView().setTranslateX(e.getSceneX()-mousePressedY);
            gameElementCopy.get().getImageView().setTranslateY(e.getSceneY()-mousePressedY);
        });
    }
}

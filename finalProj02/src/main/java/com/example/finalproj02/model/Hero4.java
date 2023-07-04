package com.example.finalproj02.model;

import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Objects;

public class Hero4 extends Hero{
    private final double radius;
    private ImageView arrow;
    int counter=0;
    public Hero4(double x, double y, double width, double height) {
        super(5, 2, "/com/example/finalproj02/images/swordsman.png", x, y, width, height);
        radius=30;
        setLevel(1);
    }

    public Hero4(){
        super(5, 2, "/com/example/finalproj02/images/swordsman.png");
        radius=30;
        setLevel(1);
    }

    public void setArrow(){
        arrow=new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/finalproj02/images/Removal-487.png"))));
        arrow.setLayoutX(this.getBounds().getMaxX());
        arrow.setLayoutY(this.getBounds().getCenterY());
        arrow.setFitWidth(30);
        arrow.setFitHeight(30);
    }

    public ImageView getArrow() {
        return arrow;
    }

    public void setArrowTimeLine(){
        //Timeline timeline=new Timeline(new KeyFrame(Duration.millis(10), e->removeArrow()));
        //timeline.setCycleCount(Animation.INDEFINITE);
        //timeline.play();
        shutArrow();
    }

    private void removeArrow(){
        //++counter;
        //if(counter>=1000)
            //arrow.setVisible(false);
    }

    public void shutArrow(){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(this.getBounds().getCenterX(), this.getBounds().getCenterY());
        LineTo line1 = new LineTo(this.getBuilding().getBounds().getCenterX(), this.getBuilding().getBounds().getCenterY());
        path.getElements().addAll(moveTo, line1);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(arrow);
        pathTransition.setPath(path);
        pathTransition.setDuration(Duration.seconds(2));
        pathTransition.play();
        /*
        TranslateTransition translateTransition=new TranslateTransition();
        translateTransition.setNode(arrow);
        //translateTransition.setDelay(Duration.millis(1000));
        translateTransition.setDelay(Duration.millis(800));
        //translateTransition.setFromX(this.getBounds().getMaxX());
        //translateTransition.setFromX(this.getBounds().getCenterY());
        translateTransition.setToX(getBuilding().getBounds().getCenterX()-this.getBounds().getCenterX());
        translateTransition.setToY(getBuilding().getBounds().getCenterY()-this.getBounds().getCenterY());
        translateTransition.play();
        translateTransition.setAutoReverse(false);
         */
    }

    public Hero4 getCopy(){
        return new Hero4(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    public void findBestBuilding(ArrayList<Building> buildings){
        ArrayList<Building> matchBuilding = new ArrayList<>(buildings);
        setBuilding(findNeatestBuilding(matchBuilding));
        //return getBuilding();
    }

    public boolean isInArea(){
        double xDistance=Math.abs(getBuilding().getBounds().getCenterX()-this.getBounds().getCenterX());
        double yDistance=Math.abs(getBuilding().getBounds().getCenterY()-this.getBounds().getCenterY());
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2)) <= (getTargetRadius()*2);
    }

    public void setTranslateTarget(TranslateTransition translateTransition){
        if(getBuilding()!=null){
            if(getBuilding().getRadius()!=0){
                setTargetRadius(getBuilding().getRadius());
                super.setTranslateTarget(translateTransition);
            }
            else{
                setTargetRadius(this.radius);
                super.setTranslateTarget(translateTransition);
            }
        }
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "name: Hero4" + super.toString();
    }
}

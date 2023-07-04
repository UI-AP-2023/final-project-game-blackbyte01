package com.example.finalproj02.view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AnimationController implements Initializable {
    @FXML
    private Circle circle;
    TranslateTransition translateTransition;

    void show(){
        Timeline timeline=new Timeline(new KeyFrame(Duration.millis(10), e->checkDistance()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        translateTransition=new TranslateTransition();
        translateTransition.setNode(circle);
        //translateTransition.setDelay(Duration.millis(10000));
        translateTransition.setDuration(Duration.millis(10000));
        translateTransition.setToX(300);
        translateTransition.setToY(300);
        translateTransition.setAutoReverse(false);
        translateTransition.play();
    }

    void setTimeLine(){
        Timeline timeline=new Timeline(new KeyFrame(Duration.millis(100), e-> checkDistance()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    void checkDistance(){
        System.out.println(circle.localToScene(circle.getBoundsInLocal()).getCenterX());
        if(circle.localToScene(circle.getBoundsInLocal()).getCenterX()>=100){
            translateTransition.pause();
            //translateTransition.setDelay(Duration.millis(1000));
            //translateTransition.setToX(200);
            //translateTransition.setToX(500);
            //translateTransition.play();
            //System.out.println("1");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}

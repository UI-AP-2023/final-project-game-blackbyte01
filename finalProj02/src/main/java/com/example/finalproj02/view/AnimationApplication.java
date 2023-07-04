package com.example.finalproj02.view;

import com.example.finalproj02.model.Building;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class AnimationApplication extends Application {

    final static Image image1=new Image(String.valueOf(AnimationApplication.class.getResource("/com/example/finalproj02/images/Removal-487.png")));
    final static Image image2=new Image(String.valueOf(AnimationApplication.class.getResource("/com/example/finalproj02/images/Removal-88.png")));
    final static Image image3=new Image(String.valueOf(AnimationApplication.class.getResource("/com/example/finalproj02/images/Removal-123.png")));
    final static Image image4=new Image(String.valueOf(AnimationApplication.class.getResource("/com/example/finalproj02/images/Removal-225.png")));

    private Group group;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AnimationController.class.getResource("/com/example/finalproj02/animation-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        AnimationController animationController=fxmlLoader.getController();
        animationController.show();
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

package com.example.finalproj02.view;

import com.example.finalproj02.model.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MapApplication0 extends Application {
    Player player;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MapController0.class.getResource("/com/example/finalproj02/map0-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MapController0 playGroundController=fxmlLoader.getController();
        playGroundController.player=player;
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public MapApplication0(Player player){
        this.player=player;
    }
}

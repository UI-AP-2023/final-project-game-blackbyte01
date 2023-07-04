package com.example.finalproj02.view;

import com.example.finalproj02.model.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MapApplication extends Application {
    int playerID;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MapControllerGUI.class.getResource("/com/example/finalproj02/map-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MapControllerGUI mapController=fxmlLoader.getController();
        mapController.playerID=playerID;
        primaryStage.setTitle("Map Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public MapApplication(int playerID){
        this.playerID=playerID;
    }
}

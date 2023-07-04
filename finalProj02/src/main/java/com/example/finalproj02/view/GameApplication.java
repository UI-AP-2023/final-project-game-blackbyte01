package com.example.finalproj02.view;

import com.example.finalproj02.model.Hero;
import com.example.finalproj02.model.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GameApplication extends Application {
    Map map;
    ArrayList<Hero> heroes;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameController.class.getResource("/com/example/finalproj02/game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        GameController gameController=fxmlLoader.getController();
        gameController.show(map, heroes);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GameApplication(Map map, ArrayList<Hero> heroes){
        this.map=map;
        System.out.println("game controller: " + map.getBuildings().size());
        this.heroes=heroes;
    }
}

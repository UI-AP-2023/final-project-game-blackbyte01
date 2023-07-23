package com.example.finalproj02.view;

import com.example.finalproj02.model.Hero;
import com.example.finalproj02.model.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class GameApplication extends Application {
    Map selectedMap;
    HashMap<Hero, Integer> selectedHeroes;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/finalproj02/fxmls/game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        GameController gameController0 = fxmlLoader.getController();
        gameController0.selectedMap = selectedMap;
        gameController0.selectedHeroes = selectedHeroes;
        //gameController0.show();
        gameController0.show0();
        primaryStage.setTitle("Game Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GameApplication(Map selectedMap, HashMap<Hero, Integer> selectedHeroes) {
        this.selectedMap = selectedMap;
        this.selectedHeroes = selectedHeroes;
    }
}

package com.example.finalproj02.view;

import com.example.finalproj02.model.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UpgradeMapApplication extends Application {
    Player player;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MapController.class.getResource("/com/example/finalproj02/fxmls/upgrade-map-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        UpgradeMapController upgradeMapController = fxmlLoader.getController();
        upgradeMapController.player = player;
        upgradeMapController.show();
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public UpgradeMapApplication(Player player) {
        this.player = player;
    }
}

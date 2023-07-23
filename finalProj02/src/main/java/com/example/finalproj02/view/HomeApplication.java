package com.example.finalproj02.view;

import com.example.finalproj02.model.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HomeApplication extends Application {
    Player player;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeController.class.getResource("/com/example/finalproj02/fxmls/home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HomeController homeController = fxmlLoader.getController();
        homeController.player = player;
        homeController.show00();
        //System.out.println("30: " + player.getMap().getMapID());
        homeController.previewMap();
        homeController.show2();
        homeController.show3();
        homeController.show4();
        primaryStage.setTitle("Home Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public HomeApplication(Player player) {
        System.out.println(player);
        this.player = player;
    }

    public HomeApplication() {
    }
}

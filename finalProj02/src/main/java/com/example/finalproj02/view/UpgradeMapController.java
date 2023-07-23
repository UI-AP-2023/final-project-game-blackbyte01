package com.example.finalproj02.view;

import com.example.finalproj02.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpgradeMapController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button confirm;

    @FXML
    private GridPane heroGridPane;

    @FXML
    private Pane heroPane;
    Player player;
    Audio audio;
    ArrayList<Building> buildings;
    ArrayList<Building> sampleBuildings;

    @FXML
    void confirm(ActionEvent event) throws SQLException, IOException {
        audio.getClickAudioEffect().play();
        new HomeApplication(player).start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    void show() {
        for (Building a : player.getMap().getBuildings()) {
            anchorPane.getChildren().add(a.getImageView());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        audio = new Audio();
        buildings = new ArrayList<>();
        sampleBuildings = new ArrayList<>();
        Building1 building1 = new Building1(10, 10, 50, 50);
        Building2 building2 = new Building2(10, 10, 50, 50);
        Building3 building3 = new Building3(10, 10, 50, 50);
        Building4 building4 = new Building4(10, 10, 50, 50);
        Building5 building5 = new Building5(10, 10, 50, 50);
        building1.makeDraggable(anchorPane, buildings);
        building2.makeDraggable(anchorPane, buildings);
        building3.makeDraggable(anchorPane, buildings);
        building4.makeDraggable(anchorPane, buildings);
        building5.makeDraggable(anchorPane, buildings);
        sampleBuildings.add(building1);
        sampleBuildings.add(building2);
        sampleBuildings.add(building3);
        sampleBuildings.add(building4);
        sampleBuildings.add(building5);
        for (int i = 0; i < sampleBuildings.size(); ++i) {
            ((Pane) ((GridPane) anchorPane.getChildren().get(2)).getChildren().get(i)).getChildren().add(sampleBuildings.get(i).getImageView());
            ((GridPane) anchorPane.getChildren().get(2)).getChildren().get(i).setVisible(true);
        }
    }
}

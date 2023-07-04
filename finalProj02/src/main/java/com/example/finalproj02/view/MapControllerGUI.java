package com.example.finalproj02.view;

import com.example.finalproj02.controller.MapController;
import com.example.finalproj02.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class MapControllerGUI implements Initializable {
    int playerID;
    ArrayList<Building> newBuildings;
    MapController mapController;
    @FXML
    private TextField b1Tf;

    @FXML
    private TextField b2Tf;

    @FXML
    private TextField b3Tf;

    @FXML
    private TextField b4Tf;

    @FXML
    private TextField b5Tf;

    @FXML
    private Button confirm;

    @FXML
    private AnchorPane pane;

    @FXML
    private Button save;

    @FXML
    private ImageView imgV;

    @FXML
    private Pane pane1;
    @FXML
    private Button btn;

    void method() throws SQLException {
        for(Building a: mapController.findMap(playerID).getBuildings()){
            System.out.println(a.getImageView().getLayoutX());
            System.out.println(a.getImageView().getLayoutY());
            pane1.getChildren().add(a.getImageView());
        }
        pane1.setVisible(true);
    }

    @FXML
    void confirm(ActionEvent event) {
        for(int i=0; i<Integer.parseInt(b1Tf.getText()); ++i)
            newBuildings.add(new Building1(10, 10, 100, 100));
        for(int i=0; i<Integer.parseInt(b2Tf.getText()); ++i)
            newBuildings.add(new Building2(10, 10, 100, 100));
        for(int i=0; i<Integer.parseInt(b3Tf.getText()); ++i)
            newBuildings.add(new Building3(10, 10, 100, 100));
        for(int i=0; i<Integer.parseInt(b4Tf.getText()); ++i)
            newBuildings.add(new Building4(10, 10, 100, 100));
        for(int i=0; i<Integer.parseInt(b5Tf.getText()); ++i)
            newBuildings.add(new Building5(10, 10, 100, 100));
        for(Building a: newBuildings) {
            a.makeImageViewDraggable();
            pane.getChildren().add(a.getImageView());
        }
    }

    @FXML
    void save(ActionEvent event) throws SQLException {
        mapController.saveNewMap(playerID, newBuildings);
    }

    @FXML
    void btn(ActionEvent event) throws SQLException {
        for(Building a: newBuildings){
            System.out.println("1: " + a.getImageView().getLayoutX());
            System.out.println("2: " + a.getImageView().localToScene(a.getImageView().getBoundsInLocal()).getMinX());
        }
        System.out.println("ID:" + playerID);
        for(Building a: mapController.findMap(playerID).getBuildings()){
            System.out.println();
            a.makeImageViewDraggable();
            pane.getChildren().add(a.getImageView());
        }
        /*
        Building building=newBuildings.get(0);
        Bounds bounds = building.getImageView().localToScene(building.getImageView().getBoundsInLocal());
        Building1 building2=new Building1(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight());
        building2.makeImageViewDraggable();
        pane.getChildren().add(building2.getImageView());
         */
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mapController= MapController.getInstance();
        newBuildings=new ArrayList<>();
    }
}

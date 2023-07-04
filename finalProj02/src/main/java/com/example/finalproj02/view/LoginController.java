package com.example.finalproj02.view;

import com.example.finalproj02.controller.MapController;
import com.example.finalproj02.controller.PlayerController;
import com.example.finalproj02.model.Map;
import com.example.finalproj02.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    PlayerController playerController;
    MapController mapController;
    Player player;
    @FXML
    private Button loginBtn;

    @FXML
    private TextField passwordTf;

    @FXML
    private Button signupBtn;

    @FXML
    private TextField usernameTf;

    @FXML
    void loginBtn(ActionEvent event) throws SQLException, IOException {
        player=playerController.login(usernameTf.getText(), passwordTf.getText());
        Map map=mapController.findMap(player.getPlayerID());
        player.setMap(map);
        //System.out.println(player.getUsername());
        //System.out.println(player.getMap().getMapID());
        //System.out.println(player.getPlayerID());
        new HomeApplication(player).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void signupBtn(ActionEvent event) throws IOException {
        new SignupApplication().start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerController=PlayerController.getInstance();
        mapController=MapController.getInstance();
    }
}

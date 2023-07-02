package com.example.finalproj02.view;

import com.example.finalproj02.controller.PlayerController;
import com.example.finalproj02.model.Player;
import com.example.finalproj02.view.LoginApplication;
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

public class SignupController implements Initializable {
    PlayerController playerController;
    Player player;
    @FXML
    private Button backBtn;

    @FXML
    private TextField passwordTf;

    @FXML
    private Button signupBtn;

    @FXML
    private TextField usernameTf;

    @FXML
    void backBtn(ActionEvent event) throws IOException {
        new LoginApplication().start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void signupBtn(ActionEvent event) throws IOException, SQLException {  // chosing level here
        int playerID=playerController.signup(usernameTf.getText(), passwordTf.getText(),  0, 0, 0);
        player=new Player(playerID, usernameTf.getText(), "player", passwordTf.getText(), 0, 0, 0);
        new HomeApplication(player).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerController=PlayerController.getInstance();
    }
}

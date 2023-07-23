package com.example.finalproj02.view;

import com.example.finalproj02.controller.PlayerController;
import com.example.finalproj02.exceptions.InvalidPasswordException;
import com.example.finalproj02.model.Audio;
import com.example.finalproj02.model.Player;
import com.example.finalproj02.view.LoginApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    PlayerController playerController;
    Player player;
    Audio audio;
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
        audio.getClickAudioEffect().play();
        new LoginApplication().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void signupBtn(ActionEvent event) throws IOException, SQLException {  // chosing level here
        audio.getClickAudioEffect().play();
        int playerID = 0;
        try {
            playerID = playerController.signup(usernameTf.getText(), passwordTf.getText(), 1, 0, 0);
            player = new Player(playerID, usernameTf.getText(), "player", passwordTf.getText(), 1, 0, 0);
            new HomeApplication(player).start((Stage) ((Node) event.getSource()).getScene().getWindow());
            audio.getPregameAudioEffect().play();
        } catch (InvalidPasswordException e) {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/finalproj02/styles/general-styles.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/finalproj02/images/icons/app-icon.png"))));
            alert.setTitle("Warning!");
            alert.setHeaderText("Invalid password Information");
            alert.setContentText("Try again! \nCurrent password is not strong enough.");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerController = PlayerController.getInstance();
        audio = new Audio();
    }
}

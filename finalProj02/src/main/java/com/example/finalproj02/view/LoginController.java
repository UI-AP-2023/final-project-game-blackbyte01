package com.example.finalproj02.view;

import com.example.finalproj02.controller.MapController;
import com.example.finalproj02.controller.PlayerController;
import com.example.finalproj02.exceptions.PlayerNotFoundException;
import com.example.finalproj02.model.Audio;
import com.example.finalproj02.model.Map;
import com.example.finalproj02.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    PlayerController playerController;
    MapController mapController;
    Player player;
    Audio audio;
    @FXML
    private AnchorPane loginAnchorPan;
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
        audio.getClickAudioEffect().play();
        try {
            player = playerController.login(usernameTf.getText(), passwordTf.getText());
            Map map = mapController.findMap(player.getPlayerID());
            player.setMap(map);
            new HomeApplication(player).start((Stage) ((Node) event.getSource()).getScene().getWindow());
            audio.getPregameAudioEffect().play();
        } catch (PlayerNotFoundException e) {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/finalproj02/styles/general-styles.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/finalproj02/images/icons/app-icon.png"))));
            alert.setTitle("Warning!");
            alert.setHeaderText("Incorrect Information");
            alert.setContentText("Try again! \nUser name or password is not correct.");
            alert.showAndWait();
        }
    }

    @FXML
    void signupBtn(ActionEvent event) throws IOException {
        audio.getClickAudioEffect().play();
        new SignupApplication().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerController = PlayerController.getInstance();
        mapController = MapController.getInstance();
        audio = new Audio();
    }
}

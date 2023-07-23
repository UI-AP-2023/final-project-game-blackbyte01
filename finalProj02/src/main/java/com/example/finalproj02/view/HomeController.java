package com.example.finalproj02.view;

import com.example.finalproj02.controller.BuildingController;
import com.example.finalproj02.controller.HeroController;
import com.example.finalproj02.controller.MapController;
import com.example.finalproj02.controller.PlayerController;
import com.example.finalproj02.model.*;
import com.example.finalproj02.model.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class HomeController implements Initializable {
    Player player;
    HeroController heroController;
    BuildingController buildingController;
    MapController mapController;
    PlayerController playerController;
    ArrayList<Integer> selectedIDs = new ArrayList<>();
    HashMap<Hero, Integer> selectedHeroes = new HashMap<>();
    Map acceptedMap;
    Hero currentHero;
    Audio audio;

    @FXML
    private Button buildingsButton;

    @FXML
    private Button heroesButton;

    @FXML
    private Button createMap;

    @FXML
    private Button startGameBtn;

    @FXML
    private TextField numberTf;

    @FXML
    private GridPane choseHeroesGridP;

    @FXML
    private ImageView heroImageView;

    @FXML
    private AnchorPane choseHeroAnchorPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private GridPane heroesGridP;

    @FXML
    private Label infoLabel;

    @FXML
    private Pane bgImagePane;

    @FXML
    private Pane infoPane;

    @FXML
    private Label playerInfoLabel;

    @FXML
    private Button nextBtn;

    @FXML
    private AnchorPane attackAncPane;

    @FXML
    private GridPane mapsGridPane;

    @FXML
    private Label CMapLbl;

    @FXML
    private Button acceptBtn;

    @FXML
    private Pane bgImagePaneGP;

    @FXML
    private AnchorPane BHAnchorPane;

    @FXML
    private Button backButton;

    @FXML
    private VBox buttonVBox;

    @FXML
    private Pane heroCountPane;

    @FXML
    private Button viewMyMap;

    @FXML
    void viewMyMap(ActionEvent event) throws IOException, SQLException {
        audio.getClickAudioEffect().play();
        if(mapController.findMap(player.getPlayerID()).getMapID()==0){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/finalproj02/styles/general-styles.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/finalproj02/images/icons/app-icon.png"))));
            alert.setTitle("Warning!");
            alert.setHeaderText("Map Not Found");
            alert.setContentText("Seems like u haven't made ur map yet!\nTry it first");
            alert.showAndWait();
        }else{
            new UpgradeMapApplication(player).start((Stage) ((Node) event.getSource()).getScene().getWindow());
        }
    }

    @FXML
    void backButton(ActionEvent event) {
        audio.getClickAudioEffect().play();
        invisibleAll();
        buttonVBox.setVisible(true);
    }

    void show00() throws SQLException {
        invisibleAll();
        heroesGridP.setVisible(true);
        infoPane.setVisible(true);
        buildingsButton.setVisible(true);
        show();
        ((ImageView) ((Pane) infoPane.getChildren().get(0)).getChildren().get(0)).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(heroController.getSampleHeroes().get(0).getPath()))));
        ((Label) infoPane.getChildren().get(1)).setText(heroController.getSampleHeroes().get(0).toString());
    }

    @FXML
    void heroesButton(ActionEvent event) throws SQLException {
        audio.getClickAudioEffect().play();
        invisibleAll();
        heroesGridP.setVisible(true);
        infoPane.setVisible(true);
        backButton.setVisible(true);
        show();
        ((ImageView) ((Pane) infoPane.getChildren().get(0)).getChildren().get(0)).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(heroController.getSampleHeroes().get(0).getPath()))));
        ((Label) infoPane.getChildren().get(1)).setText(heroController.getSampleHeroes().get(0).toString());
    }

    void invisibleAll() {
        for (Node a : BHAnchorPane.getChildren()) {
            a.setVisible(false);
        }
    }

    @FXML
    void buildingsButton(ActionEvent event) throws SQLException {
        audio.getClickAudioEffect().play();
        invisibleAll();
        heroesGridP.setVisible(true);
        infoPane.setVisible(true);
        heroesButton.setVisible(true);
        //backButton.setVisible(true);
        show01();
        ((ImageView) ((Pane) infoPane.getChildren().get(0)).getChildren().get(0)).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(buildingController.getSampleBuildings().get(0).getPath()))));
        ((Label) infoPane.getChildren().get(1)).setText(buildingController.getSampleBuildings().get(0).toString());
    }

    @FXML
    void createMap(ActionEvent event) throws IOException {
        audio.getClickAudioEffect().play();
        new MapApplication(player).start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }


    void show01() {
        for (int i = 0; i < buildingController.getSampleBuildings().size(); ++i)
            ((Button) heroesGridP.getChildren().get(i)).setGraphic(buildingController.getSampleBuildings().get(i).getImageView());
        heroesGridP.getChildren().forEach(n -> ((Button) n).setOnAction(event -> {
            audio.getClickAudioEffect().play();
            ((ImageView) ((Pane) infoPane.getChildren().get(0)).getChildren().get(0)).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(buildingController.getSampleBuildings().get(heroesGridP.getChildren().indexOf(n)).getPath()))));
            ((Label) infoPane.getChildren().get(1)).setText(buildingController.getSampleBuildings().get(heroesGridP.getChildren().indexOf(n)).toString());
            infoPane.setVisible(true);
        }));
    }

    void show() throws SQLException {
        for (int i = 0; i < 3; ++i)
            ((Button) heroesGridP.getChildren().get(i)).setGraphic(heroController.getSampleHeroes().get(i).getImageView());
        heroesGridP.getChildren().forEach(n -> ((Button) n).setOnAction(event -> {
            audio.getClickAudioEffect().play();
            ((ImageView) ((Pane) infoPane.getChildren().get(0)).getChildren().get(0)).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(heroController.getSampleHeroes().get(heroesGridP.getChildren().indexOf(n)).getPath()))));
            ((Label) infoPane.getChildren().get(1)).setText(heroController.getSampleHeroes().get(heroesGridP.getChildren().indexOf(n)).toString());
            infoPane.setVisible(true);
        }));
    }

    @FXML
    void nextBtn(ActionEvent event) throws SQLException {
        audio.getClickAudioEffect().play();
        attackAncPane.getChildren().removeIf(a -> attackAncPane.getChildren().indexOf(a) > 4);
        previewMap();
    }

    @FXML
    void acceptBtn(ActionEvent event) throws SQLException {
        audio.getClickAudioEffect().play();
        acceptedMap = mapController.findMap(selectedIDs.get((selectedIDs.size()) - 1));
        show4();
        invisibleAll1();
        choseHeroesGridP.setVisible(true);
        heroCountPane.setVisible(true);
    }

    void previewMap() throws SQLException {
        Random random = new Random();
        int playerID = random.nextInt(playerController.getMinPlayerID(), playerController.getMaxPlayerID() + 1);
        while (selectedIDs.contains(playerID) || playerID == player.getPlayerID() || mapController.findMap(playerID).getBuildings().size() == 0) {
            playerID = random.nextInt(playerController.getMinPlayerID(), playerController.getMaxPlayerID() + 1);
        }
        selectedIDs.add(playerID);
        Map map = mapController.findMap(playerID);
        for (Building a : map.getBuildings()) {
            System.out.println(a.getBounds());
            a.getImageView().setLayoutX(((a.getImageView().getLayoutX() * 658) / 1177) - 80);
            a.getImageView().setLayoutY((a.getImageView().getLayoutY() * 433) / 716);
            a.getImageView().setFitWidth((a.getImageView().getFitWidth() * 658) / 1177);
            a.getImageView().setFitHeight((a.getImageView().getFitHeight() * 433) / 716);
            attackAncPane.getChildren().add(a.getImageView());
        }
    }

    void show2() {
        playerInfoLabel.setText(player.toString());
    }

    void show3() {
        CMapLbl.setText("First of all ... \nCreate a map for yourself \nYour will be shown to other players to be attacked on.\nYou can upgrade it later if you want\nNow try it  : )");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        heroController = HeroController.getInstance();
        buildingController = BuildingController.getInstance();
        mapController = MapController.getInstance();
        playerController = PlayerController.getInstance();
        audio = new Audio();
    }

    void show4() {
        images();
        for (int i = 0; i < 3; ++i) {
            if (heroController.getSampleHeroes().get(i).getLevel() > player.getLevel()) {
                choseHeroesGridP.getChildren().get(i).setDisable(true);
            }
        }
        choseHeroesGridP.getChildren().forEach(n -> ((Button) n).setOnAction(e -> {
            audio.getClickAudioEffect().play();
            numberTf.setText("");
            currentHero = heroController.getSampleHeroes().get(choseHeroesGridP.getChildren().indexOf(n));
            heroImageView.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(currentHero.getPath()))));
            System.out.println(currentHero);
        }));
    }

    void images() {
        ImageView imageView0 = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/finalproj02/images/elements/sprites/axe-man/axeMan00.png"))));
        ImageView imageView1 = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/finalproj02/images/elements/sprites/sword-man/swordMan00.png"))));
        ImageView imageView2 = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/finalproj02/images/elements/sprites/hammer-man/hammerMan00.png"))));
        imageView0.setFitWidth(85);
        imageView0.setFitHeight(85);
        imageView1.setFitWidth(85);
        imageView1.setFitHeight(85);
        imageView2.setFitWidth(85);
        imageView2.setFitHeight(85);
        ((Button) choseHeroesGridP.getChildren().get(0)).setGraphic(imageView0);
        ((Button) choseHeroesGridP.getChildren().get(1)).setGraphic(imageView1);
        ((Button) choseHeroesGridP.getChildren().get(2)).setGraphic(imageView2);
    }

    void invisibleAll1() {
        attackAncPane.getChildren().forEach(n -> n.setVisible(false));
    }

    @FXML
    void confirmBtn(ActionEvent event) {
        audio.getClickAudioEffect().play();
        if (currentHero instanceof Hero1)
            selectedHeroes.put(new Hero1(5, 5, 70, 70), Integer.parseInt(numberTf.getText()));
        else if (currentHero instanceof Hero2)
            selectedHeroes.put(new Hero2(5, 5, 70, 70), Integer.parseInt(numberTf.getText()));
        else if (currentHero instanceof Hero3)
            selectedHeroes.put(new Hero3(5, 5, 70, 70), Integer.parseInt(numberTf.getText()));
    }

    @FXML
    void startGameBtn(ActionEvent event) throws IOException, SQLException {
        audio.getPregameAudioEffect().stop();
        new GameApplication(acceptedMap, selectedHeroes).start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
}

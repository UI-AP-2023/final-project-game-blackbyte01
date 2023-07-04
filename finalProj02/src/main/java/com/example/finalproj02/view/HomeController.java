package com.example.finalproj02.view;

import com.example.finalproj02.controller.HeroController;
import com.example.finalproj02.controller.MapController;
import com.example.finalproj02.controller.PlayerController;
import com.example.finalproj02.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    Player player;
    HeroController heroController;
    MapController mapController;
    PlayerController playerController;
    ArrayList<Integer> selectedIDs=new ArrayList<>();
    ArrayList<Hero> selectedHeroes=new ArrayList<>();
    Map acceptedMap;
    Hero currentHero;
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

    boolean isAccepted;
    @FXML
    private Pane bgImagePaneGP;


    @FXML
    void createMap(ActionEvent event) throws IOException {
        new MapApplication0(player).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    void show() throws SQLException {
        for(int i=0; i<heroController.getSampleHeroes().size(); ++i)
            ((Button)heroesGridP.getChildren().get(i)).setText("Hero" + i);
            //((Button)heroesGridP.getChildren().get(i)).setGraphic(heroController.getSampleHeroes().get(i).getImageView());
        heroesGridP.getChildren().forEach(n->((Button)n).setOnAction(event -> {
            ((ImageView)((Pane)infoPane.getChildren().get(0)).getChildren().get(0)).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(heroController.getSampleHeroes().get(heroesGridP.getChildren().indexOf(n)).getPath()))));
            //((ImageView)infoPane.getChildren().get(0)).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(heroController.getSampleHeroes().get(heroesGridP.getChildren().indexOf(n)).getPath()))));
            ((Label)infoPane.getChildren().get(1)).setText(heroController.getSampleHeroes().get(heroesGridP.getChildren().indexOf((Node) n)).toString());
            infoPane.setVisible(true);
        }));
    }

    @FXML
    void nextBtn(ActionEvent event) throws SQLException {
        attackAncPane.getChildren().removeIf(a -> attackAncPane.getChildren().indexOf(a) > 2);
        previewMap();
    }

    @FXML
    void acceptBtn(ActionEvent event) throws SQLException {
        acceptedMap=mapController.findMap(selectedIDs.get((selectedIDs.size())-1));
        System.out.println("1: " + acceptedMap);
        attackAncPane.getChildren().clear();
    }

    void previewMap() throws SQLException {
        Random random=new Random();
        int playerID=random.nextInt(playerController.getMinPlayerID(), playerController.getMaxPlayerID());
        while (selectedIDs.contains(playerID) || playerID==player.getPlayerID()){
            playerID=random.nextInt(playerController.getMinPlayerID(), playerController.getMaxPlayerID());
        }
        selectedIDs.add(playerID);
        Map map=mapController.findMap(playerID);
        System.out.println("home controller: " + map.getBuildings());
        for(Building a: map.getBuildings()){
            System.out.println(a.getBounds());
            a.getImageView().setLayoutX((a.getImageView().getLayoutX()*658)/1076);
            a.getImageView().setLayoutY((a.getImageView().getLayoutY()*433)/697);
            a.getImageView().setFitWidth((a.getImageView().getFitWidth()*658)/1076);
            a.getImageView().setFitHeight((a.getImageView().getFitHeight()*433)/697);
            attackAncPane.getChildren().add(a.getImageView());
        }
    }

    void show2(){
        playerInfoLabel.setText(player.toString());
    }

    void show3(){
        CMapLbl.setText("First of all ... \nCreate a map for yourself \nYour will be shown to other players to be attacked on.\nYou can upgrade it later if you want\nNow try it  : )");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        heroController=HeroController.getInstance();
        mapController=MapController.getInstance();
        playerController=PlayerController.getInstance();

    }

    void show4(){
        for(int i=0; i<heroController.getSampleHeroes().size(); ++i){
            ((Button)choseHeroesGridP.getChildren().get(i)).setText("Hero" + (i+1));
            if(heroController.getSampleHeroes().get(i).getLevel()>player.getLevel()){
                ((Button)choseHeroesGridP.getChildren().get(i)).setDisable(true);
            }
        }
        choseHeroesGridP.getChildren().forEach(n->((Button)n).setOnAction(e -> {
            numberTf.setText("");
            currentHero=heroController.getSampleHeroes().get(choseHeroesGridP.getChildren().indexOf(n));
            heroImageView.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(currentHero.getPath()))));
            System.out.println(currentHero);
        }));
    }

    @FXML
    void confirmBtn(ActionEvent event) {
        for(int i=0; i<Integer.parseInt(numberTf.getText()); ++i){
            if(currentHero instanceof Hero1){
                selectedHeroes.add(new Hero1(10, 10, 50, 50));
            }
            else if(currentHero instanceof Hero2){
                selectedHeroes.add(new Hero2(10, 10, 50, 50));
            }
            else if(currentHero instanceof Hero3){
                selectedHeroes.add(new Hero3(10, 10, 50, 50));
            }else if(currentHero instanceof Hero4){
                selectedHeroes.add(new Hero4(10, 10, 50, 50));
            }else if(currentHero instanceof Hero5){
                selectedHeroes.add(new Hero5(10, 10, 50, 50));
            }
        }
        System.out.println(selectedHeroes);
    }

    @FXML
    void startGameBtn(ActionEvent event) throws IOException {
        System.out.println("start game: " + acceptedMap.getBuildings().size());
        new GameApplication(acceptedMap, selectedHeroes).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }
}

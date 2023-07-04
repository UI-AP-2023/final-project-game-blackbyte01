package com.example.finalproj02.model;

import com.example.finalproj02.controller.PlayerController;
import com.mysql.cj.CancelQueryTaskImpl;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Game {
    private final GameGround gameGround;
    PlayerController playerController;
    Timeline timeline;
    int playerSide, mapSide;
    private final ArrayList<Hero> heroes;  // selected heroes
    private final ArrayList<Building> buildings;
    private final Pane pane;
    boolean isOver;
    private Label resultLabel;
    public Game(Pane pane, Label resultLabel, GameGround gameGround, ArrayList<Hero> heroes){
        this.pane=pane;
        this.resultLabel=resultLabel;
        this.gameGround=gameGround;
        this.buildings=gameGround.loadMap(pane);
        playerController=PlayerController.getInstance();
        this.heroes=heroes;
        loadHeroes();
        startTimeLine();
    }

    private void loadHeroes(){
        for(int i=0; i<unique(heroes).size(); ++i){
            ((Pane)((GridPane)pane.getChildren().get(1)).getChildren().get(i)).getChildren().add(heroes.get(i).getImageView());
            ((GridPane)pane.getChildren().get(1)).getChildren().get(i).setVisible(true);
        }
    }

    private ArrayList<Hero> unique(ArrayList<Hero> heroes){
        ArrayList<Hero> heroes1=new ArrayList<>();
        for(Hero a: heroes){
            if(a instanceof Hero1){
                heroes1.add(new Hero1(10, 10, 50, 50));
                break;
            }
        }
        for(Hero a: heroes){
            if(a instanceof Hero2){
                heroes1.add(new Hero2(10, 10, 50, 50));
                break;
            }
        }
        for(Hero a: heroes){
            if(a instanceof Hero3){
                heroes1.add(new Hero3(10, 10, 50, 50));
                break;
            }
        }
        for(Hero a: heroes){
            if(a instanceof Hero4){
                heroes1.add(new Hero4(10, 10, 50, 50));
                break;
            }
        }
        for(Hero a: heroes){
            if(a instanceof Hero5){
                heroes1.add(new Hero5(10, 10, 50, 50));
                break;
            }
        }
        return heroes1;
    }

    public GameGround getGameGround() {
        return gameGround;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }


    public void startTimeLine(){
        timeline=new Timeline(new KeyFrame(Duration.millis(10), e->checkAllHeroes()));
        timeline.setCycleCount(Animation.INDEFINITE);
        method1();
        timeline.play();
    }

    public void method1(){
        for(Hero a: heroes){
            AtomicReference<Hero> heroAtomicReference=new AtomicReference<>();
            a.getImageView().setOnMousePressed(e -> {
                heroAtomicReference.set(copyHero(a));
                if(heroIsRemained(a)){
                    pane.getChildren().add(heroAtomicReference.get().getImageView());
                }
                a.mousePressedX=e.getSceneX()-heroAtomicReference.get().getImageView().getTranslateX();
                a.mousePressedY=e.getSceneY()-heroAtomicReference.get().getImageView().getTranslateY();
            });

            a.getImageView().setOnMouseDragged(e->{
                heroAtomicReference.get().getImageView().setTranslateX(e.getSceneX()-a.mousePressedX);
                heroAtomicReference.get().getImageView().setTranslateY(e.getSceneY()-a.mousePressedY);
            });

            a.getImageView().setOnMouseReleased(e->{  // check position released
                gameGround.getHeroes().add(heroAtomicReference.get());
                heroAtomicReference.get().setAttacking(false);
                heroAtomicReference.get().setWalking(false);
                //startGame(heroAtomicReference.get());
            });
        }
    }

    private boolean heroIsRemained(Hero hero) {
        for (Hero a : heroes) {
            if (((a instanceof Hero1) && (hero instanceof Hero1)) || ((a instanceof Hero2) && (hero instanceof Hero2)) || ((a instanceof Hero3) && (hero instanceof Hero3)) || ((a instanceof Hero4) && (hero instanceof Hero4)) || ((a instanceof Hero5) && (hero instanceof Hero5))) {
                heroes.remove(a);
                return true;
            }
        }
        return false;
    }

    private Hero copyHero(Hero hero){
        if(hero instanceof Hero1)
            return ((Hero1)hero).getCopy();
        else if(hero instanceof Hero2)
            return ((Hero2) hero).getCopy();
        else if(hero instanceof Hero3)
            return ((Hero3) hero).getCopy();
        else if(hero instanceof Hero4)
            return ((Hero4) hero).getCopy();
        else
            return ((Hero5) hero).getCopy();
    }

    public void checkAllHeroes(){
        for(Hero a: gameGround.getHeroes()){
            if(!a.isAttacking() && !a.isWalking()){
                startWalking(a);
            }
            if(a.isWalking()){
                if(a.isInArea()){  // set radius in translate transition
                    System.out.println("start attacking");
                    a.setWalking(false);
                    a.setAttacking(true);
                    a.setTimeline(new Timeline(new KeyFrame(Duration.millis(1000), e->checkHealths(a, a.getBuilding()))));
                    a.getTimeline().setCycleCount(10);
                    a.getTimeline().play();
                    /*
                    if(a instanceof Hero4){
                        ((Hero4)a).setArrow();
                        pane.getChildren().add(((Hero4) a).getArrow());
                        ((Hero4) a).setArrowTimeLine();
                    }
                    if(a.getBuilding() instanceof DBuilding){
                        a.getBuilding()
                    }
                    /*
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //System.out.println("new thread is running");
                            checkHealths(a, a.getBuilding());
                        }
                    }).start();
                     */
                }
            }
        }
    }

    public void checkHealths(Hero hero, Building building) {
        if(building instanceof DBuilding){
            hero.setHealth(hero.getHealth()- ((DBuilding) building).getDamage());
            building.setHealth(building.getHealth()-hero.getDamage());
        }
        else{
            hero.setHealth(hero.getHealth()-1);
            building.setHealth(building.getHealth()-hero.getDamage());
        }
        if(hero.getHealth()<=0){
            heroes.remove(hero);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pane.getChildren().remove(hero.getImageView());
                }
            });
            hero.setAttacking(false);
            checkGameOver();
        }
        else if(building.getHealth()<=0){
            buildings.remove(building);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pane.getChildren().remove(building.getImageView());
                }
            });
            hero.setAttacking(false);
            checkGameOver();
            hero.stopTimeLine();
        }
    }

    /*
    public void checkHealths(Hero hero, Building building){
        System.out.println("check health");
        System.out.println("hero: " + hero.getHealth());
        System.out.println("building: " + hero.getBuilding().getHealth());
        while (hero.getHealth()>0 && building.getHealth()>0){
            if(building instanceof DBuilding){
                System.out.println("1");
                hero.setHealth(hero.getHealth()- ((DBuilding) building).getDamage());
                building.setHealth(building.getHealth()-hero.getDamage());
            }
            else{
                System.out.println("2");
                hero.setHealth(hero.getHealth()-1);
                building.setHealth(building.getHealth()-hero.getDamage());
            }
            if(hero.getHealth()<=0){
                //--playerSide;
                System.out.println("3");
                heroes.remove(hero);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        pane.getChildren().remove(hero.getImageView());
                        // do your GUI stuff here
                    }
                });
                hero.setAttacking(false);
                checkGameOver();
            }
            else if(building.getHealth()<=0){
                //++playerSide;
                System.out.println("4");
                buildings.remove(building);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        pane.getChildren().remove(building.getImageView());
                        // do your GUI stuff here
                    }
                });
                hero.setAttacking(false);
                checkGameOver();
            }
        }
    }
     */
    private void checkGameOver(){
        if(buildings.size()==0 || heroes.size()==0){
            timeline.stop();
            if(buildings.size()==0){

                resultLabel.setText("Game Over\nYou won the game");
            }
            else{
                resultLabel.setText("Game Over\nYou lost the game");
            }
        }
        resultLabel.setVisible(true);
    }

    public void startWalking(Hero hero){
        TranslateTransition translateTransition=new TranslateTransition();
        translateTransition.setNode(hero.getImageView());
        //translateTransition.setDelay(Duration.millis(1000));
        //Building building=hero.findBestBuilding(buildings);
        hero.findBestBuilding(buildings);
        hero.setTranslateTarget(translateTransition);
    }

    public void determineRadius(Hero hero, Building building, TranslateTransition translateTransition){
        if(hero instanceof Hero4 && building.getRadius()==0){
            setTranslateTarget(hero, building, ((Hero4)hero).getRadius(), translateTransition);
        }
        else{
            setTranslateTarget(hero, building, building.getRadius(), translateTransition);
        }
    }

    public void setTranslateTarget(Hero hero, Building building, double radius, TranslateTransition translateTransition){
        if((hero.getBounds().getCenterX()<building.getBounds().getCenterX()) && (hero.getBounds().getCenterY()<building.getBounds().getCenterY())){
            translateTransition.setToX(building.getBounds().getCenterX()-hero.centerX-radius);
            translateTransition.setToY(building.getBounds().getCenterY()-hero.centerY-radius);
        }
        else if((hero.getBounds().getCenterX()>building.getBounds().getCenterX()) && (hero.getBounds().getCenterY()<building.getBounds().getCenterY())){
            translateTransition.setToX(building.getBounds().getCenterX()-hero.centerX+radius);
            translateTransition.setToY(building.getBounds().getCenterY()-hero.centerY-radius);
        }
        else if((hero.getBounds().getCenterX()>building.getBounds().getCenterX()) && (hero.getBounds().getCenterY()>building.getBounds().getCenterY())){
            translateTransition.setToX(building.getBounds().getCenterX()-hero.centerX+radius);
            translateTransition.setToY(building.getBounds().getCenterY()-hero.centerY+radius);
        }
        else{
            translateTransition.setToX(building.getBounds().getCenterX()-hero.centerX-radius);
            translateTransition.setToY(building.getBounds().getCenterY()-hero.centerY+radius);
        }
    }

    public void updateGame(){}
}

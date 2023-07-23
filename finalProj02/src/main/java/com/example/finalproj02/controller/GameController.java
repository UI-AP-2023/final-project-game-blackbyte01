package com.example.finalproj02.controller;

import com.example.finalproj02.model.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class GameController {
    private static final GameController instance = new GameController();
    private Game game;

    private GameController() {
    }

    public static GameController getInstance() {
        return instance;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(GameGround gameGround0, Pane resultPane) {
        this.game = new Game(gameGround0, resultPane);
    }

    public void makeAllDraggable() {
        for (java.util.Map.Entry<Hero, Integer> a : game.getGameGround0().getSelectedHeroes().entrySet()) {
            AtomicBoolean isFirst = new AtomicBoolean(false);
            AtomicReference<Hero> heroAtomicReference = new AtomicReference<>();
            a.getKey().getImageView().setOnMousePressed(e -> {
                heroAtomicReference.set(copyHero(a.getKey()));
                if (heroIsRemained(a.getKey())) {
                    System.out.println("2");
                    game.getGameGround0().getGamePane().getChildren().add(heroAtomicReference.get().getImageView());
                }
                a.getKey().mousePressedX = e.getSceneX() - heroAtomicReference.get().getImageView().getTranslateX();
                a.getKey().mousePressedY = e.getSceneY() - heroAtomicReference.get().getImageView().getTranslateY();
            });

            a.getKey().getImageView().setOnMouseDragged(e -> {
                heroAtomicReference.get().getImageView().setTranslateX(e.getSceneX() - a.getKey().mousePressedX);
                heroAtomicReference.get().getImageView().setTranslateY(e.getSceneY() - a.getKey().mousePressedY);
            });

            a.getKey().getImageView().setOnMouseReleased(e -> {  // check position released
                game.getGameGround0().getPlayingHeroes().add(heroAtomicReference.get());
                heroAtomicReference.get().getGroup().setLayoutX(heroAtomicReference.get().getImageView().getTranslateX() + heroAtomicReference.get().getImageView().getLayoutX());
                heroAtomicReference.get().getGroup().setLayoutY(heroAtomicReference.get().getImageView().getTranslateY() + heroAtomicReference.get().getImageView().getLayoutY());
                if (game.getGameGround0().getGamePane().getChildren().remove(heroAtomicReference.get().getImageView())) {
                    if (!isFirst.get()) {
                        if (heroAtomicReference.get() instanceof Hero1) {
                            game.getAudio().getAxeManEntranceAudioEffect().play();
                        } else if (heroAtomicReference.get() instanceof Hero3) {
                            game.getAudio().getHammerManEntranceAudioEffect().play();
                        }
                        isFirst.set(true);
                    }
                    game.getGameGround0().getGamePane().getChildren().add(heroAtomicReference.get().getGroup());
                }
                heroAtomicReference.get().setAttacking(false);
                heroAtomicReference.get().setWalking(false);
            });
        }
    }

    private Hero copyHero(Hero hero) {
        if (hero instanceof Hero1)
            return ((Hero1) hero).getCopy();
        else if (hero instanceof Hero2)
            return ((Hero2) hero).getCopy();
        else
            return ((Hero3) hero).getCopy();
    }

    private boolean heroIsRemained(Hero hero) {
        for (java.util.Map.Entry<Hero, Integer> a : game.getGameGround0().getSelectedHeroes().entrySet()) {
            if (a.getKey().equals(hero) && a.getValue() > 0) {
                a.setValue(a.getValue() - 1);
                System.out.println(a.getValue());
                return true;
            }
        }
        return false;
    }

    public void startTimeLine() {
        game.setGameTimeline(new Timeline(new KeyFrame(Duration.millis(10), e -> checkAllHeroes())));
        game.getGameTimeline().setCycleCount(Animation.INDEFINITE);
        game.getGameTimeline().play();
    }

    public void checkAllHeroes() {
        for (Hero a : game.getGameGround0().getPlayingHeroes()) {
            if (!a.isAttacking() && !a.isWalking()) {
                startWalking0(a);
                a.setWalking(true);
            }
            if (a.isWalking()) {
                if (a.isInArea0()) {
                    a.setWalking(false);
                    a.setAttacking(true);
                }
            }
            if (a.isAttacking()) {
                startHeroAttacking0(a);
            }
        }
    }

    public void startWalking0(Hero hero) {
        hero.setBuilding(hero.findNeatestBuilding(game.getGameGround0().getSelectedMap().getBuildings()));
        hero.animateImageViews().play();
        hero.translateAnimation(hero.getBuilding()).play();
    }

    public void startHeroAttacking0(Hero hero) {
        hero.getAttackTimeLine().setCycleCount(Animation.INDEFINITE);
        hero.getAttackTimeLine().getKeyFrames().add(new KeyFrame(Duration.millis(1000), e -> checkHealths0(hero)));
        hero.getAttackTimeLine().play();
    }

    public void checkHealths0(Hero hero) {
        if (hero.getBuilding() instanceof DBuilding) {
            hero.setHealth(hero.getHealth() - ((DBuilding) hero.getBuilding()).getDamage());
            hero.getBuilding().setHealth(hero.getBuilding().getHealth() - hero.getDamage());
        } else {
            hero.setHealth(hero.getHealth() - 1);
            hero.getBuilding().setHealth(hero.getBuilding().getHealth() - hero.getDamage());
        }
        if (hero.getHealth() <= 0) {
            game.getGameGround0().getPlayingHeroes().remove(hero);
            game.getGameGround0().getGamePane().getChildren().remove(hero.getGroup());
            hero.setAttacking(false);
            checkGameIsOver();
        } else if (hero.getBuilding().getHealth() <= 0) {
            if (hero.getBuilding() instanceof DBuilding) {
                ((DBuilding) hero.getBuilding()).getDBuildingEquipment().getRemoveTimeline().stop();
            }
            game.getAudio().getBuildingCrashingAudioEffect().play();
            game.getGameGround0().getSelectedMap().getBuildings().remove(hero.getBuilding());  //
            game.getGameGround0().getGamePane().getChildren().remove(hero.getBuilding().getImageView());
            hero.setAttacking(false);
            checkGameIsOver();
        }
        System.out.println(hero.isAttacking());
        if (!hero.isAttacking()) {
            hero.getAttackTimeLine().stop();
        }
    }

    private void checkGameIsOver() {
        if (game.getGameGround0().getSelectedMap().getBuildings().size() == 0 || (!anyHeroIsRemained() && game.getGameGround0().getPlayingHeroes().size() == 0)) {
            game.setGameIsOver(true);
            game.getGameGround0().getPlayingHeroes().clear();
            game.getGameTimeline().stop();
            game.getGameTimeLine0().stop();
            for (Building a : game.getGameGround0().getSelectedMap().getBuildings()) {
                if (a instanceof DBuilding) {
                    ((DBuilding) a).getDBuildingEquipment().getRemoveTimeline().stop();
                }
            }
            if (game.getGameGround0().getSelectedMap().getBuildings().size() == 0) {
            } else {
                game.getGameGround0().getGamePane().getChildren().removeIf(a -> a instanceof Group);
            }
            double totalDamage = getTotalDamage();
            ((ImageView) game.getResultPane().getChildren().get(0)).setImage(new Rating().getStars(totalDamage));
            ((Label) game.getResultPane().getChildren().get(1)).setText(String.format("Total Damage: %.2f ", totalDamage) + "%");
            game.getResultPane().setVisible(true);
            game.getAudio().getGameAudioEffect().stop();
            game.getAudio().getResultAudioEffect().play();
        }
    }

    private double getTotalDamage() {
        double firstTotalHealth = game.getGameGround0().getFirstTotalHealth();
        double finalTotalHealth = game.getGameGround0().calculateTotalBuildingHealth();
        return ((firstTotalHealth - finalTotalHealth) / firstTotalHealth) * 100;
    }

    private boolean anyHeroIsRemained() {
        for (java.util.Map.Entry<Hero, Integer> a : game.getGameGround0().getSelectedHeroes().entrySet()) {
            if (a.getValue() > 0) {
                return true;
            }
        }
        return false;
    }

    public void startTimeLine0() {
        game.setGameTimeLine0(new Timeline(new KeyFrame(Duration.millis(1000), e -> checkAllDBuildings())));
        game.getGameTimeLine0().setCycleCount(Animation.INDEFINITE);
        game.getGameTimeLine0().play();
    }

    public void checkAllDBuildings() {
        if (!game.isGameIsOver()) {
            for (Building a : game.getGameGround0().getSelectedMap().getBuildings()) {
                if (a instanceof DBuilding) {
                    attack((DBuilding) a);
                }
            }
        }
    }

    public void attack(DBuilding dBuilding) {
        System.out.println(game.getGameGround0().getPlayingHeroes().size());
        dBuilding.setHero(dBuilding.getDBuildingEquipment().findNeatestHero(game.getGameGround0().getPlayingHeroes()));
        if (dBuilding.getHero() != null) {
            dBuilding.getDBuildingEquipment().getGroup().setLayoutX(dBuilding.getBounds().getMinX());
            dBuilding.getDBuildingEquipment().getGroup().setLayoutY(dBuilding.getBounds().getMinY());
            dBuilding.getDBuildingEquipment().setOriginX(dBuilding.getBounds().getMinX());
            dBuilding.getDBuildingEquipment().setOriginY(dBuilding.getBounds().getMinY());
            if (!game.isGameIsOver()) {
                game.getAudio().getBombAudioEffect().play();
                game.getGameGround0().getGamePane().getChildren().add(dBuilding.getDBuildingEquipment().getGroup());
            }
            dBuilding.getDBuildingEquipment().animateImageViews().play();
            dBuilding.getDBuildingEquipment().translateAnimation(dBuilding.getHero()).play();
        }
    }
}


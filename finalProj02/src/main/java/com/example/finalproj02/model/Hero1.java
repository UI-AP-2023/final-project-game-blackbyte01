package com.example.finalproj02.model;

import javafx.animation.TranslateTransition;

import java.util.ArrayList;

public class Hero1 extends Hero {
    public Hero1(double x, double y, double width, double height) {
        super("axe viking", 20, 2, 50, "/com/example/finalproj02/images/elements/sprites/axe-man/axeMan00.png", x, y, width, height);
        setLevel(1);
        setSprites(imageViewImages(imagePaths(getSpritePaths())));
        setSprites0(imageViewImages(imagePaths(getSpritePaths0())));
    }

    public Hero1() {
        super("axe viking", 3, 2, 250, "/com/example/finalproj02/images/elements/sprites/axe-man/axeMan00.png");
        setLevel(1);
    }

    public Hero1 getCopy() {
        return new Hero1(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    public void findBestBuilding(ArrayList<Building> buildings) {
        ArrayList<Building> matchBuilding = new ArrayList<>();
        for (Building a : buildings) {
            if (a.getRadius() == 0) {
                matchBuilding.add(a);
            }
        }
        setBuilding(findNeatestBuilding(matchBuilding));
    }

    public void setTranslateTarget(TranslateTransition translateTransition) {
        if (this.getBuilding() != null) {
            setTargetRadius(getBuilding().getRadius());
            super.setTranslateTarget(translateTransition);
        }
    }

    public ArrayList<String> getSpritePaths() {
        ArrayList<String> paths = new ArrayList<>();
        paths.add("/com/example/finalproj02/images/elements/sprites/axe-man/axeMan00.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/axe-man/axeMan01.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/axe-man/axeMan02.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/axe-man/axeMan03.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/axe-man/axeMan04.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/axe-man/axeMan05.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/axe-man/axeMan06.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/axe-man/axeMan07.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/axe-man/axeMan08.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/axe-man/axeMan09.png");
        return paths;
    }

    public ArrayList<String> getSpritePaths0() {
        ArrayList<String> paths = new ArrayList<>();
        paths.add("/com/example/finalproj02/images/elements/sprites/sword-man/swordMan00.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/sword-man/swordMan01.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/sword-man/swordMan02.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/sword-man/swordMan03.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/sword-man/swordMan04.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/sword-man/swordMan05.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/sword-man/swordMan06.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/sword-man/swordMan07.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/sword-man/swordMan08.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/sword-man/swordMan09.png");
        return paths;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}

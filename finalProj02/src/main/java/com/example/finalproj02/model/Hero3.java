package com.example.finalproj02.model;

import javafx.animation.TranslateTransition;

import java.util.ArrayList;

public class Hero3 extends Hero {
    public Hero3(double x, double y, double width, double height) {
        super("hammer viking", 10, 10, 100, "/com/example/finalproj02/images/elements/sprites/hammer-man/hammerMan00.png", x, y, width, height);
        setLevel(1);
        setSprites(imageViewImages(imagePaths(getSpritePaths())));
    }

    public Hero3() {
        super("hammer viking", 10, 10, 100, "/com/example/finalproj02/images/elements/sprites/hammer-man/hammerMan00.png");
        setLevel(1);
    }

    public Hero3 getCopy() {
        return new Hero3(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
    }

    public void findBestBuilding(ArrayList<Building> buildings) {
        ArrayList<Building> matchBuilding = new ArrayList<>();
        for (Building a : buildings) {
            if ((a instanceof Building3) || (a instanceof Building2)) {
                matchBuilding.add(a);
            }
        }
        setBuilding(findNeatestBuilding(matchBuilding));
    }

    public void setTranslateTarget(TranslateTransition translateTransition) {
        if (getBuilding() != null) {
            setTargetRadius(getBuilding().getRadius());
            super.setTranslateTarget(translateTransition);
        }
    }

    public ArrayList<String> getSpritePaths() {
        ArrayList<String> paths = new ArrayList<>();
        paths.add("/com/example/finalproj02/images/elements/sprites/hammer-man/hammerMan00.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/hammer-man/hammerMan01.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/hammer-man/hammerMan02.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/hammer-man/hammerMan03.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/hammer-man/hammerMan04.png");
        return paths;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

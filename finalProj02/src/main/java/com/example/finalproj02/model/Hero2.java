package com.example.finalproj02.model;

import javafx.animation.TranslateTransition;

import java.util.ArrayList;

public class Hero2 extends Hero {
    public Hero2(double x, double y, double width, double height) {
        super("sword viking", 5, 1, 150, "/com/example/finalproj02/images/elements/sprites/sword-man/swordMan00.png", x, y, width, height);
        setLevel(1);
        setSprites(imageViewImages(imagePaths(getSpritePaths())));
    }

    public Hero2() {
        super("sword viking", 5, 1, 150, "/com/example/finalproj02/images/elements/sprites/sword-man/swordMan00.png");
        setLevel(1);
    }

    public Hero2 getCopy() {
        return new Hero2(this.getMinX(), this.getMinY(), this.getImageView().getFitWidth(), this.getImageView().getFitHeight());
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

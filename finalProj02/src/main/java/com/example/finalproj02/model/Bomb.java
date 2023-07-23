package com.example.finalproj02.model;

import java.util.ArrayList;

public class Bomb extends DBuildingEquipment {

    Bomb() {
        super("Bomb", "/com/example/finalproj02/images/elements/sprites/bomb/fire00.png", 10, 10, 10, 10);
        setSprites(imageViewImages(imagePaths(getSpritePaths())));
    }

    public ArrayList<String> getSpritePaths() {
        ArrayList<String> paths = new ArrayList<>();
        paths.add("/com/example/finalproj02/images/elements/sprites/bomb/fire00.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/bomb/fire01.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/bomb/fire02.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/bomb/fire03.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/bomb/fire04.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/bomb/fire05.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/bomb/fire06.png");
        paths.add("/com/example/finalproj02/images/elements/sprites/bomb/fire07.png");
        return paths;
    }
}

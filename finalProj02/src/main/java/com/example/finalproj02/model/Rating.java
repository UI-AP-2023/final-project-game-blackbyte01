package com.example.finalproj02.model;

import javafx.scene.image.Image;

import java.util.Objects;

public class Rating {
    private final Image image0;
    private final Image image1;
    private final Image image2;
    private final Image image3;

    public Rating() {
        String star0 = "/com/example/finalproj02/images/elements/statics/stars/star00.png";
        String star1 = "/com/example/finalproj02/images/elements/statics/stars/star01.png";
        String star2 = "/com/example/finalproj02/images/elements/statics/stars/star02.png";
        String star3 = "/com/example/finalproj02/images/elements/statics/stars/star03.png";
        image0 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(star0)));
        image1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(star1)));
        image2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(star2)));
        image3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(star3)));
    }

    public Image getImage0() {
        return image0;
    }

    public Image getImage1() {
        return image1;
    }

    public Image getImage2() {
        return image2;
    }

    public Image getImage3() {
        return image3;
    }

    public Image getStars(double totalDamage) {
        if (totalDamage >= 80)
            return image3;
        else if (totalDamage >= 60)
            return image2;
        else if (totalDamage >= 20)
            return image1;
        return image0;
    }
}

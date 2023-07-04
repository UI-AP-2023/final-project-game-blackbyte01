package com.example.finalproj02.controller;

import com.example.finalproj02.model.*;

import java.util.ArrayList;

public class HeroController {
    private final ArrayList<Hero> sampleHeroes;
    public static HeroController instance=new HeroController();
    private HeroController(){
        sampleHeroes=new ArrayList<>();
        fillSampleHeroes();
    }

    private void fillSampleHeroes(){
        sampleHeroes.add(new Hero1());
        sampleHeroes.add(new Hero2());
        sampleHeroes.add(new Hero3());
        sampleHeroes.add(new Hero4());
        sampleHeroes.add(new Hero5());
    }

    public static HeroController getInstance() {
        return instance;
    }

    public ArrayList<Hero> getSampleHeroes() {
        return sampleHeroes;
    }
}

package com.example.finalproj02.controller;

import com.example.finalproj02.model.*;

import java.util.ArrayList;

public class BuildingController {
    public static BuildingController instance = new BuildingController();
    private final ArrayList<Building> sampleBuildings;

    private BuildingController() {
        sampleBuildings = new ArrayList<>();
        fillSampleBuildings();
    }

    public static BuildingController getInstance() {
        return instance;
    }

    public ArrayList<Building> getSampleBuildings() {
        return sampleBuildings;
    }

    void fillSampleBuildings() {
        sampleBuildings.add(new Building1());
        sampleBuildings.add(new Building2());
        sampleBuildings.add(new Building3());
        sampleBuildings.add(new Building4());
        sampleBuildings.add(new Building5());
    }
}

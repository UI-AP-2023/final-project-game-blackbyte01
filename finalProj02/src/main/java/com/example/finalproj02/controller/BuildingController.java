package com.example.finalproj02.controller;

import com.example.finalproj02.model.DBuilding;

import java.util.ArrayList;

public class BuildingController {
    public static BuildingController instance=new BuildingController();

    private BuildingController(){}
    public static BuildingController getInstance() {
        return instance;
    }



    /*
    public ArrayList<DBuilding> getSDBuildings(){
        return S
    }
     */
}

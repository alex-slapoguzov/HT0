package com.epam.training.models;

import com.epam.training.printer.BuildingPrinter;

import java.util.ArrayList;

public class Building {

    private  String name;
    private ArrayList<Room> listRooms;

    public Building(String name){
        this.name = name;
        this.listRooms = new ArrayList<Room>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Room> getListRooms() {
        return listRooms;
    }

    public void setListRooms(ArrayList<Room> listRooms) {
        this.listRooms = listRooms;
    }

    public void addRoom(Room room){
        listRooms.add(room);
    }

    public void describe() {
        BuildingPrinter.printBuilding(this);
    }
}

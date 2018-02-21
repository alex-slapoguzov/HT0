package com.epam.training;

import com.epam.training.exceptions.BuildingException;
import com.epam.training.models.Building;
import com.epam.training.models.Room;
import com.epam.training.models.illumination.DefaultWindow;
import com.epam.training.models.illumination.LightBulb;
import com.epam.training.models.illumination.Window;
import com.epam.training.models.things.Table;
import com.epam.training.models.things.TransformTable;

public class Main {
    public static void main(String[] args)throws BuildingException {

        Building building = new Building("Building N1");

        Room room = new Room("Room N1", 1000, 1);
        room.addFurniture(new Table("Table", 100));
        room.addFurniture(new TransformTable("Table", 10, 100));
        room.addLightBulb(new LightBulb(100));
        room.addWindow(new DefaultWindow());
        room.addWindow(new Window(100));

        building.addRoom(room);

        building.describe();
    }

    }


package com.epam.training.printer;

import com.epam.training.models.Building;
import com.epam.training.models.Room;
import com.epam.training.models.illumination.LightBulb;
import com.epam.training.models.illumination.Window;
import com.epam.training.models.things.Furniture;
import com.epam.training.models.things.TransformFurniture;

public class BuildingPrinter {

    public static void printBuilding(Building building){
        String result = "Building name : " + building.getName() + "\n";

        for (Room room : building.getListRooms()) {
            result += "  Room name: " + room.getName() + "\n" + "    Windows:" + "\n";
            for (Window window : room.getWindows()) {
                result += "      Illumation: " + window.getIllumination() + " lk \n";
            }
            result += "    LightBulbs:" + "\n";
            for (LightBulb lightBulb : room.getLightBulbs()) {
                result += "      Illumation: " + lightBulb.getIllumination() + " lk \n";
            }

            result += "    Furniture:" + "\n";
            for (Furniture furniture : room.getFurnitures()) {
                if (TransformFurniture.class.isAssignableFrom(furniture.getClass())) {
                    TransformFurniture transformFurniture = (TransformFurniture) furniture;
                    result += "      Furniture name: " + furniture.getName() + ", Furniture square min: " +
                            transformFurniture.getMinSquare() + " m^2, Furniture square max: " +
                            transformFurniture.getSquare() + " m^2 \n";

                } else {
                    result += "      Furniture name: " + furniture.getName() + ", Furniture square: " + furniture.getSquare() + " m^2 \n";
                }
            }
            result += "    Square: " + room.getSquare() + " m^2 \n";

            result += "    Total illumination: " + room.getTotalIllumation() + " lk \n";
            result += "    Usage min square: " + room.getMinTotalSquare() + " m^2 \n";
            result += "    Usage max square: " + room.getTotalSquare() + " m^2 \n";

        }

        System.out.println(result);
    }
}























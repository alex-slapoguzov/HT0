package com.epam.training.validators;

import com.epam.training.exceptions.SpaceUsageTooMuchException;
import com.epam.training.models.Room;
import com.epam.training.models.things.Furniture;

public class SquareValidator {

    private final static int MAX_SQUARE_PERCENT = 70;

    public static void validate(Room room, Furniture thing) throws SpaceUsageTooMuchException {
        if (room.getFurnitures().size() == 0){
            return;
        }
        double newSquareSum = room.getTotalSquare() + thing.getSquare();
        double usageSquare = newSquareSum / room.getSquare() * 100;

        if (usageSquare > MAX_SQUARE_PERCENT){
            throw new SpaceUsageTooMuchException("Max square percent is " + MAX_SQUARE_PERCENT + ", but current is " + usageSquare);
        }

    }
}

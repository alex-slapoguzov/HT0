package com.epam.training.validators;

import com.epam.training.exceptions.IlluminanceTooMuchException;
import com.epam.training.models.Room;
import com.epam.training.models.illumination.Illumination;

public class IlluminationValidator {

    private final static int MIN_ILLUMINATION_VALUE = 300;
    private final static int MAX_ILLUMINATION_VALUE = 4000;

    public static void validate(Room room, Illumination illumination) throws IlluminanceTooMuchException {
        if (room.getLightBulbs().size() == 0 && room.getWindows().size() == 0) {
            return;
        }
        int newIlluminationSum = room.getTotalIllumation() + illumination.getIllumination();

        if (MAX_ILLUMINATION_VALUE < newIlluminationSum) {
            throw new IlluminanceTooMuchException("Max illumination value is " + MAX_ILLUMINATION_VALUE + ", " +
                    "but current is " + newIlluminationSum);

        }

    }
}

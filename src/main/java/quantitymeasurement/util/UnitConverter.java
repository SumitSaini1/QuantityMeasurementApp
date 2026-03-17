package quantitymeasurement.util;

import quantitymeasurement.enums.LengthUnit;
import quantitymeasurement.enums.WeightUnit;
import quantitymeasurement.enums.TemperatureUnit;
import quantitymeasurement.enums.VolumeUnit;

public class UnitConverter {

    public static IMeasurable fromString(String unit) {

        try {
            return LengthUnit.valueOf(unit.toUpperCase());
        } catch (Exception ignored) {}

        try {
            return WeightUnit.valueOf(unit.toUpperCase());
        } catch (Exception ignored) {}

        try {
            return TemperatureUnit.valueOf(unit.toUpperCase());
        } catch (Exception ignored) {}

        try {
            return VolumeUnit.valueOf(unit.toUpperCase());
        } catch (Exception ignored) {}

        throw new IllegalArgumentException("Invalid unit: " + unit);
    }
}
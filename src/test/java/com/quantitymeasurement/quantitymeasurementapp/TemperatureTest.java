package com.quantitymeasurement.quantitymeasurementapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureTest {

    private static final double EPSILON = 0.0001;

    @Test
    void testTemperatureEquality_CelsiusToCelsius_SameValue() {
        assertTrue(new Quantity<>(0.0, TemperatureUnit.CELSIUS)
                .equals(new Quantity<>(0.0, TemperatureUnit.CELSIUS)));
    }

    @Test
    void testTemperatureEquality_FahrenheitToFahrenheit_SameValue() {
        assertTrue(new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT)
                .equals(new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT)));
    }

    @Test
    void testTemperatureEquality_CelsiusToFahrenheit_0Celsius32Fahrenheit() {
        assertTrue(new Quantity<>(0.0, TemperatureUnit.CELSIUS)
                .equals(new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT)));
    }

    @Test
    void testTemperatureEquality_CelsiusToFahrenheit_100Celsius212Fahrenheit() {
        assertTrue(new Quantity<>(100.0, TemperatureUnit.CELSIUS)
                .equals(new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT)));
    }

    @Test
    void testTemperatureEquality_CelsiusToFahrenheit_Negative40Equal() {
        assertTrue(new Quantity<>(-40.0, TemperatureUnit.CELSIUS)
                .equals(new Quantity<>(-40.0, TemperatureUnit.FAHRENHEIT)));
    }

    @Test
    void testTemperatureEquality_SymmetricProperty() {
        Quantity<TemperatureUnit> a = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> b = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
    }

    @Test
    void testTemperatureEquality_ReflexiveProperty() {
        Quantity<TemperatureUnit> t = new Quantity<>(25.0, TemperatureUnit.CELSIUS);
        assertTrue(t.equals(t));
    }

    @Test
    void testTemperatureConversion_CelsiusToFahrenheit_VariousValues() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> r1 = t1.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(122.0, r1.getValue(), EPSILON);

        Quantity<TemperatureUnit> t2 = new Quantity<>(-20.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> r2 = t2.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(-4.0, r2.getValue(), EPSILON);
    }

    @Test
    void testTemperatureConversion_FahrenheitToCelsius_VariousValues() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(122.0, TemperatureUnit.FAHRENHEIT);
        Quantity<TemperatureUnit> r1 = t1.convertTo(TemperatureUnit.CELSIUS);
        assertEquals(50.0, r1.getValue(), EPSILON);

        Quantity<TemperatureUnit> t2 = new Quantity<>(-4.0, TemperatureUnit.FAHRENHEIT);
        Quantity<TemperatureUnit> r2 = t2.convertTo(TemperatureUnit.CELSIUS);
        assertEquals(-20.0, r2.getValue(), EPSILON);
    }

    @Test
    void testTemperatureConversion_RoundTrip_PreservesValue() {
        Quantity<TemperatureUnit> original = new Quantity<>(60.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> converted =
                original.convertTo(TemperatureUnit.FAHRENHEIT)
                        .convertTo(TemperatureUnit.CELSIUS);
        assertEquals(original.getValue(), converted.getValue(), EPSILON);
    }

    @Test
    void testTemperatureConversion_SameUnit() {
        Quantity<TemperatureUnit> t = new Quantity<>(30.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> r = t.convertTo(TemperatureUnit.CELSIUS);
        assertEquals(30.0, r.getValue(), EPSILON);
    }

    @Test
    void testTemperatureConversion_ZeroValue() {
        Quantity<TemperatureUnit> t = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> r = t.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(32.0, r.getValue(), EPSILON);
    }

    @Test
    void testTemperatureConversion_NegativeValues() {
        Quantity<TemperatureUnit> t = new Quantity<>(-10.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> r = t.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(14.0, r.getValue(), EPSILON);
    }

    @Test
    void testTemperatureConversion_LargeValues() {
        Quantity<TemperatureUnit> t = new Quantity<>(1000.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> r = t.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(1832.0, r.getValue(), EPSILON);
    }

    @Test
    void testTemperatureUnsupportedOperation_Add() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        assertThrows(UnsupportedOperationException.class, () -> t1.add(t2));
    }

    @Test
    void testTemperatureUnsupportedOperation_Subtract() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        assertThrows(UnsupportedOperationException.class, () -> t1.subtract(t2));
    }

    @Test
    void testTemperatureUnsupportedOperation_Divide() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        assertThrows(UnsupportedOperationException.class, () -> t1.divide(t2));
    }

    @Test
    void testTemperatureUnsupportedOperation_ErrorMessage() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Exception e = assertThrows(UnsupportedOperationException.class, () -> t1.add(t2));
        assertNotNull(e.getMessage());
    }

    @Test
    void testTemperatureVsLengthIncompatibility() {
        assertFalse(new Quantity<>(100.0, TemperatureUnit.CELSIUS)
                .equals(new Quantity<>(100.0, LengthUnit.FEET)));
    }

    @Test
    void testTemperatureVsWeightIncompatibility() {
        assertFalse(new Quantity<>(50.0, TemperatureUnit.CELSIUS)
                .equals(new Quantity<>(50.0, WeightUnit.KILOGRAM)));
    }

    @Test
    void testTemperatureVsVolumeIncompatibility() {
        assertFalse(new Quantity<>(25.0, TemperatureUnit.CELSIUS)
                .equals(new Quantity<>(25.0, VolumeUnit.LITRE)));
    }

    @Test
    void testOperationSupportMethods_TemperatureUnitAddition() {
        assertFalse(TemperatureUnit.CELSIUS.supportsArithmetic());
    }

    @Test
    void testOperationSupportMethods_TemperatureUnitDivision() {
        assertFalse(TemperatureUnit.FAHRENHEIT.supportsArithmetic());
    }

    @Test
    void testOperationSupportMethods_LengthUnitAddition() {
        assertTrue(LengthUnit.FEET.supportsArithmetic());
    }

    @Test
    void testOperationSupportMethods_WeightUnitDivision() {
        assertTrue(WeightUnit.KILOGRAM.supportsArithmetic());
    }

    @Test
    void testTemperatureUnit_NonLinearConversion() {
        Quantity<TemperatureUnit> t = new Quantity<>(10.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> r = t.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(50.0, r.getValue(), EPSILON);
    }

    @Test
    void testTemperatureUnit_AllConstants() {
        assertNotNull(TemperatureUnit.CELSIUS);
        assertNotNull(TemperatureUnit.FAHRENHEIT);
        assertNotNull(TemperatureUnit.KELVIN);
    }

    @Test
    void testTemperatureUnit_ConversionFactor() {
        assertEquals(1.0, TemperatureUnit.CELSIUS.getConversionFactor());
    }

    @Test
    void testTemperatureNullUnitValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(100.0, null));
    }

    @Test
    void testTemperatureNullOperandValidation_InComparison() {
        Quantity<TemperatureUnit> t = new Quantity<>(25.0, TemperatureUnit.CELSIUS);
        assertFalse(t.equals(null));
    }

    @Test
    void testTemperatureDifferentValuesInequality() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertFalse(t1.equals(t2));
    }

    @Test
    void testTemperatureConversionPrecision_Epsilon() {
        Quantity<TemperatureUnit> t = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> r = t.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(32.0, r.getValue(), EPSILON);
    }

    @Test
    void testTemperatureConversionEdgeCase_VerySmallDifference() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(0.00001, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(32.000018, TemperatureUnit.FAHRENHEIT);
        assertTrue(t1.equals(t2));
    }

    @Test
    void testTemperatureEnumImplementsIMeasurable() {
        assertTrue(IMeasurable.class.isAssignableFrom(TemperatureUnit.class));
    }

    @Test
    void testTemperatureDefaultMethodInheritance() {
        assertTrue(LengthUnit.FEET.supportsArithmetic());
        assertTrue(WeightUnit.KILOGRAM.supportsArithmetic());
    }

    @Test
    void testTemperatureCrossUnitAdditionAttempt() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        assertThrows(UnsupportedOperationException.class, () -> t1.add(t2));
    } 

    @Test
    void testTemperatureIntegrationWithGenericQuantity() {
        Quantity<TemperatureUnit> t =
                new Quantity<>(25.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> r =
                t.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(77.0, r.getValue(), EPSILON);
    }
}
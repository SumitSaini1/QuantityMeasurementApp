package com.quantitymeasurement.quantitymeasurementapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.quantitymeasurement.quantitymeasurementapp.QuantityMeasurementApp.Length;
import com.quantitymeasurement.quantitymeasurementapp.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    void testDifferentValue() {
        Length l1 = new Length(2, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        assertFalse(l1.equals(l2));
    }

    @Test
    void testSameReference() {
        Length l1 = new Length(2, LengthUnit.FEET);
        assertTrue(l1.equals(l1));
    }

    @Test
    void testNullComparison() {
        Length l1 = new Length(5, LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }

    @Test
    void testFeetEquality_NullComparison() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Length(12.2, null);
        });
    }

    // yards
    @Test
    void testEqualityYardsToYardsSameValue() {
        Length l1 = new Length(1, LengthUnit.YARDS);
        Length l2 = new Length(1, LengthUnit.YARDS);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testEqualityYardsToYardsDifferentValue() {
        Length l1 = new Length(1, LengthUnit.YARDS);
        Length l2 = new Length(2, LengthUnit.YARDS);

        assertFalse(l1.equals(l2));

    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(3.0, LengthUnit.FEET);

        assertTrue(l1.equals(l2));

    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {

        Length l1 = new Length(3.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.YARDS);

        assertTrue(l1.equals(l2));

    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(36.0, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));

    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {

        Length l1 = new Length(36.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.YARDS);

        assertTrue(l1.equals(l2));

    }

    @Test
    void testEquality_centimetersToInches_EquivalentValue() {

        Length l1 = new Length(1.0, LengthUnit.CENTIMETERS);
        Length l2 = new Length(0.393701, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));

    }

    @Test
    void testEquality_centimetersToFeet_EquivalentValue() {

        Length l1 = new Length(1.0, LengthUnit.CENTIMETERS);
        Length l2 = new Length(1.0, LengthUnit.FEET);

        assertFalse(l1.equals(l2));

    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertEquals(yard, feet);

        assertEquals(feet, inches);

        assertEquals(yard, inches);
    }

    @Test
    void testEquality_YardWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(12.2, null);
        });

    }

    @Test
    void testEquality_YardSameReference() {

        Length l1 = new Length(1.0, LengthUnit.YARDS);

        assertTrue(l1.equals(l1));

    }

    @Test
    void testEquality_YardNullComparison() {

        Length l1 = new Length(1.0, LengthUnit.YARDS);

        assertNotEquals(null, l1);
    }

    @Test
    void testEquality_CentimetersWithNullUnit() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Length(10.0, null);
        });
    }

    @Test
    void testEquality_CentimetersSameReference() {

        Length cm = new Length(10.0, LengthUnit.CENTIMETERS);

        assertEquals(cm, cm);
    }

    @Test
    void testEquality_CentimetersNullComparison() {

        Length cm = new Length(10.0, LengthUnit.CENTIMETERS);

        assertNotEquals(null, cm);
    }

    @Test
    void testEquality_AllUnits_ComplexScenario() {

        Length yards = new Length(2.0, LengthUnit.YARDS);
        Length feet = new Length(6.0, LengthUnit.FEET);
        Length inches = new Length(72.0, LengthUnit.INCHES);

        assertEquals(yards, feet);
        assertEquals(feet, inches);
        assertEquals(yards, inches);
    }

    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                QuantityMeasurementApp.convert(1.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES));
    }

    @Test
    void testInchesToFeet() {
        assertEquals(1.0,
                QuantityMeasurementApp.convert(12.0,
                        LengthUnit.INCHES,
                        LengthUnit.FEET));
    }

    @Test
    void testYardsToFeet() {
        assertEquals(3.0,
                QuantityMeasurementApp.convert(1.0,
                        LengthUnit.YARDS,
                        LengthUnit.FEET));
    }

    @Test
    void testYardsToInches() {
        assertEquals(36.0,
                QuantityMeasurementApp.convert(1.0,
                        LengthUnit.YARDS,
                        LengthUnit.INCHES));
    }

    @Test
    void testSameUnitConversion() {
        assertEquals(5.0,
                QuantityMeasurementApp.convert(5.0,
                        LengthUnit.FEET,
                        LengthUnit.FEET));
    }

    @Test
    void testZeroValueConversion() {
        assertEquals(0.0,
                QuantityMeasurementApp.convert(0.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES));
    }

    @Test
    void testNegativeValueConversion() {
        assertEquals(-12.0,
                QuantityMeasurementApp.convert(-1.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES));
    }

    @Test
    void testNullSourceUnit() {
        assertThrows(IllegalArgumentException.class, () -> QuantityMeasurementApp.convert(1.0,
                null,
                LengthUnit.INCHES));
    }

    @Test
    void testNullTargetUnit() {
        assertThrows(IllegalArgumentException.class, () -> QuantityMeasurementApp.convert(1.0,
                LengthUnit.FEET,
                null));
    }

    @Test
    void testSameUnitFeet() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(2, LengthUnit.FEET);
        Length result = l1.add(l2);
        assertEquals(3, result.getValue());
    }

    @Test
    void testSameUnitInches() {
        Length l1 = new Length(6, LengthUnit.INCHES);
        Length l2 = new Length(6, LengthUnit.INCHES);
        Length result = l1.add(l2);
        assertEquals(12, result.getValue());
    }

    @Test
    void testFeetPlusInches() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);
        Length result = l1.add(l2);
        assertEquals(2, result.getValue());
    }

    @Test
    void testInchesPlusFeet() {
        Length l1 = new Length(12, LengthUnit.INCHES);
        Length l2 = new Length(1, LengthUnit.FEET);
        Length result = l1.add(l2);
        assertEquals(24, result.getValue());
    }

    @Test
    void testYardPlusFeet() {
        Length l1 = new Length(1, LengthUnit.YARDS);
        Length l2 = new Length(3, LengthUnit.FEET);
        Length result = l1.add(l2);
        assertEquals(2, result.getValue());
    }

    @Test
    void testZeroAddition() {
        Length l1 = new Length(5, LengthUnit.FEET);
        Length l2 = new Length(0, LengthUnit.INCHES);
        Length result = l1.add(l2);
        assertEquals(5, result.getValue());
    }

    @Test
    void testNegativeValues() {
        Length l1 = new Length(5, LengthUnit.FEET);
        Length l2 = new Length(-2, LengthUnit.FEET);
        Length result = l1.add(l2);
        assertEquals(3, result.getValue());
    }

    @Test
    void testStaticAddMethod() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.add(l1, l2);
        assertEquals(2, result.getValue());
    }

    @Test
    void testNullSecondOperand() {
        Length l1 = new Length(1, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            l1.add(null);
        });
    }

    @Test
    void testEquality() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

}

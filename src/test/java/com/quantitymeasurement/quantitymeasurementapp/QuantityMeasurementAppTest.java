package com.quantitymeasurement.quantitymeasurementapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testDifferentValue() {
        Quantity<LengthUnit> l1 = new Quantity<>(2, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        assertFalse(l1.equals(l2));
    }

    @Test
    void testSameReference() {
        Quantity<LengthUnit> l1 = new Quantity<>(2, LengthUnit.FEET);
        assertTrue(l1.equals(l1));
    }

    @Test
    void testNullComparison() {
        Quantity<LengthUnit> l1 = new Quantity<>(5, LengthUnit.FEET);
        assertFalse(l1.equals(null));
    }

    @Test
    void testEqualityYardsSameValue() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.YARDS);
        Quantity<LengthUnit> l2 = new Quantity<>(1, LengthUnit.YARDS);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testEqualityYardsDifferentValue() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.YARDS);
        Quantity<LengthUnit> l2 = new Quantity<>(2, LengthUnit.YARDS);

        assertFalse(l1.equals(l2));
    }

    @Test
    void testYardFeetEquality() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.YARDS);
        Quantity<LengthUnit> l2 = new Quantity<>(3, LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testYardInchesEquality() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.YARDS);
        Quantity<LengthUnit> l2 = new Quantity<>(36, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testCentimeterInchEquality() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.CENTIMETERS);
        Quantity<LengthUnit> l2 = new Quantity<>(0.393701, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                QuantityMeasurementApp.convert(1,
                        LengthUnit.FEET,
                        LengthUnit.INCHES));
    }

    @Test
    void testInchesToFeet() {
        assertEquals(1.0,
                QuantityMeasurementApp.convert(12,
                        LengthUnit.INCHES,
                        LengthUnit.FEET));
    }

    @Test
    void testYardsToFeet() {
        assertEquals(3.0,
                QuantityMeasurementApp.convert(1,
                        LengthUnit.YARDS,
                        LengthUnit.FEET));
    }

    @Test
    void testYardsToInches() {
        assertEquals(36.0,
                QuantityMeasurementApp.convert(1,
                        LengthUnit.YARDS,
                        LengthUnit.INCHES));
    }

    @Test
    void testSameUnitConversion() {
        assertEquals(5.0,
                QuantityMeasurementApp.convert(5,
                        LengthUnit.FEET,
                        LengthUnit.FEET));
    }

    @Test
    void testFeetAddition() {

        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(2, LengthUnit.FEET);

        Quantity<LengthUnit> result = l1.add(l2);

        assertEquals(3, result.getValue());
    }

    @Test
    void testFeetPlusInches() {

        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result = l1.add(l2);

        assertEquals(2, result.getValue());
    }

    @Test
    void testInchesPlusFeet() {

        Quantity<LengthUnit> l1 = new Quantity<>(12, LengthUnit.INCHES);
        Quantity<LengthUnit> l2 = new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> result = l1.add(l2);

        assertEquals(24, result.getValue());
    }

    @Test
    void testYardPlusFeet() {

        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.YARDS);
        Quantity<LengthUnit> l2 = new Quantity<>(3, LengthUnit.FEET);

        Quantity<LengthUnit> result = l1.add(l2);

        assertEquals(2, result.getValue());
    }

    @Test
    void testAdditionTargetFeet(){

        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> res =
                l1.add(l2, LengthUnit.FEET);

        assertEquals(2, res.getValue());
    }

    @Test
    void testAdditionTargetInches(){

        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> res =
                l1.add(l2, LengthUnit.INCHES);

        assertEquals(24, res.getValue());
    }

    @Test
    void testAdditionTargetYards(){

        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> res =
                l1.add(l2, LengthUnit.YARDS);

        assertEquals(0.666, res.getValue(), 0.01);
    }

    @Test
    void testSameWeightEquality() {

        Quantity<WeightUnit> w1 =
                new Quantity<>(1, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1, WeightUnit.KILOGRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testKilogramGramEquality() {

        Quantity<WeightUnit> w1 =
                new Quantity<>(1, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testAdditionKilogramGram() {

        Quantity<WeightUnit> w1 =
                new Quantity<>(1, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000, WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                w1.add(w2, WeightUnit.KILOGRAM);

        assertEquals(2, result.getValue(), 0.001);
    }

    @Test
    void testWeightNotEqualLength() {

        Quantity<LengthUnit> length =
                new Quantity<>(1, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(1, WeightUnit.KILOGRAM);

        assertFalse(weight.equals(length));
    }

}
package com.quantitymeasurement.quantitymeasurementapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.quantitymeasurement.quantitymeasurementapp.QuantityMeasurementApp.Length;
import com.quantitymeasurement.quantitymeasurementapp.QuantityMeasurementApp.LengthUnit;;


public class QuantityMeasurementAppTest {
    Length l1;

    @Test
    void testFeetToInches() {
        Length l1=new Length(1,LengthUnit.FEET);
        Length l2=new Length(12,LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testDifferentValue() {
        Length l1=new Length(2,LengthUnit.FEET);
        Length l2=new Length(12,LengthUnit.INCHES);

        assertFalse(l1.equals(l2));
    }
    @Test
    void testSameReference(){
        l1=new Length(2,LengthUnit.FEET);
        assertTrue(l1.equals(l1));
    }
    @Test
    void testNullComparison() {
        l1 = new Length(5, LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }
    @Test
    void testFeetEquality_NullComparison() {
       

        assertThrows(IllegalArgumentException.class, ()->{
            new Length(12.2,null);
        });
    }





   

}

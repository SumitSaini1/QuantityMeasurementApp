package com.quantitymeasurement.quantitymeasurementapp;


public class Weight {

    private final double value;
    private final WeightUnit unit;
    private static final double EPSILON = 0.0001;

    public Weight(double value, WeightUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public boolean compare(Weight other) {
        return Math.abs(
                this.unit.convertToBaseUnit(this.value) -
                other.unit.convertToBaseUnit(other.value)
        ) < EPSILON;
    }

    public Weight add(Weight other) {

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;

        double result = this.unit.convertFromBaseUnit(sumBase);

        return new Weight(result, this.unit);
    }

    public static Weight add(Weight w1, Weight w2, WeightUnit targetUnit) {

        double base1 = w1.unit.convertToBaseUnit(w1.value);
        double base2 = w2.unit.convertToBaseUnit(w2.value);

        double sumBase = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Weight(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Weight other = (Weight) obj;

        return compare(other);
    }

    @Override
    public int hashCode() {
        double base = unit.convertToBaseUnit(value);
        return Double.hashCode(base);
    }
}
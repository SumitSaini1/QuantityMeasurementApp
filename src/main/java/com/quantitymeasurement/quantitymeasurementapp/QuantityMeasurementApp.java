package com.quantitymeasurement.quantitymeasurementapp;

public class QuantityMeasurementApp {

	public enum LengthUnit {
		FEET(12.0),
		INCHES(1.0),
		YARDS(36.0),
		CENTIMETERS(0.393701);

		private final double conversionFactor;

		private LengthUnit(double conversionFactor) {
			this.conversionFactor = conversionFactor;
		}

		public double getConversionFactor() {
			return conversionFactor;
		}
	}

	public static class Length {
		private final double value;
		private final LengthUnit unit;

		public Length(double value, LengthUnit unit) {
			if (unit == null) {
				throw new IllegalArgumentException("Unit cannot be null");
			}
			this.value = value;
			this.unit = unit;
		}

		public double getValue() {
			return value;
		}

		private double convertToBaseUnit() {
			return value * this.unit.getConversionFactor();
		}

		public boolean compare(Length thatLength) {
			return Double.compare(
					this.convertToBaseUnit(),
					thatLength.convertToBaseUnit()) == 0;
		}

		public Length add(Length other) {
			if (other == null) {
				throw new IllegalArgumentException("Length can not be null");
			}

			double baseThis = this.convertToBaseUnit();
			double baseOther = other.convertToBaseUnit();

			double sumBase = baseThis + baseOther;
			double resultValue = sumBase / this.unit.getConversionFactor();
			return new Length(resultValue, this.unit);

		}

		public static Length add(Length length1, Length length2, LengthUnit targetUnit) {
			if (length1 == null) {
				throw new IllegalArgumentException("Length can not be null");
			}
			if (length2 == null) {
				throw new IllegalArgumentException("Length can not be null");
			}
			if (!Double.isFinite(length1.value) || !Double.isFinite(length2.value)) {
				throw new IllegalArgumentException("Values must be finite numbers");
			}
			double baseLength1 = length1.convertToBaseUnit();
			double baseLength2 = length2.convertToBaseUnit();
			double sumBase = baseLength1 + baseLength2;
			double resultValue = sumBase / targetUnit.getConversionFactor();
			return new Length(resultValue, targetUnit);

		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (this.getClass() != obj.getClass()) {
				return false;
			}

			Length other = (Length) obj;

			// compare
			return compare(other);
		}

		@Override
		public int hashCode() {
			return Double.hashCode(convertToBaseUnit());
		}

	}

	public static double convert(double value,
			LengthUnit source,
			LengthUnit target) {

		if (source == null || target == null) {
			throw new IllegalArgumentException("Units cannot be null");
		}

		if (!Double.isFinite(value)) {
			throw new IllegalArgumentException("Invalid numeric value");
		}

		double valueInBase = value * source.getConversionFactor();

		return valueInBase / target.getConversionFactor();
	}

	public static Length add(Length l1, Length l2) {
		if (l1 == null) {
			throw new IllegalArgumentException("Length  can not be null");
		}
		return l1.add(l2);
	}

	public static void main(String[] args) {
		System.out.println("=== Quantity Measurement Demo ===");

		try {

			
			// Addition Example
			Length l1 = new Length(1, LengthUnit.FEET);
			Length l2 = new Length(12, LengthUnit.INCHES);

			Length result = l1.add(l2);
			System.out.println("1 Feet + 12 Inches = " + result.getValue() + " " + l1.unit);

			Length resultInYards = Length.add(l1, l2, LengthUnit.YARDS);
			System.out.println("1 Feet + 12 Inches = " + resultInYards.getValue() + " YARDS");

			// Equality Checks
			Length yard = new Length(1, LengthUnit.YARDS);
			Length feet = new Length(3, LengthUnit.FEET);
			System.out.println("1 Yard == 3 Feet : " + yard.equals(feet));

			Length inches = new Length(36, LengthUnit.INCHES);
			System.out.println("1 Yard == 36 Inches : " + yard.equals(inches));

			Length cm = new Length(1, LengthUnit.CENTIMETERS);
			Length inchEquivalent = new Length(0.393701, LengthUnit.INCHES);
			System.out.println("1 CM == 0.393701 Inches : " + cm.equals(inchEquivalent));

			// Same Unit Comparison
			Length y1 = new Length(2, LengthUnit.YARDS);
			Length y2 = new Length(2, LengthUnit.YARDS);
			System.out.println("2 Yards == 2 Yards : " + y1.equals(y2));

			// Unit Conversions
			System.out.println("3 Feet -> Inches : " +
					convert(3, LengthUnit.FEET, LengthUnit.INCHES));

			System.out.println("36 Inches -> Yards : " +
					convert(36, LengthUnit.INCHES, LengthUnit.YARDS));

			System.out.println("100 CM -> Feet : " +
					convert(100, LengthUnit.CENTIMETERS, LengthUnit.FEET));

		} catch (IllegalArgumentException e) {
			System.err.println("Error: " + e.getMessage());
		}

		System.out.println("=== End ===");
	}

}

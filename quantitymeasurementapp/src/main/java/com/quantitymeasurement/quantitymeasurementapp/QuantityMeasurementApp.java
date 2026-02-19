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
				thatLength.convertToBaseUnit()
			) == 0;
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

	public static void main(String[] args) {
		try{
			// Feet to Inches
			Length l1 = new Length(1, LengthUnit.FEET);
			Length l2 = new Length(12, LengthUnit.INCHES);
			System.out.println("1 Foot == 12 Inches ? " + l1.equals(l2));
		
			// Yard to Feet
			Length l3 = new Length(1, LengthUnit.YARDS);
			Length l4 = new Length(3, LengthUnit.FEET);
			System.out.println("1 Yard == 3 Feet ? " + l3.equals(l4));
		
			// Yard to Inches
			Length l5 = new Length(1, LengthUnit.YARDS);
			Length l6 = new Length(36, LengthUnit.INCHES);
			System.out.println("1 Yard == 36 Inches ? " + l5.equals(l6));
		
			// Centimeter to Inches
			Length l7 = new Length(1, LengthUnit.CENTIMETERS);
			Length l8 = new Length(0.393701, LengthUnit.INCHES);
			System.out.println("1 CM == 0.393701 Inches ? " + l7.equals(l8));
		
			// Same unit comparison
			Length l9 = new Length(2, LengthUnit.YARDS);
			Length l10 = new Length(2, LengthUnit.YARDS);
			System.out.println("2 Yards == 2 Yards ? " + l9.equals(l10));
			
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		
		
	}

}


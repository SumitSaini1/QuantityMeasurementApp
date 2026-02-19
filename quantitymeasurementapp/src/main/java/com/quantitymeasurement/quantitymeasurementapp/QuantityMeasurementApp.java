package com.quantitymeasurement.quantitymeasurementapp;

public class QuantityMeasurementApp {

	public enum LengthUnit {
		FEET(12.0),
		INCHES(1.0);

		private final double conversionFactor;

		private LengthUnit(double conversionFactor) {
			this.conversionFactor = conversionFactor;
		}

		public double getConversionFactor() {
			return conversionFactor;
		}
	}

	public static class Length {
		private double value;
		private LengthUnit unit;

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

		public double convertToBaseUnit() {
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
			Length l1=new Length(1, LengthUnit.FEET);
			Length l2=new Length(12, LengthUnit.INCHES);
			System.out.println(l1.equals(l2));
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		
		
	}

}

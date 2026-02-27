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
		public  Length add(Length other ){
			if(other==null){
				throw new IllegalArgumentException("Length can not be null");
			}
			
			double baseThis=this.convertToBaseUnit();
			double baseOther=other.convertToBaseUnit();

			double sumBase=baseThis + baseOther;
			double  resultValue=sumBase/this.unit.getConversionFactor();
			return new Length(resultValue,this.unit);

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
	public static Length add(Length l1, Length l2){
		if(l1==null){
			throw new IllegalArgumentException("Length  can not be null");
		}
		return l1.add(l2);
	}

	public static void main(String[] args) {
		try {
			// feet to inches
			Length l1 = new Length(1, LengthUnit.FEET);
			Length l2 = new Length(12, LengthUnit.INCHES);
			// add two units 
			Length result1 =l1.add(l2);
			Length result2 =l1.add(l2);
			System.out.println(result1.getValue());
			System.out.println(result2.getValue());

			

			

			// yard to feet
			Length l3 = new Length(1, LengthUnit.YARDS);
			Length l4 = new Length(3, LengthUnit.FEET);
			System.out.println("1 Yard == 3 Feet ? " + l3.equals(l4));

			// yard to inches
			Length l5 = new Length(1, LengthUnit.YARDS);
			Length l6 = new Length(36, LengthUnit.INCHES);
			System.out.println("1 Yard == 36 Inches ? " + l5.equals(l6));

			// centimeter to inches
			Length l7 = new Length(1, LengthUnit.CENTIMETERS);
			Length l8 = new Length(0.393701, LengthUnit.INCHES);
			System.out.println("1 CM == 0.393701 Inches ? " + l7.equals(l8));

			// same unit comparison
			Length l9 = new Length(2, LengthUnit.YARDS);
			Length l10 = new Length(2, LengthUnit.YARDS);
			System.out.println("2 Yards == 2 Yards ? " + l9.equals(l10));

			// unit to  unit conversion 
			System.out.println("Convert 3 Feet to Inches: " +
					convert(3, LengthUnit.FEET, LengthUnit.INCHES));

			System.out.println("Convert 36 Inches to Yards: " +
					convert(36, LengthUnit.INCHES, LengthUnit.YARDS));

			System.out.println("Convert 100 CM to Feet: " +
					convert(100, LengthUnit.CENTIMETERS, LengthUnit.FEET));

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
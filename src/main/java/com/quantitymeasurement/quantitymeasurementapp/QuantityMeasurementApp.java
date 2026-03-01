package com.quantitymeasurement.quantitymeasurementapp;

public class QuantityMeasurementApp {

	public static class Length {
		private final double value;
		private final LengthUnit unit;
		private static final double EPSILON = 0.0001;

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

		public boolean compare(Length thatLength) {
			return Math.abs(
					this.unit.convertToBaseUnit(this.value) -
							thatLength.unit.convertToBaseUnit(thatLength.value)) < EPSILON;
		}

		public Length add(Length other) {
			if (other == null) {
				throw new IllegalArgumentException("Length can not be null");
			}

			double baseThis = this.unit.convertToBaseUnit(this.value);
			double baseOther = other.unit.convertToBaseUnit(other.value);

			double sumBase = baseThis + baseOther;
			double resultValue = this.unit.convertFromBaseUnit(sumBase);
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
			double baseLength1 = length1.unit.convertToBaseUnit(length1.value);
			double baseLength2 = length2.unit.convertToBaseUnit(length2.value);
			double sumBase = baseLength1 + baseLength2;
			double resultValue = targetUnit.convertFromBaseUnit(sumBase);
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
			double baseValue = unit.convertToBaseUnit(value);
			return Double.hashCode(baseValue);
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

		double baseValue = source.convertToBaseUnit(value);
		return target.convertFromBaseUnit(baseValue);
	}

	public static Length add(Length l1, Length l2) {
		if (l1 == null) {
			throw new IllegalArgumentException("Length  can not be null");
		}
		return l1.add(l2);
	}

	public static void main(String[] args) {

		java.util.Scanner scanner = new java.util.Scanner(System.in);
	
		System.out.println("==================================");
		System.out.println("   QUANTITY MEASUREMENT SYSTEM   ");
		System.out.println("==================================");
	
		while (true) {
	
			System.out.println("\nAvailable Units: FEET | INCHES | YARDS | CENTIMETERS");
			System.out.println("\nChoose an Option:");
			System.out.println("1 → Add Two Lengths");
			System.out.println("2 → Convert Length");
			System.out.println("3 → Compare Two Lengths");
			System.out.println("4 → Exit");
			System.out.print("Enter your choice (1-4): ");
	
			int choice = scanner.nextInt();
	
			try {
				switch (choice) {
	
					case 1:
						System.out.println("\n--- ADD TWO LENGTHS ---");
						System.out.println("Example Input: 1 FEET");
	
						System.out.print("Enter first value: ");
						double v1 = scanner.nextDouble();
						System.out.print("Enter first unit: ");
						LengthUnit u1 = LengthUnit.valueOf(scanner.next().toUpperCase());
	
						System.out.print("Enter second value: ");
						double v2 = scanner.nextDouble();
						System.out.print("Enter second unit: ");
						LengthUnit u2 = LengthUnit.valueOf(scanner.next().toUpperCase());
	
						System.out.print("Enter target unit for result: ");
						LengthUnit target = LengthUnit.valueOf(scanner.next().toUpperCase());
	
						Length l1 = new Length(v1, u1);
						Length l2 = new Length(v2, u2);
	
						Length result = Length.add(l1, l2, target);
	
						System.out.println("Result = " + result.getValue() + " " + target);
						break;
	
					case 2:
						System.out.println("\n--- CONVERT LENGTH ---");
						System.out.println("Example Input: 10 INCHES to FEET");
	
						System.out.print("Enter value: ");
						double value = scanner.nextDouble();
	
						System.out.print("Enter source unit: ");
						LengthUnit source = LengthUnit.valueOf(scanner.next().toUpperCase());
	
						System.out.print("Enter target unit: ");
						LengthUnit targetUnit = LengthUnit.valueOf(scanner.next().toUpperCase());
	
						double converted = convert(value, source, targetUnit);
	
						System.out.println("Converted Value = " + converted + " " + targetUnit);
						break;
	
					case 3:
						System.out.println("\n--- COMPARE TWO LENGTHS ---");
						System.out.println("Example Input: 1 YARD and 3 FEET");
	
						System.out.print("Enter first value: ");
						double cv1 = scanner.nextDouble();
						System.out.print("Enter first unit: ");
						LengthUnit cu1 = LengthUnit.valueOf(scanner.next().toUpperCase());
	
						System.out.print("Enter second value: ");
						double cv2 = scanner.nextDouble();
						System.out.print("Enter second unit: ");
						LengthUnit cu2 = LengthUnit.valueOf(scanner.next().toUpperCase());
	
						Length cl1 = new Length(cv1, cu1);
						Length cl2 = new Length(cv2, cu2);
	
						System.out.println("Are Equal? → " + cl1.equals(cl2));
						break;
	
					case 4:
						System.out.println("Exiting Application...");
						scanner.close();
						return;
	
					default:
						System.out.println("Invalid choice! Please enter 1-4.");
				}
	
			} catch (IllegalArgumentException e) {
				System.out.println("Error: Invalid input. Please enter valid values and units.");
			}
		}
	}
}

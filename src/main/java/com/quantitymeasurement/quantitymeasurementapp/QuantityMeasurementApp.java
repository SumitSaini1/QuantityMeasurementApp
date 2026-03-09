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
	
			System.out.println("\nChoose an Option:");
			System.out.println("1 → Add Two Lengths");
			System.out.println("2 → Convert Length");
			System.out.println("3 → Compare Two Lengths");
			System.out.println("4 → Add Two Weights");
			System.out.println("5 → Convert Weight");
			System.out.println("6 → Compare Two Weights");
			System.out.println("7 → Exit");
	
			System.out.print("Enter your choice: ");
	
			int choice = scanner.nextInt();
	
			try {
	
				switch (choice) {
	
					case 1:
	
						System.out.println("\n--- ADD TWO LENGTHS ---");
						System.out.println("Units: FEET | INCHES | YARDS | CENTIMETERS");
	
						System.out.print("Enter first value: ");
						double v1 = scanner.nextDouble();
						System.out.print("Enter first unit: ");
						LengthUnit u1 = LengthUnit.valueOf(scanner.next().toUpperCase());
	
						System.out.print("Enter second value: ");
						double v2 = scanner.nextDouble();
						System.out.print("Enter second unit: ");
						LengthUnit u2 = LengthUnit.valueOf(scanner.next().toUpperCase());
	
						System.out.print("Enter target unit: ");
						LengthUnit target = LengthUnit.valueOf(scanner.next().toUpperCase());
	
						Length l1 = new Length(v1, u1);
						Length l2 = new Length(v2, u2);
	
						Length result = Length.add(l1, l2, target);
	
						System.out.println("Result = " + result.getValue() + " " + target);
	
						break;
	
					case 2:
	
						System.out.println("\n--- CONVERT LENGTH ---");
	
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
	
						System.out.print("Enter first value: ");
						double c1 = scanner.nextDouble();
						System.out.print("Enter first unit: ");
						LengthUnit cu1 = LengthUnit.valueOf(scanner.next().toUpperCase());
	
						System.out.print("Enter second value: ");
						double c2 = scanner.nextDouble();
						System.out.print("Enter second unit: ");
						LengthUnit cu2 = LengthUnit.valueOf(scanner.next().toUpperCase());
	
						Length cl1 = new Length(c1, cu1);
						Length cl2 = new Length(c2, cu2);
	
						System.out.println("Are Equal? → " + cl1.equals(cl2));
	
						break;
	
					case 4:
	
						System.out.println("\n--- ADD TWO WEIGHTS ---");
						System.out.println("Units: KILOGRAM | GRAM | POUND");
	
						System.out.print("Enter first value: ");
						double w1 = scanner.nextDouble();
						System.out.print("Enter first unit: ");
						WeightUnit wu1 = WeightUnit.valueOf(scanner.next().toUpperCase());
	
						System.out.print("Enter second value: ");
						double w2 = scanner.nextDouble();
						System.out.print("Enter second unit: ");
						WeightUnit wu2 = WeightUnit.valueOf(scanner.next().toUpperCase());
	
						System.out.print("Enter target unit: ");
						WeightUnit targetW = WeightUnit.valueOf(scanner.next().toUpperCase());
	
						Weight weight1 = new Weight(w1, wu1);
						Weight weight2 = new Weight(w2, wu2);
	
						Weight resultWeight = Weight.add(weight1, weight2, targetW);
	
						System.out.println("Result = " + resultWeight.getValue() + " " + targetW);
	
						break;
	
					case 5:
	
						System.out.println("\n--- CONVERT WEIGHT ---");
	
						System.out.print("Enter value: ");
						double weightValue = scanner.nextDouble();
	
						System.out.print("Enter source unit: ");
						WeightUnit sourceWeight = WeightUnit.valueOf(scanner.next().toUpperCase());
	
						System.out.print("Enter target unit: ");
						WeightUnit targetWeight = WeightUnit.valueOf(scanner.next().toUpperCase());
	
						double baseWeight = sourceWeight.convertToBaseUnit(weightValue);
						double convertedWeight = targetWeight.convertFromBaseUnit(baseWeight);
	
						System.out.println("Converted Value = " + convertedWeight + " " + targetWeight);
	
						break;
	
					case 6:
	
						System.out.println("\n--- COMPARE TWO WEIGHTS ---");
	
						System.out.print("Enter first value: ");
						double cw1 = scanner.nextDouble();
						System.out.print("Enter first unit: ");
						WeightUnit cuw1 = WeightUnit.valueOf(scanner.next().toUpperCase());
	
						System.out.print("Enter second value: ");
						double cw2 = scanner.nextDouble();
						System.out.print("Enter second unit: ");
						WeightUnit cuw2 = WeightUnit.valueOf(scanner.next().toUpperCase());
	
						Weight compare1 = new Weight(cw1, cuw1);
						Weight compare2 = new Weight(cw2, cuw2);
	
						System.out.println("Are Equal? → " + compare1.equals(compare2));
	
						break;
	
					case 7:
	
						System.out.println("Exiting Application...");
						scanner.close();
						return;
	
					default:
						System.out.println("Invalid choice!");
	
				}
	
			} catch (Exception e) {
	
				System.out.println("Invalid input. Try again.");
	
			}
	
		}
	}
}
package com.quantitymeasurement.quantitymeasurementapp;

import java.util.Scanner;

public class QuantityMeasurementApp {
	public static double convert(
			double value,
			IMeasurable source,
			IMeasurable target) {

		if (source == null || target == null) {
			throw new IllegalArgumentException("Units cannot be null");
		}

		double baseValue = source.convertToBaseUnit(value);

		return target.convertFromBaseUnit(baseValue);
	}

	public static <U extends IMeasurable> Quantity<U> add(
			Quantity<U> q1,
			Quantity<U> q2) {

		return q1.add(q2);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

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

						Quantity<LengthUnit> l1 = new Quantity<>(v1, u1);
						Quantity<LengthUnit> l2 = new Quantity<>(v2, u2);

						Quantity<LengthUnit> result = l1.add(l2, target);

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

						Quantity<LengthUnit> length = new Quantity<>(value, source);

						Quantity<LengthUnit> converted = length.convertTo(targetUnit);

						System.out.println("Converted Value = " + converted.getValue() + " " + targetUnit);

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

						Quantity<LengthUnit> cl1 = new Quantity<>(c1, cu1);
						Quantity<LengthUnit> cl2 = new Quantity<>(c2, cu2);

						System.out.println("Are Equal? → " + cl1.equals(cl2));

						break;

					case 4:

						System.out.println("\n--- ADD TWO WEIGHTS ---");

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

						Quantity<WeightUnit> weight1 = new Quantity<>(w1, wu1);
						Quantity<WeightUnit> weight2 = new Quantity<>(w2, wu2);

						Quantity<WeightUnit> resultWeight = weight1.add(weight2, targetW);

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

						Quantity<WeightUnit> weight = new Quantity<>(weightValue, sourceWeight);

						Quantity<WeightUnit> convertedWeight = weight.convertTo(targetWeight);

						System.out.println("Converted Value = " + convertedWeight.getValue() + " " + targetWeight);

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

						Quantity<WeightUnit> compare1 = new Quantity<>(cw1, cuw1);
						Quantity<WeightUnit> compare2 = new Quantity<>(cw2, cuw2);

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
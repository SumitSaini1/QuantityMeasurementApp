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
			System.out.println("7 -> Add two Volume");
			System.out.println("8 -> Convert Voume");
			System.out.println("9 -> Compare Two Volume");
			System.out.println("10 → Subtract Length");
			System.out.println("11 → Subtract Weight");
			System.out.println("12 → Subtract Volume");
			System.out.println("13 → Divide Length");

			System.out.println("14 → Convert Temperature");
			System.out.println("15 → Compare Two Temperatures");
			System.out.println("16 → Exit");
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

						System.out.println("\n--- ADD TWO VOLUMES ---");

						System.out.print("Enter first value: ");
						double vol1 = scanner.nextDouble();

						System.out.print("Enter first unit: ");
						VolumeUnit vu1 = VolumeUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter second value: ");
						double vol2 = scanner.nextDouble();

						System.out.print("Enter second unit: ");
						VolumeUnit vu2 = VolumeUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter target unit: ");
						VolumeUnit targetVolume = VolumeUnit.valueOf(scanner.next().toUpperCase());

						Quantity<VolumeUnit> volume1 = new Quantity<>(vol1, vu1);
						Quantity<VolumeUnit> volume2 = new Quantity<>(vol2, vu2);

						Quantity<VolumeUnit> resultVolume = volume1.add(volume2, targetVolume);

						System.out.println("Result = " + resultVolume.getValue() + " " + targetVolume);

						break;
					case 8:

						System.out.println("\n--- CONVERT VOLUME ---");

						System.out.print("Enter value: ");
						double volValue = scanner.nextDouble();

						System.out.print("Enter source unit: ");
						VolumeUnit sourceVolume = VolumeUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter target unit: ");
						VolumeUnit targetVol = VolumeUnit.valueOf(scanner.next().toUpperCase());

						Quantity<VolumeUnit> volume = new Quantity<>(volValue, sourceVolume);

						Quantity<VolumeUnit> convertedVolume = volume.convertTo(targetVol);

						System.out.println("Converted Value = " + convertedVolume.getValue() + " " + targetVol);

						break;
					case 9:

						System.out.println("\n--- COMPARE TWO VOLUMES ---");

						System.out.print("Enter first value: ");
						double cv1 = scanner.nextDouble();

						System.out.print("Enter first unit: ");
						VolumeUnit cvu1 = VolumeUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter second value: ");
						double cv2 = scanner.nextDouble();

						System.out.print("Enter second unit: ");
						VolumeUnit cvu2 = VolumeUnit.valueOf(scanner.next().toUpperCase());

						Quantity<VolumeUnit> volumeA = new Quantity<>(cv1, cvu1);
						Quantity<VolumeUnit> volumeB = new Quantity<>(cv2, cvu2);

						System.out.println("Are Equal? → " + volumeA.equals(volumeB));

						break;
					case 10:
						System.out.println("\n--- SUBTRACT TWO LENGTHS ---");

						System.out.print("Enter first value: ");
						double sl1 = scanner.nextDouble();
						System.out.print("Enter first unit: ");
						LengthUnit slu1 = LengthUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter second value: ");
						double sl2 = scanner.nextDouble();
						System.out.print("Enter second unit: ");
						LengthUnit slu2 = LengthUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter target unit: ");
						LengthUnit targetSL = LengthUnit.valueOf(scanner.next().toUpperCase());

						Quantity<LengthUnit> subLength1 = new Quantity<>(sl1, slu1);
						Quantity<LengthUnit> subLength2 = new Quantity<>(sl2, slu2);

						Quantity<LengthUnit> resultSL = subLength1.subtract(subLength2, targetSL);

						System.out.println("Result = " + resultSL.getValue() + " " + targetSL);
						break;

					case 11:
						System.out.println("\n--- SUBTRACT TWO WEIGHTS ---");

						System.out.print("Enter first value: ");
						double sw1 = scanner.nextDouble();
						System.out.print("Enter first unit: ");
						WeightUnit swu1 = WeightUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter second value: ");
						double sw2 = scanner.nextDouble();
						System.out.print("Enter second unit: ");
						WeightUnit swu2 = WeightUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter target unit: ");
						WeightUnit targetSW = WeightUnit.valueOf(scanner.next().toUpperCase());

						Quantity<WeightUnit> subWeight1 = new Quantity<>(sw1, swu1);
						Quantity<WeightUnit> subWeight2 = new Quantity<>(sw2, swu2);

						Quantity<WeightUnit> resultSW = subWeight1.subtract(subWeight2, targetSW);

						System.out.println("Result = " + resultSW.getValue() + " " + targetSW);
						break;

					case 12:
						System.out.println("\n--- SUBTRACT TWO VOLUMES ---");

						System.out.print("Enter first value: ");
						double sv1 = scanner.nextDouble();
						System.out.print("Enter first unit: ");
						VolumeUnit svu1 = VolumeUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter second value: ");
						double sv2 = scanner.nextDouble();
						System.out.print("Enter second unit: ");
						VolumeUnit svu2 = VolumeUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter target unit: ");
						VolumeUnit targetSV = VolumeUnit.valueOf(scanner.next().toUpperCase());

						Quantity<VolumeUnit> subVolume1 = new Quantity<>(sv1, svu1);
						Quantity<VolumeUnit> subVolume2 = new Quantity<>(sv2, svu2);

						Quantity<VolumeUnit> resultSV = subVolume1.subtract(subVolume2, targetSV);

						System.out.println("Result = " + resultSV.getValue() + " " + targetSV);
						break;
					case 13:

						System.out.println("\n--- DIVIDE TWO LENGTHS ---");

						System.out.print("Enter first value: ");
						double d1 = scanner.nextDouble();

						System.out.print("Enter first unit: ");
						LengthUnit du1 = LengthUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter second value: ");
						double d2 = scanner.nextDouble();

						System.out.print("Enter second unit: ");
						LengthUnit du2 = LengthUnit.valueOf(scanner.next().toUpperCase());

						Quantity<LengthUnit> q1 = new Quantity<>(d1, du1);
						Quantity<LengthUnit> q2 = new Quantity<>(d2, du2);

						double resultDivide = q1.divide(q2);

						System.out.println("Division Result = " + resultDivide);

						break;
					case 14:

						System.out.println("\n--- CONVERT TEMPERATURE ---");

						System.out.print("Enter value: ");
						double tempValue = scanner.nextDouble();

						System.out.print("Enter source unit (CELSIUS/FAHRENHEIT/KELVIN): ");
						TemperatureUnit sourceTemp = TemperatureUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter target unit (CELSIUS/FAHRENHEIT/KELVIN): ");
						TemperatureUnit targetTemp = TemperatureUnit.valueOf(scanner.next().toUpperCase());

						Quantity<TemperatureUnit> temperature = new Quantity<>(tempValue, sourceTemp);

						Quantity<TemperatureUnit> convertedTemp = temperature.convertTo(targetTemp);

						System.out.println("Converted Value = " +
								convertedTemp.getValue() + " " + targetTemp);

						break;
					case 15:

						System.out.println("\n--- COMPARE TWO TEMPERATURES ---");

						System.out.print("Enter first value: ");
						double t1 = scanner.nextDouble();

						System.out.print("Enter first unit (CELSIUS/FAHRENHEIT/KELVIN): ");
						TemperatureUnit tu1 = TemperatureUnit.valueOf(scanner.next().toUpperCase());

						System.out.print("Enter second value: ");
						double t2 = scanner.nextDouble();

						System.out.print("Enter second unit (CELSIUS/FAHRENHEIT/KELVIN): ");
						TemperatureUnit tu2 = TemperatureUnit.valueOf(scanner.next().toUpperCase());

						Quantity<TemperatureUnit> temp1 = new Quantity<>(t1, tu1);

						Quantity<TemperatureUnit> temp2 = new Quantity<>(t2, tu2);

						System.out.println("Are Equal? → " + temp1.equals(temp2));

						break;

					case 16:

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
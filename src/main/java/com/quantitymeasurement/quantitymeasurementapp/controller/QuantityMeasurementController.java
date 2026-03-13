package com.quantitymeasurement.quantitymeasurementapp.controller;

import java.util.Scanner;

import com.quantitymeasurement.quantitymeasurementapp.enums.LengthUnit;
import com.quantitymeasurement.quantitymeasurementapp.enums.WeightUnit;
import com.quantitymeasurement.quantitymeasurementapp.enums.VolumeUnit;
import com.quantitymeasurement.quantitymeasurementapp.enums.TemperatureUnit;
import com.quantitymeasurement.quantitymeasurementapp.repository.IQuantityMeasurementRepository;
import com.quantitymeasurement.quantitymeasurementapp.repository.QuantityMeasurementDatabaseRepository;
import com.quantitymeasurement.quantitymeasurementapp.service.IQuantityMeasurementService;
import com.quantitymeasurement.quantitymeasurementapp.service.QuantityMeasurementServiceImpl;
import com.quantitymeasurement.quantitymeasurementapp.util.Quantity;

public class QuantityMeasurementController {

    IQuantityMeasurementRepository repository = new QuantityMeasurementDatabaseRepository();
    IQuantityMeasurementService service = new QuantityMeasurementServiceImpl(repository);

    public void startApplication() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nChoose Option:");
            System.out.println("1 Add Length");
            System.out.println("2 Convert Length");
            System.out.println("3 Compare Length");
            System.out.println("4 Add Weight");
            System.out.println("5 Convert Weight");
            System.out.println("6 Compare Weight");
            System.out.println("7 Add Volume");
            System.out.println("8 Convert Volume");
            System.out.println("9 Compare Volume");
            System.out.println("10 Subtract Length");
            System.out.println("11 Subtract Weight");
            System.out.println("12 Subtract Volume");
            System.out.println("13 Divide Length");
            System.out.println("14 Convert Temperature");
            System.out.println("15 Compare Temperature");
            System.out.println("16 Get All Measurements");
            System.out.println("17 Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:

                        System.out.println("Enter first length value:");
                        double l1Value = scanner.nextDouble();
                        System.out.println("Enter first length unit:");
                        LengthUnit l1Unit = LengthUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter second length value:");
                        double l2Value = scanner.nextDouble();
                        System.out.println("Enter second length unit:");
                        LengthUnit l2Unit = LengthUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter target unit:");
                        LengthUnit targetL = LengthUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<LengthUnit> l1 = new Quantity<>(l1Value, l1Unit);
                        Quantity<LengthUnit> l2 = new Quantity<>(l2Value, l2Unit);

                        System.out.println("Result: " + service.add(l1, l2, targetL).getValue());
                        break;

                    case 2:

                        System.out.println("Enter length value:");
                        double lengthValue = scanner.nextDouble();
                        System.out.println("Enter length unit:");
                        LengthUnit lengthUnit = LengthUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter target unit:");
                        LengthUnit targetUnit = LengthUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<LengthUnit> length = new Quantity<>(lengthValue, lengthUnit);

                        System.out.println("Result: " + service.convert(length, targetUnit).getValue());
                        break;

                    case 3:

                        System.out.println("Enter first length value:");
                        double cl1Value = scanner.nextDouble();
                        System.out.println("Enter first length unit:");
                        LengthUnit cl1Unit = LengthUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter second length value:");
                        double cl2Value = scanner.nextDouble();
                        System.out.println("Enter second length unit:");
                        LengthUnit cl2Unit = LengthUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<LengthUnit> cl1 = new Quantity<>(cl1Value, cl1Unit);
                        Quantity<LengthUnit> cl2 = new Quantity<>(cl2Value, cl2Unit);

                        System.out.println("Result: " + service.compare(cl1, cl2));
                        break;

                    case 4:

                        System.out.println("Enter first weight value:");
                        double w1Value = scanner.nextDouble();
                        System.out.println("Enter first weight unit:");
                        WeightUnit w1Unit = WeightUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter second weight value:");
                        double w2Value = scanner.nextDouble();
                        System.out.println("Enter second weight unit:");
                        WeightUnit w2Unit = WeightUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter target unit:");
                        WeightUnit targetW = WeightUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<WeightUnit> w1 = new Quantity<>(w1Value, w1Unit);
                        Quantity<WeightUnit> w2 = new Quantity<>(w2Value, w2Unit);

                        System.out.println("Result: " + service.add(w1, w2, targetW).getValue());
                        break;

                    case 5:

                        System.out.println("Enter weight value:");
                        double weightValue = scanner.nextDouble();
                        System.out.println("Enter weight unit:");
                        WeightUnit weightUnit = WeightUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter target unit:");
                        WeightUnit targetWeight = WeightUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<WeightUnit> weight = new Quantity<>(weightValue, weightUnit);

                        System.out.println("Result: " + service.convert(weight, targetWeight).getValue());
                        break;

                    case 6:

                        System.out.println("Enter first weight value:");
                        double cw1Value = scanner.nextDouble();
                        System.out.println("Enter first weight unit:");
                        WeightUnit cw1Unit = WeightUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter second weight value:");
                        double cw2Value = scanner.nextDouble();
                        System.out.println("Enter second weight unit:");
                        WeightUnit cw2Unit = WeightUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<WeightUnit> cw1 = new Quantity<>(cw1Value, cw1Unit);
                        Quantity<WeightUnit> cw2 = new Quantity<>(cw2Value, cw2Unit);

                        System.out.println("Result: " + service.compare(cw1, cw2));
                        break;

                    case 7:

                        System.out.println("Enter first volume value:");
                        double v1Value = scanner.nextDouble();
                        System.out.println("Enter first volume unit:");
                        VolumeUnit v1Unit = VolumeUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter second volume value:");
                        double v2Value = scanner.nextDouble();
                        System.out.println("Enter second volume unit:");
                        VolumeUnit v2Unit = VolumeUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter target unit:");
                        VolumeUnit targetV = VolumeUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<VolumeUnit> v1 = new Quantity<>(v1Value, v1Unit);
                        Quantity<VolumeUnit> v2 = new Quantity<>(v2Value, v2Unit);

                        System.out.println("Result: " + service.add(v1, v2, targetV).getValue());
                        break;

                    case 8:

                        System.out.println("Enter volume value:");
                        double volumeValue = scanner.nextDouble();
                        System.out.println("Enter volume unit:");
                        VolumeUnit volumeUnit = VolumeUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter target unit:");
                        VolumeUnit targetVolume = VolumeUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<VolumeUnit> volume = new Quantity<>(volumeValue, volumeUnit);

                        System.out.println("Result: " + service.convert(volume, targetVolume).getValue());
                        break;

                    case 9:

                        System.out.println("Enter first volume value:");
                        double cv1Value = scanner.nextDouble();
                        System.out.println("Enter first volume unit:");
                        VolumeUnit cv1Unit = VolumeUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter second volume value:");
                        double cv2Value = scanner.nextDouble();
                        System.out.println("Enter second volume unit:");
                        VolumeUnit cv2Unit = VolumeUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<VolumeUnit> cv1 = new Quantity<>(cv1Value, cv1Unit);
                        Quantity<VolumeUnit> cv2 = new Quantity<>(cv2Value, cv2Unit);

                        System.out.println("Result: " + service.compare(cv1, cv2));
                        break;

                    case 10:

                        System.out.println("Enter first length value:");
                        double sl1Value = scanner.nextDouble();
                        System.out.println("Enter first length unit:");
                        LengthUnit sl1Unit = LengthUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter second length value:");
                        double sl2Value = scanner.nextDouble();
                        System.out.println("Enter second length unit:");
                        LengthUnit sl2Unit = LengthUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter target unit:");
                        LengthUnit targetSL = LengthUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<LengthUnit> sl1 = new Quantity<>(sl1Value, sl1Unit);
                        Quantity<LengthUnit> sl2 = new Quantity<>(sl2Value, sl2Unit);

                        System.out.println("Result: " + service.subtract(sl1, sl2, targetSL).getValue());
                        break;

                    case 11:

                        System.out.println("Enter first weight value:");
                        double sw1Value = scanner.nextDouble();
                        System.out.println("Enter first weight unit:");
                        WeightUnit sw1Unit = WeightUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter second weight value:");
                        double sw2Value = scanner.nextDouble();
                        System.out.println("Enter second weight unit:");
                        WeightUnit sw2Unit = WeightUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter target unit:");
                        WeightUnit targetSW = WeightUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<WeightUnit> sw1 = new Quantity<>(sw1Value, sw1Unit);
                        Quantity<WeightUnit> sw2 = new Quantity<>(sw2Value, sw2Unit);

                        System.out.println("Result: " + service.subtract(sw1, sw2, targetSW).getValue());
                        break;

                    case 12:

                        System.out.println("Enter first volume value:");
                        double sv1Value = scanner.nextDouble();
                        System.out.println("Enter first volume unit:");
                        VolumeUnit sv1Unit = VolumeUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter second volume value:");
                        double sv2Value = scanner.nextDouble();
                        System.out.println("Enter second volume unit:");
                        VolumeUnit sv2Unit = VolumeUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter target unit:");
                        VolumeUnit targetSV = VolumeUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<VolumeUnit> sv1 = new Quantity<>(sv1Value, sv1Unit);
                        Quantity<VolumeUnit> sv2 = new Quantity<>(sv2Value, sv2Unit);

                        System.out.println("Result: " + service.subtract(sv1, sv2, targetSV).getValue());
                        break;

                    case 13:

                        System.out.println("Enter first length value:");
                        double d1Value = scanner.nextDouble();
                        System.out.println("Enter first length unit:");
                        LengthUnit d1Unit = LengthUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter second length value:");
                        double d2Value = scanner.nextDouble();
                        System.out.println("Enter second length unit:");
                        LengthUnit d2Unit = LengthUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<LengthUnit> d1 = new Quantity<>(d1Value, d1Unit);
                        Quantity<LengthUnit> d2 = new Quantity<>(d2Value, d2Unit);

                        System.out.println("Result: " + service.divide(d1, d2));
                        break;

                    case 14:

                        System.out.println("Enter temperature value:");
                        double tValue = scanner.nextDouble();
                        System.out.println("Enter temperature unit:");
                        TemperatureUnit tUnit = TemperatureUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter target unit:");
                        TemperatureUnit targetTemp = TemperatureUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<TemperatureUnit> temp = new Quantity<>(tValue, tUnit);

                        System.out.println("Result: " + service.convert(temp, targetTemp).getValue());
                        break;

                    case 15:

                        System.out.println("Enter first temperature value:");
                        double t1Value = scanner.nextDouble();
                        System.out.println("Enter first temperature unit:");
                        TemperatureUnit t1Unit = TemperatureUnit.valueOf(scanner.next().toUpperCase());

                        System.out.println("Enter second temperature value:");
                        double t2Value = scanner.nextDouble();
                        System.out.println("Enter second temperature unit:");
                        TemperatureUnit t2Unit = TemperatureUnit.valueOf(scanner.next().toUpperCase());

                        Quantity<TemperatureUnit> t1 = new Quantity<>(t1Value, t1Unit);
                        Quantity<TemperatureUnit> t2 = new Quantity<>(t2Value, t2Unit);

                        System.out.println("Result: " + service.compare(t1, t2));
                        break;

                    case 16:

                        System.out.println("Stored Measurements:");
                        repository.getAllMeasurements().forEach(e ->
                                System.out.println(e.operation + " " + e.resultValue + " " + e.resultUnit));
                        break;

                    case 17:

                        System.out.println("Exiting application...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Invalid Input");
                scanner.nextLine();
            }
        }
    }
}
package com.quantitymeasurement.quantitymeasurementapp.controller;

import java.util.Scanner;

import com.quantitymeasurement.quantitymeasurementapp.enums.LengthUnit;
import com.quantitymeasurement.quantitymeasurementapp.enums.WeightUnit;
import com.quantitymeasurement.quantitymeasurementapp.enums.VolumeUnit;
import com.quantitymeasurement.quantitymeasurementapp.enums.TemperatureUnit;
import com.quantitymeasurement.quantitymeasurementapp.service.IQuantityMeasurementService;
import com.quantitymeasurement.quantitymeasurementapp.service.QuantityMeasurementServiceImpl;
import com.quantitymeasurement.quantitymeasurementapp.util.Quantity;


public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController() {
        service = new QuantityMeasurementServiceImpl();
    }

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
            System.out.println("16 Exit");

            int choice = scanner.nextInt();

            try {

                switch (choice) {

                case 1:

                    Quantity<LengthUnit> l1 = new Quantity<>(scanner.nextDouble(),
                            LengthUnit.valueOf(scanner.next().toUpperCase()));

                    Quantity<LengthUnit> l2 = new Quantity<>(scanner.nextDouble(),
                            LengthUnit.valueOf(scanner.next().toUpperCase()));

                    LengthUnit targetL =
                            LengthUnit.valueOf(scanner.next().toUpperCase());

                    System.out.println(service.add(l1, l2, targetL).getValue());

                    break;

                case 2:

                    Quantity<LengthUnit> length =
                            new Quantity<>(scanner.nextDouble(),
                                    LengthUnit.valueOf(scanner.next().toUpperCase()));

                    LengthUnit targetUnit =
                            LengthUnit.valueOf(scanner.next().toUpperCase());

                    System.out.println(service.convert(length, targetUnit).getValue());

                    break;

                case 3:

                    Quantity<LengthUnit> cl1 =
                            new Quantity<>(scanner.nextDouble(),
                                    LengthUnit.valueOf(scanner.next().toUpperCase()));

                    Quantity<LengthUnit> cl2 =
                            new Quantity<>(scanner.nextDouble(),
                                    LengthUnit.valueOf(scanner.next().toUpperCase()));

                    System.out.println(service.compare(cl1, cl2));

                    break;

                case 4:

                    Quantity<WeightUnit> w1 =
                            new Quantity<>(scanner.nextDouble(),
                                    WeightUnit.valueOf(scanner.next().toUpperCase()));

                    Quantity<WeightUnit> w2 =
                            new Quantity<>(scanner.nextDouble(),
                                    WeightUnit.valueOf(scanner.next().toUpperCase()));

                    WeightUnit targetW =
                            WeightUnit.valueOf(scanner.next().toUpperCase());

                    System.out.println(service.add(w1, w2, targetW).getValue());

                    break;

                case 5:

                    Quantity<WeightUnit> weight =
                            new Quantity<>(scanner.nextDouble(),
                                    WeightUnit.valueOf(scanner.next().toUpperCase()));

                    WeightUnit targetWeight =
                            WeightUnit.valueOf(scanner.next().toUpperCase());

                    System.out.println(service.convert(weight, targetWeight).getValue());

                    break;

                case 6:

                    Quantity<WeightUnit> cw1 =
                            new Quantity<>(scanner.nextDouble(),
                                    WeightUnit.valueOf(scanner.next().toUpperCase()));

                    Quantity<WeightUnit> cw2 =
                            new Quantity<>(scanner.nextDouble(),
                                    WeightUnit.valueOf(scanner.next().toUpperCase()));

                    System.out.println(service.compare(cw1, cw2));

                    break;

                case 7:

                    Quantity<VolumeUnit> v1 =
                            new Quantity<>(scanner.nextDouble(),
                                    VolumeUnit.valueOf(scanner.next().toUpperCase()));

                    Quantity<VolumeUnit> v2 =
                            new Quantity<>(scanner.nextDouble(),
                                    VolumeUnit.valueOf(scanner.next().toUpperCase()));

                    VolumeUnit targetV =
                            VolumeUnit.valueOf(scanner.next().toUpperCase());

                    System.out.println(service.add(v1, v2, targetV).getValue());

                    break;

                case 8:

                    Quantity<VolumeUnit> volume =
                            new Quantity<>(scanner.nextDouble(),
                                    VolumeUnit.valueOf(scanner.next().toUpperCase()));

                    VolumeUnit targetVolume =
                            VolumeUnit.valueOf(scanner.next().toUpperCase());

                    System.out.println(service.convert(volume, targetVolume).getValue());

                    break;

                case 9:

                    Quantity<VolumeUnit> cv1 =
                            new Quantity<>(scanner.nextDouble(),
                                    VolumeUnit.valueOf(scanner.next().toUpperCase()));

                    Quantity<VolumeUnit> cv2 =
                            new Quantity<>(scanner.nextDouble(),
                                    VolumeUnit.valueOf(scanner.next().toUpperCase()));

                    System.out.println(service.compare(cv1, cv2));

                    break;

                case 10:

                    Quantity<LengthUnit> sl1 =
                            new Quantity<>(scanner.nextDouble(),
                                    LengthUnit.valueOf(scanner.next().toUpperCase()));

                    Quantity<LengthUnit> sl2 =
                            new Quantity<>(scanner.nextDouble(),
                                    LengthUnit.valueOf(scanner.next().toUpperCase()));

                    LengthUnit targetSL =
                            LengthUnit.valueOf(scanner.next().toUpperCase());

                    System.out.println(service.subtract(sl1, sl2, targetSL).getValue());

                    break;

                case 11:

                    Quantity<WeightUnit> sw1 =
                            new Quantity<>(scanner.nextDouble(),
                                    WeightUnit.valueOf(scanner.next().toUpperCase()));

                    Quantity<WeightUnit> sw2 =
                            new Quantity<>(scanner.nextDouble(),
                                    WeightUnit.valueOf(scanner.next().toUpperCase()));

                    WeightUnit targetSW =
                            WeightUnit.valueOf(scanner.next().toUpperCase());

                    System.out.println(service.subtract(sw1, sw2, targetSW).getValue());

                    break;

                case 12:

                    Quantity<VolumeUnit> sv1 =
                            new Quantity<>(scanner.nextDouble(),
                                    VolumeUnit.valueOf(scanner.next().toUpperCase()));

                    Quantity<VolumeUnit> sv2 =
                            new Quantity<>(scanner.nextDouble(),
                                    VolumeUnit.valueOf(scanner.next().toUpperCase()));

                    VolumeUnit targetSV =
                            VolumeUnit.valueOf(scanner.next().toUpperCase());

                    System.out.println(service.subtract(sv1, sv2, targetSV).getValue());

                    break;

                case 13:

                    Quantity<LengthUnit> d1 =
                            new Quantity<>(scanner.nextDouble(),
                                    LengthUnit.valueOf(scanner.next().toUpperCase()));

                    Quantity<LengthUnit> d2 =
                            new Quantity<>(scanner.nextDouble(),
                                    LengthUnit.valueOf(scanner.next().toUpperCase()));

                    System.out.println(service.divide(d1, d2));

                    break;

                case 14:

                    Quantity<TemperatureUnit> temp =
                            new Quantity<>(scanner.nextDouble(),
                                    TemperatureUnit.valueOf(scanner.next().toUpperCase()));

                    TemperatureUnit targetTemp =
                            TemperatureUnit.valueOf(scanner.next().toUpperCase());

                    System.out.println(service.convert(temp, targetTemp).getValue());

                    break;

                case 15:

                    Quantity<TemperatureUnit> t1 =
                            new Quantity<>(scanner.nextDouble(),
                                    TemperatureUnit.valueOf(scanner.next().toUpperCase()));

                    Quantity<TemperatureUnit> t2 =
                            new Quantity<>(scanner.nextDouble(),
                                    TemperatureUnit.valueOf(scanner.next().toUpperCase()));

                    System.out.println(service.compare(t1, t2));

                    break;

                case 16:
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }
    }
}
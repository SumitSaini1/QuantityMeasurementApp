package quantitymeasurement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import quantitymeasurement.dto.QuantityRequest;
import quantitymeasurement.dto.ResponseDto;
import quantitymeasurement.dto.ConvertRequest;
import quantitymeasurement.service.IQuantityMeasurementService;
import quantitymeasurement.util.IMeasurable;
import quantitymeasurement.util.Quantity;
import quantitymeasurement.util.UnitConverter;

@RestController
@RequestMapping("/api/quantity")
@RequiredArgsConstructor
public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    @PostMapping("/add")
    public ResponseDto add(@Valid @RequestBody QuantityRequest request) {

        IMeasurable unit1 = UnitConverter.fromString(request.getUnit1());
        IMeasurable unit2 = UnitConverter.fromString(request.getUnit2());

        Quantity<?> q1 = new Quantity<>(request.getValue1(), unit1);
        Quantity<?> q2 = new Quantity<>(request.getValue2(), unit2);
        ResponseDto response = new ResponseDto();
        response.setOperation("ADDITION");

        response.setValue1(request.getValue1());
        response.setUnit1(request.getUnit1());
        response.setValue2(request.getValue2());
        response.setUnit2(request.getUnit2());

        double resultValue = service.add(q1, q2, unit1).getValue();
        String resultUnit = service.add(q1, q2, unit1).getUnit().toString();
        response.setResultValue(resultValue);
        response.setResultUnit(resultUnit);
        return response;
    }

    @PostMapping("/subtract")
    public ResponseDto subtract(@Valid @RequestBody QuantityRequest request) {

        IMeasurable unit1 = UnitConverter.fromString(request.getUnit1());
        IMeasurable unit2 = UnitConverter.fromString(request.getUnit2());

        Quantity<?> q1 = new Quantity<>(request.getValue1(), unit1);
        Quantity<?> q2 = new Quantity<>(request.getValue2(), unit2);

        ResponseDto response = new ResponseDto();
        response.setOperation("ADDITION");

        response.setValue1(request.getValue1());
        response.setUnit1(request.getUnit1());
        response.setValue2(request.getValue2());
        response.setUnit2(request.getUnit2());

        double resultValue = service.subtract(q1, q2, unit1).getValue();
        String resultUnit = service.subtract(q1, q2, unit1).getUnit().toString();
        response.setResultValue(resultValue);
        response.setResultUnit(resultUnit);
        return response;
    }

    @PostMapping("/divide")
    public ResponseDto divide(@Valid @RequestBody QuantityRequest request) {

        IMeasurable unit1 = UnitConverter.fromString(request.getUnit1());
        IMeasurable unit2 = UnitConverter.fromString(request.getUnit2());

        Quantity<?> q1 = new Quantity<>(request.getValue1(), unit1);
        Quantity<?> q2 = new Quantity<>(request.getValue2(), unit2);
        double resultValue = service.divide(q1, q2);
        ResponseDto response = new ResponseDto();
        response.setOperation("DIVIDE");
        response.setValue1(request.getValue1());
        response.setUnit1(request.getUnit1());
        response.setValue2(request.getValue2());
        response.setUnit2(request.getUnit2());
        response.setResultValue(resultValue);
        response.setResultUnit("RATIO");

        return response;
    }

    @PostMapping("/compare")
    public ResponseDto compare(@Valid @RequestBody QuantityRequest request) {

        IMeasurable unit1 = UnitConverter.fromString(request.getUnit1());
        IMeasurable unit2 = UnitConverter.fromString(request.getUnit2());

        Quantity<?> q1 = new Quantity<>(request.getValue1(), unit1);
        Quantity<?> q2 = new Quantity<>(request.getValue2(), unit2);
        ResponseDto response = new ResponseDto();
        response.setOperation("ADDITION");

        response.setValue1(request.getValue1());
        response.setUnit1(request.getUnit1());
        response.setValue2(request.getValue2());
        response.setUnit2(request.getUnit2());

        boolean resultValue = service.compare(q1, q2);

        response.setResultValue(resultValue ? 1 : 0);
        response.setResultUnit("BOOLEAN");
        return response;
    }

    @PostMapping("/convert")
    public ResponseDto convert(@RequestBody ConvertRequest request) {

        IMeasurable fromUnit = UnitConverter.fromString(request.getFromUnit());
        IMeasurable toUnit = UnitConverter.fromString(request.getToUnit());

        Quantity<?> q = new Quantity<>(request.getValue(), fromUnit);
        Quantity<?> result = service.convert(q, toUnit);

        ResponseDto response = new ResponseDto();
        response.setOperation("CONVERT");
        response.setValue1(request.getValue());
        response.setUnit1(request.getFromUnit());
        response.setResultValue(result.getValue());
        response.setResultUnit(result.getUnit().toString());

        return response;
    }
}
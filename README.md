# QuantityMeasurementApp

This project is a step-by-step implementation of a Length Measurement system in Java.

Each feature is implemented in a separate Git branch (UC1 to UC5).

---

## Branches and What Was Done

### 🔹 UC1 – Feet Equality  
Branch: `feature/UC1-FeetEquality`

- Created `Feet` class.
- Implemented `equals()` method.
- Compared two Feet objects.
- Added basic JUnit test cases.

---

### 🔹 UC2 – Inches Equality  
Branch: `feature/UC2-InchEquality`

- Added `Inches` class.
- Implemented equality logic for Inches.
- Tested equality for both Feet and Inches.

---

### 🔹 UC3 – Generic Length  
Branch: `feature/UC3-GenericLength`

- Replaced Feet and Inches with one `Length` class.
- Created `LengthUnit` enum (FEET, INCHES).
- Implemented cross-unit equality:
  - 1 Foot = 12 Inches.
- Used base unit conversion (inches).

---

### 🔹 UC4 – Add More Units  
Branch: `feature/UC4-YardEquality`

- Added YARDS and CENTIMETERS to enum.
- No change required in Length logic.
- Verified:
  - 1 Yard = 3 Feet
  - 1 Yard = 36 Inches
  - 1 CM = 0.393701 Inches

---

### 🔹 UC5 – Unit Conversion  
Branch: `feature/UC5-UnitConversion`

- Added static `convert()` method.
- Convert value from one unit to another.

---

### 🔹 UC6 – Addition of Two Length Units  
Branch: `feature/UC6-UnitAddition`

- Implemented addition of two `Length` objects.
- Used base unit (inches) internally for calculation.
- Converted both lengths to base unit.
- Added the converted values.
- Converted the result back to the unit of the first operand.
- Returned a new `Length` object (immutability maintained).
- Added JUnit test cases for:
  - Same unit addition
  - Cross unit addition
  - Reverse order
  - Zero case
  - Negative case
  - Null validation

Example:
- 1 Foot + 12 Inches = 2 Feet
- 12 Inches + 1 Foot = 24 Inches

---

### 🔹 UC7 – Addition with Explicit Target Unit  
Branch: `feature/UC7-TargetUnitAddition`

- Extended addition to allow explicit target unit.
- Implemented static method:
  `add(length1, length2, targetUnit)`
- Converted both lengths to base unit.
- Added the values.
- Converted the result into the specified target unit.
- Returned new `Length` object in target unit.
- Added validation for null inputs.
- Added JUnit test cases for:
  - Target same as first operand
  - Target same as second operand
  - Target different from both operands
  - Commutativity
  - Zero case
  - Negative values
  - Large values

Example:
- add(1 Foot, 12 Inches, FEET) = 2 Feet
- add(1 Foot, 12 Inches, INCHES) = 24 Inches
- add(1 Foot, 12 Inches, YARDS) ≈ 0.667 Yards

---

## 🔹 UC8 – Refactoring Unit Enum

Branch: `feature/UC8-StandaloneUnit`

Refactored the design to separate unit conversion responsibility from the `Length` class into a standalone enum, improving scalability and maintainability.

• Extracted `LengthUnit` from inside `Length` class into a standalone enum
• Moved all conversion logic into `LengthUnit`
• Implemented:

* `convertToBaseUnit()`
* `convertFromBaseUnit()`
  • Simplified `Length` class:
* Removed internal conversion logic
* Delegated conversion to `LengthUnit`
  • Improved design using:
* Single Responsibility Principle
* Better separation of concerns
  • Maintained backward compatibility (no API change)

### Added JUnit test cases for:

• Equality (same & cross unit)
• Conversion correctness
• Addition operations
• Regression tests (UC1–UC7 still passing)

### Example:

```
1 Foot = 12 Inches (handled by LengthUnit)
Length class only focuses on comparison & arithmetic
```

---

## 🔹 UC9 – Weight Measurement Support

Branch: `feature/UC9-Weight-Measurement`

Extended the system to support a new measurement category: **Weight (Kilogram, Gram, Pound)** alongside length.

• Introduced new enum `WeightUnit`
• Supported units:

* KILOGRAM (base unit)
* GRAM (1 kg = 1000 g)
* POUND (1 lb ≈ 0.453592 kg)
  • Created `QuantityWeight` class similar to `QuantityLength`
  • Implemented:
* Equality comparison (via base unit: kg)
* Unit conversion
* Addition (same + cross unit)
  • Ensured **length and weight are separate categories** (no cross comparison)
  • Maintained immutability of objects

### Added JUnit test cases for:

• Same unit equality (kg, g, lb)
• Cross unit equality (kg ↔ g, kg ↔ lb)
• Conversion between all units
• Addition with:

* Same unit
* Different units
* Zero
* Negative values
* Null validation
  • Category mismatch (length ≠ weight)

### Example:

```
1 kg = 1000 g
1 kg ≈ 2.20462 lb

1 kg + 1000 g = 2 kg
```

---

## 🔹 UC10 – Generic Quantity with Unit Interface

Branch: `feature/UC10-Unit-Interface-For-MultiCategory-Support`

Refactored the system into a **generic and scalable architecture** to support multiple measurement categories using a common interface.

• Introduced `IMeasurable` interface

* `getConversionFactor()`
* `convertToBaseUnit()`
* `convertFromBaseUnit()`
* `getUnitName()`

• Refactored:

* `LengthUnit` and `WeightUnit` → implement `IMeasurable`

• Created generic class:

* `Quantity<U extends IMeasurable>`

• Replaced:

* `QuantityLength`
* `QuantityWeight`
  with a single generic class

• Implemented in generic class:

* `equals()` (base unit comparison + type safety)
* `convertTo()`
* `add()` (same + target unit)
* `hashCode()` and `toString()`

• Ensured **type safety**:

* Prevents invalid comparisons (e.g., length vs weight)

• Simplified `QuantityMeasurementApp`:

* Removed duplicate methods
* Created generic operations

• Eliminated:

* Code duplication
* Repeated logic across categories

• Achieved:

* DRY Principle
* Scalable architecture
* Easy addition of new units (volume, temperature, etc.)

### Added JUnit test cases for:

• Cross-category safety (invalid comparisons)
• Generic equality & conversion
### Example:

```
Quantity<LengthUnit> → Length
Quantity<WeightUnit> → Weight

add(1 Foot, 12 Inches) = 2 Feet
add(1 kg, 1000 g) = 2 kg

Invalid: 1 Foot ≠ 1 Kilogram
```

---
### 🔹 UC11 – Volume Measurement  
Branch: `feature/UC11-Volume-Measurement-Equality`

- Added new category: Volume (Litre, Millilitre, Gallon)
- Created `VolumeUnit` enum implementing `IMeasurable`
- Supported operations:
  - Equality comparison
  - Unit conversion
  - Addition of volumes
- No changes required in existing generic `Quantity<U>` logic
- Verified:
  - 1 Litre = 1000 Millilitre
  - 1 Gallon ≈ 3.78541 Litres
  - Cross-unit equality (L ↔ mL ↔ Gallon)
  - Addition across different units

---

### 🔹 UC12 – Subtraction and Division  
Branch: `feature/UC12-Subtraction-and-Division`

- Added subtraction and division operations to `Quantity<U>`
- Supports cross-unit arithmetic within same category
- Maintains immutability and type safety
- Verified:
  - Subtraction (e.g., 5L - 2L = 3L)
  - Division (ratio between quantities)
  - Works across different units

---
### 🔹 UC13 – Centralized Arithmetic Logic  
Branch: `feature/UC13-Centralized-Arithmetic-Logic`

- Refactored arithmetic logic to remove code duplication
- Introduced common helper method (DRY principle)
- Improved maintainability and readability
- Verified:
  - No duplicate logic in add/subtract/divide
  - Consistent validation and conversion

---
### 🔹 UC14 – Temperature Measurement  
Branch: `feature/UC14-TemperaturE-Measurement-with-Selective-Arithmetic-Support-and-Measurable-Refactoring`

- Added Temperature category (Celsius, Fahrenheit, Kelvin)
- Introduced selective arithmetic support
- Temperature supports only comparison & conversion
- Updated `IMeasurable` for optional operations
- Verified:
  - Temperature conversion works correctly
  - Invalid operations (like multiply) are restricted

---
### 🔹 UC15 – N-Tier Architecture Refactoring  
Branch: `feature/UC15-N-Tier`

- Refactored project into layers:
  - Controller, Service, Repository, Model
- Applied SOLID principles
- Improved code separation and scalability
- Verified:
  - Clean separation of concerns
  - Easy to extend and maintain

---
### 🔹 UC16 – Database Integration (JDBC)  
Branch: `feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence`

- Added database persistence using JDBC
- Replaced in-memory storage with DB repository
- Introduced Maven project structure
- Supports storing and retrieving measurement history
- Verified:
  - Data persists in database
  - CRUD operations working

---
### 🔹 UC17 – Spring Boot Integration  
Branch: `feature/UC17-spring-backend-for-quantity-measurement`

- Converted project into Spring Boot application
- Added REST APIs for quantity operations
- Integrated Spring Data JPA (ORM)
- Added Swagger for API documentation
- Included Actuator for monitoring
- Verified:
  - REST endpoints working (GET, POST, PUT, DELETE)
  - Database integration via JPA
  - API documentation accessible

---
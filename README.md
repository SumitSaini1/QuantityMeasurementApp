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
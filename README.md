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

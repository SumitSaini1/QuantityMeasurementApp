// package quantitymeasurement.app;

// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.sql.Connection;
// import java.sql.Statement;
// import quantitymeasurement.controller.QuantityMeasurementController;
// // import quantitymeasurement.util.ConnectionPool;
// import quantitymeasurement.util.IMeasurable;

// public class QuantityMeasurementApp {

//     public static void main(String[] args) {

        
//         try {
//             Connection conn = ConnectionPool.getConnection();

//             String sql = new String(
//                     Files.readAllBytes(
//                             Paths.get("src/main/resources/schema.sql")));

//             Statement stmt = conn.createStatement();
//             stmt.execute(sql);

//             System.out.println("Database table created successfully!");

//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         QuantityMeasurementController controller =
//                 new QuantityMeasurementController();

//         controller.startApplication();
//     }

//     public static double convert(double value,
//                                  IMeasurable source,
//                                  IMeasurable target) {

//         if (source == null || target == null) {
//             throw new IllegalArgumentException("Units cannot be null");
//         }

//         double baseValue = source.convertToBaseUnit(value);

//         return target.convertFromBaseUnit(baseValue);
//     }
// }
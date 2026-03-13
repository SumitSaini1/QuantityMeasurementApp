package com.quantitymeasurement.quantitymeasurementapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionPool {

    private static final String URL =
    "jdbc:h2:file:./data/quantitymeasurementdb;AUTO_SERVER=TRUE";

    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
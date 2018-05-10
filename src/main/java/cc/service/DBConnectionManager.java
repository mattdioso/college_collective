package cc.service;

import java.sql.*;
import java.sql.Connection;

public class DBConnectionManager {
	public static Connection connect() {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/CC_test";

		String username = "matt";
		String password = "Univega1986";

		System.out.println("Loading Driver....");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}

		System.out.println("Connecting Database...");

		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database Connected!");
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect to the database", e);
		}

		return connection;
	}

	public static void disconnect(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
				System.out.println("Successfully dropped database connection");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
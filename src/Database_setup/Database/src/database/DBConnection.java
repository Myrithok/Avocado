package database;

import java.sql.*;
import java.util.Scanner;

public class DBConnection{

	// database access info
	String driver = "oracle.jdbc.driver.OracleDriver";
	public final static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/UP";
	private static final String user = "root";
	private static final String password = "miwi9226";
	
	private static Connection con;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			System.out.println("connected to Database");
			System.out.println("\n");
			
			
			return con;
		} catch (Exception e) {
			System.out.println("Connection Error");
		}
		return null;
	}

}
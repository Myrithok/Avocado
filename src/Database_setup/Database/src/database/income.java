package database;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class income {
	private static final String url = "jdbc:mysql://localhost:3306/income";

    private static final String user = "root";

    private static final String password = "miwi9226";
	
	public static void main(String[] args) {
		

	try {
		//1. get a connection to database 
		
		Connection myConn = DriverManager.getConnection(url, user, password);
		
		System.out.println("connected to Database");
		
		//2. create statement
		Statement myStmt = myConn.createStatement();
		
		//3. execute sql query
		ResultSet myRs = myStmt.executeQuery("select * from income_min");
		
		//select * from debt_minimum where COORDINATE LIKE '%10.2.1__%'
		
		//4. process result set
		while (myRs.next()) {
			System.out.println(myRs.getString("COORDINATE")+ ", " + myRs.getString("VALUE"));	
		}	
	}
 
	catch (Exception exc) {
		exc.printStackTrace();
		}
	}
}

package database;

import java.sql.*;

public class DataSet{
	
	public static void main(String args[]) {
	try {
		//1. get a connection to database
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");
		
		//2. create statement
		Statement myStmt = myConn.createStatement();
		
		//3. execute sql query
		ResultSet myRs = myStmt.executeQuery("select * from employee");
		
		//4. process result set
		while (myRs.next()) {
			System.out.println(myRs.getString("last_name"+", " +myRs.getString("first_name")));
		}
	}

	catch (Exception exc) {
		exc.printStackTrace();
		}
	}
}
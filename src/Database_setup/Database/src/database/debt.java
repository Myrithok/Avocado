package database;

import java.sql.*;
//one public function
//public void 

public class debt{
	
	private static final String url = "jdbc:mysql://localhost:3306";

    private static final String user = "root";

    private static final String password = "miwi9226";
	
	public static void main(String[] args) {
		

	try {
		//1. get a connection to database
		//Service: @127.0.0.1:3306	 
		
		Connection myConn = DriverManager.getConnection(url, user, password);
		
		System.out.println("connected to Database");
		
		//2. create statement
		Statement myStmt = myConn.createStatement();
		
		//3. execute sql query
		ResultSet myRs = myStmt.executeQuery("SELECT * FROM debt_min.debt_min;");
		
		//select * from debt_minimum where COORDINATE LIKE '%10.2.1__%'
		
		//4. process result set
		while (myRs.next()) {
			System.out.println(myRs.getString("DE_COORDINATE")+", " +myRs.getString("DE_VALUE"));
		}
	}
 
	catch (Exception exc) {
		exc.printStackTrace();
		}
	}
}
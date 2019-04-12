package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author danielwu
 * 
 *         This class allows to create table, insert and output the entire table
 *
 */

//https://www.youtube.com/watch?v=GU_zYgXXOzE


public class Jdbc {
	public static void main(String[] args) throws Exception {
		createUserTable();
		//createUser("haha1", "badass");
		
		//userExsits("haha");
		//createFriendTable();
		//InsertFriend(1,5);
		//friendIDExists("Boba");
		
		//validLogin("hah", "badass");
		//deleteUser("haha");
		//get();
		
		
		//updatePassword("haha", "niceass" );
	}

	
	
	public static boolean validLogin(String username, String password) {
		try {
			Connection con = getConnection();
			String ValidateSQL = "SELECT USERNAME, PASSWORD FROM LOGIN_TB WHERE USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(ValidateSQL);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			String uName = "", uPass = "";
			//System.out.println("userName: " + uName);
			if (rs.next()) {
				System.out.println("userName: " + uName);
				uName = rs.getString("USERNAME");
				uPass = rs.getString("PASSWORD");
				System.out.println("userName: " + uName);
				System.out.println("password: " + uPass);
				if (uPass.equals(password)) {
					System.out.println("user is valid");
					return true;
				}	
			}
			else {
				System.out.println("Not valid");
				return false;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return false;
	} 
	

	public static boolean userExsits(String user) throws Exception {
		try {
			Connection con = getConnection();
			String ExistSQL = "SELECT * FROM LOGIN_TB WHERE USERNAME ='" + user + "'";
			PreparedStatement statement = con.prepareStatement(ExistSQL);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				System.out.println("User exist");
				return true;
			}

			else {
				System.out.println("User does not exist");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

   	// update password by select user
	public static void saveUser(User U) throws Exception{
	  try { 
		  Connection con = getConnection(); 
		  String UpdateSQL = ("UPDATE LOGIN_TB "
				  + "SET PASSWORD = ?,"
				  + "SET DEBTDATA = ?,"
				  + "SET GRADDEBT = ?,"
				  + "SET DEBT = ?,"
				  + "SET INTEREST = ?,"
				  + "SET GRAD = ?,"
				  + "SET BIRTH = ?,"
				  + "SET OPTED = ?,"
				  + "SET PROVINCE = ?,"
				  + "SET EDUCATION = ?,"
				  + "SET FIELD = ?,"
				  + "SET SEX = ?,"
				  + "SET FRIENDCODE = ?,"
				  + "SET USERRANK = ?," 
				  + "WHERE USERNAME = '"+U+"'" );
	  
	  PreparedStatement updated = con.prepareStatement(UpdateSQL);
	  updated.setString(1, U);
	  updated.executeUpdate();

	  } catch(Exception e){ System.out.println(e); } finally {
	  System.out.println("successfully updated"); } }

	
	public static void createUser(String username, String password) throws Exception {
		try {
			Connection con = getConnection();
			String InsertSQL = ("INSERT INTO LOGIN_TB" 
					+ "(USERNAME, PASSWORD) " 
					+ "VALUES(?,?)");
			PreparedStatement posted = con.prepareStatement(InsertSQL);
			posted.setString(1, username);
			posted.setString(2, password);
		
			posted.executeUpdate();
		}		
		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			System.out.println("Insert Completed");
		}
	}	
	
	public static void InsertFriend(int ME, int YOU) throws Exception {
		try {
			Connection con = getConnection();
			String InsertFriendSQL = ("INSERT INTO FRIEND"
					+ "(FRIENDID, ME, YOU) "
					+ "VALUES(null, ?,?)");
			PreparedStatement create = con.prepareStatement(InsertFriendSQL); // getting sql statement to be ready to use (not used
			create.setInt(1, ME);
			create.setInt(2, YOU);
			create.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static boolean friendIDExists(String friendID) throws Exception {
		try {
			Connection con = getConnection();
			String ExistFriendSQL = "SELECT * FROM FRIEND WHERE FRIENDID ='" + friendID + "'";
			PreparedStatement statement = con.prepareStatement(ExistFriendSQL);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				System.out.println("Friend exist");
				return true;

			}

			else {
				System.out.println("User does not exist");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public static void createFriendTable() throws Exception {
		try {
			Connection con = getConnection(); // getting connected to the database
			String sql = ("CREATE TABLE IF NOT EXISTS FRIEND"
					+ "(FRIENDID INT NOT NULL AUTO_INCREMENT,"
					+ "ME INT NOT NULL,"
					+ "YOU INT NOT NULL,"
					+ "PRIMARY KEY(FRIENDID))" );
			PreparedStatement create = con.prepareStatement(sql); // getting sql statement to be ready to use (not used	
			create.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("function completed");
		}
	}
	
	public static void deleteUser(String username)throws Exception {
		try {
			Connection con = getConnection();
			String DELETESQL = ("DELETE FROM LOGIN_TB WHERE USERNAME = ?");
			PreparedStatement deleted = con.prepareStatement(DELETESQL);
			deleted.setString(1, username);
			deleted.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			System.out.println("Delete Completed");
		}
	}
	
	
	public static void createUserTable() throws Exception {
		try {
			Connection con = getConnection(); // getting connected to the database
			String sql = ("CREATE TABLE IF NOT EXISTS LOGIN_TB " 
					+ "(USERNAME VARCHAR(50), " 
					+ "PASSWORD VARCHAR(50), "
					+ "INCOMEDATA FLOAT(50),"
					+ "DEBTDATA FLOAT(50),"
					+ "GRADDEBT FLOAT(50),"
					+ "DEBT FLOAT(50),"
					+ "INTEREST FLOAT(50),"
					+ "GRAD FLOAT(50),"
					+ "BIRTH VARCHAR(50),"
					+ "OPTED BOOLEAN,"
					+ "PROVINCE VARCHAR(50),"
					+ "EDUCATION VARCHAR(50),"
					+ "FIELD VARCHAR(50),"
					+ "SEX VARCHAR(50),"
					+ "FRIENDCODE INT,"
					+ "USERRANK INT,"
					+ "PRIMARY KEY(USERNAME))");
			PreparedStatement create = con.prepareStatement(sql); // getting sql statement to be ready to use (not used											
			create.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Table created");
		}
	}

	/**
	 * @return array of users and passwords
	 * @throws Exception
	 */
	public static ArrayList<String> get() throws Exception {
		try {
			// ESTABLISH CONNECTION WITH DATABASE
			Connection con = getConnection();

			// SQL statement required to Select all data from database
			String SelectSQL = ("SELECT * FROM LOGIN_TB "); // Stop after SQL finds one of each copy
			PreparedStatement statement = con.prepareStatement(SelectSQL);
			ResultSet result = statement.executeQuery();
		
			ArrayList<String> array = new ArrayList<String>();
			while (result.next()) {
				System.out.print(result.getString("USERNAME"));
				System.out.print(" ");
				System.out.print(result.getString("PASSWORD"));
				System.out.print(" ");
				System.out.print(result.getFloat("INCOMEDATA"));
				System.out.print(" ");
				System.out.print(result.getFloat("DEBTDATA"));
				System.out.print(" ");
				System.out.print(result.getFloat("GRADDEBT"));
				System.out.print(" ");
				System.out.print(result.getFloat("DEBT"));
				System.out.print(" ");
				System.out.print(result.getFloat("INTEREST"));
				System.out.print(" ");
				System.out.print(result.getFloat("GRAD"));
				System.out.print(" ");
				System.out.print(result.getFloat("BIRTH"));
				System.out.print(" ");
				System.out.print(result.getBoolean("OPTED"));
				System.out.print(" ");
				System.out.print(result.getString("PROVINCE"));
				System.out.print(" ");
				System.out.print(result.getString("EDUCATION"));
				System.out.print(" ");
				System.out.print(result.getString("FIELD"));
				System.out.print(" ");
				System.out.print(result.getString("SEX"));
				System.out.print(" ");
				System.out.print(result.getInt("FRIENDCODE"));
				System.out.print(" ");
				System.out.println(result.getInt("RANK"));
				
				array.add(result.getString("Username"));
			}
			System.out.println("All records have been selected");
			return array;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static Connection getConnection() throws Exception {
		try {
			String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";

			String url = "jdbc:mysql://localhost:3306/UP";
			String user = "root";
			String password = "miwi9226";
			Class.forName(DB_DRIVER_CLASS);

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("connected to Database");
			// System.out.println("\n");
			return con;
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
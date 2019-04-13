package randomBS;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
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
		//createUserTable();
		//createUser("Dakota", "Loveanime");
		//createUser("BOB", "Loveanime");
		//saveUser(new User("BOB", 1, 2, 3, 40000, 5, new Date(0), new Date(0), true, "Ontario", "Bachelor", "Education", "Male", 500));
		//saveUser(new User("Dakota", 5,4,3,200000,1, new Date(0), new Date(0), true, "Ontario", "Master", "Education", "Female", 200));
		//createUser("TESTONE", "Loveanime");
		//saveUser(new User("TESTONE", 1, 2, 3, 100000, 5, new Date(0), new Date(0), true, "Ontario", "Bachelor", "Education", "Male", 500));
		//createUser("TESTTWO", "Loveanime");
		//saveUser(new User("TESTTWO", 1, 2, 3, 20000, 5, new Date(0), new Date(0), true, "Ontario", "Bachelor", "Education", "Male", 500));
		//createUser("TESTTHREE", "Loveanime");
		//saveUser(new User("TESTTHREE", 1, 2, 3, 3000, 5, new Date(0), new Date(0), true, "Ontario", "Bachelor", "Education", "Male", 500));
		//NotCurrentUser ncu = getLeaderboard(2);
		//System.out.println("USERNAME: " + ncu.getUsername());
		//System.out.println("SCORE: " + ncu.getScore());
		//createUser("Erfan", "alwaysfresh");
		//saveUser(new User("Erfan", 10,3,4,6,0, new Date(0), new Date(0), false, "Ontario", "Phd", "Education", "Female", 1));
		//loadUser("haha1");
		//userExsits("BOB");
		//userExsits("Dakota");
		
		//getDebtData("1.1.1.3");
		//getIncomeData("1.4.1.1.1.1.4.2");
		//getFriend(200);
		
		//createFriendTable();
		//InsertFriend(1,5);
		//friendIDExists("Boba");
		//friendIDExists("1");
		
		//validLogin("BOB","THEBUILDER123");
		//deleteUser("haha1");
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
			
			if (rs.next()) {
				uName = rs.getString("USERNAME");
				uPass = rs.getString("PASSWORD");
				System.out.println("userName: " + uName);
				System.out.println("password: " + uPass);
				if (uPass.equals(password)) {
					System.out.println("Valid User!");
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

	public static User loadUser(String username)throws Exception {
		try {
		Connection con = getConnection(); 
		String SQL = "SELECT * FROM LOGIN_TB WHERE USERNAME = '"+username+"'";
		PreparedStatement updated = con.prepareStatement(SQL);
		ResultSet result = updated.executeQuery(SQL);
		
		while(result.next()){
	         //Retrieve by column name
	         String USERNAME  = result.getString("USERNAME");
	         float INCOMEDATA = result.getFloat("INCOMEDATA");
	         float DEBTDATA = result.getFloat("DEBTDATA");
	         float GRADDEBT = result.getFloat("GRADDEBT");
	         float DEBT = result.getFloat("DEBT");
	         float INTEREST = result.getFloat("INTEREST");
	         String GRAD = result.getString("GRAD");
	         String BIRTH = result.getString("BIRTH");
	         boolean OPTED= result.getBoolean("OPTED");
	         String PROVINCE = result.getString("PROVINCE");
	         String EDUCATION = result.getString("EDUCATION");
	         String FIELD = result.getString("FIELD");
	         String SEX = result.getString("SEX");
	         int FRIENDCODE = result.getInt("FRIENDCODE");
	         int RANK = result.getInt("USERRANK");
		}
		//return (new User(USERNAME, INCOMEDATA, DEBTDATA, GRADDEBT, DEBT, INTEREST, GRAD, BIRTH, OPTED, PROVINCE, EDUCATION, FIELD, SEX, FRIENDCODE));
		}
	
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
		
   	// update password by select user
	public static void saveUser(User U) throws Exception{
	  try { 
		  System.out.println(U.getLocationS());
		  Connection con = getConnection(); 
		  String UpdateSQL = ("UPDATE LOGIN_TB "
				 
				  + "SET INCOMEDATA = " + U.getMedianDemographicIncome()+","
				  + " DEBTDATA = "+U.getMedianDemographicDebt()+","
				  + " GRADDEBT = "+U.getDebtAtGrad()+","
				  + " DEBT = "+U.getCurrentDebt()+","
				  + " INTEREST = "+U.getInterestRate()+","
				  + " GRAD = '"+U.getGradDateS()+"',"
				  + " BIRTH = '"+U.getDateOfBirth()+"',"
				  + " OPTED = "+U.optedIn()+","
				  + " PROVINCE = '"+U.getLocationS()+"',"
				  + " EDUCATION = '"+U.getEduationLevelS()+"',"
				  + " FIELD = '"+U.getFieldOfStudy()+"',"
				  + " SEX = '"+U.getSexS()+"',"
				  + " FRIENDCODE = "+U.getFriendCode()+","
				  + " USERRANK = "+U.getRank()+","
				  + " SCORE = "+U.getScore()
				  + " WHERE USERNAME like '"+U.getUsername()+"'" );
		  System.out.println(UpdateSQL);
	  PreparedStatement updated = con.prepareStatement(UpdateSQL);
	  updated.executeUpdate();
	  setRanks();

	  } catch(Exception e){ System.out.println(e); } finally {
	  System.out.println("successfully updated"); } }

	public static void createUser(String username, String password) throws Exception {
		try {
			Connection con = getConnection();
			String InsertSQL = ("INSERT INTO LOGIN_TB" 
					+ "(USERNAME, PASSWORD, INCOMEDATA, DEBTDATA, GRADDEBT,"
					+ "DEBT, INTEREST, GRAD, BIRTH, OPTED, PROVINCE, EDUCATION, FIELD,"
					+ "SEX, FRIENDCODE, USERRANK,SCORE) " 
					+ "VALUES(?,?,NULL,NULL,NULL,NULL,NULL,NULL,NULL,"
					+ "NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL)");
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
					+ "GRAD DATE,"
					+ "BIRTH DATE,"
					+ "OPTED BOOLEAN,"
					+ "PROVINCE VARCHAR(50),"
					+ "EDUCATION VARCHAR(50),"
					+ "FIELD VARCHAR(50),"
					+ "SEX VARCHAR(50),"
					+ "FRIENDCODE INT,"
					+ "USERRANK INT,"
					+ "SCORE FLOAT(50),"
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


	public static NotCurrentUser getLeaderboard(int r) {
		try {
			// ESTABLISH CONNECTION WITH DATABASE
			Connection con = getConnection();
			String queryGetUser = "select USERNAME, SCORE from UP.LOGIN_TB where OPTED=1 and USERRANK = "+ r;
			PreparedStatement statement = con.prepareStatement(queryGetUser);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return (new NotCurrentUser(result.getString("USERNAME"), result.getInt("SCORE")));
			}
			return (new NotCurrentUser("NOT FOUND", 0));
			// SQL statement required to Select all data from database
			//String 
			} catch (Exception e) {
		
			}
		return (new NotCurrentUser("NOT FOUND", 0));
	}
	
	private static void setRanks() {
		try {
			Connection con = getConnection();
			String queryGetRank = ("Select USERNAME, ROW_NUMBER() OVER (order by SCORE DESC) as 'RANK' from UP.LOGIN_TB WHERE OPTED=1 order by SCORE");
			PreparedStatement statement = con.prepareStatement(queryGetRank);
			ResultSet result = statement.executeQuery();
			int rank = 0;
			while(result.next()) {
				String querySetRank = "UPDATE LOGIN_TB SET USERRANK = " + result.getInt("RANK") + " WHERE USERNAME = '" + result.getString("USERNAME")+"' AND OPTED=1";
				PreparedStatement saveRank = con.prepareStatement(querySetRank);
				saveRank.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static double getDebtData(String coord) {
		try {
		Connection con = getConnection();
		String DebtSelect = "SELECT DE_VALUE FROM debt_min WHERE DE_COORDINATE = '" + coord + "'";
		PreparedStatement statement = con.prepareStatement(DebtSelect);
		ResultSet result = statement.executeQuery();
		
		if(result.next()) {
			System.out.println(result.getFloat("DE_VALUE"));
			return result.getFloat("DE_VALUE");
		}
		}
	
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public static double getIncomeData(String coord) {
		try {
		Connection con = getConnection();
		String IncomeSelect = "SELECT IN_VALUE FROM income_min WHERE IN_COORDINATE = '" + coord + "'";
		PreparedStatement statement = con.prepareStatement(IncomeSelect);
		ResultSet result = statement.executeQuery();
		
		if(result.next()) {
			System.out.println(result.getFloat("IN_VALUE"));
			return result.getInt("IN_VALUE");
			}
		}
	
		catch(Exception e){
			e.printStackTrace();
		}
		//return 100.0;
		return 0;
	}
	
	//public static NotCurrentUser getFriend(int code) { //friendcode
	//	return (new NotCurrentUser("User", 100));      //notCurrent user, friendcode
	public static NotCurrentUser getFriend(int code) {
		try {
			Connection con = getConnection();
			String getFriendQuery = "SELECT USERNAME, SCORE FROM LOGIN_TB WHERE FRIENDCODE = '" + code + "'";
			PreparedStatement statement = con.prepareStatement(getFriendQuery);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				//System.out.println(result.getInt("FRIENDCODE"));
				//System.out.println(result.getString("USERNAME"));
				return (new NotCurrentUser(result.getString("USERNAME"),result.getInt("SCORE")));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String getDistant(int code) {  
		try {
			Connection con = getConnection();
			String getFrdQuery = "SELECT USERNAME FROM LOGIN_TB WHERE FRIENDCODE = '" + code + "'";
			PreparedStatement statement = con.prepareStatement(getFrdQuery);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return (result.getString("USERNAME"));	
			}//user
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
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
				System.out.println(result.getInt("USERRANK"));
				
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
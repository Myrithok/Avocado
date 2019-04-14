package avocado;

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

public class Jdbc {
	public static void main(String[] args) throws Exception {

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
				if (uPass.equals(password)) {
					return true;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
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
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static User loadUser(String username) throws Exception {
		try {
			Connection con = getConnection();
			String SQL = "SELECT * FROM LOGIN_TB WHERE USERNAME = '" + username + "'";
			PreparedStatement updated = con.prepareStatement(SQL);
			ResultSet result = updated.executeQuery(SQL);
			String USERNAME = "";
			float INCOMEDATA = 0;
			float DEBTDATA = 0;
			float GRADDEBT = 0;
			float DEBT = 0;
			float INTEREST = 0;
			String GRAD = "";
			String BIRTH = "";
			boolean OPTED = false;
			String PROVINCE = "";
			String EDUCATION = "";
			String FIELD = "";
			String SEX = "";
			int FRIENDCODE = 0;
			int RANK = 0;
			while (result.next()) {
				USERNAME = result.getString("USERNAME");
				INCOMEDATA = result.getFloat("INCOMEDATA");
				DEBTDATA = result.getFloat("DEBTDATA");
				GRADDEBT = result.getFloat("GRADDEBT");
				DEBT = result.getFloat("DEBT");
				INTEREST = result.getFloat("INTEREST");
				GRAD = result.getString("GRAD");
				BIRTH = result.getString("BIRTH");
				OPTED = result.getBoolean("OPTED");
				PROVINCE = result.getString("PROVINCE");
				EDUCATION = result.getString("EDUCATION");
				FIELD = result.getString("FIELD");
				SEX = result.getString("SEX");
				FRIENDCODE = result.getInt("FRIENDCODE");
				RANK = result.getInt("USERRANK");
			}
			return (new User(USERNAME, INCOMEDATA, DEBTDATA, GRADDEBT, DEBT, INTEREST, GRAD, BIRTH, OPTED, PROVINCE,
					EDUCATION, FIELD, SEX, FRIENDCODE));
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static void saveUser(User U) throws Exception {
		try {
			Connection con = getConnection();
			String UpdateSQL = ("UPDATE LOGIN_TB "

					+ "SET INCOMEDATA = " + U.getMedianDemographicIncome() + "," + " DEBTDATA = "
					+ U.getMedianDemographicDebt() + "," + " GRADDEBT = " + U.getDebtAtGrad() + "," + " DEBT = "
					+ U.getCurrentDebt() + "," + " INTEREST = " + U.getInterestRate() + "," + " GRAD = '"
					+ U.getGradDateS() + "'," + " BIRTH = '" + U.getDateOfBirthS() + "'," + " OPTED = " + U.optedIn()
					+ "," + " PROVINCE = '" + U.getLocationS() + "'," + " EDUCATION = '" + U.getEduationLevelS() + "',"
					+ " FIELD = '" + U.getFieldOfStudy() + "'," + " SEX = '" + U.getSexS() + "'," + " FRIENDCODE = "
					+ U.getFriendCode() + "," + " USERRANK = " + U.getRank() + "," + " SCORE = " + U.getScore()
					+ " WHERE USERNAME like '" + U.getUsername() + "'");
			PreparedStatement updated = con.prepareStatement(UpdateSQL);
			updated.executeUpdate();
			setRanks();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void createUser(String username, String password) throws Exception {
		try {
			Connection con = getConnection();
			String InsertSQL = ("INSERT INTO LOGIN_TB" + "(USERNAME, PASSWORD, INCOMEDATA, DEBTDATA, GRADDEBT,"
					+ "DEBT, INTEREST, GRAD, BIRTH, OPTED, PROVINCE, EDUCATION, FIELD,"
					+ "SEX, FRIENDCODE, USERRANK,SCORE) " + "VALUES(?,?,NULL,NULL,NULL,NULL,NULL,NULL,NULL,"
					+ "NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL)");
			PreparedStatement posted = con.prepareStatement(InsertSQL);
			posted.setString(1, username);
			posted.setString(2, password);

			posted.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	

	public static void addFriend(int YOU, int ME) throws Exception {
		try {
			Connection con = getConnection();
			String InsertFriendSQL = ("INSERT INTO FRIEND" + "(FRIENDID, ME, YOU) " + "VALUES(null, ?,?)");
			PreparedStatement create = con.prepareStatement(InsertFriendSQL); // getting sql statement to be ready to
																				// use (not used
			create.setInt(1, ME);
			create.setInt(2, YOU);
			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static boolean friendCodeExists(int friendID) throws Exception {
		try {
			Connection con = getConnection();
			String ExistFriendSQL = "SELECT * FROM LOGIN_TB WHERE FRIENDCODE ='" + friendID + "'";
			PreparedStatement statement = con.prepareStatement(ExistFriendSQL);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				return true;

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static boolean userExists(String username) throws Exception {
		try {
			Connection con = getConnection();
			String ExistFriendSQL = "SELECT * FROM LOGIN_TB WHERE USERNAME ='" + username + "'";
			PreparedStatement statement = con.prepareStatement(ExistFriendSQL);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				return true;

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public static void createTables() throws Exception {
		createDebtTable();
		createIncomeTable();
		createUserTable();
		createFriendTable();
	}

	private static void createFriendTable() throws Exception {
		try {
			Connection con = getConnection();
			String sql = ("CREATE TABLE IF NOT EXISTS FRIEND" + "(FRIENDID INT NOT NULL AUTO_INCREMENT,"
					+ "ME INT NOT NULL," + "YOU INT NOT NULL," + "PRIMARY KEY(FRIENDID))");
			PreparedStatement create = con.prepareStatement(sql); // getting sql statement to be ready to use (not used
			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
		}
	}

	private static void createUserTable() throws Exception {
		try {
			Connection con = getConnection(); // getting connected to the database
			String sql = ("CREATE TABLE IF NOT EXISTS LOGIN_TB " + "(USERNAME VARCHAR(50), " + "PASSWORD VARCHAR(50), "
					+ "INCOMEDATA FLOAT(50)," + "DEBTDATA FLOAT(50)," + "GRADDEBT FLOAT(50)," + "DEBT FLOAT(50),"
					+ "INTEREST FLOAT(50)," + "GRAD VARCHAR(50)," + "BIRTH VARCHAR(50)," + "OPTED BOOLEAN,"
					+ "PROVINCE VARCHAR(50)," + "EDUCATION VARCHAR(50)," + "FIELD VARCHAR(50)," + "SEX VARCHAR(50),"
					+ "FRIENDCODE INT," + "USERRANK INT," + "SCORE FLOAT(50)," + "PRIMARY KEY(USERNAME))");
			PreparedStatement create = con.prepareStatement(sql); // getting sql statement to be ready to use (not used
			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Table created");
		}
	}

	private static void createDebtTable() throws Exception {
		try {
			Connection con = getConnection();
			String CreateDebtTableSQL = ("CREATE TABLE IF NOT EXISTS debt_min" + "(DE_COORDINATE VARCHAR(50), "
					+ "DE_VALUE INT(11), PRIMARY KEY(DE_COORDINATE))");
			PreparedStatement create = con.prepareStatement(CreateDebtTableSQL);
			create.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static void createIncomeTable() throws Exception {
		try {
			Connection con = getConnection();
			String CreateDebtTableSQL = ("CREATE TABLE IF NOT EXISTS income_min" + "(IN_COORDINATE VARCHAR(50), "
					+ "IN_VALUE INT(11), PRIMARY KEY(IN_COORDINATE))");
			PreparedStatement create = con.prepareStatement(CreateDebtTableSQL);
			create.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static NotCurrentUser getLeaderboard(int r) {
		try {
			Connection con = getConnection();
			String queryGetUser = "select USERNAME, SCORE from UP.LOGIN_TB where OPTED=1 and USERRANK = " + r;
			PreparedStatement statement = con.prepareStatement(queryGetUser);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				return (new NotCurrentUser(result.getString("USERNAME"), result.getInt("SCORE")));
			}
			return (new NotCurrentUser("NOT FOUND", 0));
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
			while (result.next()) {
				String querySetRank = "UPDATE LOGIN_TB SET USERRANK = " + result.getInt("RANK") + " WHERE USERNAME = '"
						+ result.getString("USERNAME") + "' AND OPTED=1";
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

			if (result.next()) {
				return result.getFloat("DE_VALUE");
			}
		}

		catch (Exception e) {
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

			if (result.next()) {
				return result.getInt("IN_VALUE");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static ArrayList<NotCurrentUser> getFriends(int code) {
		ArrayList<NotCurrentUser> out = new ArrayList<NotCurrentUser>();
		try {
			Connection con = getConnection();
			String queryGetFriends = "Select YOU from FRIEND WHERE ME = " + code;
			PreparedStatement statement = con.prepareStatement(queryGetFriends);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String queryGetNotCurrentUser = "Select USERNAME, SCORE from LOGIN_TB where FRIENDCODE = "
						+ result.getInt("YOU");
				statement = con.prepareStatement(queryGetNotCurrentUser);
				ResultSet friends = statement.executeQuery();

				if (friends.next()) {
					NotCurrentUser temp = new NotCurrentUser(friends.getString("USERNAME"), friends.getFloat("SCORE"));
					if (!out.contains(temp)) {
						out.add(temp);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	private static ArrayList<Integer> getFriendsCodes(int code) {
		ArrayList<Integer> out = new ArrayList<Integer>();
		try {
			Connection con = getConnection();
			String queryGetFriends = "Select YOU from FRIEND WHERE ME = " + code;
			PreparedStatement statement = con.prepareStatement(queryGetFriends);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				out.add(result.getInt("YOU"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	private static ArrayList<Integer> friendsOfFriends(ArrayList<Integer> inputCodes) {
		ArrayList<Integer> returnList = new ArrayList<Integer>();

		for (int i : inputCodes) {
			ArrayList<Integer> temp = getFriendsCodes(i);
			returnList.addAll(temp);
		}
		return returnList;
	}

	public static ArrayList<String> getSuggested(int code, int howmany) {
		ArrayList<String> out = new ArrayList<String>();
		ArrayList<Integer> outCodes = new ArrayList<Integer>();
		ArrayList<Integer> checked = new ArrayList<Integer>();
		ArrayList<Integer> friends = getFriendsCodes(code);
		ArrayList<Integer> temp = friends;
		String queryOutCodes = "";
		try {
			Connection con = getConnection();

			checked.addAll(temp);
			while (true) {
				temp = friendsOfFriends(temp);
				if (checked.containsAll(temp)) {
					break;
				}
				checked.addAll(temp);
				for (int i : temp) {
					if (!friends.contains(i) && !outCodes.contains(i)) {
						outCodes.add(i);
					}
					if (outCodes.size() >= howmany) {
						break;
					}
				}
				if (outCodes.size() >= howmany) {
					break;
				}
			}

			for (int i : outCodes) {
				queryOutCodes = "Select USERNAME from LOGIN_TB where FRIENDCODE = " + i;
				PreparedStatement statementOutCodes = con.prepareStatement(queryOutCodes);
				ResultSet resultOutCodes = statementOutCodes.executeQuery();
				while (resultOutCodes.next()) {
					out.add(resultOutCodes.getString("USERNAME"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	private static Connection getConnection() throws Exception {
		try {
			String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";

			String url = "jdbc:mysql://localhost:3306/UP";
			String user = "root";
			String password = "miwi9226";
			Class.forName(DB_DRIVER_CLASS);

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("connected to Database");
			return con;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
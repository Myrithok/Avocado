package randomBS;

import java.util.ArrayList;
import java.util.Date;

public class Jdbc {
	public static boolean userExists(String username) {
		return true;
	}

	public static boolean validLogin(String username, String password) {
		if (username == "Apple") {
			return false;
		} else {
			return true;
		}
	}

	public static User loadUser(String username) {
		return new User(username, 100, 100, 100, 100, 100, new Date(0), new Date(0), true, "Ontario", "Bachelor",
				"Education", "Male", 12345);
	}

	public static void addFriend(User me, int you) {
		return;
	}

	public static NotCurrentUser getLeaderboard(int r) {
		return new NotCurrentUser("testuser", 200);
	}

	public static void saveUser(User u) {
		return;
	}

	public static void createUser(String username, String password) {
		return;
	}
	
	public static boolean friendCodeExists(int code) {
		return false;
	}
	public static double getDebtData(String coord) {
		return 100.0;
	}
	public static double getIncomeData(String coord) {
		return 100.0;
	}
	public static ArrayList<Integer> getConnectedPeople(int code){
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(101);
		test.add(202);
		test.add(303);
		return test;
	}
}

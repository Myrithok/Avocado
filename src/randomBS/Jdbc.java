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
		test.add(12345);
		test.add(101);
		test.add(202);
		test.add(303);
		test.add(404);
		test.add(505);
		return test;
	}
	public static ArrayList<ArrayList<Integer>> getConnections(ArrayList<Integer> people){
		ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(101);
		temp.add(202);
		test.add(temp);
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		temp2.add(101);
		temp2.add(303);
		test.add(temp2);
		ArrayList<Integer> temp3 = new ArrayList<Integer>();
		temp3.add(12345);
		temp3.add(101);
		test.add(temp3);
		ArrayList<Integer> temp4 = new ArrayList<Integer>();
		temp4.add(303);
		temp4.add(404);
		test.add(temp4);
		ArrayList<Integer> temp5 = new ArrayList<Integer>();
		temp5.add(404);
		temp5.add(505);
		test.add(temp5);
		return test;
	}
	public static NotCurrentUser getFriend(int code) {
		return (new NotCurrentUser("User", 100));
	}
	public static String getDistant(int code) {
		return "Name";
	}
}

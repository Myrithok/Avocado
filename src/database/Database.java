package database;

import randomBS.*;

public class Database {

	
	public Database() {
		
	}
	
	//Dataset Table Functions Start
	/**
	 * Updates the median demographic information for the given user
	 * @param user The user to update.
	 */
	public void updateDatasetInformation(User user) {
		
	}
	//Dataset Table Functions End
	
	//Login Table Functions
	/**
	 * Used to check if given login information is valid.
	 * @param username The given username.
	 * @param password The given password.
	 * @return A boolean True if the login information is valid and false otherwise
	 */
	public boolean validLogin(String username, String password) {
		
	} 
	
	/**
	 * Checks if a given username is registered to an existing user
	 * @param username Username to check availability of
	 * @return Returns true if a user with the given username already exists and false otherwise
	 */
	public boolean userExsits(String username) {
		
	}
	
	/**
	 * This function creates a user upon regsistration
	 * @param username Username to register
	 * @param password Password to associate with username
	 */
	private void createUser(String username, String password) {
		
	}
	//Login Table functions End
	
	//User Info Table Functions
	/**
	 * Function possibly to be used in tandem with previous function
	 * to add a user with information to the user table
	 * @param user The user object with the appropriate information to add to the
	 * user table
	 */
	public void createUser(User user) {
		
	}
	
	/**
	 * Checks if a given friend ID has been assigned
	 * @param friendID The friend ID to check
	 * @return True if the friend ID has been assigned already and false otherwise.
	 */
	public boolean friendIDExists(long friendID) {
		
	}
	
	/**
	 * Used for construction of the leaderboard
	 * @param rank rank of the user you want.
	 * @return Username of user at the given rank
	 */
	public NotCurrentUser getLeaderboard(int rank) {
		
	}
	
	//new function added so that we will be able to determine the rank of a user so that
	//we can find out what ranks to pull when displaying them in the leaderboard
	/**
	 * Returns the rank of a user given their score
	 * @param user 
	 * @return An integer representing the number of users who have a score higher than
	 * to them inclusive of them
	 */
	public int getRank(User user) {
		double userScore = user.getScore();
		int rank;
		
		return rank;
	}
	
	/**
	 * Updates the database with the changed information from the supplied user
	 * @param user The user whose information will be updated in the database
	 */
 	public void updateDatabase(User user) {
		
	}
	
	/**
	 * This function when given a username returns a user object with the correct information taken from
	 * the database.
	 * @param username The username of the user profile to load
	 * @return A user object representing the user with the provided username
	 */
	public User loadUser(String username) {
		
	}
	//User Info Table Functions End
	
	//Friends List Functions
	/**
	 * Adds a record to the friend table representing
	 * @param user The user whose initiated the friendship whose information
	 * will be shared with the other user.
	 * @param friendID The user who will see the other user in their friend leaderboard
	 */
	public void addFriend(User user, long friendID) {
		
	}
	
	/**
	 * Returns a directed graph with users as nodes and
	 * each friend connection as the directed edges
	 * @param friendID The Node to center searches on
	 * @return The digraph of all users that can be reached via the given user
	 */
	//using the friendID here may be a bad idea unless we plan to implement
	//the search features in the digraph class itself
	public Digraph Friends(long friendID) {
		
	}
	//Friends List Functions End
	

	
	public static void main(String[] args) {
		//Dakota test area
		
		//Andrew test area
		
		//Erfan test area
		
		//Daniel test area
	}
}

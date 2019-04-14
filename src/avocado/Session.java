package avocado;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Session {
	int ID;
	User user;
	
	public Session() {
		start();
	}
	
	public void start() {
		boolean validChoice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To Avocado\n");
		int i;
		do {
			System.out.println("Would you like to:");
			System.out.println("     1. Login");
			System.out.println("     2. Sign up");
			i = sc.nextInt();
			if (i!= 1 && i != 2) {
				validChoice = false;
				System.out.println("Invalid choice made please try again.\n");
			}
			else {
				validChoice = true;
			}
		}
		while(!validChoice);
		
		if(i == 1) {
			login();
		}
		else {
			signup();
		}
		
	}
	
	public void login() {
		Scanner sc = new Scanner(System.in);
		boolean validLogin = false;
		String username;
		
		do {
			System.out.print("Please Enter Your Username: ");
			
			username = sc.nextLine();
			
			System.out.print("Please Enter Your Password: ");
			
			String password = sc.nextLine();
			
			
			try {
				if(Jdbc.userExists(username)) {
					if(Jdbc.validLogin(username, password)) {
						validLogin = true;
					}
					else {
						System.out.println("Incorrect Username or Password Please Try Again.\n");
						validLogin = false;
					}
				}
				else {
					System.out.println("Invalid Username or Password Provided Please Try Again.\n");
					validLogin = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}while(!validLogin);
		
		try {
			this.user = Jdbc.loadUser(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		homepage(sc);
	}
	
	//finish after constructor for user
	public void signup() {
		Scanner sc = new Scanner(System.in);
		
		//username
		System.out.println("Welcome to the Avocado account setup wizzard");
		
		String username;
		boolean validUsernameChosen = false;
		do {
			System.out.print("Choose a username: ");
			
			username = sc.nextLine();
			
			try {
				if(Jdbc.userExists(username)) {
					System.out.println("Invalid username Please Try again.\n");
					validUsernameChosen = false;
				}
				else {
					validUsernameChosen = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}while(!validUsernameChosen);
		
		String password;
		System.out.print("Choose a password: ");
		password = sc.nextLine();
		
		double gradDebt = 0.0;
		boolean validGradDebt;
		do {
			try {
				System.out.print("What was your debt at graduation: ");
				gradDebt = sc.nextDouble();
				validGradDebt = true;
			}
			catch(Exception e) {
				System.out.println("Invalid choice try again.");
				validGradDebt = false;
			}
		}while(!validGradDebt);
		
		double debt = 0.0;
		boolean validDebt;
		do {
			try {
				System.out.print("What is your current debt: ");
				gradDebt = sc.nextDouble();
				validDebt = true;
			}
			catch(Exception e) {
				System.out.println("Invalid choice try again.");
				validDebt = false;
			}
		}while(!validDebt);
		
		double interest = 0.0;
		boolean validInterest;
		do {
			try {
				System.out.print("What is the interest rate on your debt: ");
				interest = sc.nextDouble();
				validInterest = true;
			}
			catch(Exception e) {
				System.out.println("Invalid choice try again.");
				validInterest = false;
			}
		}while(!validInterest);
		
		Date grad = new Date();
		boolean validGradDate;
		do {
			try {
				System.out.print("When did you graduate(DD/MM/YYYY): ");
				grad = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
				validGradDate = true;
			}
			catch(Exception e) {
				System.out.println("Invalid choice try again.");
				validGradDate = false;
			}
		}while(!validGradDate);
		
		Date birth = new Date();
		boolean validbirthDate;
		do {
			try {
				System.out.print("When were you born(DD/MM/YYYY): ");
				birth = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
				validbirthDate = true;
			}
			catch(Exception e) {
				System.out.println("Invalid choice try again.");
				validbirthDate = false;
			}
		}while(!validbirthDate);
		
		Location province = null;
		boolean validprovince;
		do {
			try {
				System.out.print("What province do you live in(Include No Spaces): ");
				province = Location.valueOf(sc.nextLine());
				validprovince = true;
			}
			catch(Exception e) {
				System.out.println("Invalid choice try again.");
				validprovince = false;
			}
		}while(!validprovince);
		
		EducationLevel education = null;
		boolean valideducation;
		do {
			try {
				System.out.print("What province do you live in(Include No Spaces): ");
				education = EducationLevel.valueOf(sc.nextLine());
				valideducation = true;
			}
			catch(Exception e) {
				System.out.println("Invalid choice try again.");
				valideducation = false;
			}
		}while(!valideducation);
		
		Sex sex = null;
		boolean validSex;
		do {
			try {
				System.out.print("What province do you live in(Include No Spaces): ");
				sex = Sex.valueOf(sc.nextLine());
				validSex = true;
			}
			catch(Exception e) {
				System.out.println("Invalid choice try again.");
				validSex = false;
			}
		}while(!validSex);
		
		FieldOfStudy field = null;
		boolean validfield;
		do {
			try {
				System.out.print("What province do you live in(Include No Spaces): ");
				field = FieldOfStudy.valueOf(sc.nextLine());
				validfield = true;
			}
			catch(Exception e) {
				System.out.println("Invalid choice try again.");
				validfield = false;
			}
		}while(!validfield);
		
		User user = new  User(username, gradDebt, debt, interest, grad, birth,
				province, education, field, sex);
		
		this.user = user;
		
		try {
			Jdbc.createUser(username,password);
			Jdbc.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		homepage(sc);
	}
	
	public void homepage(Scanner sc) {
		boolean validChoice = false;
		int i;
		
		System.out.println("Welcome back " + this.user.getUsername() + ".\n");
		System.out.println("Your Score is: " + this.user.getScore());
		
		do {
			System.out.println("Would you like to:");
			System.out.println("     1. View Friends");
			System.out.println("     2. Update Information");
			
			if(this.user.optedIn())
				System.out.println("     3. View Leaderboard");
			
			i = sc.nextInt();

			if(i != 1 && i != 2 && (i != 3 && this.user.optedIn())) {
				System.out.println("Invalid Choice Made.");
				validChoice = false;
			}
			else {
				validChoice = true;
			}
		}while(!validChoice);
		
		switch(i) {
			case 1:
				friends(sc);
			case 2:
				update(sc);
			case 3:
				leaderboard(sc);
		}
	}
	
	public void friends(Scanner sc) {	
		System.out.println("Welcome to your friends page " + this.user.getUsername() + ".\n");
		System.out.println("Your friend ID is: " + this.user.getFriendCode() + "\n");
		
		ArrayList<NotCurrentUser> friends =  this.user.getFriendLeaderboard();
		ArrayList<String> suggestedFriends = this.user.getSuggested();
		
		System.out.println("Your Friend Leaderboard\n");
		
		for(int i=0; i<friends.size(); i++) {
			NotCurrentUser friend = friends.get(i);
			System.out.println((i+1) + ". " + friend.getUsername() + " " + friend.getScore());
		}
		
		System.out.println("\nSome People You May Know\n");
		
		for (String i : suggestedFriends) {
			System.out.println(i);
		}
		
		boolean valid;
		int choice;
		
		do {
			System.out.println("Would you like to:");
			System.out.println("     1. Go back to the homepage.");
			System.out.println("     2. Add a friend.");
			choice = sc.nextInt();
			
			if(choice != 1 && choice != 2) {
				System.out.println("Invalid selection please try again");
				valid = false;
			}
			else
				valid = true;
		}while(!valid);
		
		switch(choice) {
			case 1:
				homepage(sc);
				break;
			case 2:
				addFriend(sc);
				friends(sc);
				break;
		}
	}
	
	public void addFriend(Scanner sc) {
		System.out.print("Please add the friend code of the user you wish to share information with: ");
		int friendID = sc.nextInt();
		try {
			Jdbc.addFriend(this.user.getFriendCode(), friendID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void leaderboard(Scanner sc) {
		int rank = this.user.getRank();
		
		System.out.println("Welcome to your leaderboard page " + this.user.getUsername() + ".\n");
		System.out.println("Your leaderboard rank is " + rank + ".\n");
		
		System.out.println("Leaderboard Top 5\n");
		
		for(int i=1; i<6; i++) {
			NotCurrentUser user = Jdbc.getLeaderboard(i);
			if (!user.getUsername().equals(""))
				System.out.println(user.getUsername() + " " + user.getScore());
		}
		
		System.out.println("\nLocal Leaderboard\n");
		
		for(int i = (rank-2); i < (rank+2); i++) {
			NotCurrentUser user = Jdbc.getLeaderboard(i);
			if (!user.getUsername().equals(""))
				System.out.println(user.getUsername() + " " + user.getScore());
		}
		
		System.out.print("Press Enter to go back.");
		sc.nextLine();
		homepage(sc);
	}
	
	public void update(Scanner sc) {
		
		System.out.println("Welcome to your information update page " + this.user.getUsername() + ".\n");
		
		System.out.println("Your Recorded Current debt is: " + this.user.getCurrentDebt());
		
		if(this.user.optedIn())
			System.out.println("You are currently opted into the leaderboard.\n");
		else
			System.out.println("You are currently not opted into the leaderboard.\n");
		
		boolean valid;
		int choice;
		
		do {
			System.out.println("Would you like to:");
			System.out.println("     1. Go back to the homepage.");
			System.out.println("     2. Update your current debt.");
			System.out.println("     3. Change your leaderboard opt-in status.");
			choice = sc.nextInt();
			
			if(choice != 1 && choice != 2 && choice !=3) {
				System.out.println("Invalid selection please try again");
				valid = false;
			}
			else
				valid = true;
		}while(!valid);
		
		switch(choice) {
			case 1:
				homepage(sc);
				break;
			case 2:
				debtupdate();
			try {
				Jdbc.saveUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
				update(sc);
				break;
			case 3:
				if(this.user.optedIn())
					this.user.optOut();
				else
					this.user.optIn();
			try {
				Jdbc.saveUser(this.user);
			} catch (Exception e) {
				e.printStackTrace();
			}
				update(sc);
				break;
		}
	}
	
	public void debtupdate() {
		boolean valid;
		double newDebt = 0.0;
		do {			
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("Please enter your new debt: ");
				newDebt = sc.nextDouble();
				valid = true;
			}
			catch (Exception e) {
				System.out.println("Invalid input try again.");
				valid = false;
			}
		}while(!valid);
		this.user.setCurrentDebt(newDebt);
	}
	
	public static void main(String[] args) {
		//Dakota test area
		
		Session test = new Session();
		
		//Andrew test area
		
		//Erfan test area
		
		//Daniel test area
	}
}
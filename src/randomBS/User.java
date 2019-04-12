package randomBS;

import java.time.Period;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class User {
	private double medianDemographicIncome;
	private double medianDemographicDebt;
	private double score;
	private String username;
	private int rank;

	private double debtAtGrad;
	private double currentDebt;
	private double interestRate;

	private Date gradDate;
	private Date dateOfBirth;
	private int friendCode;

	private ArrayList<NotCurrentUser> friends;
	private ArrayList<String> suggestedFriends;

	private boolean optedIn;

	// replace the types of these with enums
	private Location geoLocation;
	private EducationLevel educationLevel;
	private FieldOfStudy fieldOfStudy;
	private Sex sex;

	private boolean hasChanged;

	public User(String username, double gradDebt, double debt, double interest, Date grad, Date birth, boolean opted,
			Location province, EducationLevel education, FieldOfStudy field, Sex sex) {
		this.username = username;
		this.debtAtGrad = gradDebt;
		this.currentDebt = debt;
		this.interestRate = interest;
		this.gradDate = grad;
		this.dateOfBirth = birth;
		this.optedIn = opted;
		this.geoLocation = province;
		this.educationLevel = education;
		this.fieldOfStudy = field;
		this.sex = sex;
		this.scoreCalc();
		this.generateFriendCode();
		this.findFriends();
		this.getMedianData();
	}

	public User(String username, double incomeData, double debtData, double gradDebt, double debt, double interest,
			Date grad, Date birth, boolean opted, String province, String education, String field,
			String sex, int friendCode) {
		this.username = username;
		this.medianDemographicIncome = incomeData;
		this.medianDemographicDebt = debtData;
		this.debtAtGrad = gradDebt;
		this.currentDebt = debt;
		this.interestRate = interest;
		this.gradDate = grad;
		this.dateOfBirth = birth;
		this.optedIn = opted;
		this.geoLocation = Location.valueOf(province);
		this.educationLevel = EducationLevel.valueOf(education);
		this.fieldOfStudy = FieldOfStudy.valueOf(field);
		this.sex = Sex.valueOf(sex);
		this.scoreCalc();
		this.friendCode = friendCode;
		//this.findFriends();
		this.rank = 1;
	}

	// getters and setters

	/**
	 * Getter for median demographic income
	 * 
	 * @return A double representing the median demographic income
	 */
	public double getMedianDemographicIncome() {
		return this.medianDemographicIncome;
	}

	/**
	 * Setter for median demographic income
	 * 
	 * @param income
	 *            Double representing correct median demographic income
	 */
	public void setMedianDemographicIncome(double income) {
		this.medianDemographicIncome = income;
		this.hasChanged = true;
	}

	/**
	 * Getter for median demographic debt at graduation
	 * 
	 * @return Double representing median demographic debt at graduation
	 */
	public double getMedianDemographicDebt() {
		return this.medianDemographicDebt;
	}

	/**
	 * Setter for median demographic debt at graduation
	 * 
	 * @param debt
	 *            Double representing correct median demographic debt at graduation
	 */
	public void setMedianDemographicDebt(double debt) {
		this.medianDemographicDebt = debt;
		this.hasChanged = true;
	}

	/**
	 * Getter for the score
	 * 
	 * @return Double representing the users score
	 */
	public double getScore() {
		return this.score;
	}

	/**
	 * Getter for the username of the current user
	 * 
	 * @return A string representing the username of the current user
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Setter for the username of the current user
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
		this.hasChanged = true;
	}

	/**
	 * Getter for the rank of the current user
	 * 
	 * @return Integer representing the rank of the current user among other users
	 */
	public int getRank() {
		return this.rank;
	}

	/**
	 * Setter for the rank of the current user
	 * 
	 * @param rank
	 *            Integer representing the correct rank to set the user to
	 */
	public void setRank(int rank) {
		this.rank = rank;
		this.hasChanged = true;
	}

	/**
	 * Getter for user's debt at graduation
	 * 
	 * @return Double representing the current user's debt at graduation
	 */
	public double getDebtAtGrad() {
		return this.debtAtGrad;
	}

	/**
	 * Setter for the current users debt at graduation
	 * 
	 * @param debtAtGrad
	 *            Double representing the correct debt at graduation value for the
	 *            user.
	 */
	public void setDebtAtGrad(double debtAtGrad) {
		this.debtAtGrad = debtAtGrad;
		this.hasChanged = true;
	}

	/**
	 * Getter for user's current debt
	 * 
	 * @return A double representing the user's current debt
	 */
	public double getCurrentDebt() {
		return this.currentDebt;
	}

	/**
	 * Setter for user's current debt
	 * 
	 * @param currentDebt
	 *            Double representing the correct current debt for the user.
	 */
	public void setCurrentDebt(double currentDebt) {
		this.currentDebt = currentDebt;
		this.hasChanged = true;
	}

	/**
	 * Getter for interest rate
	 * 
	 * @return Double representing interest rate on user's debt
	 */
	public double getInterestRate() {
		return this.interestRate;
	}

	/**
	 * Setter for interest rate
	 * 
	 * @param interestRate
	 *            Double representing correct interest rate on user's debt
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
		this.hasChanged = true;
	}

	/**
	 * Getter for graduation date
	 * 
	 * @return Date representing the user's date of graduation
	 */
	public Date getGradDate() {
		return this.gradDate;
	}
	
	public String getGradDateS() {
		return this.gradDate.toString();
	}

	/**
	 * Setter for the users graduation date
	 * 
	 * @param gradDate
	 *            Date representing the user's correct graduation date.
	 */
	public void setGradDate(Date gradDate) {
		this.gradDate = gradDate;
		this.hasChanged = true;
	}

	/**
	 * Getter for user's date of birth
	 * 
	 * @return Date representing the user's date of birth
	 */
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public String getDateOfBirthS() {
		return this.dateOfBirth.toString();
	}

	/**
	 * Setter for user's date of birth
	 * 
	 * @param dateOfBirth
	 *            Date representing user's correct date of birth
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		this.hasChanged = true;
	}

	/**
	 * Getter for friend code
	 * 
	 * @return Long representing the user's friend code
	 */
	public int getFriendCode() {
		return this.friendCode;
	}

	/**
	 * Setter for friend code
	 * 
	 * @param friendCode
	 *            Long representing the user's friend code
	 */
	public void setFriendCode(int friendCode) {
		this.friendCode = friendCode;
		this.hasChanged = true;
	}

	/**
	 * Checks if the user has opted into the leader board
	 * 
	 * @return Returns true if the user has opted into the leaderboard
	 */
	public boolean optedIn() {
		return this.optedIn;
	}

	/**
	 * Opts the user into the leaderboard
	 */
	public void optIn() {
		this.optedIn = true;
		this.hasChanged = true;
	}

	/**
	 * Opts the user out of the leaderboard
	 */
	public void optOut() {
		this.optedIn = false;
		this.hasChanged = true;
	}

	/**
	 * Getter for the user's sex
	 * 
	 * @return Returns a Sex enum representing the user's sex
	 */
	public Sex getSex() {
		return this.sex;
	}
	
	public String getSexS() {
		return this.sex.toString();
	}

	/**
	 * Setter for the uer's sex
	 * 
	 * @param sex
	 *            Sex enum representing the user's correct sex
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
		this.hasChanged = true;
	}

	/**
	 * Getter for the user's location
	 * 
	 * @return Location enum representing the user's location
	 */
	public Location getLocation() {
		return this.geoLocation;
	}
	
	public String getLocationS() {
		return this.geoLocation.toString();
	}

	/**
	 * Setter for the user's location
	 * 
	 * @param location
	 *            Location enum representing the user's location
	 */
	public void setLocation(Location location) {
		this.geoLocation = location;
		this.hasChanged = true;
	}

	/**
	 * Getter for the user's field of study
	 * 
	 * @return Field of Study enum representing the user's field of study
	 */
	public FieldOfStudy getFieldOfStudy() {
		return this.fieldOfStudy;
	}
	
	public String getFieldOfStudyS() {
		return this.fieldOfStudy.toString();
	}

	/**
	 * Setter for the user's field of study
	 * 
	 * @param fieldOfStudy
	 *            Field of Study enum representing the user's field of study
	 */
	public void setFieldOfStudy(FieldOfStudy fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
		this.hasChanged = true;
	}

	/**
	 * Getter for user's education level
	 * 
	 * @return Education Level enum representing the user's education level
	 */
	public EducationLevel getEduationLevel() {
		return this.educationLevel;
	}
	
	public String getEduationLevelS() {
		return this.educationLevel.toString();
	}

	/**
	 * Setter for user's education level
	 * 
	 * @param educationLevel
	 *            Education Level enum representing the user's education level
	 */
	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
		this.hasChanged = true;
	}

	/**
	 * Checks if the user's information has changed
	 * 
	 * @return True if the user's information has been changed.
	 */
	public boolean hasChanged() {
		return this.hasChanged;
	}

	// main functions

	/**
	 * Calculates the user's age at graduation
	 * 
	 * @return Integer representing the age of the user
	 */
	public int getAgeAtGrad() {
		LocalDate dateOfBirth = new java.sql.Date(this.dateOfBirth.getTime()).toLocalDate();
		LocalDate gradDate = new java.sql.Date(this.gradDate.getTime()).toLocalDate();
		return Period.between(dateOfBirth, gradDate).getYears();
	}

	/**
	 * Calculates the current age of the user
	 * 
	 * @return Integer representing the age of the user
	 */
	public int getAge() {
		LocalDate dateOfBirth = new java.sql.Date(this.dateOfBirth.getTime()).toLocalDate();
		LocalDate current = new java.sql.Date(new Date().getTime()).toLocalDate();
		return Period.between(dateOfBirth, current).getYears();
	}

	public ArrayList<NotCurrentUser> getFriends() {
		return this.friends;
	}

	public ArrayList<String> getSuggested() {
		return this.suggestedFriends;
	}

	/**
	 * Returns the co-ordinate string necessary to search in the dataset to find the
	 * user's median demographic debt
	 * 
	 * @return A string representing a co-ordinate location in the dataset
	 */
	public String getDebtCoordinate() {
		String out = "";
		out += this.geoLocation.toval() + ".";
		out += this.educationLevel.toDebtVal() + ".";
		out += "1.";
		out += "3";
		return out;
	}

	/**
	 * Returns the co-ordinate string necessary to search in the dataset to find the
	 * user's median demographic income
	 * 
	 * @return A string representing a co-ordinate location in the dataset
	 */
	public String getIncomeCoordinate() {
		String age = "3.";
		if (this.getAgeAtGrad() < 35) {
			age = "2.";
		}
		String out = "";
		out += this.geoLocation.toval() + ".";
		out += this.educationLevel.toIncomeVal() + ".";
		out += this.fieldOfStudy.toval() + ".";
		out += this.sex.toval() + ".";
		out += age;
		out += "2.";
		out += "4.";
		out += "2";
		return out;
	}

	/**
	 * This function calculates the user's score based on the formula
	 * GradDebt/medianDemographic Debt*[x/medianDemographic Income]*c
	 * 
	 * where x is the monthly payment necessary to reduce the debt from it initial
	 * value to its current value given the interest rate and c is a normalizing
	 * constant.
	 */
	public void scoreCalc() {
		LocalDate current = new java.sql.Date(new Date().getTime()).toLocalDate();
		LocalDate gradDate = new java.sql.Date(this.gradDate.getTime()).toLocalDate();
		double periods = Period.between(gradDate, current).getMonths();
		double i = Math.pow(1 + this.interestRate, periods);
		double numerator = this.interestRate * (this.debtAtGrad * i - this.currentDebt);
		double denominator = i - 1.0;
		double payment = numerator / denominator;
		double normC = 1.0;
		double debtCorrection = this.debtAtGrad / this.medianDemographicDebt;
		double score = debtCorrection * normC * (payment / this.medianDemographicIncome);
		this.score = score;
	}

	private void generateFriendCode() {
		boolean generated = false;
		int code = 0;
		Random random = new Random();
		while (!generated) {
			code = random.nextInt();
			/*
			 * if(!friendCodeExists(code)){ generated = true; }
			 */
		}
		this.friendCode = code;
	}

	private void getMedianData() {
		// this.medianDemographicDebt = getDebtData(this.getDebtCoordinate());
		// this.medianDemographicIncome = getIncomeData(this.getIncomeCoordinate());
	}

	private void findFriends() {
		int howManySuggestions = 5;
		Friends friendGraph = new Friends();
		// Add connected component using:
		// friendGraph.addNode(friendCode);
		// Add edges for each friendship using:
		// friendGraph.addEdge(me, you);
		FriendFinder friendSearch = new FriendFinder(friendGraph, this.friendCode, howManySuggestions);
		ArrayList<Integer> friendCodes = friendSearch.friends();
		ArrayList<NotCurrentUser> friendList = new ArrayList<NotCurrentUser>();
		// Construct NotCurrentUser for each item in friendCodes and add it to
		// friendList
		this.friends = friendList;
		ArrayList<Integer> suggestedCodes = friendSearch.suggestions();
		ArrayList<String> suggestedList = new ArrayList<String>();
		// Add username corresponding to each code in suggestedCodes to suggestedList
		this.suggestedFriends = suggestedList;
	}

	public ArrayList<NotCurrentUser> getFriendLeaderboard() {
		ArrayList<NotCurrentUser> output = this.friends;
		output.add(new NotCurrentUser(this.username, this.score));
		sortRank(output);
		return output;
	}

	private void sortRank(ArrayList<NotCurrentUser> list) {
		NotCurrentUser[] a = new NotCurrentUser[list.size()];
		a = list.toArray(a);
		MergeSort.sort(a);
		list.clear();
		for (NotCurrentUser u : a) {
			list.add(u);
		}
	}

	public static void main(String[] args) {
		// Dakota test area

		// Andrew test area
		
		// Erfan test area

		// Daniel test area
	}
}

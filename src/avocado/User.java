package avocado;

import java.time.Period;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	private Location geoLocation;
	private EducationLevel educationLevel;
	private FieldOfStudy fieldOfStudy;
	private Sex sex;

	public User(String username, double gradDebt, double debt, double interest, Date grad, Date birth,
			Location province, EducationLevel education, FieldOfStudy field, Sex sex) {
		this.username = username;
		this.debtAtGrad = gradDebt;
		this.currentDebt = debt;
		this.interestRate = interest;
		this.gradDate = grad;
		this.dateOfBirth = birth;
		this.optedIn = false;
		this.geoLocation = province;
		this.educationLevel = education;
		this.fieldOfStudy = field;
		this.sex = sex;
		this.scoreCalc();
		this.generateFriendCode();
		this.getMedianData();
	}

	public User(String username, double incomeData, double debtData, double gradDebt, double debt, double interest,
			String grad, String birth, boolean opted, String province, String education, String field, String sex,
			int friendCode) {
		this.username = username;
		this.medianDemographicIncome = incomeData;
		this.medianDemographicDebt = debtData;
		this.debtAtGrad = gradDebt;
		this.currentDebt = debt;
		this.interestRate = interest;
		try {
			this.gradDate = new SimpleDateFormat("yyyy-MM-dd").parse(grad);
			this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
		} catch (ParseException e) {
			//Oh No
		}
		this.optedIn = opted;
		this.geoLocation = Location.valueOf(province);
		this.educationLevel = EducationLevel.valueOf(education);
		this.fieldOfStudy = FieldOfStudy.valueOf(field);
		this.sex = Sex.valueOf(sex);
		this.scoreCalc();
		this.friendCode = friendCode;
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
	 * Getter for median demographic debt at graduation
	 * 
	 * @return Double representing median demographic debt at graduation
	 */
	public double getMedianDemographicDebt() {
		return this.medianDemographicDebt;
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
	 * Getter for the rank of the current user
	 * 
	 * @return Integer representing the rank of the current user among other users
	 */
	public int getRank() {
		return this.rank;
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
		this.scoreCalc();
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
	 * Getter for graduation date
	 * 
	 * @return Date representing the user's date of graduation
	 */
	public String getGradDateS() {
		return new SimpleDateFormat("yyyy-MM-dd").format(gradDate);
	}

	/**
	 * Getter for user's date of birth
	 * 
	 * @return Date representing the user's date of birth
	 */
	public String getDateOfBirthS() {
		return new SimpleDateFormat("yyyy-MM-dd").format(dateOfBirth);
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
	}

	/**
	 * Opts the user out of the leaderboard
	 */
	public void optOut() {
		this.optedIn = false;
	}

	/**
	 * Getter for the user's sex
	 * 
	 * @return Returns a Sex enum representing the user's sex
	 */
	public String getSexS() {
		return this.sex.toString();
	}


	/**
	 * Getter for the user's location
	 * 
	 * @return Location enum representing the user's location
	 */
	public String getLocationS() {
		return this.geoLocation.toString();
	}

	/**
	 * Getter for the user's field of study
	 * 
	 * @return Field of Study enum representing the user's field of study
	 */
	public String getFieldOfStudyS() {
		return this.fieldOfStudy.toString();
	}

	/**
	 * Getter for user's education level
	 * 
	 * @return Education Level enum representing the user's education level
	 */
	public String getEduationLevelS() {
		return this.educationLevel.toString();
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
		this.score = Math.round(score);
	}

	private void generateFriendCode() {
		boolean generated = false;
		int code = 0;
		Random random = new Random();
		while (!generated) {
			code = random.nextInt();
			try {
				if (!Jdbc.friendCodeExists(code)) {
					generated = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			generated = true;
		}
		this.friendCode = code;
	}

	private void getMedianData() {
		this.medianDemographicDebt = Jdbc.getDebtData(this.getDebtCoordinate());
		this.medianDemographicIncome = Jdbc.getIncomeData(this.getIncomeCoordinate());
	}

	private void findFriends() {
		int howManySuggestions = 5;
		this.friends = Jdbc.getFriends(this.friendCode);
		this.suggestedFriends = Jdbc.getSuggested(this.friendCode, howManySuggestions);
	}

	public ArrayList<NotCurrentUser> getFriendLeaderboard() {
		findFriends();
		ArrayList<NotCurrentUser> output = this.friends;
		NotCurrentUser self = new NotCurrentUser(this.username, this.score);
		output.add(self);
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

}

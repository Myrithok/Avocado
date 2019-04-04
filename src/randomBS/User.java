package randomBS;

import java.time.Period;
import java.time.LocalDate;
import java.util.Date;

public class User {
	private double medianDemographicIncome;
	private double medianDemographicDebt;
	private double score;
	private String username;
	private int rank;
	private int ID;
	
	private double debtAtGrad;
	private double currentDebt;
	private double interestRate;
	
	private Date gradDate;
	private Date dateOfBirth;
	private long friendCode;
	
	private boolean optedIn;
	
	//replace the types of these with enums
	private Location geoLocation;
	private EducationLevel educationLevel;
	private FieldOfStudy fieldOfStudy;
	private Sex sex;
	
	private boolean hasChanged;
	
	public User() {
		
	}
	
	//getters and setters
	
	public double getMedianDemographicIncome() {
		return this.medianDemographicIncome;
	}
	
	public void setMedianDemographicIncome(double income) {
		this.medianDemographicIncome = income;
		this.hasChanged = true;
	}
	
	public double getMedianDemographicDebt() {
		return this.medianDemographicDebt;
	}
	
	public void setMedianDemographicDebt(double debt) {
		this.medianDemographicDebt = debt;
		this.hasChanged = true;
	}
	
	public double getScore() {
		return this.score;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
		this.hasChanged = true;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
		this.hasChanged = true;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
		this.hasChanged = true;
	}
	
	public double getDebtAtGrad() {
		return this.debtAtGrad;
	}
	
	public void setDebtAtGrad(double debtAtGrad) {
		this.debtAtGrad = debtAtGrad;
		this.hasChanged = true;
	}
	
	public double getCurrentDebt() {
		return this.currentDebt;
	}
	
	public void setCurrentDebt(double currentDebt) {
		this.currentDebt = currentDebt;
		this.hasChanged = true;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
		this.hasChanged = true;
	}
	
	public Date getGradDate() {
		return this.gradDate;
	}
	
	public void setGradDate(Date gradDate) {
		this.gradDate = gradDate;
		this.hasChanged = true;
	}
	
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		this.hasChanged = true;
	}
	
	public long getFriendCode() {
		return this.friendCode;
	}
	
	public void setFriendCode(long friendCode) {
		this.friendCode = friendCode;
		this.hasChanged = true;
	}
	
	public boolean optedIn() {
		return this.optedIn;
	}
	
	public void optIn() {
		this.optedIn = true;
		this.hasChanged = true;
	}
	
	public void optOut() {
		this.optedIn = false;
		this.hasChanged = true;
	}
	
 	public Sex getSex() {
		return this.sex;
	}
	
	public void setSex(Sex sex) {
		this.sex = sex;
		this.hasChanged = true;
	}
	
	public Location getLocation() {
		return this.geoLocation;
	}
	
	public void setLocation(Location location) {
		this.geoLocation = location;
		this.hasChanged = true;
	}
	
	public FieldOfStudy getFieldOfStudy() {
		return this.fieldOfStudy;
	}
	
	public void setFieldOfStudy(FieldOfStudy fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
		this.hasChanged = true;
	}
	
	public EducationLevel getEduationLevel() {
		return this.educationLevel;
	}
	
	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
		this.hasChanged = true;
	}
 	
	public boolean hasChanged() {
		return this.hasChanged;
	}
	
	//main functions
	public int getAgeAtGrad() {
		LocalDate dateOfBirth = new java.sql.Date(this.dateOfBirth.getTime()).toLocalDate();
		LocalDate gradDate = new java.sql.Date(this.gradDate.getTime()).toLocalDate();
		return Period.between(dateOfBirth, gradDate).getYears();
	}
	
	public int getAge() {
		LocalDate dateOfBirth = new java.sql.Date(this.dateOfBirth.getTime()).toLocalDate();
		LocalDate current = new java.sql.Date(new Date().getTime()).toLocalDate();
		return Period.between(dateOfBirth, current).getYears();
	}
	
	public String getDebtCoordinate() {
		String out = "";
		out += this.geoLocation.toval() + ".";
		out += this.educationLevel.toDebtVal() + ".";
		out += "1.";
		out += "3";
		return out;
	}
	
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
	
	public void scoreCalc() {
		LocalDate current = new java.sql.Date(new Date().getTime()).toLocalDate();
		LocalDate gradDate = new java.sql.Date(this.gradDate.getTime()).toLocalDate();
		
		double periods =  Period.between(gradDate, current).getMonths();
		
		double i = Math.pow(1+this.interestRate, periods);
		
		double numerator = this.interestRate * (this.debtAtGrad*i - this.currentDebt);
		double denominator = i - 1.0;
		
		double payment = numerator/denominator;
		
		double normC = 1.0;
		
		double debtCorrection = this.debtAtGrad/this.medianDemographicDebt;
		
		double score = debtCorrection*normC*(payment/this.medianDemographicIncome);
		
		this.score = score;
	}
	
	public static void main(String[] args) {
		//Dakota test area
		
		//Andrew test area
		
		//Erfan test area
		
		//Daniel test area
	}
}

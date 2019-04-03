package randomBS;

import java.time.Period;
import java.time.LocalDate;
import java.util.Date;

public class User {
	private double medianDemographicIncome;
	private double medianDemographicDebt;
	private double score;
	private String username;
	private double rank;
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
		
	}
	
	public String getIncomeCoordinate() {
		
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

package gov.kotkov.mikhail.exercise2.employee;

import java.math.BigDecimal;
import java.math.RoundingMode;

import gov.kotkov.mikhail.exercise2.util.Job;

public abstract class Employee {

	private final String firstName, lastName;
	
	private final Job job;
	//wage for standard hours worked
	private BigDecimal wageRate;
	
	//actual hours worked
	private int actualWorkhours;
	
	//standard amount of hours employee has to work 
	private static int standardWorkhours;
	
	public Employee(String firstName, String lastName, Job job, BigDecimal wageRate) {
		validateName(firstName, lastName);
		this.job = job;
		this.firstName = firstName;
		this.lastName = lastName;
		this.wageRate = wageRate.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getWageRate() {
		return wageRate;
	};
	
	public void setWageRate(BigDecimal wageRate) {
		if(wageRate.signum() == -1) {
			throw new IllegalArgumentException("wage rate can't be negative");
		}
		this.wageRate = wageRate.setScale(2, RoundingMode.HALF_UP);
	}
	
	public void setActualWorkhours(int actualWorkhours) {
		if(actualWorkhours < 1) {
			throw new IllegalArgumentException("actual workhours can't be negative");
		}
		this.actualWorkhours = actualWorkhours;
	}

	public static void setStandardWorkhours(int standardWorkhours) {
		if(standardWorkhours < 1) {
			throw new IllegalArgumentException("standard workhours can't be negative");
		}
		Employee.standardWorkhours = standardWorkhours;
	}
	
	public double getWorkhoursPercentage() {
		return ((double)actualWorkhours/standardWorkhours) * 100;
	}

	private void validateName(String firstName, String lastName) {
		if(firstName.isEmpty() || lastName.isEmpty()) {
			throw new IllegalArgumentException("Employee must have first and last name");
		} else if(!firstName.chars().allMatch(Character::isLetter) || !lastName.chars().allMatch(Character::isLetter)) {
			throw new IllegalArgumentException("Name must consist of alphabetic characters");
		}
	}

	public Job getJob() {
		return job;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", job=" + job
				+ ", wageRate=" + wageRate + ", actualWorkhours=" + actualWorkhours + "]";
	}

	public int getActualWorkhours() {
		return actualWorkhours;
	}

	public static int getStandardWorkhours() {
		return standardWorkhours;
	}

}

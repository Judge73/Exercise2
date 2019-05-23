package gov.kotkov.mikhail.exercise2.employee;

import java.math.BigDecimal;

import gov.kotkov.mikhail.exercise2.util.Job;

public class Programmer extends Employee {

	public Programmer(String firstName, String lastName, BigDecimal wageRate) {
		super(firstName, lastName, Job.PROGRAMMER, wageRate);
	}

}

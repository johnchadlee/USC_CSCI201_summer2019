package johncl_CSCI201L_lab2;

public abstract class SalariedEmployee extends Employee {

	public SalariedEmployee(String firstName, String lastName, String birthdate, int employeeID, String jobTitle, String company,
			double salary) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.employeeID = employeeID;
		this.jobTitle = jobTitle;
		this.company = company;
		this.annualSalary = salary;
	}
	double annualSalary;
	@Override
	public double getAnnualSalary() {
		// TODO Auto-generated method stub
		return annualSalary;
	}

}

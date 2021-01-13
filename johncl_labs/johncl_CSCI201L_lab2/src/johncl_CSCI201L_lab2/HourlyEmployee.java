package johncl_CSCI201L_lab2;

public abstract class HourlyEmployee extends Employee {

	public HourlyEmployee(String firstName, String lastName, String birthdate, int employeeID, String jobTitle, String company,
			double hourlyRate, double numberHoursPerWeek) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.employeeID = employeeID;
		this.jobTitle = jobTitle;
		this.company = company;
		this.annualSalary = (52 * hourlyRate * numberHoursPerWeek);
	}	
	
	double annualSalary;
	@Override
	public double getAnnualSalary() {
		// TODO Auto-generated method stub
		return annualSalary;
	}


}

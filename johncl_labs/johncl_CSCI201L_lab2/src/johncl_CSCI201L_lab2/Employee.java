package johncl_CSCI201L_lab2;

public abstract class Employee extends Person {
	public Employee(String fName, String lName, String  bDay, int salary){
		super(fName, lName, bDay);
		this.salary = salary;
		
	}
	int employeeID;
	String jobTitle;
	String company;

	public int getEmployeeID() {
		return employeeID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public String getCompany() {
		return company;
	}
	public abstract double getAnnualSalary();
}

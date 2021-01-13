package johncl_CSCI201L_lab2;

public class Person {
	public Person(String fName, String lName, String bDay) {
		this.firstName = fName;
		this.lastName = lName;
		this.birthdate = bDay;
	}
	String firstName;
	String lastName;
	String birthdate;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getBirthdate() {
		return birthdate;
	}
}


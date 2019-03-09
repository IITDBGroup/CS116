/**
 * 
 */
package midterm;

/**
 * @author lord_pretzel
 *
 */
public class Student {

	private String firstName;
	private String lastName;
	private int creditsTaken;
	private double gpa;
	
	public Student(String firstName, String lastName, int creditsTaken, double gpa) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setCreditsTaken(creditsTaken);
		this.setGpa(gpa);
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCreditsTaken() {
		return creditsTaken;
	}

	public void setCreditsTaken(int creditsTaken) {
		this.creditsTaken = creditsTaken;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public void registerGrade(int credits, double grade) {
		gpa = (gpa * creditsTaken) + (credits * grade);
		creditsTaken += credits;
		gpa /= creditsTaken;
	}
	

}

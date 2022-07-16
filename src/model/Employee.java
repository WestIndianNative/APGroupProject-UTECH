package model;

public class Employee extends User {
	
	private String employeeNo;

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param employeeNo
	 */
	public Employee(int id, String firstName, String lastName, String employeeNo) {
		super(id, firstName, lastName);
		this.employeeNo = employeeNo;
	}
	
	public Employee() {
		super();
		this.employeeNo = "";
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	@Override
	public String toString() {
		return "Employee [employeeNo=" + employeeNo + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	

}

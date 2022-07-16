package model;

public class Technician extends Employee {
	
	private boolean available;
	
	
	
	

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param employeeNo
	 * @param available
	 */
	public Technician(int id, String firstName, String lastName, String employeeNo, boolean available) {
		super(id, firstName, lastName, employeeNo);
		this.available = available;
	}

	public Technician() {
		super();
		this.available = false;	
	}



	public boolean isAvailable() {
		return available;
	}





	public void setAvailable(boolean available) {
		this.available = available;
	}





	@Override
	public String toString() {
		return "Technician [available=" + available + ", getEmployeeNo()=" + getEmployeeNo() + ", toString()="
				+ super.toString() + ", getId()=" + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}

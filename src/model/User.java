package model;

import javax.persistence.Embeddable;

@Embeddable
public class User {
	
	
	private int Id;
	protected String firstName;
	private String lastName;
	
	

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 */
	public User(int id, String firstName, String lastName) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public User() {
		super();
		Id = 0;
		this.firstName = "";
		this.lastName = "";
	}

	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
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


	@Override
	public String toString() {
		return "User [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	
	
	
	
	
	

}

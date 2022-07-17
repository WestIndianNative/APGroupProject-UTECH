package model;

import javax.persistence.*;

@Embeddable
public class Customer extends User {
	
	
	private String emailAddress;

	private String contactNo;
	
	
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param contactNo
	 */
	public Customer(int id, String firstName, String lastName, String emailAddress, String contactNo) {
		super(id, firstName, lastName);
		this.emailAddress = emailAddress;
		this.contactNo = contactNo;
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param contactNo
	 */




	public Customer() {
		super();
		this.emailAddress = "";
		this.contactNo = "";
	}

	public String getEmailAddress() {
		return emailAddress;
	}



	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}



	public String getContactNo() {
		return contactNo;
	}



	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}



	@Override
	public String toString() {
		return "Customer [emailAddress=" + emailAddress + ", contactNo=" + contactNo + ", getId()=" + getId()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
	

}

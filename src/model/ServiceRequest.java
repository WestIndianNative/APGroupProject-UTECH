package model;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.SessionFactoryBuilder;

@Entity
@Table(name = "ServiceRequest")
public class ServiceRequest extends Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Record_No")
	private int recordNo;

	@Column(name = "Id")
	private int id;

	@Column(name = "Fname")
	private String firstName;

	@Column(name = "Lname")
	private String lastName;

	 @Column(name="Email")
	 private String emailAddress; 
	 @Column(name="Contact")
	 private String contactNo;
	 

	@Column(name = "IssueType")
	private String issueType;

	@Column(name = "Address")
	private String Address;


	@Override
	public String toString() {
		return "ServiceIssue [recordNo=" + recordNo + ", id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailAddress=" + emailAddress + ", contactNo=" + contactNo + ", issueType=" + issueType
				+ ", Address=" + Address + "]";
	}
/**
 * @param recordNo
 * @param id
 * @param firstName
 * @param lastName
 * @param emailAddress
 * @param contactNo
 * @param issueType
 * @param Address
 */
public ServiceRequest( int id, String firstName, String lastName, String emailAddress, String contactNo,
		String issueType, String Address) {
	super();
	
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailAddress = emailAddress;
	this.contactNo = contactNo;
	this.issueType = issueType;
	this.Address = Address;
}



	public ServiceRequest() {
		super();
		this.Address = "";
		this.issueType = "";


	}


	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	/*
	 * @Override public String toString() { return "ServiceIssue [issueType=" +
	 * issueType + ", detailOfIssue=" + detailOfIssue + ", getEmailAddress()=" +
	 * getEmailAddress() + ", getContactNo()=" + getContactNo() + ", toString()=" +
	 * super.toString() + ", getId()=" + getId() + ", getFirstName()=" +
	 * getFirstName() + ", getLastName()=" + getLastName() + ", getClass()=" +
	 * getClass() + ", hashCode()=" + hashCode() + "]"; }
	 */

	public void AddReportToDB() {
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(this);
		transaction.commit();
		session.close();
	}

}

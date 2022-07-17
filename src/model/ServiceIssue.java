package model;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.SessionFactoryBuilder;

@Entity
@Table(name = "customerIssue")
public class ServiceIssue extends Customer {

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

	@Column(name = "ReportDetails")
	private String detailOfIssue;


	@Override
	public String toString() {
		return "ServiceIssue [recordNo=" + recordNo + ", id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailAddress=" + emailAddress + ", contactNo=" + contactNo + ", issueType=" + issueType
				+ ", detailOfIssue=" + detailOfIssue + "]";
	}
/**
 * @param recordNo
 * @param id
 * @param firstName
 * @param lastName
 * @param emailAddress
 * @param contactNo
 * @param issueType
 * @param detailOfIssue
 */
public ServiceIssue( int id, String firstName, String lastName, String emailAddress, String contactNo,
		String issueType, String detailOfIssue) {
	super();
	
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailAddress = emailAddress;
	this.contactNo = contactNo;
	this.issueType = issueType;
	this.detailOfIssue = detailOfIssue;
}



	public ServiceIssue() {
		super();
		this.detailOfIssue = "";
		this.issueType = "";


	}


	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getDetailOfIssue() {
		return detailOfIssue;
	}

	public void setDetailOfIssue(String detailOfIssue) {
		this.detailOfIssue = detailOfIssue;
	}



	public void AddReportToDB() {
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(this);
		transaction.commit();
		session.close();
	}

}

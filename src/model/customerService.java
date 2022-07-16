package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.SessionFactoryBuilder;


@Entity
@Table(name="customerServiceIssue")
public class customerService extends User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Customer_No")
	private int cusServiceID;
	@Column(name="First")
	private String firstName ;
	@Column(name="lastName")
	private String lastName;
	@Column(name="Email")
	private String Email;
	
	@Column(name="Contact")
	private String Contact;
	
	@Column(name="Issue_Type")
	private String Issue_Type;
	@Column(name="Date_of_Issue")
	private String Date_of_Issue;
	@Column(name="Status")
	private String Status;
	@Column(name="Response_Time")
	private String ResponseT;
	@Column(name="Technician")
	private String TechnicianA;
	@Column(name="lastResponse")
	private String lastResponse;
	@Column(name="Who_Responed")
	private String Who_Responed;
	
	private Customer customer;

	
	
	
	
	



	
	public customerService(Customer customer, String Date_of_Issue, String Status, String ResponseT, String TechnicianA, String lastResponse, String Who_Responed) {
		super();
		this.Date_of_Issue = Date_of_Issue;
		this.Status = Status;
		this.ResponseT = ResponseT;
		this.TechnicianA = TechnicianA;
		this.lastResponse = lastResponse;
	    this.Who_Responed = Who_Responed;
		
	}
	
	
	/*
	 * public customerService(int cusServiceID,String firstName,String
	 * lastName,String Email, String Contact,String Issue_Type, String
	 * Date_of_Issue,String Status,String ResponseT,String lastResponse,String
	 * Who_Responed) { this.cusServiceID = cusServiceID; this.firstName = firstName;
	 * this.lastName= lastName; this.Email= Email; this.Contact = Contact;
	 * this.Issue_Type = Issue_Type; this.Date_of_Issue = Date_of_Issue; this.Status
	 * = Status; this.ResponseT = ResponseT; this.TechnicianA = TechnicianA;
	 * this.lastResponse = lastResponse; this.Who_Responed = Who_Responed;
	 * 
	 * }
	 */
    
	
	
	
	
	public int getCusServiceID() {
		return cusServiceID;
	}

	public void setCusServiceID(int cusServiceID) {
		this.cusServiceID = cusServiceID;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getIssue_Type() {
		return Issue_Type;
	}

	public void setIssue_Type(String issue_Type) {
		Issue_Type = issue_Type;
	}

	public String getDate_of_Issue() {
		return Date_of_Issue;
	}

	public void setDate_of_Issue(String date_of_Issue) {
		Date_of_Issue = date_of_Issue;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getResponseT() {
		return ResponseT;
	}

	public void setResponseT(String responseT) {
		ResponseT = responseT;
	}

	public String getTechnicianA() {
		return TechnicianA;
	}

	public void setTechnicianA(String technicianA) {
		TechnicianA = technicianA;
	}

	public String getLastResponse() {
		return lastResponse;
	}

	public void setLastResponse(String lastResponse) {
		this.lastResponse = lastResponse;
	}

	public String getWho_Responed() {
		return Who_Responed;
	}

	public void setWho_Responed(String who_Responed) {
		Who_Responed = who_Responed;
	}
	
	
	
	
	

	@Override
	public String toString() {
		return "customerService [\ncusServiceID : " + cusServiceID + ", \nfirstName:  " + firstName + ", \nlastName : " + lastName
				+ ",\n Email :" + Email + ", \nContact " + Contact + ", \nIssue_Type: " + Issue_Type + ", \nDate_of_Issue: "
				+ Date_of_Issue + ", \nStatus: " + Status + ", \nResponseT: " + ResponseT + ", \nTechnicianA: " + TechnicianA
				+ ", \nlastResponse: " + lastResponse + ", \nWho_Responed: " + Who_Responed + "]";
	}


	public void create() {
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		Transaction transaction= session.beginTransaction();
		//Student stu=(Student) session.get(Student.class, this.id);
		//stu.setFirstName(firstName);
		//stu.setLastName(lastName);
		session.save(this);
		transaction.commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	public List<customerService> readAll(){
		List<customerService> studentList=new ArrayList<>();
		Session session =SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		Transaction transaction= session.beginTransaction();
		studentList=session.createQuery("From customerService").getResultList();
		transaction.commit();
		session.close();
		return studentList;
	}
public void delete(int id) {
	    Session session =SessionFactoryBuilder.getSessionFactory()
	         .getCurrentSession();
		Transaction transaction= session.beginTransaction();
		//Student stu=(Student) session.get(Student.class, this.id);
		//session.delete(stu);

		 // Delete a persistent object
		customerService student = session.get(customerService.class, id);
        if (student != null) {
            session.delete(student);
            System.out.println("student  deleted");
        }

        // Delete a transient object
  /*      Student student2 = new Student();
        student2.setId(2);
        session.delete(student2);
        System.out.println("Student 2 is deleted");
    */
		transaction.commit();
		session.close();
}
public void update() {
    Session session =SessionFactoryBuilder.getSessionFactory()
         .getCurrentSession();
	Transaction transaction= session.beginTransaction();
	//Student stu=(Student) session.get(Student.class, this.id);
	session.update(this);
	transaction.commit();
	session.close();
}
public customerService get(int id) {
	customerService stu=null;
	Transaction transaction=null;
    try(Session session =SessionFactoryBuilder.getSessionFactory()
         .getCurrentSession()){
	    transaction= session.beginTransaction();


		stu=session.get(customerService.class, id);
		session.delete(stu);
		transaction.commit();
	}catch(Exception e) {
		if(transaction!=null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}

	return stu;
   }
}

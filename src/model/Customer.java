package model;



public class Customer extends User{
	
	private String email;
	private	String phoneNumber;
	private String TypeIssue;
	private String DetailIssue;
	private String Address;
	

	private User customer;
	
	
	
	Customer(){
		super();
		this.id = 0;
		this.firstName = " ";
		this.lastName = " ";
		this.email = " ";
		this.phoneNumber = " ";
		this.TypeIssue = " ";
		this.DetailIssue = " ";
		this.Address = "";
	}
	
	public Customer(User customer, String email, String phoneNumber, String Address, String TypeIssue, String DetailIssue){
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.TypeIssue = TypeIssue;
		this.DetailIssue = DetailIssue;
		this.Address = Address;
		
	}
	
	public Customer(Customer customer){
		
		id = customer.id;
		firstName = customer.firstName;
		lastName = customer.lastName;
		email = customer.email;
		phoneNumber = customer.phoneNumber;
		TypeIssue = customer.TypeIssue;
		DetailIssue = customer.DetailIssue;
		
	}
	
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getTypeIssue() {
		return TypeIssue;
	}
	
	public void setTypeIssue(String TypeIssue) {
		this.TypeIssue = TypeIssue;
	}
	
	public String getDetailIssue() {
		return DetailIssue;
	}
	
	public void setDateIssue(String DetailIssue) {
		this.DetailIssue = DetailIssue;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", phoneNumber=" + phoneNumber + ", TypeIssue=" + TypeIssue
				+ ", DetailIssue=" + DetailIssue + ", Address=" + Address + ", customer=" + customer + ", id=" + id
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	

}

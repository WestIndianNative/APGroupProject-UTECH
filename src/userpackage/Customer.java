package userpackage;



public class Customer extends User{
	
	String email;
	String phoneNumber;
	String TypeIssue;
	String DetailIssue;
	
	
	Customer(){
		
		this.id = 0;
		this.firstName = " ";
		this.lastName = " ";
		this.email = " ";
		this.phoneNumber = " ";
		this.TypeIssue = " ";
		this.DetailIssue = " ";
	}
	
	Customer(int id, String firstName, String lastName, String email, String phoneNumber, String TypeIssue, String DetailIssue){
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.TypeIssue = TypeIssue;
		this.DetailIssue = DetailIssue;
		
	}
	
	Customer(Customer customer){
		
		id = customer.id;
		firstName = customer.firstName;
		lastName = customer.lastName;
		email = customer.email;
		phoneNumber = customer.phoneNumber;
		TypeIssue = customer.TypeIssue;
		DetailIssue = customer.DetailIssue;
		
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
	

}

package userpackage;

/**
 * The User Class is the Base Class for Technician, Customer 
 * and the Representative.
 */
public class User {
	
	int id;
	String firstName;
	String lastName;
	
	//Constructors
	
	User(){
		
		this.id = 0;
		this.firstName = " ";
		this.lastName = " ";
	}
	
	User(int id, String firstName, String lastName){
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	User(User user){
		
		id = user.id;
		firstName = user.firstName;
		lastName = user.lastName;
	}

	//Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

}

package userpackage;



public class Employee extends User{
	
	//Constructors
	
	public boolean available;

	Employee(){
		
		this.id = 0;
		this.firstName = " ";
		this.lastName = " ";
	}
	
	Employee(int id, String firstName, String lastName){
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	Employee(Employee employee){
		
		id = employee.id;
		firstName = employee.firstName;
		lastName = employee.lastName;
	}
}



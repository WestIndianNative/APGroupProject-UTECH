package userpackage;




public class Technician extends Employee{

	boolean available; 
	
	Technician(){
		
		this.id = 0;
		this.firstName = " ";
		this.lastName = " ";
		this.available = true;
	}
	
	Technician(int id, String firstName, String lastName, boolean available){
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.available = available;
	}
	
	Technician(Employee employee){
		
		id = employee.id;
		firstName = employee.firstName;
		lastName = employee.lastName;
		available = employee.available;
	}
}


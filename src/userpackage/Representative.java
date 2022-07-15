package userpackage;


public class Representative extends Employee{

	Representative(){
		
		this.id = 0;
		this.firstName = " ";
		this.lastName = " ";
	}
	
	Representative(int id, String firstName, String lastName){
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	Representative(Representative representative){
		
		id = representative.id;
		firstName = representative.firstName;
		lastName = representative.lastName;
	}
	
	
}

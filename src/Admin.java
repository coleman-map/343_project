package diyUniversity;

public class Admin extends Employee{
	private Boolean isSuper;
		
	public Admin(){
		super();
	}
	
	public Admin(String firstName, String lastName, String midIntial, int ID) {
		super(firstName, lastName, midIntial, ID);
		this.isSuper = false;
	}
	
	public Admin(String firstName, String lastName, String midIntial, int ID, double salary,Boolean isSuper) {
		super(firstName, lastName, midIntial, ID, salary);
		this.isSuper = isSuper;
	}
	
	public boolean isSuper() {
		return isSuper;
	}


	public void makeAdmin(){
		isSuper = true;
	}
	
	public void createAdmin(int id){
		super.createEmp(id);
	}
	
	public String toString(){
		return super.toString();
	}
}

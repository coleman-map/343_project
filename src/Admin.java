
public class Admin extends Employee{
	private Boolean isSuper;
		
	/**
	 * Empty value constructor
	 */
	public Admin(){
		super();
	}
	
	/**
	 * Overloaded constructor
	 * @param firstName
	 * @param lastName
	 * @param midIntial
	 * @param ID
	 */
	public Admin(String firstName, String lastName, String midIntial, int ID) {
		super(firstName, lastName, midIntial, ID);
		this.isSuper = false;
	}
	
	/**
	 * Overloaded constructor for super Admin
	 * @param firstName
	 * @param lastName
	 * @param midIntial
	 * @param ID
	 * @param salary
	 * @param isSuper
	 */
	public Admin(String firstName, String lastName, String midIntial, int ID, double salary,Boolean isSuper) {
		super(firstName, lastName, midIntial, ID, salary);
		this.isSuper = isSuper;
	}
	
	/**
	 * Checks if Admin is super
	 * @return true or false
	 */
	public boolean isSuper() {
		return isSuper;
	}

	/**
	 * Creates Admin into super 
	 */
	public void makeAdmin(){
		isSuper = true;
	}
	
	/**
	 * Prompts user to enter new values 
	 * @param id
	 */
	public void createAdmin(int id){
		super.createEmp(id);
	}
	
	/**
	 * Prints object information
	 */
	public String toString(){
		return super.toString();
	}
}


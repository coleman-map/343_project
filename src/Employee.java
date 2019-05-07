public class Employee extends Person {
	private double salary = 0;
	
	public Employee(){
		
	}
	
	/**
	 * Default constructor employee
	 * @param firstName- first name
	 * @param lastName - last name
	 * @param midIn - middle initial
	 * @param ID - identification
	 * @param salary - salary of employee
	 */
	public Employee(String firstName,String lastName,String midIntial,int ID){
		super(firstName,lastName,midIntial,ID);
		this.salary = 0;
		
	}
	
	
	/**
	 * Overloaded constructor
	 * @param firstName- first name
	 * @param lastName - last name
	 * @param midIn - middle initial
	 * @param ID - identification
	 * * @param salary - salary of employee
	 */
	public Employee(String firstName,String lastName,String midIntial,int ID, double salary ){
		super(firstName,lastName,midIntial,ID);
		this.salary = salary;
		
	}
	
	
	//Setters-------------------------------------------
	/**
	 * sets Salary
	 * @param salary - sets salary
	 */
	public void setSalary(double salary){
		this.salary = salary;
	}
	
			//Getters-------------------------------------------	
	
	/**
	 * get salary
	 * @return - salary
	 */
	public double getSalary(){
		return salary;	
	}
	
	public String toString(){
		return super.toString() + String.format("%-15s", salary);
	}
	public void createEmp(int id){
		super.createPerson(id);
	}
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class College {
	Scanner in = new Scanner(System.in);
	Validation validator = new Validation();
	/**
	 * A class for representing a college in the university
	 */
	
	private String colName;
	private ArrayList<Department> departments;
	private int numDep;
	private Person dean;
	/**
	 * Default constructor method
	 * 
	 * Inputs: none
	 * 
	 * Outputs: none
	 * 
	 * Return Value: the College
	 * 
	 * Exception: none
	 */
	College(){
		this.colName = "";
		this.dean = null;
		this.numDep = 0;
		departments=new ArrayList <Department>();
	}
	
	
	public College(String name){
		this.colName = name;
		this.dean = null;
		this.numDep = 0;
		departments=new ArrayList <Department>();
	}
	
	
	/**
	 * Loaded constructor method
	 * 
	 * Inputs:
	 *	colName - name of the college
	 *	departments - list of all departments in college
	 *	numDep - number of departments in college
	 *	dean - dean of the college 
	 *	
	 * Output: none
	 * 
	 * Return Value: the College
	 * 
	 * Exception: none
	 */
	//, Person dean
	College(String colName, List<Department> departments, Person dean){
		this.colName = colName;
		this.dean = dean;
		this.departments = new ArrayList<Department>(departments);
	}
	/**
	 * Gets dean of the college
	 * 
	 * Inputs: none
	 * 
	 * Outputs: 
	 *	dean - dean of the college
	 *
	 * Return Value:
	 *	@return - dean of college (Employee)
	 *
	 * Exception: none
	 */
	public Person getDean() {
		return dean;
	}
	/**
	 * Sets dean
	 * 
	 * Inputs:
	 * 	dean - the dean of the college
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 * 
	 */
	public void setDean(Person dean) {
		this.dean = dean;
	}
	
	/**
	 * Gets college name 
	 * 
	 * Inputs: none
	 * 
	 * Outputs: 
	 *	colName - name of the college
	 *
	 * Return Value:
	 *	@return - name of college (String)
	 *
	 * Exception: none
	 */
	public String getColName() {
		return colName;
	}
	
	
	public ArrayList<Department> getDepartments(){
		return this.departments;
	}
	/**
	 * Sets college name
	 * 
	 * Inputs:
	 * 	colName - name of the college
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 */
	public void setColName(String colName) {
		this.colName = colName;
	}
	
	/**
	 * Gets number of departments in college 
	 * 
	 * Inputs: none
	 * 
	 * Outputs: 
	 *	numDep - number of departments
	 *
	 * Return Value:
	 *	@return - number of departments (int)
	 *
	 * Exception: none
	 */
	public int getNumDep() {
		return numDep;
	}
	
	/**
	 * Sets number of departments
	 * 
	 * Inputs:
	 * 	numDep - number of departments in college
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 */
	public void setNumDep(int numDep) {
		this.numDep = numDep;
	}
	
	/**
	 * Gets dean of the college
	 * 
	 * Inputs: none
	 * 
	 * Outputs: 
	 *	dean - dean of the college
	 *
	 * Return Value:
	 *	@return - dean of college (Employee)
	 *
	 * Exception: none
	 */
//	public Person getDean() {
//		return dean;
//	}
	
	/**
	 * Sets dean
	 * 
	 * Inputs:
	 * 	dean - the dean of the college
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 * 
	 */
//	public void setDean(Person dean) {
//		this.dean = dean;
//	}
//	
	
	/**
	 * Adds department to college
	 * 
	 * Inputs:
	 * 	dep - new department to be added
	 * 
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: 
	 * 	InvalidParamter - department already exists
	 */
	public void addDep() {
		boolean isnew_Dep=true;
		String dep_Name="";
		do {
			System.out.println("Type the name of the department you want to include or exit to exit: ");
			dep_Name= in.nextLine(); 
			
			if (dep_Name.toLowerCase().equals("exit"))
				break;
			
			Department department =new Department (dep_Name);
			
			
			if(this.departments.size()>0) {
				for(int i=0; i<this.departments.size();i++) {
					if(this.departments.get(i).getDepName().equalsIgnoreCase(dep_Name)) {
						System.out.println("The name already belong to a department in the college and cannot"
								+ " be added again");
						isnew_Dep =false;
						break;
					}
				}
				if(isnew_Dep)
					this.departments.add(department);
				else
					continue;

								
		}//end of if(this.departments.size()>0)
			else 
				this.departments.add(department);
			
			System.out.println("Do you wish to add majors to the department?: (y/n)");
			String input=in.nextLine();
			input=validator.validateChar(input);
			if (input.equals("y")) {
				while (input.equals("y")) {
					String major_name;
					// final version must have inputs of type course and not string
					System.out.println("Input the name of the major you want to add or exit to exit");
					major_name= in.nextLine();
					if (major_name.equals("exit")) {
						input="n";
						break;
					}// end of if (course_name=="exit")
					
					int index=this.departments.indexOf(department);
//					boolean check = true;
					
					for (int i=0;i<this.departments.size();i++) {
						if(this.departments.get(i).hasMajor(major_name)) {
							System.out.println("This major already belongs to the department, try again");
							break;
						}
							
					}
					if(this.departments.get(index).hasMajor(major_name))
						continue;
					else {
//						System.out.println("Check: ");
						Major major=new Major(major_name);
						this.departments.get(index).addMjr(major);	
						//System.out.println("Major added");
					}
					
					
				}//end of while (input =="y")
				
			}//end of if (input=="y")

		}while (!dep_Name.equalsIgnoreCase("exit"));
		
		
		
	}
	
	
	/**
	 * Deletes department
	 * 
	 * Inputs:
	 * 	dep	- department to be deleted
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception:
	 * 	InvalidParameter - department does not exist
	 */
	public void delDep() {
		displayDeps();
		String dep_to_del="";
		boolean found =false;
		do {
			System.out.println("Enter the name of the department you want to delete or exit to exit");
			dep_to_del=in.nextLine();
			if(!hasDep(dep_to_del)) {
				System.out.println("This Department does not belong to the College, try again");
				continue;
			}else {
				for (Department d :departments) {
					if (d.getDepName().equalsIgnoreCase(dep_to_del)){
						this.departments.remove(d);
						found=true;
						System.out.println("The department has been deleted");
						break;
					}//end of if (d.getDepName().equalsIgnoreCase(dep_to_del))
					
				}//end of for (Department d :departments)
				if (found)
					break;
			}
		}while (!dep_to_del.equalsIgnoreCase("exit"));
		
		
		
	}
	 
	/**
	 * editDepMenu
	 * his sub-menu allows to change the department name, open the major menu or going back to the College menu
	 * 
	 * Inputs: None
	 * 
	 * Outputs: Menu
	 * 
	 * ReturnValue: None
	 * 
	 */
	public void editDepMenu() {
  	  boolean found=false;
  	  
  	  String major_chosen="";
  	  String opt_chosen="";
  	  int opt_chosen_i;
  	  Major temp_major;
  	  int index=0;
  	  
  	  displayDeps();
  	  System.out.println("Select the Department you want to work on");
  	  major_chosen=in.nextLine();
  	  Department current=findDep(major_chosen);
  	  
  	  while(!major_chosen.equalsIgnoreCase("exit")) {
  		  System.out.print("\n" + current.getDepName()+ " DEPARTMENT MENU "
					+ "\n1. Change department name"
					+ "\n2. Department Menu"
					+ "\n3. Exit"
					+ "\nEnter here: ");
  		  opt_chosen=in.nextLine();
  		  opt_chosen_i= validator.validate_int(opt_chosen);
  		  if (opt_chosen_i==1)
  			  changeDepName(current);
  		  else if (opt_chosen_i==2)
  		  	  current.DepMenu();
  		  else if (opt_chosen_i==3)
  			  break;
  		  }//end of if (opt_chosen_i==1)	
  	  }
  	/**
  	 * findDep
  	 * Given a department name it returns the department object
  	 * 
  	 * Input: String dep_name- string of characters containing the name of department
  	 * 
  	 * Output: Message showing that the department is not found
  	 * 
  	 * ReturnValue: Department object
  	 * 
  	 * @param dep_name
  	 * @return Department
  	 */
	public Department findDep (String dep_name) {
	String opt_chosen;
  	  boolean found=false;
  	  int index=0;
  	  for (int i=0;i<this.departments.size();i++) {
			if(this.departments.get(i).getDepName().equalsIgnoreCase(dep_name)) {
					found=true;
					index=i;
				}
			
	  }
  	  if (!found) {
				System.out.println("The major does not exist in this department ");	
				return null;
			}else
				return this.departments.get(index);
			
	}
	
	/**
	 * hasDep
	 * hasDep given a string of characters returns a boolean showing whether the department linked it belongs to the college or not
	 * 
	 * Inputs: String _dep- string of characters containing the name of a department
	 * 
	 * Outputs: None
	 * 
	 *
	 * 
	 * @param _dep
	 * 
	 *ReturnValue:
	 * true if the value belongs to the department
	 * false if the value does not belong to the department
	 * 
	 * @return boolean true or false
	 */
	public boolean hasDep (String _dep) {
		for(Department d:departments) {
			if (d.getDepName().equalsIgnoreCase(_dep))
				return true;
		}
		return false;
	}
	public boolean isDean(int id){
		for(Department d:departments){
			if(d.getChair() == null){
				
			}else if(d.getChair().getID() == id){
				System.out.println("Employee is already dean of " + d.getDepName() + "!");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * changeDepName
	 *  Overwrites the name of a department if the name is available 
	 *  
	 *  Inputs- Department current- the department whose name is going be overwritten
	 *  
	 *  Outputs: Messages showing whether the name is available or not
	 * 
	 *  ReturnValue: None
	 * @param current
	 */
	public void changeDepName(Department current) {
  	  String opt_chosen="";
  	  boolean not_new=false;
  	  int index=0;
  	  System.out.println("Input the new name for the Department");
  	  
  	String new_name = in.nextLine();
	
	while(new_name.length() > 60){
		System.out.println("Character limit reached(60), Enter name again");
		System.out.println();
		new_name = in.nextLine();
	}
	
	
  	  
  	  
  	  for (int i=0;i<this.departments.size();i++) {
  		  if (this.departments.get(i).getDepName().equalsIgnoreCase(new_name))
  			  not_new=true;
  	  }
  	  if(not_new) {
  		  System.out.println("This name is not valid because it already belong to a department in the college"
  		  		+ " returning to menu");
  	  }else {
  		  System.out.println("Department Name Changed To: " + new_name);
  		  current.setDepName(new_name);
  	  }
	}
	
	/**
	 * Displays the departments in the college
	 * 
	 * Inputs: none
	 * 	
	 * Outputs: a list of all the departments in the college
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 */
	public void displayDeps() {
		System.out.printf("%-20s %-15s ", "Department Name", "Department Dean");
		System.out.println("");
		for (Department d : departments) {
			System.out.println(d);
		}
	}
	
	/**
	 * toString
	 * 
	 * 	Outputs the College name and the number of departments
	 * 
	 * Inputs: None
	 * 
	 * Outputs:  A formatted string of characters including the college name and the number of departments
	 * 
	 * ReturnValue: a string containing the college name and the number of departments
	 * 
	 */
	public String toString(){
		return String.format("%-30s %-25s", colName,  departments.size());
	}
	
	
	/**
	 * Menu to edit college attributes
	 * 
	 * Inputs: none
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 */
	public void colMenu() {
		int choice = 0;
		
		do{
			System.out.println("1. Add a Department \n2. Delete Department"
					+ " \n3. Print Departments"
					+ "\n4. Edit Department"
					+ " Menu\n5. Exit");
			String option_s = in.nextLine();
			
			choice = validator.validate_int(option_s);
			
			
			if(choice == 1){
				addDep();
			}else if(choice == 2){
				delDep();
			}else if(choice == 3){
				displayDeps();
			}else if(choice == 4){
				editDepMenu();
			}else if(choice == 5){
				break;
			}else {
				System.out.println("Not a valid input, going back to menu");
			}
	
		}while(choice != 5);
	}

}

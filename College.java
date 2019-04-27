package diyUniversity;

import java.util.List;

public class College {
	
	/**
	 * A class for representing a college in the university
	 */
	
	private String colName;
	private List<Department> departments;
	private int numDep;
	private Employee dean;
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
	College() {}
	
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
	College(String colName, List<Department> departments, int numDep, Employee dean) {
		this.colName = colName;
		this.departments = departments;
		this.numDep = numDep;
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
	public Employee getDean() {
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
	public void setDean(Employee dean) {
		this.dean = dean;
	}
	
	
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
	public void addDep(Department dep) {
		departments.add(dep);
		numDep++;
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
	public void delDep(Department dep) {
		departments.remove(dep);
		numDep--;
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
		for (Department d : departments) {
			System.out.println(d);
		}
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
		System.out.println("1. Create College\n 2. Add Department \n 3. Remove Department \n 4. View Departments \5. Exit");
		//IDK IF I NEED TO DO A DO WHILE HERE OR IF WE DO THAT IN MAIN! 
	}

}

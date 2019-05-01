import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class University {
	Scanner in = new Scanner(System.in);
	/**
	 * A class for representing a different
	 */
	
	private String uniName;
	private List<College> colleges;
	private TreeMap<Integer, Person> people;
	private int numCol;
	/**
	 * Default constructor method
	 * 
	 * Inputs: none
	 * 
	 * Outputs: none
	 * 
	 * Return Value: the University
	 * 
	 * Exception: none
	 */
	University() {}
	
	/**
	 * Loaded constructor method
	 * 
	 * Inputs:
	 *	uniName - name of the university
	 *	
	 * Output: none
	 * 
	 * Return Value: the University
	 * 
	 * Exception: none
	 */
	University(String uniName, List<College> colleges, TreeMap<Integer, Person> people,int numCol) {
		this.uniName = uniName;
		this.colleges = new ArrayList<College>(colleges);
		this.people = new TreeMap<Integer, Person>(people);
		this.numCol = numCol;
	}
	
	/**
	 * Gets university name 
	 * 
	 * Inputs: none
	 * 
	 * Outputs: 
	 *	uniName - name of the university
	 *
	 * Return Value:
	 *	@return - name of university (String)
	 *
	 * Exception: none
	 */
	public String getUniName() {
		return uniName;
	}
	
	/**
	 * Sets university name
	 * 
	 * Inputs:
	 * 	colName - name of the university
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 */
	public void setUniName(String uniName) {
		this.uniName = uniName;
	}
	
	/**
	 * Gets number of colleges in the university
	 * 
	 * Inputs: none
	 * 
	 * Outputs: 
	 *	numCol - number of colleges
	 *
	 * Return Value:
	 *	@return - number of colleges (int)
	 *
	 * Exception: none
	 */
	public int getNumCol() {
		return numCol;
	}
	
	/**
	 * Sets number of colleges
	 * 
	 * Inputs:
	 * 	numCol - number of colleges in the university
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 */
	public void setNumCol(int numCol) {
		this.numCol = numCol;
	}
	
	/**
	 * Adds college to university
	 * 
	 * Inputs: none
	 * 
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: 
	 * 	InvalidParamter - college already exists
	 */
	public void addCol() { //Modified by Juan
		if(numCol == 10){
			System.out.println("Maximum Colleges Reached!");
		}else{
			System.out.print("Enter name of College: ");
			String name = in.nextLine();
			for(College c: colleges){
				if((c.getColName()).equalsIgnoreCase(name)){
					System.out.println("College already exists!");
					return;
				}
			}
			colleges.add(new College(name));
			numCol++;
		}
		return;
	}
	
	/**
	 * Deletes college
	 * 
	 * Inputs:
	 * 	col	- college to be deleted
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception:
	 * 	InvalidParameter - college does not exist
	 */
	public void delCol() {
		if(numCol == 0){
			System.out.println("No Colleges Exist.");
		}else{
			
		}
		//colleges.remove(col);
		numCol--;
	}
	
	/**
	 * Displays the colleges in the university
	 * 
	 * Inputs: none
	 * 	
	 * Outputs: a list of all the colleges in the university
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 */
	public void displayCols() {
		for (College c : colleges) {
			System.out.println(c);
		}
	}
	
	/**
	 * Menu to edit university attributes
	 * 
	 * Inputs: none
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 */
	public void uniMenu() {
		int choice;
		System.out.println("UNIVERSITY MENU \n1. Change University Name\n 2. Add College \n 3. Remove College \n 4. View Colleges \n5. Edit College \n6. Exit");
		choice = in.nextInt();
		
		if(choice == 1){
			System.out.print("Enter new name: ");
			this.uniName = in.next();
		}else if(choice == 2){
			addCol();
		}else if(choice == 3){
			delCol();
		}
		
		//IDK IF I NEED TO DO A DO WHILE HERE OR IF WE DO THAT IN MAIN! 
	}

	public Person findPerson(int id) {
		for(Map.Entry<Integer, Person> entry: people.entrySet()){
			if(entry.getKey() == id){
					return entry.getValue();
			}
		}
		System.out.println("Incorrect ID number. Please try again.\n");
		return null;
	}
}
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
		String name = "";
		
		if(numCol == 10){
			System.out.println("Maximum Colleges Reached!");
		}else{
			do{
				System.out.print("Enter College name: ");
				name = in.nextLine();
				if(findCol(name) != null){
					System.out.println("College already exists!");
				}
			}while(findCol(name) != null);
		}
		
		colleges.add(new College(name));
		numCol++;
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
			String name = "";
			
			displayCols();
			
			do{
				System.out.print("Enter name of College to remove: ");
				name = in.nextLine();
				if(findCol(name) == null){
					System.out.println("College does not exist!");
				}
			}while(findCol(name) == null);
			
			colleges.remove(findCol(name));
			numCol--;
		}
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
		System.out.printf("%-31s %-25s", "\nCOLLEGE", "NO. OF DEPARTMENTS");
		System.out.print("\n");
		for (College c : colleges) {
			System.out.println(c);
		}
	}
	
	public void changeColName(College c){
		String name = "";
		
		do{
			System.out.println("Enter new College name: ");
			name = in.nextLine();
			if(findCol(name) != null){
				System.out.println("College already exists!");
			}
		}while(findCol(name) != null);
		
		c.setColName(name);
		
	}
	
	public void changeDean(College c){
		int id;

		displayEmps();

		do{
			System.out.print("Enter employee ID: ");
			id = Integer.parseInt(in.nextLine());
		}while(findPerson(id) == null || findPerson(id) instanceof Student || isDean(id) == true);

		c.setDean(findPerson(id));
		
	}

	public boolean isDean(int id){
		for(College col: colleges){
			if(col.getDean() == null){
				
			}else if(col.getDean().getID() == findPerson(id).getID()){
				System.out.println("Employee is already dean of " + col.getColName() + "!");
				return true;
			}
		}
		return false;
	}
	
	public void addPerson(){
		int choice;
		do{
			System.out.print("\n1. Add a Student"
					+ "\n2. Add a Professor"
					+ "\n3. Add a Admin"
					+ "\n4. Add a Employee"
					+ "\n5. Exit"
					+ "\nEnter here: ");
			choice = Integer.parseInt(in.nextLine());
			
			if(choice == 1){
				Student s = new Student();
				
				Random r = new Random();
				int Low = 0;
				
				int High = 999;
				
				int id = r.nextInt(High-Low) + Low;
				
				s.createStud(id);
				
			}else if(choice == 2){
				
			}else if(choice == 3){
				
			}else if(choice == 4){
				
			}else if(choice == 5){
		
			}
		}while(choice != 5);
			
	}
	
	public void removePerson(){
		
	}
	
	public void editPerson(){
		
	}
	
	public College findCol(String name){
		for(College c: colleges){
			if(c.getColName().equalsIgnoreCase(name)){
				return c;
			}
		}
		return null;
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
	
	public void displayStuds(){
		System.out.printf("%-10s %-15s %-15s %-5s", "ID", "FIRST NAME", "LAST NAME", "MIDDLE INITIAL\n");
		for(Map.Entry<Integer, Person> entry: people.entrySet()){
			if(entry.getValue() instanceof Student){
				System.out.println(entry.getValue());
			}
		}
	}
	
	public void displayAdmins(){
		System.out.printf("%-10s %-15s %-15s %-19s %-14s %-10s", "ID", "FIRST NAME", "LAST NAME", "MIDDLE INITIAL", "SALARY\n");
		for(Map.Entry<Integer, Person> entry: people.entrySet()){
			if(entry.getValue() instanceof Admin){
				System.out.println(entry.getValue());
			}
		}
	}
	
	public void displayProfs(){
		System.out.printf("%-10s %-15s %-15s %-19s %-5s", "ID", "FIRST NAME", "LAST NAME", "MIDDLE INITIAL", "SALARY");
		System.out.println("");
		for(Map.Entry<Integer, Person> entry: people.entrySet()){
			if(entry.getValue() instanceof Professor){
				System.out.println(entry.getValue());
			}
		}
	}
	
	public void displayEmps(){
		System.out.printf("%-10s %-15s %-15s %-19s %-14s", "ID", "FIRST NAME", "LAST NAME", "MIDDLE INITIAL", "SALARY");
		System.out.println("");
		for(Map.Entry<Integer, Person> entry: people.entrySet()){
			if(entry.getValue() instanceof Employee){
				System.out.println(entry.getValue());
			}
		}
	}
	
	public void peopleMenu(){
		int choice;
		do{
			System.out.print("\nPEOPLE MENU "
					+ "\n1. Add a Person"
					+ "\n2. Remove a Person"
					+ "\n3. View Students"
					+ "\n4. View Employees"
					+ "\n5. Edit a Person"
					+ "\n6. Exit"
					+ "\nEnter here: ");
			choice = Integer.parseInt(in.nextLine());
			
			if(choice == 1){
				addPerson();
			}else if(choice == 2){
				removePerson();
			}else if(choice == 3){
				displayStuds();
			}else if(choice == 4){
				displayEmps();
			}else if(choice == 5){
				editPerson();
			}
		}while(choice != 5);
			
	}
	
	public void collegeMenu(){
		int choice;
		do{
			System.out.print("\nCOLLEGE MENU "
					+ "\n1. Add a College"
					+ "\n2. Remove a College"
					+ "\n3. View Colleges"
					+ "\n4. Edit College"
					+ "\n5. Exit"
					+ "\nEnter here: ");
			choice = Integer.parseInt(in.nextLine());
			if(choice == 1){
				addCol();
			}else if(choice == 2){
				delCol();
			}else if(choice == 3){
				displayCols();
			}else if(choice == 4){
				editMenu();	
			}
		}while(choice != 5);
	}

	public void editMenu(){
		String name;
		int choice;
		
		displayCols();

		do{
			System.out.print("Enter name of College to edit: ");
			name = in.nextLine();
			if(findCol(name) == null){
				System.out.println("College does not exist!");
			}
		}while(findCol(name) == null);
		
		College c = findCol(name);
		
		do{
			System.out.print("\n" + c.getColName() + " EDIT MENU "
					+ "\n1. Change Dean"
					+ "\n2. Change College Name"
					+ "\n3. Department Menu"
					+ "\n4. Exit"
					+ "\nEnter here: ");
			choice = Integer.parseInt(in.nextLine());
			if(choice == 1){
				changeDean(c);
			}else if(choice == 2){
				changeColName(c);
			}else if(choice == 3){
				c.colMenu();
			}else if(choice == 4){
				return;
			}
		}while(choice != 4);
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

		do{
			System.out.print("\nUNIVERSITY MENU "
					+ "\n1. Change University Name"
					+ "\n2. College Menu "
					+ "\n3. People Menu"
					+ "\n4. Exit"
					+ "\nEnter here: ");
			choice = Integer.parseInt(in.nextLine());

			if(choice == 1){
				System.out.print("Enter new name: ");
				this.uniName = in.nextLine();
			}else if(choice == 2){
				collegeMenu();
			}else if(choice == 3){
				peopleMenu();
			}
		}while(choice != 4);
		
		
	}
	
}
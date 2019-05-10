import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class University {
	Scanner in = new Scanner(System.in);
	Validation validator = new Validation();
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
	University(String uniName, List<College> colleges, TreeMap<Integer, Person> people) {
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
				name = validator.validateLength(name);
				if(findCol(name) != null){
					System.out.println("College already exists!");
				}
			}while(findCol(name) != null);
		}
		
		System.out.println("College of " + name + " added!");
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
		if(colleges.size() == 0){
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
			
			System.out.println("College of " + name + " deleted!");
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
			name = validator.validateLength(name);
			if(findCol(name) != null){
				System.out.println("College already exists!");
			}
		}while(findCol(name) != null);
		
		System.out.println("College name changed to: " + name);
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
		System.out.println("Dean changed to: " + findPerson(id).getFirstName() + " " + findPerson(id).getLastName());
		
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
	
	public boolean isChair(int id){
		//displayDep();
		for (College c:this.colleges) {
			for (Department d:c.getDepartments()) {
				if(d.getChair().getID()==id)
					return true;
			}
		}
		return false;
	}
	
	public void changeChair (int id) {
		College temp;
		if(!isChair(id)) {
			this.displayCols();
			System.out.println("In what college will the new Chair be placed");
			String _college =in.nextLine();
			while(findCol(_college)==null&&!_college.equalsIgnoreCase("exit")) {
				System.out.println("The college does not belong to the university, try again or input exit");
				_college=in.nextLine();
			}
			if (_college.equalsIgnoreCase("exit"))
				return;
			temp=findCol(_college);
			temp.displayDeps();
			System.out.println("In what Department will the new Chair be placed");
			String _department =in.nextLine();
			
			while(temp.findDep(_department)==null&&!_department.equalsIgnoreCase("exit")) {
				System.out.println("The department does not belong to the university, try again or input exit");
				_department=in.nextLine();
			}
			if (_department.equalsIgnoreCase("exit"))
				return;
			Department temp_dep=temp.findDep(_department);
			Employee Chair= (Employee) findPerson(id);
			temp_dep.setChair(Chair);
		}
	}
	
	public void addPerson(){
		int choice;
		do{
			System.out.print("\n1. Add a Student"
					+ "\n2. Add a Professor"
//					+ "\n3. Add a Admin"
					+ "\n3. Add a Employee"
					+ "\n4. Exit"
					+ "\nEnter here: ");
			choice = Integer.parseInt(in.nextLine());
			
			if(choice == 1){
				Student	s= stud();
				people.put(s.getID(), s);

			}else if(choice == 2){
				Professor p = prof();
				people.put(p.getID(), p);
				
			}else if(choice == 3){
				Employee e = Employ();
				people.put(e.getID(), e);
			}
		}while(choice != 5);
			
	}
	
	public void addAdmin() {
		Admin a = admin();
		people.put(a.getID(), a);
	}

	
	public Employee Employ() {
        Employee e = new Employee();
		
		Random r = new Random();
		int Low = 0;
		
		int High = 999;
		
		int id = r.nextInt(High-Low) + Low;
		
		id = idCheck(id);
		
		e.createPerson(id);
		
		return e;		
		
	}
	
	public Admin admin() {
        Admin a = new Admin();
		
		Random r = new Random();
		int Low = 0;
		
		int High = 999;
		
		int id = r.nextInt(High-Low) + Low;
		
		id = idCheck(id);
		
		a.createPerson(id);
		
		return a;		
		
	}
	
	
	public Professor prof() {
        Professor p = new Professor();
		
		Random r = new Random();
		int Low = 0;
		
		int High = 999;
		
		int id = r.nextInt(High-Low) + Low;
		
		id = idCheck(id);
		
		p.createPerson(id);
		
		return p;		
	}

	public Student stud(){
		Student s = new Student();
		
		Random r = new Random();
		int Low = 0;
		
		int High = 999;
		
		int id = r.nextInt(High-Low) + Low;
		
		id = idCheck(id);
		
		s.createPerson(id);
		
		return s;		
	}
	
	public int idCheck(int id){
		while(people.containsKey(id))
		{
			Random r = new Random();
			int Low = 0;
			
			int High = 999;
			
			id = r.nextInt(High-Low) + Low;
		}
		return id;
	}
	
	public boolean timeConflict(Professor p, Course c){
		if(p.getSchedule() == null){
			return false;
		}
		for (Course pCo : p.getSchedule()) {
			if (pCo.getStartTime().equals(c.getStartTime()) && pCo.getEndTime().equals(c.getStartTime()) 
					&& pCo.getLocation().equals(c.getLocation()) && pCo.getSemester().equals(c.getSemester())) {
				return true;
			}
		}
		return false;
	}
	
	public void removePerson(){
		int choice;
		int ID;
		Person p;
		do{
			System.out.print("\n1. Delete a Student"
					+ "\n2. Delete a Professor"
					+ "\n3. Delete a Admin"
					+ "\n4. Delete a Employee"
					+ "\n5. Exit"
					+ "\nEnter here: ");
			choice = Integer.parseInt(in.nextLine());
			
			if(choice == 1){
				
				displayStuds();
				System.out.println("Enter the ID");
				ID = Integer.parseInt(in.nextLine());
				p = findPerson(ID);
				people.remove(p.getID());
			
				
			}else if(choice == 2){
				
				displayProfs();
				System.out.println("Enter the ID");
				ID = Integer.parseInt(in.nextLine());
				 p = findPerson(ID);
				people.remove(p.getID());
			
			}else if(choice == 3){
			
			
			displayAdmins();
			System.out.println("Enter the ID");
			ID = Integer.parseInt(in.nextLine());
			 p = findPerson(ID);
			people.remove(p.getID());
			
			
			
			}else if(choice == 4){
				
				displayEmps();
				System.out.println("Enter the ID");
				ID = Integer.parseInt(in.nextLine());
				 p = findPerson(ID);
				people.remove(p.getID());
				
			}
		}while(choice != 5);
			
	}
	
	public void editPerson(){
		int choice;
		int ID;
		do{
			System.out.print("\n1. Edit a Student"
					+ "\n2. Edit a Professor"
					+ "\n3. Edit a Admin"
					+ "\n4. Edit a Employee"
					+ "\n5. Exit"
					+ "\nEnter here: ");
			choice = Integer.parseInt(in.nextLine());
			
			if(choice == 1){
				displayStuds();
				System.out.println("Enter the ID");
				ID = Integer.parseInt(in.nextLine());
				findPerson(ID).createPerson(ID);
				
			}else if(choice == 2){
				displayProfs();
				System.out.println("Enter the ID");
				ID = Integer.parseInt(in.nextLine());
				findPerson(ID).createPerson(ID);
			
			}else if(choice == 3){
				displayAdmins();
				System.out.println("Enter the ID");
				ID = Integer.parseInt(in.nextLine());
				findPerson(ID).createPerson(ID);
				
			}else if(choice == 4){
				displayEmps();
				System.out.println("Enter the ID");
				ID = Integer.parseInt(in.nextLine());
				findPerson(ID).createPerson(ID);
				
			}
		}while(choice != 5);
			
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
	
	public void displayAllCourses(){
		for(College c: colleges){
			for(Department d: c.getDepartments()){
				for(Major m: d.getMajors()){
					for(Course cor: m.getCourses()){
						System.out.println(cor);
					}
				}
			}
		}
	}
	
	public void displayAllMajors(){
		for(College c: colleges){
			System.out.println("\nMajors in College of " + c.getColName());
			for(Department d: c.getDepartments()){
				for(Major m: d.getMajors()){
					System.out.println(m);
				}
			}
		}
	}
	
	public Major findMajor(String name){
		for(College c: colleges){
			for(Department d: c.getDepartments()){
				for(Major m: d.getMajors()){
					if(m.getMjrName().equalsIgnoreCase(name)){
						return m;
					}
				}
			}
		}
		return null;
	}
	
	public boolean courseExists(String name){
		for(College c: colleges){
			for(Department d: c.getDepartments()){
				for(Major m: d.getMajors()){
					for(Course cor: m.getCourses()){
						if(cor.getName().equalsIgnoreCase(name)){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public Course findCourse(String name){
		for(College c: colleges){
			for(Department d: c.getDepartments()){
				for(Major m: d.getMajors()){
					for(Course cor: m.getCourses()){
						if(cor.getName().equalsIgnoreCase(name)){
							return cor;
						}
					}
				}
			}
		}
		return null;
	}
	
	public void assignProf(){
		String name;
		int id;
		Professor p;
		Course c;
		
		displayAllCourses();
		do{
		do{
			System.out.println("Enter course name:");
			name = in.nextLine();
		}while(findCourse(name) == null || findCourse(name).getProf() != null);
		
		c = findCourse(name);
		
		do{
			System.out.print("Enter employee ID: ");
			id = Integer.parseInt(in.nextLine());
		}while(findPerson(id) == null || !(findPerson(id) instanceof Professor) || isDean(id) == true);
		
		p = (Professor) findPerson(id);
		
	}while(timeConflict(p, c) == false);
		
		p.addSession(c);
		c.addProf(p);
		
	}
	
	public void isPaid(Student _student) {
		 if (_student.tuitionPaid())
		  System.out.println("The student has paid the tuition");
		 else
		  System.out.println("The student has not paid the tuition");
		}
	
	public void checkTuition(){
		displayStuds();
		   System.out.println("Enter the ID of the student you want to check");
		   String student_ID=in.nextLine();
		   int student = validator.validate_int(student_ID);
		   //Validate??
		   while (findPerson(student)==null) {
		    
		    System.out.println("The ID does not belong to any student try again");
		    student_ID=in.nextLine();
		    student= validator.validate_int(student_ID);
		   }
		   Student std= (Student)findPerson(student);
		   isPaid(std);
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
					+ "\n6. Assign Chair"
					+ "\n7. Check Student Tuition"
					+ "\n8. Set Student grade"
					+ "\n9. Assign Professor"
					+ "\n10. Exit"
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
			}else if(choice == 6){
				int inp;
				displayEmps();
				do{
					System.out.print("Enter ID of employee: ");
					inp = Integer.parseInt(in.nextLine());
				}while(findPerson(inp) == null);
				changeChair(findPerson(inp).getID());
				System.out.println("Chair assigned!");
			}else if(choice == 7){
				checkTuition();
			}else if (choice==8){
			
			displayStuds();
				System.out.println("Enter the ID of the student you want to modify the grade of");
				String student_ID=in.nextLine();
				int student = validator.validate_int(student_ID);
				while (findPerson(student)==null) {
					
					System.out.println("The ID does not belong to any student try again");
					student_ID=in.nextLine();
					student=validator.validate_int(student_ID);
				}
				Student std= (Student)findPerson(student);
				setGrade(std);
				
			
			}else if(choice == 9){
				assignProf();
			}
			
		}while(choice != 10);
			
	}
	public void setGrade(Student _student) {
		_student.viewCoursesTaken();
		System.out.println("Enter the name of the course whose grade you want to modify");
		String course=in.nextLine();
		System.out.println("Enter the grade you want to give the student (A/B/C/D/F)");
		String grade=in.nextLine();
		while ((!grade.equals("A"))&&(!grade.equals("B"))&&(!grade.equals("C"))&&(!grade.equals("D"))&&(!grade.equals("F"))) {
			System.out.println("The grade inputted must be (A/B/C/D/F), try again");
			grade=in.nextLine();
		}
		course+= ": "+grade;
		
		_student.setCourse(course);
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
		}while(choice != 5);
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
				String g_uniName = in.nextLine();
				g_uniName = validator.validateLength(g_uniName);
				
				this.uniName = g_uniName;
				
				System.out.println("University Named Changed to: " + this.uniName);
			
			
			}else if(choice == 2){
				collegeMenu();
			}else if(choice == 3){
				peopleMenu();
			}
		}while(choice != 4);
		
		
	}
	
	
}

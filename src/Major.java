import java.util.List;
import java.util.Scanner;

class Major {
	/* A class for a major in a department */
	
	private String mjrName;
	private List<Course> courses;


	public Major(String mjrName){
		this.mjrName = mjrName;
	}
	/*
		Major
			Constructor
	
		Inputs:
			mjrName - name of major
			Courses - courses that the major 
			numCor - number of courses major has
	
		Outputs: None
	
		Return Value: The Major
	
		Exception: None
	*/
	public Major(String mjrName, List<Course> courses) {
		this.mjrName = mjrName;
		this.courses = courses;
	}


	/*
	setMjrName 
	Sets the major's name
	
	Inputs: mjrName -  name of major
	
	Outputs: None
	
	Return Value: None
	
	Exception: None
	*/
	public void setMjrName(String mjrName) {
		this.mjrName = mjrName;
	}


	/*
	getMjrName
		gets the major's name
	
	Inputs: None
	
	Outputs: None
	
	Return Value: mjrName -  name of major (String)
	
	Exception: None
	*/
	public String getMjrName() {
		return mjrName;
	}

	
	public List<Course> getCourses(){
		return this.courses;
	}
	
	/*
	addCor
		Adds course
	
	Inputs:
		courseName - name of the course
	
	Outputs:
		None
	
	Return Value:
		None
	
	Exception:
		Invalid Parameter - course already added
	*/
	void addCor() {
		Scanner in = new Scanner(System.in);
		System.out.println("Add Course");
		if (courses.size() < 100) {
			System.out.println("What is the name of the course?"); 
	   		String name = in.nextLine();
	   		for (Course c : courses) 
	   		{
	   			if (c.getName().equals(name)) {
	   				System.out.println("Course Already Added!");
	   				mjrMenu();
	   				break;
	   			}
	   		}
			System.out.println("What is the start time of the course?");
	   		String sTime = in.nextLine();
	   		System.out.println("What is the end time of the course?");
		   	String eTime = in.nextLine();
	   		System.out.println("What is the location of the course?");
	   		String loc = in.nextLine();
	   		System.out.println("What is the semester of the course?");
	   		String sem = in.nextLine();
	   		for (Course c : courses) {
	   			if (c.getStartTime().equals(sTime) && c.getEndTime().equals(eTime) 
	   					&& c.getLocation().equals(loc) && c.getSemester().equals(sem)) {
	   				System.out.println("Time Conflicts Detected! \n Try Again!");
	   				mjrMenu();
	   				break;
	   			}
	   		}
	   		System.out.println("What is the capacity of the course?");
	   		Integer cap = in.nextInt();
	   		courses.add(new Course(name, sTime, eTime, loc, sem, cap));
	   		System.out.println("New Course Added!");
		} else {
			System.out.println("Max Courses Reached!");
		}
		
   		
		//
	}

	/*
	deleteCor
		Deletes course
	
	Inputs:
		courseName - name of the course
		
	Outputs:
		None
	
	Return Value:
		None
	
	Exception:
		Invalid Parameter - courseName is not a valid name
	*/	
	
	/*
	displayCourses
		Display a list of courses
	
	Inputs:
		None
	
	Outputs:
		String list of courses
	
	Return Value:
		None
	
	Exception:
	None 
	*/
	void displayCourses() {
		for (Course c : courses) {
			System.out.println(c.getName());
		}
	}
	
	String deleteCor() {
		Scanner in = new Scanner(System.in);
		displayCourses();
		System.out.println("What course would you like to delete?");
		String input1 = in.nextLine();
		for (Course c : courses) {
			if (c.getName().equals(input1)) {
				courses.remove(c);
				return "Course Removed";
			} 
		}
//		in.close();
		return "Course Not Found!";

   	 }
	
	
   	/*
	ediCourse
	Edits a course from the major
	
	Inputs:  	
	Outputs: None
	
	ReturnValue: None
	
	Exception: ParameterNotIncluded – if the major inputed does not belong the department
   	*/
   	public void editCor(Course c) {
   		String userInput;
   		Scanner in = new Scanner(System.in);
   		do {
   			System.out.println("EDIT COURSE MENU \n ---------------- \n 1. Name  \n 2. Time \n 3. Location \n 4. Semester "
   	   				+ "\n 5. PreRequistes \n 6. Capacity \n 7. Quit");
   	   		userInput = in.nextLine().trim();
   	   		if (userInput.equals("1")) {
   	   			System.out.println("What is the name of the course?"); 
   	   			String name = in.nextLine();
   	   			System.out.println("Old Name: " + c.getName());
   	   			c.setName(name);
   	   			System.out.println("New Name: " + c.getName());
   	   		} else if (userInput.equals("2")) {
   	   			System.out.println("What is the start time of the course?");
   	   			String sTime = in.nextLine();
   	   			System.out.println("What is the end of time of the course?");
   	   			String eTime = in.nextLine();
   	   			Boolean check = true;
   		   		for (Course co : courses) {
   		   			if (co.getStartTime().equals(sTime) && co.getEndTime().equals(eTime)
   		   					&& co.getLocation().equals(c.getLocation()) && co.getSemester().equals(c.getSemester())) {
   		   				check = false;
   		   			}
   		   		}
   		   		if(check) {
   	   	   			System.out.println("Old Start Time: " + c.getStartTime());
   	   	   			c.setStartTime(sTime);
   	   	   			System.out.println("New Start Time: " + c.getStartTime());
	   	   			System.out.println("Old End Time: " + c.getEndTime());
	   	   			c.setEndTime(eTime);
	   	   			System.out.println("New Start Time: " + c.getEndTime());
   		   		} else {
   		   			System.out.println("Time Conflict!");
   		   		}
   
   	   		} else if (userInput.equals("3")) {
   	   			System.out.println("What is the location of the course?");
   	   			String loc = in.nextLine();
   	   			Boolean check = true;
   		   		for (Course co : courses) {
   		   			if (co.getStartTime().equals(c.getStartTime()) && co.getEndTime().equals(c.getEndTime())
   		   					&& co.getLocation().equals(loc) && co.getSemester().equals(c.getSemester())) {
   		   				check = false;
   		   			}
   		   		}
   		   		if(check) {
   	   	   			System.out.println("Old Location: " + c.getLocation());
   	   	   			c.setLocation(loc);
   	   	   			System.out.println("New Location: " + c.getLocation());
   		   		} else {
   		   			System.out.println("Location Conflict!");
   		   		}
   	   		} else if (userInput.equals("4")) {
   	   			System.out.println("What is the semester of the course?");
   	   			String sem = in.next();
   	   			System.out.println("Old Semsester: " + c.getSemester());
   	   			c.setSemester(sem);
   	   			System.out.println("New Semester: " + c.getSemester());
   	   		} else if (userInput.equals("5")) {
   	   			System.out.println("What is the name of the preReq?");
   	   			String preReq = in.nextLine();
   	   			Boolean check = true;
   	   			for(Course co : courses) {
   	   				if(co.getName().equals(preReq)) {
   	   					if (!c.getPre().contains(co)) {
   	   						c.addPrereq(co);
   	   					} 
   	   				}
   	   			}
   	   			if (check) {
   	   				System.out.println("Cannot add pre req!");
   	   			} else {
   	   				System.out.println("Pre Req added!");
   	   			}
   	   		} else if (userInput.equals("6")) {
   	   			System.out.println("What is the capacity of the course?");
   	   			Integer cap = in.nextInt();
   	   			System.out.println("Old Capacity: " + c.getCap());
   	   			c.setCap(cap);
   	   			System.out.println("New Capacity: " + c.getCap());
   	   		} else if(userInput.equals("7")) {
   	   			System.out.println("Exited.");
   	   		}
   		} while(!userInput.equals("7"));
   	}

   	


	
	public String toString() {
		return this.mjrName;}
	
	/*
	mjrMenu
		Display a menu for majors
		
	Inputs: None
	
	Outputs: String displaying majors
	
	Return Value: None
	
	Exceptions: None 
	*/
	void mjrMenu() {
		String input;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("----------------------- \n1. Add Course \n2. Delete Course \n3. Edit Course \n4. Quit");
			input = in.next();
			if (input.equals("1")) {
		   		addCor();
			} else if (input.equals("2")) {
				System.out.println(deleteCor());
			} else if (input.equals("3")) {
				Scanner a = new Scanner(System.in);
				displayCourses();
				System.out.println("What course would you like to edit?");
				String cName = a.nextLine();
				System.out.println(cName);
				Boolean check = false;

				for (Course c : courses) {
					if (c.getName().equals(cName)) {
						check = true;	
						editCor(c);
						break;
					} 
				}
				if (!check) {
					System.out.println("Course not found!");
				}
			} else if (input.equals("4")) {
				System.out.println("Quit");
			} else {
				System.out.println("Invalid Input");
			}
		} while (!input.equals("4"));
	}
	
}

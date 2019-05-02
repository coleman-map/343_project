package diyUniversity;

import java.util.List;

class Major {
	/* A class for a major in a department */
	
	private String mjrName;
	private List<Course> courses;
	private int numCor;


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
	public Major(String mjrName, List<Course> courses, int numCor) {
		this.mjrName = mjrName;
		this.courses = courses;
		this.numCor = numCor;
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


	/*
	getNumCor
		Gets the number of courses
	
	Inputs: None
	
	Outputs: None
	
	Return Value: numCor - number of courses major has (int)
	
	Exception: None
	*/
	int getNumCor(){
		return numCor;
	}



	/*
	setNumCor
		Sets the number of courses
	
	Inputs: numCor - the number of courses a class has
	
	Outputs: None
	
	Return Value: None
	
	Exception: Invalid Parameter - if numCor <= 0
	*/
	void setNumCor(int numCor) {
		this.numCor = numCor;
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
	void addCor(Course course) {
	 	if (numCor < 100 & !courses.contains(course)) {
	 		courses.add(course);
	 		numCor--;
	 		System.out.println("Course Added!");
	 	} else {
	 		System.out.println("Course already exists!");
	 	}
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
	void deleteCor(Course course) {
   		 	if (courses.contains(course)) {
   		 		courses.remove(course);
   		 		numCor--;
   		 		System.out.println("Course Removed!");
   		 	} else {
   		 		System.out.println("Course doesn't exist!");
   		 	}
   	 }
	
   	/*
	ediCourse
	Edits a course from the major
	
	Inputs:  	
	Outputs: None
	
	ReturnValue: None
	
	Exception: ParameterNotIncluded – if the major inputted does not belong the department
   	*/
   	public void editMjr() {
   		//WILL DO AFTER CREATING COURSE CLASS! 
   	}

   	


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
			System.out.println(c);
		}
	}
	
	public String toString() {
		return "hell0";}
	
	/*
	mjrMenu
		Display a menu for majors
		
	Inputs: None
	
	Outputs: String displaying majors
	
	Return Value: None
	
	Exceptions: None 
	*/
	void mjrMenu() {}
	
}



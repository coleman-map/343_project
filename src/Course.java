import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Course {
		/* A class for representing a college course. */


		private String corName, corLocation, corSemester, cStart, cEnd;
		private Professor prof;
		private int cap;
		private List<Course> preReq;
		private List<Student> enrolled;
		private Double cost;

		
		/*
		Course
		Constructor
		Inputs:
		corName - Name of course
		corStartTime - Time when class meets
		corEndTime - Time when class ends
		corLocation - Room and building where class meets
		corSemester – Semester when class is offered
		prof – Professor assigned to teach class
		cap – Maximum number of students that can enroll
		prereq – List of Courses required before taking this course
		enrolled – List of students currently enrolled
		            	
		Outputs: None
		Return Value: the Course
		Exception:
		InvalidStringLength – if string corName exceeds 150 characters
		InvalidTime – if start and end time conflict
		InvalidCoursePrereq – if a course that doesn’t exist is assigned as a prerequisite  
		*/
		Course(String corName, String cStart, String cEnd, String corLocation, String corSemester, Professor prof, int cap,  List<Course> preReq, List<Student> e, Double cost) {
			this.corName = corName;
			this.cStart = cStart;
			this.cEnd = cEnd;
			this.corLocation = corLocation;
			this.corSemester = corSemester;
			this.prof = prof;
			this.cap = cap;
			this.preReq = preReq;
			this.enrolled = e;
			this.cost = cost;
		}
		
		Course(String corName, String cStart, String cEnd, String corLocation, String corSemester, Professor prof, int cap, Double cost) {
			this.corName = corName;
			this.cStart = cStart;
			this.cEnd = cEnd;
			this.corLocation = corLocation;
			this.corSemester = corSemester;
			this.prof = prof;
			this.cap = cap;
			this.preReq = new ArrayList<Course>();
			this.enrolled = new ArrayList<Student>();
			this.cost = cost;
		}
		
		Course(String corName, String cStart, String cEnd, String corLocation, String corSemester, int cap) {
			this.corName = corName;
			this.cStart = cStart;
			this.cEnd = cEnd;
			this.corLocation = corLocation;
			this.corSemester = corSemester;
			this.cap = cap;
		}


		/*
		getName
		Returns course name
		Inputs: 	None
		Outputs:	None
		
		Return Value: corName (String)
		Exception: None
		*/
		public String getName() {
			return corName;
		}


		/*
		getStartTime
		            	Returns course start time
		Inputs:
		            	None
		Outputs:
		            	None
		Return Value:
		            	corStartTime - time class begins(Calendar)
		Exception:
			None
		*/
		public String getStartTime() {
			return cStart;
		}


		/*
		getEndTime
		            	Returns course end time
		Inputs:
		            	None
		Outputs:
		            	None
		Return Value: 
		            	corEndTime - time class ends (Calendar)
		Exception:
			None
		*/
		public String getEndTime() {
			return cEnd;
		}


		/*
		getLocation
		            	Returns course location
		Inputs:
		            	None
		Outputs:
		            	None
		Return Value:
		            	corLocation - location (String)
		Exception:
			None
		*/
		public String getLocation() {
			return corLocation;
		}


		/*
		getSemester
		            	Returns course semester 
		Inputs:
		            	None
		Outputs:
		            	None
		Return Value:
		            	corSemester - semester (String)
		Exception:
			None
		*/
		public String getSemester() {
			return corSemester;
		}



		/*
		getProf
		            	Returns course professor
		Inputs:
		            	None
		Outputs:
		            	None
		Return Value: 
		            	Prof - course professor (Professor)
		Exception:
			None
		*/
		public Professor getProf() {
			return prof;
		}

		/*
		getCap
		            	Returns course maximum enrollment possible
		Inputs:
		            	None
		Outputs:
		            	None
		Return Value:
		            	Cap - max # of enrollment (int)
		Exception:
			None
		*/
		public int getCap() {
			return cap;
		}


		public Double getCost(){
			return this.cost;
		}
		
		public List<Course> getPre() {
			return this.preReq;
		}
		/*
		setName
		            	Sets course name to input value
		Inputs:
		            	name - new course name 
		Outputs:
		            	None
		Return Value:
		            	None
		Exception:
			InvalidStringLength - if string exceeds 150 characters
		*/
		public void setName(String name) {
			this.corName = name;
		}


		/*
		setStartTime
		            	Sets course start time to new values via Calander.changeDate() function
		Inputs:
		            	None 
		Outputs:
		            	None
		Return Value:
		            	None
		Exception:
			None
		*/
		public void setStartTime(String cStart) {
			this.cStart = cStart;
		}


		/*
		setEndTime
		            	Sets course end time to new values via Calander.changeDate() function
		Inputs:
		            	None 
		Outputs:
		            	None
		Return Value:
		            	None
		Exception:
			None
		*/
		public void setEndTime(String cEnd) {
			this.cEnd = cEnd;
		}

		/*
		setLocation
		            	Sets course location to input value
		Inputs:
		            	loc - new course location 
		Outputs:
		            	None
		Return Value:
		            	None
		Exception:
			InvalidStringLength - if string exceeds 150 characters
		*/
		public void setLocation(String loc) {
			this.corLocation = loc;
		}


		/*
		setSemester
		            	Sets course semester to input value
		Inputs:
		            	sem - new course semester 
		Outputs:
		            	None
		Return Value:
		            	None
		Exception:
			InvalidStringLength - if string exceeds 150 characters
		*/
		public void setSemester(String sem) {
			this.corSemester = sem;
		}


		/*
		setProf
		            	Sets course professor to input value
		Inputs:
		            	p - new course profesor 
		Outputs:
		            	None
		Return Value:
		            	None
		Exception:
			InvalidObjectDoesNotExist - if professor input does not exist in database
		*/
		public void setProf(Professor p ) {
			this.prof = p;
		}


		/*
		setCap
		            	Sets course cap to input value
		Inputs:
		            	cap - new course cap 
		Outputs:
		            	None
		Return Value:
		            	None
		Exception:
			None
		*/
		public void setCap(int cap) {
			this.cap = cap;
		}

		
		public void setCost(Double cost){
			this.cost = cost;
		}

		/*
		addPrereq
		            	Add another course as a prerequisite 
		Inputs:
		            	newPre - new course to add to prereq list 
		Outputs:
		            	None
		Return Value:
		            	None
		Exception:
			InvalidObjectDoesNotExist - if course does not exist in database
		*/
		public void addPrereq(Course newPre) {
			
			if (!preReq.contains(newPre)) {
				preReq.add(newPre);
				System.out.println("Pre-req added!");
			} else {
				System.out.println("Pre-req already in place");
			}
						
		}


		/*
		removePrereq
		            	Remove a course as a prerequisite 
		Inputs:
		            	choice - number of course to remove 
		Outputs:
		            	Display list of current prerequisites 
		Return Value:
		            	None
		Exception:
			ListEmpty - if the list is empty
		*/
		void removePrereq(Course pre){
			if (preReq.contains(pre)) {
				preReq.remove(pre);
				System.out.println("Pre-req removed!");
			} else {
				System.out.println("Pre-req not there");
			}
		}


		/*
		displayPrereq
		            	Display current list of prereqs for course 
		Inputs:
		            	None
		Outputs:
		            	List of prerequisites 
		Return Value:
		            	None
		Exception:
			ListEmpty - if the list is empty
		*/
		void displayPrereq(){
			for (Course p : preReq) {
				System.out.println(p.getName());
			}
		}


		/*
		displayEnrolled
		            	Display current list of students enrolled in course 
		Inputs:
		            	None
		Outputs:
		            	List of students enrolled
		Return Value:
		            	None
		Exception:
			ListEmpty - if the list is empty
		*/
		void displayEnrolled(){
			for(Student s : enrolled) {
				System.out.println(s);
			}
		}


		/*
		corMenu
		            	Menu used by admin to edit individual aspects of a course
		Inputs:
		            	None
		Outputs:
		            	Various menu options to edit the course number 1 - 7
		Return Value:
		            	None
		Exception:
			OutofBounds - if number inputted is not between 1 and 7'
			
					corName - Name of course
		corStartTime - Time when class meets
		corEndTime - Time when class ends
		corLocation - Room and building where class meets
		corSemester – Semester when class is offered
		prof – Professor assigned to teach class
		cap – Maximum number of students that can enroll
		prereq – List of Courses required before taking this course
		enrolled – List of students currently enrolled
		*/
//		void corMenu(){
//		
//		}
		
	
		
		public Boolean addStudent(Student s){
			if(s.getCurrentUnits() == 20 || enrolled.size() == cap){
				return false;
			}else if(timeConflict(s) == true){
				return true;
			}else{
				for(String sCor: s.getCoursesTaken()){
					if(preReq.contains(sCor)){

					}else{
						return false;
					}
				}
				enrolled.add(s);
				cap--;
				return true;
				
			}
		}
		
		public void addProf(Professor p){
			this.prof = p;
		}
		
		public void dropStudent(Student s){
			for(Iterator<Student> iter = enrolled.iterator(); iter.hasNext();){
				Student stud = iter.next();
				if(stud.getID() == s.getID()){
					iter.remove();
				}
			}
		}
		
		public boolean timeConflict(Student s){
			for (Course sCor : s.getCurrentSchedule()) {
		   			if (sCor.getStartTime().equals(cStart) && sCor.getEndTime().equals(cEnd)
		   					&& sCor.getLocation().equals(corLocation) && sCor.getSemester().equals(corSemester)) {
		   				return true;
		   			}
		   		}
			return false;
		}

		public String toString(){
			return String.format("%-15s", corName);
		}
}

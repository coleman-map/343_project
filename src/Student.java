package diyUniversity;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	
	
	private List<String> coursesTaken;
	private List<Course> currentSchedule;
	private Boolean paidTuition;
	private double tuition;
	private Major major;
	private int currentUnits;
	
	/**
	 * Default constructor
	 */
	public Student(){
		
	}
	
	/**
	 * Overloaded constructor
	 * @param firstName
	 * @param lastName
	 * @param midIntial
	 * @param ID
	 */
	public Student(String firstName, String lastName, String midIntial, int ID) {
		super(firstName, lastName, midIntial, ID);
		this.setCoursesTaken(new ArrayList<String>());
		this.setCurrentSchedule(new ArrayList<Course>());
		this.paidTuition = false;
		this.tuition = 0;
		this.major = null;
		this.currentUnits = 0;
		
	}
	
	
	/**
	 * Overloaded constructor
	 * @param firstName
	 * @param lastName
	 * @param midIntial
	 * @param ID
	 * @param coursesTaken
	 * @param currentSchedule
	 * @param tuitionStatus
	 * @param tuition
	 * @param major
	 */
	public Student(String firstName, String lastName, String midIntial, int ID, List<String> 
					coursesTaken,List<Course> currentSchedule, Boolean tuitionStatus, double tuition, 
					Major major) 
	{
		super(firstName, lastName, midIntial, ID);
		this.setCoursesTaken(coursesTaken);
		this.setCurrentSchedule(currentSchedule);
		this.paidTuition = tuitionStatus;
		this.tuition = tuition;
		this.major = major;
		
	}
	
	
	/**
	 * Returns a course the student has passed
	 * @param course_name
	 * @return Course
	 */
	public String getCourse(String course_name) {
		return this.coursesTaken.get(this.coursesTaken.indexOf(course_name));
	}
	
	/**
	 * Adds a course to the coursesTaken list
	 * @param _course_name
	 */
	public void setCourse(String _course_name) {
		String course=_course_name.substring(0,_course_name.length()-3);
		
		this.coursesTaken.set(this.coursesTaken.indexOf(course), _course_name);
	}
	
	
	/**
	 * Fills coursesTaken list with whole new values of type String
	 * @param coursesTaken
	 */
	public void setCoursesTaken(List<String> coursesTaken) {
		this.coursesTaken = new ArrayList<String>(coursesTaken);
	}
	
	/**
	 * Fills currentSchedule list with whole new values of type Course
	 * @param currentSchedule
	 */
	public void setCurrentSchedule(List<Course> currentSchedule ){
		this.currentSchedule = new ArrayList<Course>(currentSchedule);
	}

	/**
	 * Adds a course to currentSchedule list
	 * @param session
	 */
	public void addSession(Course session){
		this.currentSchedule.add(session);
		this.tuition += session.getCost();
	}
	
	/**
	 * Removes a course form currentSchedle list
	 * @param session
	 */
	public void dropSession(Course session){
		List<Course> toRemove = new ArrayList<Course>();
		
		for(Course cor: currentSchedule){
			if(cor.getName().equalsIgnoreCase(session.getName())){
				toRemove.add(cor);
				System.out.println("Course Removed!");
			}
		}
		
		currentSchedule.removeAll(toRemove);
		
		this.tuition -= session.getCost();
	}
	
	/**
	 * Checks if tuition is paid
	 * @return
	 */
	public boolean tuitionPaid(){
		 return this.paidTuition;
		}
	
	/**
	 * Allows student to pay tuition
	 */
	public void payTuition(){
		double pay;
		
		System.out.println("Enter payment: $ ");
		pay = Double.parseDouble(in.nextLine());
		
		this.tuition -= pay;
		if(this.tuition <= 0){
			this.paidTuition = true;
		}
		
		System.out.println("You owe: $" + this.tuition);
	}
	
	/**
	 * Prints courseTaken list
	 */
	public void viewCoursesTaken(){
		for(int i =0; i < coursesTaken.size(); i++ ){
			System.out.println(coursesTaken.get(i));
		}
	}
	
	/**
	 * Prints currentSchedule list
	 */
	public void viewCurrentSchedule(){
		for(int i =0; i < currentSchedule.size(); i++ ){
			System.out.println(currentSchedule.get(i));
		}
	}
	
	/**
	 * Gets coursesTaken list
	 * @return List of Strings
	 */
	public List<String> getCoursesTaken(){
		return this.coursesTaken;
	}
	
	/**
	 * Gets currentSchedule list
	 * @return List of Courses
	 */
	public List<Course> getCurrentSchedule(){
		return this.currentSchedule;
	}
	
	/**
	 * Calculates current enrolled units
	 */
	public void calcCurrentUnits(){
		for(Course c: currentSchedule){
			this.currentUnits += 3;
		}
	}
	
	/**
	 * Edits major
	 * @param major
	 */
	public void setMajor(Major major){
		this.major = major;
	}
	
	/**
	 * Gets major 
	 * @return
	 */
	public Major getMajor(){
		return this.major;
		
	}
	
	/**
	 * Gets current units enrolled in
	 * @return currentUnits
	 */
	public int getCurrentUnits(){
		return this.currentUnits;
	}
	
	/**
	 * Allows user to edit attributes
	 * @param id
	 */
	public void createStud(int id) {
		super.createPerson(id);
	}
	


}

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	
	
	private List<String> coursesTaken;
	private List<Course> currentSchedule;
	private Boolean paidTuition;
	private double tuition;
	private Major major;
	private int currentUnits;
	
	
	public Student(){
		
	}
	
	public Student(String firstName, String lastName, String midIntial, int ID) {
		super(firstName, lastName, midIntial, ID);
		this.setCoursesTaken(new ArrayList<String>());
		this.setCurrentSchedule(new ArrayList<Course>());
		this.paidTuition = false;
		this.tuition = 0;
		this.major = null;
		this.currentUnits = 0;
		
	}
	
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
	
	
	
	
	public void setCoursesTaken(List<String> coursesTaken) {
		this.coursesTaken = new ArrayList<String>(coursesTaken);
	}
	
	
	public void setCurrentSchedule(List<Course> currentSchedule ){
		this.currentSchedule = new ArrayList<Course>(currentSchedule);
	}

	public void addSession(Course session){
		this.currentSchedule.add(session);
		this.tuition += session.getCost();
	}
	
	public void dropSession(Course session){
		for(Course cor: currentSchedule){
			if(cor.getName().equalsIgnoreCase(session.getName())){
				this.currentSchedule.remove(cor);
			}
		}
		this.tuition -= session.getCost();
	}
	
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
	
	public void viewCoursesTaken(){
		for(int i =0; i < coursesTaken.size(); i++ ){
			System.out.println(coursesTaken.get(i));
		}
	}
	
	public void viewCurrentSchedule(){
		for(int i =0; i < currentSchedule.size(); i++ ){
			System.out.println(currentSchedule.get(i));
		}
	}
	
	public List<String> getCoursesTaken(){
		return this.coursesTaken;
	}
	
	public void calcCurrentUnits(){
		for(Course c: currentSchedule){
			this.currentUnits += 3;
		}
	}
	
	public void setMajor(Major major){
		this.major = major;
	}
	
	public Major getMajor(){
		return this.major;
		
	}
	
	public int getCurrentUnits(){
		return this.currentUnits;
	}
	
	public void createStud(int id) {
		super.createPerson(id);
	}
	


}

import java.util.List;

public class Student extends Person {
	
	
	private List<String> coursesTaken;
	private List<String> currentSchedule;
	private Boolean paidTuition;
	private double tuition;
	private Major major;
	private int currentUnits;
	
	
	public Student(){
		
	}
	
	public Student(String firstName, String lastName, String midIntial, int ID) {
		super(firstName, lastName, midIntial, ID);
		this.setCoursesTaken(null);
		this.setCurrentSchedule(null);
		this.paidTuition = false;
		this.tuition = 0;
		this.major = null;
		this.currentUnits = 0;
		
	}
	
	public Student(String firstName, String lastName, String midIntial, int ID, List<String> 
					coursesTaken,List<String> currentSchedule, Boolean tuitionStatus, double tuition, 
					Major major, int currentUnits) 
	{
		super(firstName, lastName, midIntial, ID);
		this.setCoursesTaken(coursesTaken);
		this.setCurrentSchedule(currentSchedule);
		this.paidTuition = tuitionStatus;
		this.tuition = tuition;
		this.major = major;
		this.currentUnits = currentUnits;
		
	}
	
	
	
	
	public void setCoursesTaken(List<String> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}
	
	
	public void setCurrentSchedule(List<String> currentSchedule ){
		this.currentSchedule = currentSchedule;
	}

	public void addSession(String session){
		this.currentSchedule.add(session);
	}
	
	public void dropSession(String sessionDropped){
		while(this.currentSchedule.remove(sessionDropped));
	}
	
	public void payTuition(){
		this.paidTuition = true;
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
	
	public void setCurrentUnits(int currentUnits){
		this.currentUnits = currentUnits;
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

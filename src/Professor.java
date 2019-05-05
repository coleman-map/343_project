import java.util.ArrayList;
import java.util.List;

public class Professor extends Employee{

	private ArrayList<Course> schedule;
	
	
	public Professor(){
		
	}
	
	public Professor(String firstName, String lastName, String midIntial, int ID, double salary) {
		super(firstName, lastName, midIntial, ID, salary);
		
		
	}
	
	public Professor(String firstName, String lastName, String midIntial, int ID, double salary, ArrayList<Course> schedule) {
		super(firstName, lastName, midIntial, ID, salary);
		this.setSchedule(schedule);
		
	}
	
	

	/**
	 * Gets schedule
	 * @return the schedule
	 */
	public ArrayList<Course> getSchedule() {
		return schedule;
	}

	/**
	 * Sets schedule
	 * @param schedule the schedule to set
	 */
	public void setSchedule(ArrayList<Course> schedule) {
		this.schedule = new ArrayList<Course>(schedule);
	}
	
	/**
	 * Adds session
	 * @param session - session you are adding
	 */
	public void addSession(Course session){
		this.schedule.add(session);
	}
	
	/**
	 * Drops session
	 * @param session
	 */
	public void dropSession(String session){
		while(this.schedule.remove(session));  //removes all occurence of string
	}									   //or schedule.remove(session); 
												//removes the first String object that is equal to the
        										// String represented by this literal

	public void displaySchedule(){
		for(Course c: schedule){
			System.out.println(c);
		}
	}

}
import java.util.List;

public class Professor extends Employee{

	private List<String> schedule;
	
	
	public Professor(String firstName, String lastName, String midIntial, int ID, double salary) {
		super(firstName, lastName, midIntial, ID, salary);
		this.setSchedule(null);
		
	}
	
	public Professor(String firstName, String lastName, String midIntial, int ID, double salary, List<String> schedule) {
		super(firstName, lastName, midIntial, ID, salary);
		this.setSchedule(schedule);
		
	}
	
	

	/**
	 * Gets schedule
	 * @return the schedule
	 */
	public List<String> getSchedule() {
		return schedule;
	}

	/**
	 * Sets schedule
	 * @param schedule the schedule to set
	 */
	public void setSchedule(List<String> schedule) {
		this.schedule = schedule;
	}
	
	/**
	 * Adds session
	 * @param session - session you are adding
	 */
	public void addSession(String session){
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
	

}
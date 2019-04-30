
public class Person {

	/**
	 * Employee class builds outline of a Person
	 * @author Malik
	 *
	 */
	
		private String firstName = "";
		private String lastName = "";
		private String midIn = "";
		private int ID = 0;	
		
		
		
		
		/**
		 * Default constructor
		 * @param firstName- first name
		 * @param lastName - last name
		 * @param midIn - middle initial
		 * @param ID - identification
		 */
		
		public Person()
		{
			this.firstName = "";
			this.lastName = "";
			this.midIn = "";
			this.ID = 0;
		}
		
		
		
		/**
		 * Over loaded constructor
		 * @param firstName- first name
		 * @param lastName - last name
		 * @param midIn - middle initial
		 * @param ID - identification
		 */
		
		public Person(String firstName,String lastName,String midIntial,int ID )
		{
			this.firstName = firstName;
			this.lastName = lastName;
			this.midIn = midIntial;
			this.ID = ID;
		}
		
		
		
		//Setters-----------------------------------------------
		
		
		/**
		 * set first name
		 * @param firstName - given firstName
		 */
		public void setFirstName(String firstName){
			this.firstName = firstName;
		}
		
			
		
		/**
		 * set Last name
		 * @param firstName - given lastName
		 */
		public void setLastName(String lastName){
			this.lastName = lastName;
		}
		
		
		
		/**
		 * set middle initial
		 * @param midIntial - given middle Initial
		 */
		public void setMid(String midIntial){
			this.midIn = midIntial;
		}
		
		
		
		/**
		 * sets identification
		 * @param ID - sets identification
		 */
		public void setID(int ID){
			this.ID = ID;
		}
		
		
		
		//Getters-------------------------------------------
		
		
		/**
		 * get first name
		 * @return - first name
		 */
		public String getFirstName(){
			return firstName;	
		}
		
		
		/**
		 * get last name
		 * @return - last name
		 */
		public String getLastName(){
			return lastName;	
		}
		
		/**
		 * get middle initial
		 * @return - middle initial
		 */
		public String getMid(){
			return midIn;	
		}
		
		
		
		
		/**
		 * get ID
		 * @return - first name
		 */
		public int getID(){
			return ID;	
		}
}
	


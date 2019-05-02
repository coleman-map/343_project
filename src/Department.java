package diyUniversity;

import java.util.List;

class Department {
	
	/* This class represents and includes all the attributes and functionalities a university department should have as an entity */

	private String depName;
	private List<Major> majors;
	private int numMjr;
	private Employee depChair;

	/*	
	       Department
	   		Constructor

           	Inputs:
				depName – depName will contain in a string of characters the name of the department
				majors: since every department must include a list of majors. Majors, will be a list containing all the required/desired majors.
				numMjr: numMjr will be an integer representing the amount of majors included in the department
				depChair: depChar will contain an Employee profile that will take the role of Department Chair  
 
           	Outputs:
            		None

           	Return Value:
            		Characteristics from the department as desired

           	Exception:
                MissingParameter - if a parameter is not included
				LimitMajors – if there is any intent of increasing the number of majors in the department over 30
				ParameterOutOfBoundaries – if any of the parameters character limit goes over the established maximum
    */
	public Department (String depName, List <Major> majors, int numMjr, Employee depChair) {
		this.depName = depName;
		this.majors = majors;
		this.numMjr = numMjr;
		this.depChair = depChair;
	}


	/** setDepName
			Sets the name of the Department
			
			Inputs: depName – The name of the department
			
			Outputs: None
			
			Return Value: None
			
			Exception:
			InvalidParameter – if the object is anything different from a string of characters and/or over the maximum limit of characters allowed
	*/
	public void setDepName (String depName) {
		this.depName = depName; 
	}


     /*
			getDepName
				Gets the name of the Department
			
			Inputs: None
			
			Outputs: None
			
			Return Value: DepName – The name of the department (String)
			 
			Exception: None
	*/
   	public String getDepName() {
   		return this.depName;
   	}


   	/*
			setChair
				Sets the Chair of the Department
			
			Inputs: depChair – The Employee that will take the role of Department Chair
			
			Outputs: None
			 
			Return Value: None
			
			Exception:
			InvalidParameter – if the object is anything different from an employee profile
    */
   	public void setChair (Employee depChair) {
   		this.depChair = depChair;
   	}
           	

     /*
			getChair 
			Gets the Chair of the Department
			
			Inputs: None
			
			Outputs: None
			
			Return Value: depChair – The Employee that will take the role of Department Chair (Employee)
			
			Exception: None
    */
  	public Employee getChair() {
   		return depChair;
   	}
 

	/*
			setNumMjr
			Sets the number of majors contained in a department
			
			Inputs: numMjr – the new amount of majors
			
			Outputs: None
			   
			Return Value: None
			 
			Exception:
			InvalidParameter – if the object is anything different from an integer and/or over 50 majors
	 */
  	public void setNumMjr (int numMjr) {
   		this.numMjr = numMjr;
   	}

   	/*
		getNumMjr
		Gets the number of majors contained in a department
		
		Inputs: None
		
		Outputs: None
		
		Return Value:
		numMjr – the amount of majors (int) 
		
		Exception:
		None
   	*/
    public int getNumMjr() {
    		return numMjr;
    }
    
    /**
     * addMjr 
     * Adds a major from the department 
     * 
     * Inputs: Major - the major that will be added
     * 
     * Outputs: None
     * 
     * Return Value:None
     * 
     * Exception: major already exists 
     * @param major
     */
    
   	public void addMjr(Major major) {
		 	if (numMjr < 100 & !majors.contains(major)) {
		 		majors.remove(major);
		 		numMjr--;
		 		System.out.println("Major Added!");
		 	} else {
		 		System.out.println("Major already exists!");
		 	}
	 }
    
    
   	/*
	deleteMjr
	Deletes a major from the department
	
	Inputs:  	Major - The major that will be deleted
	
	Outputs: None
	
	ReturnValue: None
	
	Exception: ParameterNotIncluded – if the major inptted does not belong the department
   	*/
   	public void deleteMjr(Major major) {
   		 	if (majors.contains(major)) {
   		 		majors.remove(major);
   		 		numMjr--;
   		 		System.out.println("Major Removed!");
   		 	} else {
   		 		System.out.println("Major doesn't exist!");
   		 	}
   	 }
   	
   	/*
	editMjr
	Edits a major from the department
	
	Inputs:  	Major - The major that will be deleted, majorName - the new name of the major
	
	Outputs: None
	
	ReturnValue: None
	
	Exception: ParameterNotIncluded – if the major inptted does not belong the department
   	*/
   	public void deleteMjr(Major major, String majorName) {
   		 	if (majors.contains(major)) {
   		 		major.setMjrName(majorName);
   		 		System.out.println("Major Edited!");
   		 	} else {
   		 		System.out.println("Major doesn't exist!");
   		 	}
   	 }
   	
   	 
   	/*
	   	displayMajors	Displays a list of the majors that belong to the department
	
	   	Inputs: None
	   	
	   	Outputs: A formatted list showing all the names from the majors in the department
	
	   	Return Value: None
	   	           	   
	   	Exception:  None
   	*/
   	
   	
   	public void displayMajors() {
		for (Major m : majors) {
			System.out.println(m);
		}
   	}
       	
 
    	/*
	    depMenu 
	    Display the menu that contains the different actions that can be done regarding the department dynamics
	
		Inputs:	None
	
		Outputs: The menu including options such as, include new major, retrieve department information…
	
	    Return Value: None
	
		Exception: None
     */
     void depMenu() {
    	 
    	 //THINGS TO DO 
    	 
     }
           	

}






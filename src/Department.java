  	
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Department {
	
	/* This class represents and includes all the attributes and functionalities a university department should have as an entity */
	Scanner reader = new Scanner(System.in);
	Validation validator=new Validation();
	private String depName;
	private ArrayList<Major> majors= new ArrayList <Major>();
	private int maxMajors=50;
	//private Employee depChair;

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
	//, Employee depChair
	public Department (String depName, ArrayList <Major> majors) {
		this.depName = depName;
		this.majors = majors;
		//this.depChair = depChair;
	}
	public Department (String depName) {
		this.depName = depName;
		this.majors = new ArrayList <Major>();
		//this.depChair = null;
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
   	/*
   	 * public void setChair (Employee depChair) {
   		this.depChair = depChair;
   	}
   	 */
   	
           	

     /*
			getChair 
			Gets the Chair of the Department
			
			Inputs: None
			
			Outputs: None
			
			Return Value: depChair – The Employee that will take the role of Department Chair (Employee)
			
			Exception: None
    */
   	/*
   	 * public Employee getChair() {
   		return depChair;
   	}
   	 */
  	
 

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
    		return this.majors.size();
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
		 	if (this.majors.size()<maxMajors & !majors.contains(major)) {
		 		majors.add(major);
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
   	
   	public void editMjr(Major major, String majorName) {
   		 	if (majors.contains(major)) {
   		 		//major.setMjrName(majorName);
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
      public void addMajor() {
    	  String major_name="";
    	  while (major_name.toLowerCase()!="exit") {
				System.out.println("Type the name of the major you want to include or exit to exit: ");
				major_name= reader.nextLine(); 
				
				if (major_name.toLowerCase().equals("exit"))
					break;
				Major major=new Major (major_name);
				
				
				if(this.majors.size()>0) {
					if (this.majors.contains(major)) {
						System.out.println("The major already exists and cannot be added again");
						continue;
					}else
						this.majors.add(major);
						
				}else
					this.majors.add(major);
				
				System.out.println("Do you wish to add courses: (y/n)");
				String input=reader.nextLine();
				input=validator.validateChar(input);
				if (input.equals("y")) {
					while (input.equals("y")) {
						String course_name;
						// final version must have inputs of type course and not string
						System.out.println("Input the name of the course you want to add or exit to exit");
						course_name= reader.nextLine();
						if (course_name.equals("exit")) {
							input="n";
							break;
						}// end of if (course_name=="exit")
						int index=this.majors.indexOf(major);
						this.majors.get(index).addCourse(course_name);
						System.out.println("Course added");
					}//end of while (input =="y")
					
				}//end of if (input=="y")
				else {
					break;
				}
					
			}//end of while (major_name.toLowerCase()!="exit")
			
      }
      
      public void displayMajor() {
    	  for (int i=0;i<this.majors.size();i++)
				System.out.println(this.majors.get(i).getName());
      }
      public void deleteMajor() {
    	  displayMajor();
    	  System.out.println("Input the name of the major you want to delete");
			String maj_delete=reader.nextLine();
			boolean found=false;
			for (int i=0;i<this.majors.size();i++) {
				if(this.majors.get(i).getName().equals(maj_delete)) {
					this.majors.remove(i);
					found=true;
					System.out.println("Major deleted");
					
				}//end of if(this.majors.get(i).getName()==maj_delete)
			}//end of for (int i=0;i<this.majors.size();i++)
			if (!found) 
				System.out.println("The major cant be deleted because it does not exist in this department");
      }
      public Major findMajor (String _major_name) {
    	  String opt_chosen;
    	  boolean found=false;
    	  int index=0;
    	  for (int i=0;i<this.majors.size();i++) {
			if(this.majors.get(i).getName().equalsIgnoreCase(_major_name)) {
					found=true;
					index=i;
				}
			
	  }
    	  if (!found) {
				System.out.println("The major does not exist in this department ");	
				return null;
			}else
				return this.majors.get(index);
			

      }
      public void changeMajorName(Major current) {
    	  String opt_chosen="";
    	  boolean not_new=false;
    	  int index=0;
    	  System.out.println("Input the new name for the major");
    	  String new_name=reader.nextLine();
    	  for (int i=0;i<this.majors.size();i++) {
    		  if (this.majors.get(i).getName().equalsIgnoreCase(new_name))
    			  not_new=true;
    	  }
    	  if(not_new) {
    		  System.out.println("This name is not valid because it already belong to a major in the department"
    		  		+ " returning to menu");
    	  }else {
    		  current.setName(new_name);
    	  }
    	  
    	  
//  			else {
//  				System.out.println("Input the new name for the major");
//  				String major_name=reader.nextLine();
//  				this.majors.get(index).setName(major_name);
//  				System.out.println("Major name has been changed, going back to the menu");
//  			}
//      }
      }
      
      
      public void editMajorCourse() {
    	  
      }
      
      public void editMajorMenu() {
    	  boolean found=false;
    	  
    	  String major_chosen="";
    	  String opt_chosen="";
    	  int opt_chosen_i;
    	  Major temp_major;
    	  int index=0;
    	  
    	  displayMajor();
    	  System.out.println("Select the major you want to work on");
    	  major_chosen=reader.nextLine();
    	  Major current=findMajor(major_chosen);
    	  
    	  while(!major_chosen.equalsIgnoreCase("exit")) {
    		  System.out.print("\n" + current.getName()+ " MAJOR MENU "
  					+ "\n1. Change major name"
  					+ "\n2. Major Menu"
  					+ "\n3. Exit"
  					+ "\nEnter here: ");
    		  opt_chosen=reader.nextLine();
    		  opt_chosen_i= validator.validate_int(opt_chosen);
    		  if (opt_chosen_i==1)
    			  changeMajorName(current);
    		  else if (opt_chosen_i==2);
    		  	 // current.Menu();
    		  else if (opt_chosen_i==3)
    			  break;
    		  }//end of if (opt_chosen_i==1)	
    	  }
    		  
        
    		  
    
    	/*
	    depMenu 
	    Display the menu that contains the different actions that can be done regarding the department dynamics
	
		Inputs:	None
	
		Outputs: The menu including options such as, include new major, retrieve department information…
	
	    Return Value: None
	
		Exception: None
     */
	public void DepMenu() {
		
		String option_s = "";
		int option =0;
		String major_name="";
		
		
		
		while (option!=5) {
			System.out.println("1. Add a major \n2. Delete Major \n3. Print all majors in the department"
					+ "\n4. Edit Major"
					+ " Menu\n5. Exit");
			option_s = reader.nextLine();
			option = validator.validate_int(option_s);
			if (option==1) {
				addMajor();
			}//end of if (option==1)
			else if (option==2) {
				deleteMajor();
			}//end of else if (option==2)
			else if (option==3) {
				displayMajor();
			}//end of else if (option==3)
			else if (option==4) {
				editMajorMenu();
			}else if(option==5) {
				break;
			}
			else
				System.out.println("Invalid output");
		}//end of while (option!=4)
	}
	
}








import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class MainMenu {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		TreeMap<Integer, Person> people = new TreeMap<Integer, Person>();
		ArrayList<College> initialColleges = new ArrayList<College>();
		//Predefined data
		initialColleges.add(new College("Computer Science"));
		initialColleges.add(new College("Liberal Arts"));
		people.put(986, new Student("Juan", "Garcia", "C", 986));
		people.put(345, new Admin("Malik", "Coleman", "K", 345, 300.00, true));
		people.put(764, new Professor("Jon", "Tron", "T", 764, 20000.00));
		initialColleges.get(0).setDean(people.get(764));
		
		//This object holds everything
		University uni = new University("California State University, Longer Beach", initialColleges, people, 1);
		
		//Go time
		menu(uni);
		
	}
	
	public static void menu(University uni){
		int exit = 1;
		do{
			Person user = login(uni);
			
			if(user instanceof Admin){
				AdminMenu(uni, user);
			}else if( user instanceof Student){
				StudMenu(uni, user);
			}else{
				ProfMenu(uni, user);
			}
			System.out.println("You have been logged out. \n");
		}while(exit == 1);
		
		
		
		
	}
	
	private static void ProfMenu(University uni, Person user){
		
	}

	private static void StudMenu(University uni, Person user){
		
	}

	private static void AdminMenu(University uni, Person user){
		int choice;
		do{
		System.out.print("\nADMININSTRATOR MENU "
				+ "\n1. University Menu "
				+ "\n2. College Menu "
				+ "\n3. Department Menu"
				+ "\n4. Major Menu "
				+ "\n5. Course Menu"
				+ "\n6. Exit "
				+ "\nEnter here: ");
		choice = Integer.parseInt(in.nextLine());
		
		if(choice == 1){
			uni.uniMenu();
		}else if(choice == 2){
			
		}else if(choice == 3){
			
		}else if(choice == 4){
			
		}else if(choice == 5){
		
		}else if(choice == 6){
			return;
		}
		}while(choice != 6);
	}

	public static Person login(University uni){
		int id = 0;
		
		do{
			System.out.print("Welcome to " + uni.getUniName() + 
					"!\nPlease enter your ID number: ");
			id = Integer.parseInt(in.nextLine());
		}while(uni.findPerson(id) == null);
		
		return uni.findPerson(id);
	}
	
}


import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class MainMenu {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		TreeMap<Integer, Person> people = new TreeMap<Integer, Person>();
		ArrayList<College> initialColleges = new ArrayList<College>();
		initialColleges.add(new College("Computer Science"));
		people.put(986, new Student("Juan", "Garcia", "C", 986));
		University uni = new University("California State University, Longer Beach", initialColleges, people, 1);
		menu(uni);
		
	}
	
	public static void menu(University uni){
		Person user = login(uni);
		
		if(user instanceof Admin){
			AdminMenu(uni, user);
		}else if( user instanceof Student){
			StudMenu(uni, user);
		}else{
			ProfMenu(uni, user);
		}
		
		
		
		
	}
	
	private static void ProfMenu(University uni, Person user){
		
	}

	private static void StudMenu(University uni, Person user){
		
	}

	private static void AdminMenu(University uni, Person user){
		System.out.print("ADMININSTRATOR MENU "
				+ "\n1. University Menu "
				+ "\n2. College Menu "
				+ "\n3. Department Menu"
				+ "\n4. Major Menu "
				+ "\n5. Course Menu"
				+ "\n6. Exit "
				+ "\nEnter here: ");
		int choice = in.nextInt();
		
		if(choice == 1){
			uni.uniMenu();
		}else if(choice == 2){
			
		}else if(choice == 3){
			
		}else if(choice == 4){
			
		}else if(choice == 5){
			return;
		}
	}

	public static Person login(University uni){
		int id = 0;
		
		do{
			System.out.println("Welcome to " + uni.getUniName() + 
					"!\nPlease enter your ID number: ");
			id = in.nextInt();
		}while(uni.findPerson(id) == null);
		
		return uni.findPerson(id);
	}
	
}

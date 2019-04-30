import java.util.List;

public class University {
	
	/**
	 * A class for representing a different
	 */
	
	private String uniName;
	private List<College> colleges;
	private int numCol;
	/**
	 * Default constructor method
	 * 
	 * Inputs: none
	 * 
	 * Outputs: none
	 * 
	 * Return Value: the University
	 * 
	 * Exception: none
	 */
	University() {}
	
	/**
	 * Loaded constructor method
	 * 
	 * Inputs:
	 *	uniName - name of the university
	 *	colleges - list of all colleges in the university
	 *	numCol - number of colleges in the university
	 *	
	 * Output: none
	 * 
	 * Return Value: the University
	 * 
	 * Exception: none
	 */
	University(String uniName, List<College> colleges, int numCol) {
		this.uniName = uniName;
		this.colleges = colleges;
		this.numCol = numCol;
	}
	
	/**
	 * Gets university name 
	 * 
	 * Inputs: none
	 * 
	 * Outputs: 
	 *	uniName - name of the university
	 *
	 * Return Value:
	 *	@return - name of university (String)
	 *
	 * Exception: none
	 */
	public String getUniName() {
		return uniName;
	}
	
	/**
	 * Sets university name
	 * 
	 * Inputs:
	 * 	colName - name of the university
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 */
	public void setUniName(String uniName) {
		this.uniName = uniName;
	}
	
	/**
	 * Gets number of colleges in the university
	 * 
	 * Inputs: none
	 * 
	 * Outputs: 
	 *	numCol - number of colleges
	 *
	 * Return Value:
	 *	@return - number of colleges (int)
	 *
	 * Exception: none
	 */
	public int getNumCol() {
		return numCol;
	}
	
	/**
	 * Sets number of colleges
	 * 
	 * Inputs:
	 * 	numCol - number of colleges in the university
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 */
	public void setNumCol(int numCol) {
		this.numCol = numCol;
	}
	
	/**
	 * Adds college to university
	 * 
	 * Inputs:
	 * 	col - new college to be added
	 * 
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: 
	 * 	InvalidParamter - college already exists
	 */
	public void addCol(College col) {
		colleges.add(col);
		numCol++;
	}
	
	/**
	 * Deletes college
	 * 
	 * Inputs:
	 * 	col	- college to be deleted
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception:
	 * 	InvalidParameter - college does not exist
	 */
	public void delCol(College col) {
		colleges.remove(col);
		numCol--;
	}
	
	/**
	 * Displays the colleges in the university
	 * 
	 * Inputs: none
	 * 	
	 * Outputs: a list of all the colleges in the university
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 */
	public void displayCols() {
		for (College c : colleges) {
			System.out.println(c);
		}
	}
	
	/**
	 * Menu to edit university attributes
	 * 
	 * Inputs: none
	 * 	
	 * Outputs: none
	 * 
	 * Return Value: none
	 * 
	 * Exception: none
	 */
	public void uniMenu() {
		System.out.println("1. Create University\n 2. Add College \n 3. Remove College \n 4. View Colleges \5. Exit");
		//IDK IF I NEED TO DO A DO WHILE HERE OR IF WE DO THAT IN MAIN! 
	}
}
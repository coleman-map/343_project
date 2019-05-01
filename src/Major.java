import java.util.ArrayList;

public class Major {

	private String m_name;
	private int max_courses=100;
	// ArrayList final content should be of type Course
	private ArrayList<String> course_list=new ArrayList <String>();
	
	public Major() {
		this.m_name="void";
		
	}
	// variable should be of type course at final version
	public void addCourse(String _course) {
		if (this.course_list.size()<=max_courses)
			this.course_list.add(_course);
		else
			System.out.println("Maximum amount of courses reached");
		
	}
	
	public void deleteCourse(String _course) {
		this.course_list.remove(_course);
	}
}

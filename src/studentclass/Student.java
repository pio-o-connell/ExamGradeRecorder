package studentclass;

///
///* Class for use with main program
///* package student class
///*/

/**
 *
 * @author Pio O'Connell
 */
public class Student {
    private String firstname;
	private String surname;
	private String id;
	private int mark;
	private String grade;
	
	public Student (String id0,String firstname0,String secondname0,int mark0){
		 firstname = firstname0;
		 surname = secondname0;
		 id = id0;
		 mark = mark0;
		
		 if((mark >84) && (mark<101))
				setGrade("\tDistinction");
			else if((mark>64) && (mark<85))
					setGrade("\tMerit");
				else
					if ((mark>39) && (mark<65))
						setGrade("\tPass");
					else
						setGrade("\tFail");}	
						
					
			
				
		 
	
	
	public String toString (){
						
		return(this.id +" \t\t "+this.firstname+" \t  "+this.surname+"              "+this.grade+"     "+this.mark);	
		// to get proper formatting,it would be better to read into fixed width table first and display
	}
	
	public String getFirstName() {
		return firstname;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setFirstName(String firstname0) {
		this.firstname = firstname0;
	}
	
	public void setSurname(String secondname0) {
		this.surname = secondname0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;}
	
	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}

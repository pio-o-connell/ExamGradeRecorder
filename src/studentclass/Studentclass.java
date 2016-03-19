// ------------------------------------------------------------------/
// Program  allows a teacher to input student details 
// such as student first name, student second name and examination
// mark at the keyboard for an entered from input 'number of students'.
//  The program  displays the mark and grade for each of the students
// e.g. William Buckley received a Merit for his mark of 68
// The grades are given by the following table:
// Mark range grade 85 – 100 distinction 
//                  65 – 84 merit 
//                  40 – 64 pass
//                   0 - 39 fail
//
// The program is a menu driven application that allows the user 
//                to 'add', 'remove' and 'list' student objects 
// ------------------------------------------------------------------/

package studentclass;
import java.util.Scanner;

/**
 *
 * @author Pio O'Connell
 */
public class Studentclass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
		String tempId,tempFirstName,tempSurname;
		String temp=null;
		int tempMark=0;
		int option=0,maxStudents=0;
		boolean numeric=true;
		System.out.println("------------------------------------");
		System.out.println("Student Mark Check");
		System.out.println("Add/View students marks system :");
		System.out.println("------------------------------------");
				
			System.out.println("Please enter 'Maximum' Number of students for this session  :");
			
			do
			{
			
			temp = keyboard.nextLine();
			numeric=true;
			try {
				maxStudents=Integer.parseInt(temp);
			} catch (NumberFormatException e) {
			      //Will Throw  =exception!
			      //do something! anything to handle the exception.
				numeric = false;				

				System.out.println("Please enter 'Maximum' Number of students for this session  :");
			}

			} 
			while(!numeric);
			
			boolean finished = false;
			int i=0 ;
			int nmrStudents=0;
			int recordno=0;
			char input;
			
			Student students[] = new Student[maxStudents];

			do
			{
			System.out.println("\n///// Menu ////////");
			System.out.println("Maximum Records  "+maxStudents+" Current "+ nmrStudents);
			System.out.println("Choose option 1 to add 'new' records(max. "+maxStudents+"):");
			System.out.println("Choose option 2 to 'view' current records");
			System.out.println("Choose option 3 to 'delete' an indexed records");
			System.out.println("Choose option 4 to 'quit' :");
		
			temp = keyboard.nextLine();
			numeric=true;
			try {
				option=Integer.parseInt(temp);
			} catch (NumberFormatException e) {
			      //Will Throw exception!
			      //do something! anything to handle the exception.
				numeric = false;				

				System.out.println("Choose either option 1,2,3,4");
			}		
			if(numeric){
			switch (option)	
			{
				case 1: 
					if ((nmrStudents) == maxStudents)					
						System.out.println("Max Number of students entered reached ("+maxStudents+")");
					else{
						System.out.println("Enter Student Id:(e.g. R00118177) " );
						tempId = keyboard.nextLine();
						System.out.println("Enter Student FirstName:");
						tempFirstName = keyboard.nextLine();
						System.out.println("Enter Student Surname:");
						tempSurname = keyboard.nextLine();
						System.out.println("Enter Student Mark(0-100)" );
						temp = keyboard.nextLine();
						numeric=true;
						try {
							tempMark=Integer.parseInt(temp);
						} catch (NumberFormatException e) {
					      //Will Throw exception!
					      //do something! anything to handle the exception.
						numeric = false;				

						System.out.print("No new record added");
					}	
					if(numeric){
					nmrStudents++;	
					students[nmrStudents-1] = new Student(tempId,tempFirstName,tempSurname,tempMark);	
				
					}
						
					}
					break;
				case 2:
					if(nmrStudents >0 ){
					System.out.println("Current records ..");
					System.out.println(nmrStudents);
					System.out.println("Record No.\t\tStudent Id \t\t Student Name              \t   Grade          Mark");
					System.out.println("-----------   \t   -------------------        \t------------------------      \t  ----------- \t ------  ");
					for ( i=0; i < nmrStudents;i++)
						System.out.println((i+1) +"\t\t\t"+students[i]);
					for(i=0;i<3;i++)
						System.out.println();
					}
					else
						System.out.println("Records indicate database is 'empty'..\n\n");	
					break;
				case 3:
					if(nmrStudents >0){
					System.out.println("Please enter the 'indexed record no'  you wish 'deleted'..>");	
					temp = keyboard.nextLine();
					numeric=true;
					try {
						recordno=Integer.parseInt(temp);
					} catch (NumberFormatException e) {
					      //Will Throw exception!
						numeric = false;				
						System.out.println("Please Choose Record from 1 to"+nmrStudents);
					}										
					if ((recordno > 0)&&(recordno <=nmrStudents )){
						System.out.println("Are you sure ('y'/'n')");
						input = keyboard.next().trim().charAt(0);
						if (input == 'y'){
							for(i=(recordno-1);i<(nmrStudents-1);i++)
									students[i]= students[i+1];				// garbage collector will pick up dangling pointer
							nmrStudents--;
							System.out.println(" 'indexed record no' "+recordno+"  'deleted'");
							}
							else
								System.out.println(" 'indexed record no' "+recordno+"  ' not deleted'");
							keyboard.nextLine(); // to fflush() the buffer						
						}
						else if ((recordno > nmrStudents))
								System.out.println(" 'indexed record no' "+recordno+"  ' does not exist'");										
					}
					else
						System.out.println("Records indicate database is 'empty'..\n\n");	
					break;
				case 4:
					System.out.println("You are finished goodbye");
					finished = true;
					break;
				default:
					System.out.println("Invalid option please enter 1 or 2");
					break;
			}
			}
		//System.out.println("Hit any key to continue ");
		//keyboard.nextInt();
		}
		while (!finished);
    }
    
}

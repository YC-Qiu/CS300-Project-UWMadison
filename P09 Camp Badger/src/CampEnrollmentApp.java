//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P09 Camp Badger
// Files:           CampEnrollmentApp.java, Camper.java, CamperBST.java
//									CampManager.java, CampTreeNode.java
// Course:          COMP SCI 300 FALL 2019
//
// Author:          Yucheng Qiu
// Email:           yqiu56@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Hankel Bao
// Partner Email:   hbao24@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   __X_ Write-up states that pair programming is allowed for this assignment.
//   __X_ We have both read and understand the course Pair Programming Policy.
//   __X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:   NONE
// Online Sources:  NONE 
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class implements a UI for users to handle the camp.
 * @author pc
 * @since 11-20-2019
 */
public class CampEnrollmentApp {
	
	
  /**
   * Based on the Gradescope sample, print the result of whole project. 
   * @return true
   */
  public static boolean test() {
    Camper camper1 = new Camper("A", "a", 9);
    Camper camper2 = new Camper("B", "b", 12);
    Camper camper3 = new Camper("C", "c", 8);
    Camper camper4 = new Camper("D", "d", 10);
    Camper camper5 = new Camper("E", "e", 10);
    Camper camper6 = new Camper("F", "f", 10);
    Camper camper7 = new Camper("G", "g", 10);
    CamperBST cb = new CamperBST();
    cb.insert(camper1);
    cb.insert(camper2);
    cb.insert(camper3);
    cb.insert(camper4);
    cb.insert(camper5);
    cb.insert(camper6);
    cb.insert(camper7);
    cb.delete(camper7);
    cb.print();
    return true;
  }

  /**
   * Main method for testing the given commands in sim.txt
   * @param args
   * @throws IOException if problem occurs during the file loading process
   */
  public static void main(String[] args) throws IOException {
  	
  	CampManager manager = new CampManager();
  	
    List <String> fileLines = Files.readAllLines(Paths.get("sim.txt"));
    
    for(String x:fileLines) {
    	
    	String[] arg = x.split(" ");
    	
    	switch (arg[0]) {
    		
				case "E":
					// E for enrolling a camper
					int age = Integer.parseInt(arg[3]);
					if(age >= 8 && age <= 14) {
						Camper newcamper = new Camper(arg[2],arg[1],age);
						manager.enrollCamper(newcamper);
						System.out.println("Enrollment of " + newcamper.getFirstName() +
							" " + newcamper.getLastName() + " Successful!");
					}
					else {
						System.out.println("This person is either too old or too young "
							+ "to be in Camp Badger.");
					}
					break;
					
				case "R":
					// R for Unenrolling a camper
					Camper delcamper = new Camper(arg[2],arg[1],9);
					// The name of the camper. No matter what age is.
					boolean nosuchcamper = false;
					
					try {
						manager.unenrollCamper(delcamper);
					}catch (NoSuchElementException e) {
						nosuchcamper = true;
					}
					
					if(!nosuchcamper) {
						
					System.out.println("Unenrollment of " + delcamper.getFirstName() +
						" " + delcamper.getLastName() + " Successful!");
					}
					else {
						System.out.println("That camper is not enrolled.");
					}
					break;
					
				case "T":
					// T for Traversal the whole BST
					System.out.println("--- " + arg[1] + " Traversal ---");
					for(Iterator<Camper> i = manager.traverse(arg[1]); 
						i.hasNext();) {
						Camper camper = i.next();
						System.out.println(camper.toString());
					}
					for(int i=0;i<26;i++){System.out.print("-");}
					System.out.println();
					break;
					
				case "S":
					// S for print statistics
					manager.printStatistics();
					break;
			}
    }
    //test();
  }
  
}

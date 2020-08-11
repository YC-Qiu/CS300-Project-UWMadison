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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements a manager to provide actions to modify the camper BST.
 * @author Hankel Bao
 * @since 11-20-2019
 */
public class CampManager {
  private CamperBST campers; // Root of the BST
  // Name of the camps
  private final static String[] CABIN_NAMES =
    new String[] {"Otter Overpass", "Wolverine Woodland", "Badger Bunkhouse"};
  
  /**
   * Constructor for the CampManager by initializing the campers field
   */
  public CampManager() {
    this.campers = new CamperBST();
  }
  
  /**
   * "Enrolls" a camper by determining their cabin and adding them to the tree.
   * @param newCamper - the camper to be enrolled into the camp
   */
  public void enrollCamper(Camper newCamper) {
    // I really don't think cabin should be determined here.
    // It is directly related to Campers, the the field is in campers.
    // This piece of code should be in Camper.java
    int age = newCamper.getAge();
    if (age >=8 && age <=9)
      newCamper.assignCabin(CABIN_NAMES[0]);
    if (age >= 10 && age <= 12)
      newCamper.assignCabin(CABIN_NAMES[1]);
    if (age >= 13 && age <= 14)
      newCamper.assignCabin(CABIN_NAMES[2]);

    this.campers.insert(newCamper);
  }
  
  /**
   * "Unenrolls" a camper by removing them from the tree.
   * @param delCamper - the camper to be unenrolled the camp
   * @throws NoSuchElementException if CamperBST.delete throws the exception
   */
  public void unenrollCamper(Camper delCamper) throws NoSuchElementException{
  	
    this.campers.delete(delCamper);
    
  }
  
  /**
   * Prints statistics based on the current "state" of the camp. The
   * statistics to be printed is the total number of campers.
   */
  public void printStatistics() {
  	
  	System.out.println("--- Camp Statistics ---");
  	
    System.out.println("Number of Campers: " + this.campers.size());
    
    for(int i=0;i<23;i++) {System.out.print("-");}
    
    System.out.println();
  }
  
  /**
   * Traverses the tree in the designated order by calling it through the
   * CamperBST class.
   * @param order - the type of traversal for the tree to perform
   * @return the Iterator of Campers from CampBST.traverse()
   */
  public Iterator<Camper> traverse(String order){
 
  	return campers.traverse(order);
 
  }
}

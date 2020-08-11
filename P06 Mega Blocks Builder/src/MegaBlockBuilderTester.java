//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P06 Mega Blocks Builder
// Files:           LinkedListMegaBlock.java, LinkedMegaBlock.java, 
//									MegaBlockBuilderTester.java
// Course:          COMP SCI 300 FALL 2019
//
// Author:          Yucheng Qiu
// Email:           yqiu56@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Haoming Meng
// Partner Email:   hmeng29@wisc.edu
// Partner Lecturer's Name: Gary Dahl
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   __x_ Write-up states that pair programming is allowed for this assignment.
//   __x_ We have both read and understand the course Pair Programming Policy.
//   __x_ We have registered our team prior to the team registration deadline.
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

import java.util.NoSuchElementException;

/**
 * This class tests functionality of methods from different classes of 
 * P06 Mega Blocks Builder project.
 * 
 * @author Haoming Meng
 *
 */
public class MegaBlockBuilderTester {
  
	/**
   * Checks for the correctness of the equals() method in MegaBlock class
   * @return  true if the result pass the test condition, false if not
   */
  public static boolean testMegaBlockEquals() {
    MegaBlock tester1 = new MegaBlock(Color.BLUE, 'A');
    MegaBlock tester2 = new MegaBlock(Color.BLUE, 'B');
    if( !tester1.equals(tester2)) {
      return false;
    }
    return true;
  }
  
  /**
   * Test Clear() in Class LinkedListMegaBlock.
   * @param list the list to clear
   * @return true if the method correctly works
   */
  public static boolean testLinkedListMegaBlockClear(LinkedListMegaBlock list){
		
    list.clear();
    
    // test if the list is empty now
    return list.toString().equals("");

	}
  /**
   * Checks for the correctness of the toString() method in MegaBlock class
   * @return  true if the result pass the test condition, false if not
   */
  public static boolean testMegaBlockToString() {
    MegaBlock tester1 = new MegaBlock(Color.BLUE, 'A');
    if(!tester1.toString().equals("BLUE A")) {
      return false;
    } return true;
  }
  
  /**
   * Test the functionality of the constructor, mutator, and accessor of
   * LinkedMegaBlock
   * @return true if the result pass the test condition, false if not
   */
  public static boolean testLinkedMegaBlock() {
    
    // Test the functionality of the constructor
    MegaBlock tester1 = new MegaBlock(Color.BLUE, 'A');
    MegaBlock tester2 = new MegaBlock(Color.YELLOW, 'B');
    LinkedMegaBlock tester1A = new LinkedMegaBlock(tester1);
    if(!tester1A.getBlock().equals(tester1) || tester1A.getNext() != null) {
      return false;
    }
    // Test the functionality of the accessor
    if(!tester1A.getBlock().equals(tester1)) {
      return false;
    }
    // Test the functionality of the mutator
    tester1A.setBlock(tester2);
    if(!tester1A.getBlock().equals(tester2)) {
      return false;
    }
    return true;
  }
  
  /**
   * Checks for the correctness of the LinkedListMegaBlock.addRed() method
   * @return true if the result pass the test condition, false if not
   */
  public static boolean testLinkedMegaBlockListAddRed() {
    LinkedListMegaBlock testLinkedList = new LinkedListMegaBlock();
    MegaBlock testBlock1 = null;
    MegaBlock testBlock2 = new MegaBlock(Color.RED, 'A');
    boolean throwException = false;
    
    try {
      testLinkedList.addRed(testBlock1);
    } catch (IllegalArgumentException e) {
      // TODO: handle exception
      throwException = true;
    }
    
     testLinkedList.addRed(testBlock2);
     if(!testLinkedList.get(0).getColor().equals(Color.RED)) {
       return false;
     }
     return throwException;
  }
  
  /**
   * Checks for the correctness of the LinkedListMegaBlock.removeBlue() method
   * @return true if the result pass the test condition, false if not
   */
  public static boolean testLinkedListMegaBlockRemoveBlue() {
    // Create test LinkedListMegaBlock object and add some RED blocks
    LinkedListMegaBlock testLinkedList = new LinkedListMegaBlock();
    testLinkedList.addRed(new MegaBlock(Color.RED, 'A'));
    testLinkedList.addRed(new MegaBlock(Color.RED, 'B'));
    boolean throwException = false;// Track if correct exception is thrown
    
    // Test if the method throw NoSuchElementException when there is no BLUE
    // blocks in the LinkedList
    try {
      testLinkedList.removeBlue();
    } catch (NoSuchElementException e) {
      // TODO: handle exception
      throwException = true;
    }
    // Add BLUE blocks and test if the removeBlue method returns a BLUE block
    testLinkedList.addBlue(new MegaBlock(Color.BLUE, 'C'));
    testLinkedList.addBlue(new MegaBlock(Color.BLUE , 'D'));
    if(!testLinkedList.removeBlue().getColor().equals(Color.BLUE)) {
      return false;
    }
    return throwException;
  }
  
  /**
  * Driver method to test the implemented classes in P06 Mega Blocks Builder
  * @param args input arguments
  */
  public static void main (String[] args) {
    System.out.println("Test MegaBlock equals " + testMegaBlockEquals());
    System.out.println("Test MegaBlock toString " + testMegaBlockToString());
    System.out.println("Test LinkedMegaBlock " + testLinkedMegaBlock());
    System.out.println("Test LinkedMegaBlockList AddRed "
    + testLinkedMegaBlockListAddRed());
    System.out.println("Test LinkedListMegaBlock RemoveBlue"
    + testLinkedListMegaBlockRemoveBlue());
    
    // Create a new empty LinkedListMegaBlocks list
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    // display list's content and size information
    display(list);
 // Add some blocks to list and display its contents and size information
    list.addBlue(new MegaBlock(Color.BLUE, 'C')); // add a blue mega block
    display(list);
    list.addBlue(new MegaBlock(Color.BLUE, 'S')); // add a blue mega block
    display(list);
    list.addYellow(0,new MegaBlock(Color.YELLOW, 'Y'));
    display(list);
    list.addRed(new MegaBlock(Color.RED, 'A'));
    list.addRed(new MegaBlock(Color.RED, 'B')); 
    display(list);
    list.addYellow(3, new MegaBlock(Color.YELLOW, 'H'));
    // at index 3 of this list
    display(list);
    // remove/add some blocks and display the list after each operation
    list.removeBlue(); // remove a blue block
    display(list);
    list.removeBlue(); // remove a blue block
    display(list);
    list.addYellow(list.size(), new MegaBlock(Color.YELLOW, 'W'));
    display(list);
    list.removeRed(); // remove a red block
    display(list);
    list.removeYellow(list.size()-1);
    display(list);
    
    testLinkedListMegaBlockClear(list);
    display(list);
    
    System.out.println("Test Clear() " + testLinkedListMegaBlockClear(list));
    
  }
  
  /**
  * Helper method to display the contents of a list of mega blocks
  * @param list a reference to a LinkedListMegaBlock object
  * @throws NullPointerException if list is null
  */
  private static void display(LinkedListMegaBlock list) {
  	// display list content
  	System.out.println("list content: " + list);
  	// display information about the size of this list and
  	// the its blocks' color counts
  	System.out.println("Size: " + list.size() +
  		", redCount: " + list.getRedCount() +
  		", yellowCount: " + list.getYellowCount() +
  		", blueCount: " + list.getBlueCount());
  	System.out.println();
  }
  
  
}

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P08 Ascii Art
// Files:           AsciiArtDriver.java, AsciiArtTester.java, Canvas.java
//									DrawingChange.java, DrawingStack.java,
//									DrawingStackIterator.java, DrawingStackIterator.java
//									LinkedNode.java, StackADT.java
// Course:          COMP SCI 300 FALL 2019
//
// Author:          Yucheng Qiu
// Email:           yqiu56@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NONE
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
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

import java.util.EmptyStackException;

/**
 * This class tests the whole project.
 * @author YC Qiu
 * @version 1.0
 * @since 2019-11-14
 */
public class AsciiArtTester {
	
	/** Test methods.
	 * @param args
	 */
	public static void main(String[] args) {
		if(!testStackPushPeek())
			System.out.println("testStackPushPeek() failed.");
		
		if(!runAsciiArtTestSuite())
			System.out.println("runAsciiArtTestSuite() failed.");
	}
	
	/**
	 * This test checks for the correctness of both DrawingStack.push() and
	 * DrawingStack.peek() methods.
	 * @return true if the method works correctly
	 */
	public static boolean testStackPushPeek(){
		
		DrawingStack testStack = new DrawingStack();
		
		DrawingChange testchange1 = 
			new DrawingChange(0, 0, 'a', 'A');
		
		DrawingChange testchange2 = 
				new DrawingChange(0, 1, 'b', 'B');
		
		testStack.push(testchange1);
		
		testStack.push(testchange2);
		
		if(!testStack.peek().equals(testchange2)) return false;
		
		return true;
	}
	
	/**
	 * Test other methods in Canvas.java, DrawingStack.java and iterator.
	 * @return true if methods work appropriately.
	 */
	public static boolean runAsciiArtTestSuite() { 
		
		if(!testUndo()) return false;
		
		if(!testPop()) return false;
		
		if(!testStackIterator()) return false;
		
		if(!testRedo()) return false;
		
		if(!testtoString()) return false;
		
		return true;
	}
	
	/**
	 * Test method toString()
	 * @return true if the method work appropriately.
	 */
	private static boolean testtoString() {
		
		Canvas testCanvas = new Canvas(2, 2);
		
		testCanvas.draw(0, 0, 'M');
		testCanvas.draw(0, 1, 'Q');
		testCanvas.draw(1, 0, 'N');
		testCanvas.draw(1, 1, 'I');
		
		String str1 = testCanvas.toString();
		
		String str2 = "MQ"+System.lineSeparator()+"NI"+System.lineSeparator();
		
		return str1.equals(str2);
	}
	
	/**
	 * Test method Undo()
	 * @return true if the method work appropriately.
	 */
	private static boolean testUndo() {
		
		Canvas testCanvas = new Canvas(3, 3);
		
		testCanvas.draw(0, 0, 'M');
		
		String str1 = testCanvas.toString();
		
		testCanvas.draw(2, 2, 'N');
		
		testCanvas.undo();
		
		if(!testCanvas.toString().equals(str1)) return false;
		
		return true;
	}
	
	/**
	 * Test method Redo()
	 * @return true if the method work appropriately.
	 */
	private static boolean testRedo() {
		
		Canvas testCanvas = new Canvas(3, 3);
		
		testCanvas.draw(0, 0, 'M');
		
		testCanvas.draw(2, 2, 'N');
		
		String str1 = testCanvas.toString();
		
		testCanvas.undo();
		
		testCanvas.redo();
		
		if(!testCanvas.toString().equals(str1)) return false;
		
		return true;
	}
	
	/**
	 * Test method Pop().
	 * @return true if method work appropriately.
	 */
	private static boolean testPop() {
		
		DrawingStack dS = new DrawingStack();
		
		DrawingChange testchange1 = 
				new DrawingChange(0, 0, 'a', 'A');
			
		DrawingChange testchange2 = 
					new DrawingChange(0, 1, 'b', 'B');
		
		boolean ExceptionExists = false;
		
		try {
			
			dS.pop();

		}catch(EmptyStackException e) {
			
			ExceptionExists = true;
			
		}
		
		dS.push(testchange1);
		
		dS.push(testchange2);
		
		if(!dS.pop().equals(testchange2)) return false;
		
		return ExceptionExists;
	}
	
	/**
	 * Test the iterator of DrawingStack.
	 * @return true if methods work appropriately.
	 */
	private static boolean testStackIterator() {
		
		try {
			
			DrawingStack testStack = new DrawingStack();
			
			DrawingChange testchange1 = 
				new DrawingChange(0, 0, 'a', 'A');
				
			DrawingChange testchange2 = 
				new DrawingChange(0, 1, 'b', 'B');
			
			DrawingChange testchange3 = 
				new DrawingChange(1, 1, 'c', 'C');
				
			testStack.push(testchange1);
				
			testStack.push(testchange2);
			
			testStack.push(testchange3);
			
			String teststr = "";
			
			for(DrawingChange x : testStack) {
				teststr += x.newChar;
			}
			
			if(!teststr.equals("CBA")) return false;
		}catch(Exception e) {
			return false;
		}
		
		return true;
		
	}
}

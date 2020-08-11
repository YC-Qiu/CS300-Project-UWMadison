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

/**
 * This class represents a change happend in canvas.
 * @author YC Qiu
 * @version 1.0
 * @since 2019-11-14
 */
public class DrawingChange {
	
	public final int row; // row (y-coordinate) for this DrawingChange
	public final int col; // col (x-coordinate) for this DrawingChange
	public final char prevChar; // previous character in the (row,col) position
	public final char newChar; // new character in the (row,col) position
	
	/**
	 * Draw a new char at the given position.
	 * @param row row of change
	 * @param col column of change
	 * @param prevChar the char at the position before the change
	 * @param newChar new char to draw
	 */
	public DrawingChange(int row, int col, char prevChar, char newChar) {
		
		this.row = row;
		
		this.col = col;
		
		this.prevChar = prevChar;
		
		this.newChar = newChar;
		
	}
	
	
}

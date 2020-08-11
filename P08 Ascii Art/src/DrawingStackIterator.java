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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents an iterator for DrawingStack class.
 * @author YC Qiu
 * @version 1.0
 * @since 2019-11-14
 */
public class DrawingStackIterator implements Iterator<DrawingChange>{

	private LinkedNode<DrawingChange> currentPoi;
	// Current position
	
	/**
	 * Default constructor.
	 * @param top top of the stack
	 */
	public DrawingStackIterator(LinkedNode<DrawingChange> top) {
		// TODO Auto-generated constructor stub
		currentPoi = top;
		
	}
	
	/**
	 * Check if the next node is available.
	 * @see java.util.Iterator#hasNext()
	 * @return true if the stack has next node to go through.
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return currentPoi != null;
	}

	/**
	 * Returns the current data and move to the next node
	 * @see java.util.Iterator#next()
	 * @return the current data
	 */
	@Override
	public DrawingChange next() {
		// TODO Auto-generated method stub
		if(!hasNext())
		throw new NoSuchElementException("No elements remain");
		
		DrawingChange data = currentPoi.getData();
		
		currentPoi = currentPoi.getNext();
		
		return data;
	}
	
	
}

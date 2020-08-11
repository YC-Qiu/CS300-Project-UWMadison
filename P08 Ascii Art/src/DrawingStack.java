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
import java.util.Iterator;

/**
 * This class represents a stack for saving the changes.
 * @author YC Qiu
 * @version 1.0
 * @since 2019-11-14
 */
public class DrawingStack implements StackADT<DrawingChange>,
Iterable<DrawingChange>{

	// top of the stack
	private LinkedNode<DrawingChange> top;
	
	// number of elements
	private int size;
	
	/**
	 * Constructor for initializing.
	 */
	public DrawingStack() {
		// TODO Auto-generated constructor stub
		top = null;
		
		size = 0;
	}
	
	/**
	 * Returns an iterator of this class.
	 * @see java.lang.Iterable#iterator()
	 * @return an instance of DrawingStackIterator
	 */
	@Override
	public Iterator<DrawingChange> iterator() {
		// TODO Auto-generated method stub
		return new DrawingStackIterator(top);
	}

	/**
	 * Push an element into the stack
	 * @param element a DrawingChange element to be added in
	 * @see StackADT#push(java.lang.Object)
	 * @throws IllegalArgumentException if element is null.
	 */
	@Override
	public void push(DrawingChange element) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(element == null)
			throw new IllegalArgumentException("input is null");
		
		LinkedNode<DrawingChange> newnode = new LinkedNode<DrawingChange>(element);
		
		if(top != null) newnode.setNext(top);
		top = newnode;
		
		size++;
	}

	/** 
	 * Pop the top element of the stack.
	 * @see StackADT#pop()
	 * @return the data gotten
	 * @throws EmptyStackException if the stack is empty
	 */
	@Override
	public DrawingChange pop() throws EmptyStackException{
		// TODO Auto-generated method stub
		if(isEmpty()) throw new EmptyStackException();
		
		DrawingChange data = top.getData();
		
		top = top.getNext();
		
		size--;
		
		return data;
	}

	/**
	 * Get the data of the top element without removing it. 
	 * @see StackADT#peek()
	 * @return the data of the top element
	 * @throws EmptyStackException if the stack is empty
	 */
	@Override
	public DrawingChange peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		
		if(isEmpty()) throw new EmptyStackException();
		
		return top.getData();
	}

	/**
	 * Check whether the stack is empty.
	 * @see StackADT#isEmpty()
	 * @return true if the stack is empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	/** 
	 * Returns the number of elements inside the stack.
	 * @see StackADT#size()
	 * @return the size of the stack
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}

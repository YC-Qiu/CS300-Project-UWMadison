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
 * This class implements a canvas to draw characters.
 * @author YC Qiu
 * @version 1.0
 * @since 2019-11-14
 */
public class Canvas {

	private final int width; // width of the canvas

	private final int height; // height of the canvas

	private char[][] drawingArray; // 2D character array to store the drawing

	private final DrawingStack undoStack; // store previous changes for undo

	private final DrawingStack redoStack; // store undone changes for redo

	/**
	 * Constructor creates a new canvas which is initially blank (use the default
	 * value for char type or you can use spaces.
	 * @param width width of canvas
	 * @param height height of canvas
	 * @throws IllegalArgumentException with a descriptive error message
	 * if width or height is 0 or negative.
	 */
	public Canvas(int width, int height) throws IllegalArgumentException{
		
		// Check if width or height is invalid
		if(width <=0 || height <=0)
		throw new IllegalArgumentException("Width or height is invalid.");
		
		this.width = width;
		
		this.height = height;
		
		drawingArray = new char[height][width];
		
		// Initialize the array
		for(int i = 0; i < height; i++) {
			for(int j = 0 ; j < width; j++) {
				
				drawingArray[i][j] = '\0';
				
			}
		}
		
		// Initialize stacks
		undoStack = new DrawingStack();
		
		redoStack = new DrawingStack();
	}

	/**
	 * Draw a character at the given position drawingArray[row][col].
	 * If that position is already marked with a different character, overwrite
	 * it. After making a new change, add a matching DrawingChange to the
	 * undoStack so that we can undo if needed. After making a new change, the
	 * redoStack should be empty (meaning that you should clear the redoStack if
	 * it is not already empty).
	 * @param row row of element
	 * @param col column of element
	 * @param c new char to draw
	 * @throws IllegalArgumentException if the drawing position is
	 * outside the canvas
	 */
	public void draw(int row, int col, char c) 
		throws IllegalArgumentException {
		
		// Check if position is outside the canvas
		if(row < 0 || row >= height || col < 0 || col >= width)
			throw new IllegalArgumentException("The position is outside"
				+ " the canvas.");
		
		char prevchar = drawingArray[row][col];
		
		DrawingChange newchange = new DrawingChange(row, col,prevchar,c);
		
		drawingArray[row][col] = c;
		
		undoStack.push(newchange);
		
		clearStack(redoStack);
		
	}
	
	/**
	 * Clear the assigned stack.
	 * @param ds stack to clear
	 */
	private void clearStack(DrawingStack ds) {
		
		while(!ds.isEmpty()) ds.pop();
		
	}
	
	/**
	 * Undo the most recent drawing change. An undone DrawingChange should be
	 * popped off the undoStack. An undone DrawingChange should be added to the
	 * redoStack so that we can redo if needed. The content of the drawingArray
	 * should be updated accordingly to this change.
	 * @return true if successful. False otherwise.
	 */
	public boolean undo() {
		
		if(undoStack.isEmpty()) return false;
		
		DrawingChange lastchange = undoStack.pop();
		
		// Get the information from last change.
		int row = lastchange.row;
		int col = lastchange.col;
		char prevchar = lastchange.prevChar;
		
		// Do the change.
		drawingArray[row][col] = prevchar;
		
		// Push the change into redostack.
		redoStack.push(lastchange);
		
		return true;
	}

 
	/**
	 * Redo the most recent undone drawing change. A redone DrawingChange should
	 * be popped off the redoStack. A redone DrawingChange should be added (back)
	 * to the undoStack so that we can undo again if needed. The content of the
	 * drawingArray should be updated accordingly to this change.
	 * @return true if successful. False otherwise.
	 */
	public boolean redo() {
		
		if(redoStack.isEmpty()) return false;
		
		DrawingChange lastchange = redoStack.pop();
		
		// Get the information from last change.
		int row = lastchange.row;
		int col = lastchange.col;
		char newchar = lastchange.newChar;
		
		// Do the change.
		drawingArray[row][col] = newchar;
		
		// Push the change into undostack.
		undoStack.push(lastchange);
		
		return true;
		
	}
	
	@Override
	/**
	 * Return a printable string version of the Canvas.
	 * Format example:
	 * [_ is blank. Use System.lineSeparator() to put a newline character between
	 * rows]
	 * X___X
	 * _X_X_
	 * __X__
	 * _X_X_
	 * X___X
	 * @return a printable string version of the Canvas
	 */
	public String toString() {
		
		String result = "";
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				
				result += drawingArray[i][j];
				
			}
			
			result += System.lineSeparator();
			
		}
		
		return result;

	}
	
	/**
	 * Print the full canvas.
	 */
	public void printDrawing() {
		
		System.out.println(toString());
		
	}
	
	/**
	 * Print a record of the changes that are stored on
	 * the undoStack.
	 */
	public void printHistory() {
		
		int count = undoStack.size();
		
		for(DrawingChange x : undoStack) {
			
			System.out.println(count+". draw '" + x.newChar
				+ "' on ("+ x.row + "," + x.col +")");
			
			count--;
		}
	}
}

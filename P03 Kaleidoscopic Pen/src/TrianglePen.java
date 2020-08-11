//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P03 Kaleidoscopic Pen
// Files:           TrianglePen.java, Point.java, Triangle.java,
// 									KaleidoscopePen.java
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
// Persons:   
// Online Sources:  
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;
import java.util.Iterator;
import processing.core.PApplet;

/**
 * The TrianglePen Class implements a pen that creates points when the mouse
 * pressing, and creates a new triangle when for each three points created.
 * 
 * @author Yucheng Qiu
 * @version 1.0
 * @since 2019-9-25
 */
public class TrianglePen {
	
	/**
	 * A default constructor for creating an instance of TrianglePen class.
	 */
	public TrianglePen() {}
	
	
	/** 
	 * Constructor for creating an instance of TrianglePen class.
	 * @param processing Applet object that represents the graphic display window
	 * @param showPoints whether to show the Points created by this pen or not 
	 */
	public TrianglePen(PApplet processing, boolean showPoints) {
		
		//Set the processing class variable to the one passed as input parameter.
		this.processing = processing;
		
		mouseWasPressed = false;
		
		keyWasPressed = '\0';
		
		//Initiate the ArrayList for points and triangles.
		PointsArray = new ArrayList<Point>();
		
		TrianglesArray = new ArrayList<Triangle>();
		
		NumOfPoints = 0;
		
		this.showPoints = showPoints;
	}
	
	/** 
	 * Update the picture on the screen.
	 * @param mouseX the x-position of the mouse
	 * @param mouseY the y-position of the mouse
	 * @param mousePressed whether the mouse is pressed
	 * @param keyPressed whether a key is pressed
	 */
	public void update(int mouseX, int mouseY, boolean mousePressed,
	  char keyPressed){
		
	  // process mouse-based user input
		if(mousePressed != mouseWasPressed) {
			
			if(mousePressed) handleMousePress(mouseX, mouseY);
			
			else handleMouseRelease(mouseX, mouseY);
			
		}
		
		if(mousePressed) handleMouseDrag(mouseX, mouseY);
		
		mouseWasPressed = mousePressed;
		
		// process keyboard-based user input
		if(keyPressed != keyWasPressed) handleKeyPress(mouseX, mouseY, keyPressed);
			keyWasPressed = keyPressed;
		
		// draw everything in its current state
		draw();
		
	}
	
	/**
	 * Draw the triangles and points onto the screen.
	 */
	private void draw() {
		
		// The number of points created.
		int PointsCount = 0;
		
		for(Iterator<Point> iterator = PointsArray.iterator(); 
			iterator.hasNext();) {
			
			Point CurrentPoint =  iterator.next();
			
			PointsCount++;
			
			// For each three points created, draw a triangle.
			if(PointsCount % 3 == 0) 
				TrianglesArray.get((PointsCount/3)-1).draw(processing);
			
			if(showPoints) CurrentPoint.draw(processing);
			
		}
		
	}

	/**
	 * Method to handle a dragged point when the mouse is released.
	 * @param mouseX the x-position of the mouse
	 * @param mouseY the y-position of the mouse
	 */
	private void handleMouseRelease(int mouseX, int mouseY) {
		
		// The mouse released that point.
		CurrentDrag = null;
		
	}

	/**
	 * Method to change the color of a triangle when a key is pressed
	 * @param mouseX the x-position of the mouse
	 * @param mouseY the y-position of the mouse
	 * @param keyPressed whether a key is pressed
	 */
	private void handleKeyPress(int mouseX, int mouseY, char keyPressed){

		int ColorChange = keyPressed - '0';
		
		// If the color is in range
		if(ColorChange >= 0 && ColorChange <= 7) {
			
			for(Iterator<Triangle> iterator = TrianglesArray.iterator();
				iterator.hasNext();) {
				
				// Change the color of triangles beneath the mouse
				iterator.next().TryToChangeTriangleColor(mouseX, mouseY ,ColorChange);
				
			}
			
		}
		
	}

	/**
	 * Method to change the position of a point when the mouse drags it
	 * @param mouseX the x-position of the mouse
	 * @param mouseY the y-position of the mouse
	 */
	private void handleMouseDrag(int mouseX, int mouseY) {
		
		if(CurrentDrag != null) {
			
			// Reset the position of the point to follow the mouse
			CurrentDrag.setPosition(mouseX, mouseY);
		
		}
		
	}

	private boolean mouseWasPressed; // mousePressed from previous update() call
	
	private char keyWasPressed; // keyPressed from previous update() call
	
	private ArrayList<Point> PointsArray; // ArrayList to store all the points
	
	// ArrayList to store all the triangles
	private ArrayList<Triangle> TrianglesArray; 
	
	// PApplet object that represents the graphic display window
	private PApplet processing;
	
	private int NumOfPoints; 	// Number of points created
	
	private Point CurrentDrag; // Currently dragged point
	
	// whether to show the Points created by this pen or not
	private boolean showPoints;
	
	/**
	 * Method to draw points and triangles when the mouse is pressed
	 * @param mouseX the x-position of the mouse
	 * @param mouseY the y-position of the mouse
	 */
	private void handleMousePress(int mouseX, int mouseY) {
		
		for(Iterator<Point> iterator = PointsArray.iterator();iterator.hasNext();){
			
			Point point = iterator.next();
			
			// If the mouse is trying to drag a point, don't create any point.
			if(point.isOver(mouseX, mouseY)) {CurrentDrag = point; return;}
			
		}
		
		// Add a new point.
		Point NewPoint = new Point(mouseX, mouseY); 
		
		NumOfPoints++;
		
		PointsArray.add(NewPoint);
		
		// Add a triangle for each three points created.
		if(NumOfPoints % 3 == 0) {
			Triangle NewTriangle = new Triangle(
				PointsArray.get(NumOfPoints-3),
				PointsArray.get(NumOfPoints-2),
				PointsArray.get(NumOfPoints-1), 0);
			
			TrianglesArray.add(NewTriangle);
					
		}
	}
}

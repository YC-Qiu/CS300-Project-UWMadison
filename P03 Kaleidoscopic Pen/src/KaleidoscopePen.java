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
import processing.core.PApplet;

/**
 * The KaleidoscopePen Class implements a Kaleidoscope pen that controls
 * five triangle pens to create 5 rotated triangles each time.
 * 
 * @author Yucheng Qiu
 * @version 1.0
 * @since 2019-9-25
 */
public class KaleidoscopePen {
	
	// PApplet object that represents the graphic display window
	private PApplet processing;
	
	// Constant pi
	private double pi = 3.14;
	
	// number of trianglepens controlled
	private int NumberOfPens;
	
	/**
	 * A Constructor to create an instance of a KaleidoscopePen
	 * @param drawTo PApplet object that represents the graphic display window
	 * @param numberOfTrianglePens umber of trianglepens controlled
	 */
	public KaleidoscopePen(PApplet drawTo, int numberOfTrianglePens) {
		
		processing = drawTo;
		
		NumberOfPens = numberOfTrianglePens;
		
		myTrianglePens = new TrianglePen[numberOfTrianglePens];
		
		// Initiate all the TrianglePens
		for(int i = 0; i < numberOfTrianglePens; i++) {
			
			// Only make the first pen to create visible points
			if(i == 0) myTrianglePens[i] = new TrianglePen(processing,true);
			else myTrianglePens[i] = new TrianglePen(processing,false);
			
		}
		
	}
	
	private TrianglePen[] myTrianglePens; // ArrayList contains all TrianglePens
	
	/**
	 * Update the images on screen
	 * @param mouseX the x-position of the mouse
	 * @param mouseY the x-position of the mouse
	 * @param mousePressed whether mouse is pressed
	 * @param keyPressed whether a key is pressed
	 */
	public void update(int mouseX, int mouseY, boolean mousePressed,
		char keyPressed) {
		
		for(int i = 0; i < NumberOfPens; i++) {
			
			// the position of the points after rotation
			int XAfterRotate,yAfterRotate;
			
			double RotateDegree = (i * 2 * pi / NumberOfPens);
			
			XAfterRotate = rotate(mouseX, mouseY, RotateDegree)[0];
			
			yAfterRotate = rotate(mouseX, mouseY, RotateDegree)[1];
			
			// Rotate the points to create Kaleidoscope
			myTrianglePens[i].update(XAfterRotate, yAfterRotate, mousePressed,
				keyPressed);
			
		}
	}
	
	
	
	/**
	* Rotates a position around the center of an 800x600 screen by the specified
	* amount, and then returns an array containing the resulting position.
	* @param x position of the point to be rotated (0 to 800 pixels)
	* @param y position of the point to be rotated (0 to 600 pixels)
	* @param angle amount of rotation to apply(angle in radians units: 0 to 2*PI)
	* @return the rotated position array: x @ index 0, y @ index 1
	*/
	private int[] rotate(int x, int y, double angle) {
		x -= 400; // translate center of screen to origin (0,0)
		y -= 300;
		int[] rotatedPosition = new int[] { // rotate around origin
			(int)(x * Math.cos(angle) - y * Math.sin(angle)),
			(int)(x * Math.sin(angle) + y * Math.cos(angle)) };
		rotatedPosition[0] += 400; // return to center of screen
		rotatedPosition[1] += 300;
		return rotatedPosition;
	}
}

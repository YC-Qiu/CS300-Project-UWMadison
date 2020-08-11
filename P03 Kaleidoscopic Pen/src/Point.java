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
 * The Point Class implements points that can appear on the screen
 * 
 * @author Yucheng Qiu
 * @version 1.0
 * @since 2019-9-25
 */
public class Point {
	
	private int xPos, yPos; // The position of the center of the point
	
	/**
	 * A constructor to create a point object
	 * @param x_position the x-position of the center of the point
	 * @param y_position the y-position of the center of the point
	 */
	public Point(int x_position, int y_position) {
		
		xPos = x_position;
		
		yPos = y_position;
		
	}
	
	
	/**
	 * A method to get the private variable xPos
	 * @return the value of xPos
	 */
	public int getX() {return this.xPos;}
	
	/**
	 * A method to get the private variable yPos
	 * @return the value of yPos
	 */
	public int getY() {return this.yPos;}
	
	
	/**
	 * Set the position for the center of the point
	 * @param x the x-position for the point to be settled
	 * @param y the y-position for the point to be settled
	 */
	public void setPosition(int x, int y) {
		
		xPos = x;
		
		yPos = y;
		
	}
	
	// The diameter of the point
	public final static int POINT_DIAMETER = 8;
	
	/**
	 * Draw to point onto the screen
	 * @param drawTo PApplet object that represents the graphic display window
	 */
	public void draw(PApplet drawTo) {
		
		// draw a white circle at this point's position
		drawTo.circle(xPos, yPos, POINT_DIAMETER);
		
	}
	
	
	/**
	 * @param x the x-position of a given point
	 * @param y the y-position of a given point
	 * @return returns true when the position x, y
	 * is within the circle drawn to visualize this point, 
	 * otherwise returns false
	 */
	public boolean isOver(int x, int y) {
		
		//the formula for calculating the distance from the given point
		//to the center of the circle
		double Distance = (x - xPos)*(x - xPos) + (y - yPos)*(y - yPos);
		Distance = Math.pow(Distance, 0.5);
		
		return Distance < POINT_DIAMETER/2; 
		
	}
}

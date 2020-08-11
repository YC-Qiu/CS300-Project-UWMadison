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
 * The Triangle Class implements triangles that can appear on the screen
 * 
 * @author Yucheng Qiu
 * @version 1.0
 * @since 2019-9-25
 */
public class Triangle {
	
	// the vertice of the triangle
	private Point MyPoint1, MyPoint2, MyPoint3;
	
	//the color of the triangle
	private int color;
	
	
	/**
	 * A Constructor to create an instance of Triangle
	 * @param point1 vertex 1
	 * @param point2 vertex 2
	 * @param point3 vertex 3
	 * @param color the color of the triangle
	 */
	public Triangle(Point point1, Point point2, Point point3, int color) {

		MyPoint1 = point1;

		MyPoint2 = point2;

		MyPoint3 = point3;

		this.color = COLORS[color];

	}

	private static final int[] COLORS = new int[] { //int packed w/8 bits of ARGB
		// WHITE, RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
		-1, -766643, -752563, -723891, -11668348, -11696908, -8106508, -766476 };

	/**
	 * Set the color of the triangle
	 * @param color the color to set
	 */
	public void setColor(int color) {
		
		this.color = COLORS[color];

	}
	
	/**
	 * To Judge whether the color of that triangle should be changed,
	 * for each one in the arraylist.
	 * @param px the x-position of the mouse
	 * @param py the y-position of the mouse
	 * @param color the color to change
	 */
	public void TryToChangeTriangleColor(int px, int py, int color) {
		
		// If the mouse is over the triangle, change its color.
		// Otherwise do nothing.
		if(isOver(px, py)) setColor(color);
			
	}
	
	/**
	 * to judge if the mouse is over a triangle
	 * @param px the x-position of the mouse
	 * @param py the y-position of the mouse
	 * @return true if the mouse is over it, false for not
	 */
	public boolean isOver(int px, int py) {
		int t1x = MyPoint1.getX();
		int t1y = MyPoint1.getY();
		int t2x = MyPoint2.getX();
		int t2y = MyPoint2.getY();
		int t3x = MyPoint3.getX();
		int t3y = MyPoint3.getY();
		
		px -= t1x; // don't worry about this arithmetic
		
		py -= t1y;
		
		t2x -= t1x;
		
		t2y -= t1y;
		
		t3x -= t1x;
		
		t3y -= t1y;
		
		double dotp2 = px * t2x + py * t2y;
		
		double dotp3 = px * t3x + py * t3y;
		
		double dot22 = t2x * t2x + t2y * t2y;
		
		double dot23 = t2x * t3x + t2y * t3y;
		
		double dot33 = t3x * t3x + t3y * t3y;
		
		double invDen = 1 / (dot33 * dot22 - dot23 * dot23);
		
		double a = (dot22 * dotp3 - dot23 * dotp2) * invDen;
		
		double b = (dot33 * dotp2 - dot23 * dotp3) * invDen;
		
		return (a >= 0) && (b >= 0) && (a + b < 1);
		
	}
	
	/**
	 * Draw to triangle onto the screen
	 * @param drawTo PApplet object that represents the graphic display window
	 */
	public void draw(PApplet drawTo) {
		
		// Set the color of the triangle printed
		drawTo.fill(color);
		
		drawTo.triangle(
			MyPoint1.getX(), MyPoint1.getY(),
			MyPoint2.getX(), MyPoint2.getY(),
			MyPoint3.getX(), MyPoint3.getY());
		
		// Reset the color
		drawTo.fill(-1);
		
	}
	
}

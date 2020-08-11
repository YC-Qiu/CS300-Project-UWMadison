//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P05 Memeage 5000
// Files:           MemeageTests.java, Color.java, ColorPlusChar.java,
//									Memeage.java
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
 * This class implements a color pixel as a FourByte object.
 * 
 * @author YC Qiu
 * @version 1.0
 * @since 2019-10-17
 */
/**
 * @author pc
 *
 */
/**
 * @author pc
 *
 */
public class Color extends FourBytes {

	public Color(int argb) {
		
		super(argb);
		
	}

	/**
	 * Constructor using 4 basic arguments of color.
	 * @param alpha value of alpha
	 * @param red value of red
	 * @param green value of green
	 * @param blue value of blue
	 */
	public Color(int alpha, int red, int green, int blue) {
		
		super(0);
		
		setAlpha(alpha);
		
		setRed(red);
		
		setGreen(green);
		
		setBlue(blue);
		
	}
	
	/**
	 * Construct a Color object with the same value
	 * @param other a Color object
	 */
	public Color(Color other) {
		
		super(other.getInt());
		
	}
	
	/**
	 * Set the argb value of a Color pixel.
	 * @param argb the value of argb
	 */
	public void setARGB(int argb) {
		
		setInt(argb);
		
	}
	
	/**
	 * Set the value of alpha.
	 * @param alpha value of alpha
	 */
	public void setAlpha(int alpha) {
		
		setBits(8, 24, alpha);
		
	}
	
	/**
	 * Set the value of red.
	 * @param red value of red
	 */
	public void setRed(int red) {
		
		setBits(8, 16, red);
		
	}
	
	/**
	 * Set the value of green.
	 * @param green value of green
	 */
	public void setGreen(int green) {
		
		setBits(8, 8, green);
		
	}
	
	/**
	 * Set the value of blue.
	 * @param blue value of blue
	 */
	public void setBlue(int blue) {
		
		setBits(8, 0, blue);
		
	}
	
	/**
	 * Get the ARGB value of this pixel.
	 * @return value of argb
	 */
	public int getARGB(){
		
		return getInt();
		
	}
	
	/**
	 * Get the alpha value of this pixel.
	 * @return value of alpha
	 */
	public int getAlpha(){
		
		return getBits(8,24);
		
	}
	
	
	/**
	 * Get the red value of this pixel.
	 * @return value of red.
	 */
	public int getRed(){
		
		return getBits(8,16);
		
	}
	
	/**
	 * Get the green value of this pixel.
	 * @return value of green
	 */
	public int getGreen(){
		
		return getBits(8,8);
		
	}
	
	
	/**
	 * Get the blue value of this pixel.
	 * @return value of blue
	 */
	public int getBlue(){
		
		return getBits(8,0);
		
	}
	
	
}

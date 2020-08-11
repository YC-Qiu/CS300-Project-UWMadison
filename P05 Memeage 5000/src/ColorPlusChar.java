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
 * This class implements how a character is put into a color pixel.
 * 
 * @author YC Qiu
 * @version 1.0
 * @since 2019-10-17
 */
public class ColorPlusChar extends Color {

	/**
	 * Constructor using a Color object and a char.
	 * @param color the color to add
	 * @param character the char to add
	 */
	public ColorPlusChar(Color color, char character) {
		
		super(color);
		
		hideChar(character);
		
	}
	
	/**
	 * Constructor using a Color object
	 * @param color a Color object 
	 */
	public ColorPlusChar(Color color) {
		
		super(color);
		// TODO Auto-generated constructor stub
		
	}
	
	
	/**
	 * stores 8-bit character within the least significant bits of color
	 * components
	 * @param character the char to hide
	 */
	public void hideChar(char character) {
		
		FourBytes CharToHide = new FourBytes(character);
		
		// Change the bits
		setBits(2, 0, CharToHide.getBits(2, 0));

		setBits(2, 8, CharToHide.getBits(2, 2));

		setBits(2, 16, CharToHide.getBits(2, 4));

		setBits(2, 24, CharToHide.getBits(2, 6));
		
	}
	
	/**
	 * retrieves 8-bit character from the least significant bits of color
	 * components
	 * @return the char revealed
	 */
	public char revealChar() {
		
		FourBytes RevealChar = new FourBytes(0);
		// Hide the char
		RevealChar.setBits(2, 6 , getBits(2, 24));
		
		RevealChar.setBits(2, 4, getBits(2, 16));
		
		RevealChar.setBits(2, 2, getBits(2, 8));
		
		RevealChar.setBits(2, 0, getBits(2, 0));
		
		return RevealChar.getChar();
		
	}

}

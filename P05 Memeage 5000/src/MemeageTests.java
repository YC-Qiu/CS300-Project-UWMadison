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
import java.io.File;
import java.io.IOException;

/**
 * This class tests the whole project.
 * 
 * @author YC Qiu
 * @version 1.0
 * @since 2019-10-17
 */
public class MemeageTests {

	/**
	 * Call the tests.
	 * @param args input arguments 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(!testColor()) System.out.println("testColor() not passed.");
		
		if(!testColorPlusChar())
			System.out.println("testColorPlusChar() not passed.");
		
		if(!testFourBytesGetBits())
			System.out.println("testFourBytesGetBits() not passed.");
		
		if(!testFourBytesSetBits())
			System.out.println("testFourBytesSetBits() not passed.");
		
		if(!testImage())
			System.out.println("testImage() not passed.");
		
		if(!testMemeage())
			System.out.println("testMemeage() not passed");
		

	}
	
	/**
	 * Test setBits() method in FourByte Class
	 * @return true if the method correctly works.
	 */
	public static boolean testFourBytesSetBits() {
		
		FourBytes newFourbyte = new FourBytes(0);
		
		newFourbyte.setBits(3, 8, 13);
		
		if(newFourbyte.getInt() != 1280) return false;
		
		return true;
	}
	
	/**
	 * Test getBits() method in FourByte Class
	 * @return true if the method correctly works.
	 */
	public static boolean testFourBytesGetBits() {
		
		FourBytes newFourbyte = new FourBytes(13312);
		
		if ( newFourbyte.getBits(4, 10) != 13) return false;
		
		return true;
		
	}
	
	/**
	 * Test constructor, setter, and getter method in Color Class
	 * @return true if the methods correctly works.
	 */
	public static boolean testColor() {
		
		Color color = new Color(13312);
		
		if(color.getARGB() != 13312) return false;
		
		if(color.getAlpha() != 0) return false;
		
		if(color.getGreen() != 52) return false;
		
		color.setBlue(99);
		
		if(color.getBlue() != 99) return false;
		
		return true;
	}
	
	/**
	 * Test constructor, setter, and getter method in Image Class
	 * @return true if the method correctly works.
	 */
	public static boolean testImage() {
		
		File imagefile = new File("testImage.png");
		
		try {
			
			Image testimage = new Image(imagefile);
			
			if(testimage.getHeight() != 3) return false;
			
			if(testimage.getWidth() != 3) return false;
			
			if(testimage.getColor(1, 1).getGreen() != 255) return false;

			
			if(testimage.getColor(1, 1).getBlue() != 255) return false;
			
			if(testimage.getColor(1, 1).getRed() != 0) return false;
			
		} catch (IOException e) {
			// TODO: handle exception
			return false;
			
		}
		
		return true;

	}
	
	/**
	 * Test constructor, setter, and getter method in ColorPlusChar Class
	 * @return true if the method correctly works.
	 */
	public static boolean testColorPlusChar() {
		
		Color c = new Color(0);
		
		ColorPlusChar TestCPC = new ColorPlusChar(c,'k');
		
		if(TestCPC.revealChar() != 'k') return false;
		
		TestCPC.hideChar('s');
		
		if(TestCPC.revealChar() != 's') return false;
		
		return true;
		
	}
	
	/**
	 * Test constructor, setter, and getter method in Memeage Class
	 * @return true if the method correctly works.
	 */
	public static boolean testMemeage() {
		
		File f = new File("image02.png");
		
		try {
			
			Memeage newMemeage = new Memeage(f,"I love CS 300");

			
			if(!newMemeage.getMeme().equals("I love CS 300")) return false;

			newMemeage.setMeme("I hope my homework and final exam have full points");
			
			if(!newMemeage.getMeme().equals("I hope my"
				+ " homework and final exam have full points")) return false;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}

		return true;
	}
}

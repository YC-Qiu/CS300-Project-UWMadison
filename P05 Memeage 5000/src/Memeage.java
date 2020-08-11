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
 * This class creates memeage to hide a string.
 * 
 * @author YC Qiu
 * @version 1.0
 * @since 2019-10-17
 */
public class Memeage extends Image {

	/**
	 * Constructor loading from a file
	 * @param file the file to load
	 */
	public Memeage(File file) throws IOException{
		
		super(file);
		
	}

	
	/**
	 * Create a memeage to hide a string
	 * @param file picture to load
	 * @param meme the string to hide
	 */
	public Memeage(File file, String meme)
		throws IOException, IllegalArgumentException{
		
		super(file);
		
		setMeme(meme);
		
	}
	
	/**
	 * Set the meme into a picture
	 * @param meme the string to set
	 * @throws IllegalArgumentException if the number of characters in the
	 * String meme is greater than or equal to the number of Colors/pixel
	 * locations within the image. Or any character within the meme message
	 * has a character code that is greater than 127
	 */
	public void setMeme(String meme) throws IllegalArgumentException{
		
		// The number of chars
		int count = 0;
		
		//Exception
		if(getHeight() * getWidth() <= meme.length())
			throw new IllegalArgumentException("The number of characters in the "
			+ "String meme is greater than or equal to the number of Colors"
			+ "/pixel locations within the image");
		
		for(int i = 0; i < getHeight() && count != -1; i++) {
			
			for(int j = 0; j < getWidth() && count != -1; j++) {

				if(count == meme.length()) {
					
					// if the meme ends
					ColorPlusChar MemeColor = new ColorPlusChar(getColor(j, i), '\0');
					
					setColor(j, i, MemeColor);
					
					count = -1;
					
					break;
				}
				
				if(meme.charAt(count) > 127)
					throw new IllegalArgumentException("A non-ASCII character");
				
				ColorPlusChar MemeColor = new ColorPlusChar(getColor(j, i),
					meme.charAt(count));
				
				setColor(j, i, MemeColor);
				
				count++;
				
			}
			
		}
		
	}
	
	/**
	 * Get the meme inside a picture.
	 * @return the meme found
	 * @throws IllegalStateException a character with a character code that is
	 * greater than 127 is extracted from a Color within the memeage or none
	 * of the characters extracted from this image contain the null character
	 * that should exist to mark the end of the meme message: '\0'.
	 */
	public String getMeme() throws IllegalStateException{
		
		char[] CollectedChar = new char[getHeight() * getWidth()];
		
		//The number of chars collected
		int count = 0;
		
		for(int i = 0; i < getHeight(); i++) {
			
			for(int j = 0; j < getWidth(); j++) {
				
				ColorPlusChar MemeColor = new ColorPlusChar(getColor(j, i));
				
				char newChar = MemeColor.revealChar();
				
				//exception
				if(newChar > 127)
					throw new IllegalStateException("A non-ASCII character");
				
				if(newChar == '\0') {
					// if the meme ends, return the string collected.
					String Meme = new String(CollectedChar, 0, count);
					
					return Meme;
					
				}
				
				CollectedChar[count++] = newChar;
				
			}
		}
		
		throw new IllegalStateException("Character to mark the end of the meme "
			+ "message doesn't exist");
		
	}
}

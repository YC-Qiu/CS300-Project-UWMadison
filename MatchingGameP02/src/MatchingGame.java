
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           MatchingGame
// Files:           MatchingGame.java
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
import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * @author <Yucheng Qiu>
 *
 */
public class MatchingGame {

	// Congratulations message
	private final static String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";

	// Cards not matched message
	private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!";

	// Cards matched message
	private final static String MATCHED = "CARDS MATCHED! Good Job!";

	// 2D-array which stores cards coordinates on the window display
	private final static float[][] CARDS_COORDINATES = new float[][] { 
		{ 170, 170 }, { 324, 170 }, { 478, 170 },
			{ 632, 170 }, { 170, 324 }, { 324, 324 }, 
			{ 478, 324 }, { 632, 324 }, { 170, 478 }, 
			{ 324, 478 }, { 478, 478 }, { 632, 478 } };

	// Array that stores the card images filenames
	private final static String[] CARD_IMAGES_NAMES = new String[] { 
			"apple.png", "ball.png", "peach.png",
			"redFlower.png", "shark.png", "yellowFlower.png" };

	// PApplet object that represents the graphic display window
	private static PApplet processing;

	private static Card[] cards; // one dimensional array of cards

	private static PImage[] images; // array of images of the different cards

	private static Random randGen; // generator of random numbers

	private static Card selectedCard1; // First selected card

	private static Card selectedCard2; // Second selected card

	// boolean evaluated true if the game is won, and false otherwise
	private static boolean winner;

	// number of cards matched so far in one session of the game
	private static int matchedCardsCount;

	private static String message; // Displayed message to the display window

	/**
	 * Defines the initial environment properties of this game as the program starts
	 */
	public static void setup(PApplet processing) {
		// Set the processing class variable to the one passed as input parameter.
		MatchingGame.processing = processing;

		
		//create the static field images array that stores references of type PImage
		images = new PImage[ CARD_IMAGES_NAMES.length];
		
		// Initiate the images array. Use the image from folder "images"
		for(int i = 0; i < CARD_IMAGES_NAMES.length; i++ ) {
			
			images[i] = processing.loadImage("images" + 
		File.separator + CARD_IMAGES_NAMES[i]);
			
		}
		
		//initiate the game
		initGame();
		
		
	}
	
	/**
	* Initializes the Game
	*/
	public static void initGame() {
		
		//initiate the static field variables
		
		//the random number generator
		randGen = new Random(Utility.getSeed());
		
		//the reference of selected cards
		selectedCard1 = null;
		
		selectedCard2 = null;
		
		//the number of matched cards
		matchedCardsCount = 0;
		
		//Whether the player wins
		winner = false;
		
		//The message displayed to tell the player if the cards
		//he chooses are matched
		message = "";
		
		//an array stores the refernces of all cards
		cards = new Card[CARD_IMAGES_NAMES.length*2];
		
		//an array used to generate random positions.
		//it tells whether a position is already possessed by other cards
		boolean CoordinatesUsed[] = new boolean[CARD_IMAGES_NAMES.length *2];
		
		//Initiate the CoordinatesUsed array.
		for(int i = 0; i < CARD_IMAGES_NAMES.length *2; i++) {
			
			CoordinatesUsed[i] = false;
			
		}
		
		//The number for counting how many coordinates are used.
		int CoordinatesUsedCount = 0;
		
		
		for(int i = 0; i < CARD_IMAGES_NAMES.length * 2; i++) {
			
			//A boolean tells if current position has not been used.
			boolean IsPositionOK = false;
			
			//Current chosen position
			int RandomPosition = 0;
			
			while(IsPositionOK != true || CoordinatesUsedCount >= 12) {
				
				//Generate a random position
				RandomPosition = randGen.nextInt(CARD_IMAGES_NAMES.length *2);
				
				if(CoordinatesUsed[RandomPosition] == false) break;
				
			}
			
			CoordinatesUsed[RandomPosition] = true;
			
			CoordinatesUsedCount ++;
			
			//Create cards objects and ensure that each image should be on
			//EXACTLY TWO cards.
			cards[i] = new Card(images[(int)(i/2)], 
					CARDS_COORDINATES[RandomPosition][0], 
					CARDS_COORDINATES[RandomPosition][1]);
			
		}
		
	}
	
	/**
	* Callback method called each time the user presses a key
	*/
	public static void keyPressed() {
		
		//if key 'n' or 'N' is pressed, the game will be restart.
		if(processing.key == 'n' || processing.key == 'N') {
			
			initGame();
			
		}
	}

	/**
	* Callback method draws continuously this application window display
	*/
	public static void draw() {
		
		// Set the color used for the background of the Processing window
		processing.background(245, 255, 250); // Mint cream color
		
		for(int i = 0; i < CARD_IMAGES_NAMES.length * 2; i++) {
			
			//Draw all the cards.
			cards[i].draw();
			
		}
		
		//Display the message.
		displayMessage(message);
		
	}
	
	/**
	* Displays a given message to the display window
	* @param message to be displayed to the display window
	*/
	public static void displayMessage(String message) {
		
	processing.fill(0);
	
	processing.textSize(20);
	
	processing.text(message, processing.width / 2, 50);
	
	processing.textSize(12);
	
	}
	
	/**
	* Checks whether the mouse is over a given Card
	* @return true if the mouse is over the storage list, false otherwise
	*/
	public static boolean isMouseOver(Card card){
		
		//If the Mouse is in the X-axis range.
		boolean MouseOverX = (processing.mouseX > card.getX() - card.getWidth()/2 && 
				processing.mouseX < card.getX() + card.getWidth()/2);
		
		//If the Mouse is in the Y-axis range.
		boolean MouseOverY = (processing.mouseY > card.getY() - card.getHeight()/2 &&
				processing.mouseY < card.getY() + card.getHeight()/2);
		
		return MouseOverX && MouseOverY;
		
	}
	
	/**
	* Callback method called each time the user presses the mouse
	*/
	public static void mousePressed() {
		
		//If the player wins, do nothing.
		if(winner) return;
		
		for(int i = 0; i < CARD_IMAGES_NAMES.length *2; i++) {
		
			if(isMouseOver(cards[i])) {
				
				cards[i].select();
				
				cards[i].setVisible(true);
				
				//If two different card is selected
				if(selectedCard1 != null && selectedCard2 == null 
						&& !cards[i].equals(selectedCard1)) {
					
					selectedCard2 = cards[i];
					
					//If the player choose the last two cards.
					if(matchedCardsCount == 10 && matchingCards(selectedCard1, selectedCard2)) {
						
						winner = true;
						
						message = CONGRA_MSG;
						
						break;
						
					}
					else if(matchingCards(selectedCard1, selectedCard2)) {
						
						//if two cards are matched.
						message = MATCHED;
						
					}
					else if(!matchingCards(selectedCard1, selectedCard2)) {
						
					//if two cards are not matched.
						message = NOT_MATCHED;
						
					}
				}
				else if(selectedCard1 == null) {
					
					selectedCard1 = cards[i];
					
				}
				else if(selectedCard1 != null && selectedCard2 != null) {
					
					if(!matchingCards(selectedCard1, selectedCard2)) {
						
						//if the selected two cards are not matched, 
						//turn them back.
						selectedCard1.setVisible(false);
						
						selectedCard2.setVisible(false);
						
					}
					else {
						
						//if the cards are matched.
						matchedCardsCount += 2;
						
						if(matchedCardsCount >=12) {
							
							winner = true;
							
							message = CONGRA_MSG;
							
							break;
							
						}
					}
					
					selectedCard1.deselect();
					
					selectedCard2.deselect();
					
					selectedCard1 = null;
					
					selectedCard2 = null;
					
					selectedCard1 = cards[i];
					
				}
				
				break;
				
			}
			
		}
		
	}
	
	/**
	* Checks whether two cards match or not
	* @param card1 reference to the first card
	* @param card2 reference to the second card
	* @return true if card1 and card2 image references are the same, false otherwise
	*/
	public static boolean matchingCards(Card card1, Card card2) {
		
		if(card1.getImage().equals(card2.getImage())) 
			return true;
		else 
			return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Utility.runApplication(); // starts the application
	}

}

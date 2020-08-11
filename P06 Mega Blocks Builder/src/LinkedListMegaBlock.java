//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P06 Mega Blocks Builder
// Files:           LinkedListMegaBlock.java, LinkedMegaBlock.java, 
//									MegaBlockBuilderTester.java
// Course:          COMP SCI 300 FALL 2019
//
// Author:          Yucheng Qiu
// Email:           yqiu56@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Haoming Meng
// Partner Email:   hmeng29@wisc.edu
// Partner Lecturer's Name: Gary Dahl
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   __x_ Write-up states that pair programming is allowed for this assignment.
//   __x_ We have both read and understand the course Pair Programming Policy.
//   __x_ We have registered our team prior to the team registration deadline.
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
import java.util.NoSuchElementException;

/**
 * This class implements a linked list for megablocks.
 * @author <Yucheng Qiu>
 * @version 1.0
 * @since Oct 24 2019
 */
public class LinkedListMegaBlock {
  
  private LinkedMegaBlock head; // head of this list
  private LinkedMegaBlock tail; // tail of this list
  private int size; // size of this list (total number of megablocks stored
  									//in this list)
  private int redCount; // number of RED megablocks stored in this list
  private int yellowCount; // number of YELLOW megablocks stored in this list
  private int blueCount; // number of BLUE megablocks stored in this list
  
  /**
   * Creates an empty linked list of mega blocks
   */
  public LinkedListMegaBlock() {
    // Initiate the list.
  	this.head = null;
    this.tail = null;
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;
  }
  
  /**
   * Adds a blueBlock at the end of this list
   * @param blueBlock new element to be added to this list
   * @throws IllegalArgumentException if blueBlock is null or if the color of
   * the specific blueBlock is not equal to Color.BLUE
   */
  public void addBlue(MegaBlock blueBlock) throws IllegalArgumentException{
    
  	if(blueBlock == null)
  		throw new IllegalArgumentException("The block is null");
  	
  	if(blueBlock.getColor() != Color.BLUE)
  		throw new IllegalArgumentException("The block is not blue");
  	
  	// New LinkedMegaBlock instance
  	LinkedMegaBlock newBlock = new LinkedMegaBlock(blueBlock);
  	
  	addBlock(newBlock, size);
  	
  	blueCount++;
  }
  
  /**
   * Add a LinkedMegaBlock to the assigned position.
   * @param block the block to add
   * @param index the index of the position
   */
  private void addBlock(LinkedMegaBlock block, int index) {
		
  	if(isEmpty()) {
  		// Empty list initiates.
  		tail = block;
  		
  		head = block;
  	}
  	else if(index == 0) {
  		
  		// Add a block to the head
  		block.setNext(head);
  		
  		head = block;
  	}
  	else if (index == size) {
			
  		// Add a block to the tail
  		tail.setNext(block);
  		
  		tail = block;
		}
  	else {
  		
  		// Add a yellow block
  	 	int count = 0;
    	
    	LinkedMegaBlock CurrentBlock = null;
    	
    	// Find the previous block.
    	while(count < index) {
    		
    		if(count == 0) CurrentBlock = head;
    		else CurrentBlock = CurrentBlock.getNext();
    		
    		count++;
    	}
    	
    	block.setNext(CurrentBlock.getNext());
    	
    	CurrentBlock.setNext(block);
		}
  	
  	size++;
  	
  	return;
	}
  
  /**
   * Adds a new object at the head of this list
   * @param redBlock new element to be added to this list
   * @throws IllegalArgumentException if redBlock is null or if its color does
   * not equal to Color.RED
   */
  public void addRed(MegaBlock redBlock) throws IllegalArgumentException{
    
  	if(redBlock == null)
  		throw new IllegalArgumentException("The block is null");
  	
  	if(redBlock.getColor() != Color.RED)
  		throw new IllegalArgumentException("The block is not red");
  	
  	// New LinkedMegaBlock instance.
  	LinkedMegaBlock newBlock = new LinkedMegaBlock(redBlock);
  	
  	addBlock(newBlock, 0);
  	
  	redCount++;
  }
  
  /**
   * Adds the provided yellowBlock at the position index in this list
   * @param index index at which the specified yellow block is to be inserted
   * @param yellowBlock
   * @throws IllegalArgumentException if yellowBlock is null or if it does not
   * have a Color.YELLOW color
   * @throws IndexOutOfBoundsException if the index is out of the range
   * reserved for yellow blocks (index < redCount || index > size - blueCount)
   */
  public void addYellow(int index,MegaBlock yellowBlock) throws
  IllegalArgumentException, IndexOutOfBoundsException {
    
  	if(yellowBlock == null)
  		throw new IllegalArgumentException("The block is null");
  	
  	if(yellowBlock.getColor() != Color.YELLOW)
  		throw new IllegalArgumentException("The block is not yellow");
  	
  	if(index < redCount || index > size - blueCount)
  		throw new IndexOutOfBoundsException("The index is invalid");
  	
  	// New LinkedMegaBlock instance.
  	LinkedMegaBlock newBlock = new LinkedMegaBlock(yellowBlock);
  	
  	addBlock(newBlock, index);
  	
  	yellowCount++;
  }
  
  /**
   * Removes all of the elements from this list. The list will be empty after
   * this call returns.
   */
  public void clear() {
  	
  	// Clear all blocks.
    while(redCount > 0) {
  		removeRed();
  	}
    while(blueCount > 0) {
  		removeBlue();
  	}
    while(yellowCount > 0) {
  		removeYellow(0);
  	}
    
    // Clear head and tail
    head = null;
    tail = null;
    
    // Size should be already set to 0 by removeXXX().
  }
  
  /**
   * Returns the element stored at position index of this list without removing
   * it.
   * @param index position within this list
   * @return the megablock object stored at position index of this list
   * @throws IndexOutOfBoundsException if the index is out of range
   * (index < 0 || index >= size())
   */
  public MegaBlock get(int index) throws IndexOutOfBoundsException{
  	
  	return getLinkedMegaBlock(index).getBlock();
    
  }

  /**
   * Returns the Linked element at position index of this list without removing
   * it.
   * @param index position within this list
   * @return the linkedmegablock at position index of this list
   * @throws IndexOutOfBoundsException if the index is out of range
   * (index < 0 || index >= size())
   */
  private LinkedMegaBlock getLinkedMegaBlock(int index)
  	throws IndexOutOfBoundsException{
  	
  	if(index < 0 || index >= size())
  		throw new IndexOutOfBoundsException("The index is invalid");
  	
  	int count = 0;
  	
  	LinkedMegaBlock CurrentBlock = null;
  	
  	// Find the block with index
  	while(count <= index) {
  		
  		if(count == 0) CurrentBlock = head;
  		else CurrentBlock = CurrentBlock.getNext();
  		
  		count++;
  	}
  	
  	return CurrentBlock;
    
  }
  
  /**
   * Returns the number of blue mega bloks stored in this list
   * @return the blueCount
   */
  public int getBlueCount() {
    
  	return blueCount;
  	
  }
  
  /**
   * Returns the number of red mega bloks stored in this list
   * @return the redCount
   */
  public int getRedCount() {
    
  	return redCount;
  	
  }
  
  /**
   * Returns the number of yellow mega bloks stored in this list
   * @return the yellowCount
   */
  public int getYellowCount() {
    
  	return yellowCount;
  	
  }
  
  /**
   * Returns true if this list contains no elements.
   * @return true if this list is empty, and false otherwise.
   */
  public boolean isEmpty() {
    
  	return size == 0;
  	
  }
  
  private MegaBlock removeBlock(int index) {
		
  	LinkedMegaBlock linkedblock = getLinkedMegaBlock(index);
  	
  	if(index == 0) {
  		
  		// Remove the first block
  		head = linkedblock.getNext();
  		
  	}
  	else if (index == size - 1){
  		
  		// Remove the last block
  		LinkedMegaBlock preblock = getLinkedMegaBlock(size-2);
  		
  		tail = preblock;
  		
  		tail.setNext(null);
  		
		}
  	else {
  		
  	 	int count = 0;
    	
    	LinkedMegaBlock PreBlock = null;
    	
    	// FInd a block between head and tail
    	while(count < index) {
    		
    		if(count == 0) PreBlock = head;
    		else PreBlock = PreBlock.getNext();
    		
    		count++;
    	}
    	
    	PreBlock.setNext(linkedblock.getNext());
    	
		}
  	
  	size--;
  	
  	return linkedblock.getBlock();
  	
	}
  
  /**
   * Removes and returns the element at the tail of this list if it has a blue
   * color
   * @return a reference to the removed element
   * @throws NoSuchElementException if this list does not contain any blue
   * block
   */
  public MegaBlock removeBlue() throws NoSuchElementException{
    
  	if(getBlueCount() == 0)
  		throw new NoSuchElementException("No blue blocks in the list");
  	
  	blueCount--;
  	
  	return removeBlock(size-1);
  	
  }

  /**
   * Removes and returns the mega block at the head of this list if its color
   * is red
   * @return a reference to the removed element
   * @throws NoSuchElementException if this list does not contain any red mega
   * block
   */
  public MegaBlock removeRed() throws NoSuchElementException{
    
  	if(getRedCount() == 0)
  		throw new NoSuchElementException("No red blocks in the list");
  	
  	redCount--;
  	
  	return removeBlock(0);
  	
  }
  
  /**
   * Removes and returns the element stored at index position in this list
   * @param index position of the element to remove in this list
   * @return a reference to the removed element
   * @throws IndexOutOfBoundsException if the index is out of range
   * (index < redCount or index >= size - blueCount)
   */
  public MegaBlock removeYellow(int index) throws IndexOutOfBoundsException{
    
  	if(index < getRedCount() || index >= size - getBlueCount())
  		throw new IndexOutOfBoundsException("The index is invalid");
  	
  	yellowCount--;
  	
  	return removeBlock(index);
  	
  }

  /**
   * Replaces the megablock at the specified position in this list with the
   * specified element if they have the same Color
   * @param index index of the block to replace
   * @param block element to be stored at the specified position
   * @return the element previously at the specified position
   * @throws IllegalArgumentException if object is null or is not equal to the
   * megablock already at at index position
   * @throws IndexOutOfBoundsException if the index is out of range
   * (index < 0 || index >= size())
   */
  public MegaBlock set(int index, MegaBlock block) throws
  IllegalArgumentException, IndexOutOfBoundsException {
    
  	if(block == null)
  		throw new IllegalArgumentException("The block is null");
  	
  	// Check the color
  	if(block.getColor() != get(index).getColor())
  		throw new IllegalArgumentException("The colors of two blocks do not "
  		+ "match");
  	
  	if(index < 0 || index >= size())
  		throw new IndexOutOfBoundsException("The index is invalid");
  	
  	// Get the current block at position index
  	LinkedMegaBlock linkedblock = getLinkedMegaBlock(index);
  	
  	// Generate a new Block instance
  	LinkedMegaBlock newLinkBlock = new LinkedMegaBlock(block);
  	
  	newLinkBlock.setNext(linkedblock.getNext());
  	
  	// Find the previous block
  	if(index == 0) head = newLinkBlock;
  	else if(index == size-1) tail = newLinkBlock;
  	else {
  		
  		LinkedMegaBlock PreLinkedBlock = getLinkedMegaBlock(index-1);
  		
  		PreLinkedBlock.setNext(newLinkBlock);
  		
  	}

  	return linkedblock.getBlock();
  	
  }

  /**
   * Returns the size of this list
   * @return the number of megablocks stored in this list.
   */
  public int size() {
    
  	return size;
  	
  }
  
  @Override
  /**
   * Returns a String representation of the contents of this list
   * @Overrides toString in class java.lang.Object
   * @return return a String representation of the content of this list. If
   * this list is empty, an empty String ("") will be returned.
   */
  public String toString() {
    
  	if(size==0) return"";
  	else {
  		
  		String result = "";
  		// Iterate all blocks in the list.
  		for(int i = 0; i < size ; i++) {
  			
  			LinkedMegaBlock CurrentBlock = getLinkedMegaBlock(i);
  			
  			// Connnect the string of current block with the result string
  			result = result.concat(CurrentBlock.toString());
  			
  		}
  		
  		return result;
  		
  	}	
  }
  
}
  
  

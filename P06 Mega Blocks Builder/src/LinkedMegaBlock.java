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
/**
 * This class implements a linked mega block data type for P06 Mega Blocks
 * Builder
 * @author Haoming Meng
 *
 */
public class LinkedMegaBlock {
  private MegaBlock block; // data field of this linkedMegaBlock
  private LinkedMegaBlock next; // link to the next linkedMegaBlock
  
  /**
   * Creates a new LinkedMegaBlock that has a specific MegaBlock as data and
   * null 
   * as next reference
   * @param block is the data field of the new object
   */
  public LinkedMegaBlock(MegaBlock block) {
    this.block = block;
    this.next = null;
  }
  
  /**
   * Creates a new LinkedMegaBlock with a specific data block and a specific
   * reference 
   * to the next LinkedMegaBlock
   * @param block is the data field of the new object
   * @param next is the link to the next LinkedMageBlock object
   */
  public LinkedMegaBlock(MegaBlock block, LinkedMegaBlock next) {
    this.block = block;
    this.next = next;
  }
  
  /**
   * The accessor method of block instance variable
   * @return the block data field of this LinkedMegaBlock
   */
  public MegaBlock getBlock() {
    return block;
  }
  
  /**
   * The accessor method of next instance variable
   * @return the reference to the next field of this LinkedMegaBlock
   */
  public LinkedMegaBlock getNext() {
    return next;
  }
  
  /**
   * The mutator method of block instance variable
   * @param block is the data field to be changed to the LinkedMegaBlock object
   */
  public void setBlock(MegaBlock block) {
    this.block = block;
  }
  
  /**
   * The mutator method of next instance variable
   * @param next is the link to be changed to the LinkedMegaBlock object
   */
  public void setNext(LinkedMegaBlock next) {
    this.next = next;
  }
  
  @Override
  public String toString() {
    if(next == null) {
      return block.toString() + " -> END";
    }else {
      return block.toString() + " -> ";
    }
  }
  
}

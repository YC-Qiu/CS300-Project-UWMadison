//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P09 Camp Badger
// Files:           CampEnrollmentApp.java, Camper.java, CamperBST.java
//									CampManager.java, CampTreeNode.java
// Course:          COMP SCI 300 FALL 2019
//
// Author:          Yucheng Qiu
// Email:           yqiu56@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Hankel Bao
// Partner Email:   hbao24@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   __X_ Write-up states that pair programming is allowed for this assignment.
//   __X_ We have both read and understand the course Pair Programming Policy.
//   __X_ We have registered our team prior to the team registration deadline.
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class implements a BST for campers.
 * @author Hankel Bao
 * @since 11-20-2019
 */
public class CamperBST {
  public CampTreeNode root;
  // Root of BST
  private int size;
  private LinkedList<Camper> traversedLList;

  /**
   * Default constructor
   */
  public CamperBST() {
    this.root = null;
    this.size = 0;
  }

  /**
   * Get the size of the BST.
   * @return size of the BST
   */
  public int size() {
    return this.size;
  }

  /**
   * Check if the tree is empty
   * @return true if the tree is empty. Otherwise false.
   */
  public boolean isEmpty() {
    return this.size == 0 ? true : false;
  }

  // starts tree insertion by calling insertHelp() on the root and
  // assigning root to be the subtree returned by that method
  public void insert(Camper newCamper) {
    // The helper method does not explain anything!
    // This is very poor function naming and comments
    this.root = insertHelp(this.root, newCamper);
    this.size++;
  }

  /**
   * Recursive helper method to insert.
   * 
   * @param current - The "root" of the subtree we are inserting into, ie the
   * node we are currently at.
   * @param newCamper - the camper to be inserted into the tree
   * @return the root of the modified subtree we inserted into
   */
  private CampTreeNode insertHelp(CampTreeNode current, Camper newCamper) {
    // Again the help here is confusing and meaningless.
    // Helper function could not explain what it does.

    if (current == null) {
      // Construct the leaf
      current = new CampTreeNode();
      current.setData(newCamper);
    } else {
      // Call insertHelp on child nodes
      if (newCamper.compareTo(current.getData()) < 0)
        current.setLeftNode(insertHelp(current.getLeftNode(), newCamper));
      else
        current.setRightNode(insertHelp(current.getRightNode(), newCamper));
    }

    return current;
  }

  /**
   * Deletes a Camper into the binary search tree if it exists.
   * 
   * @param key - the camper to be deleted from the tree
   * @throws NoSuchElementException if it is thrown by deleteHelp
   */
  public void delete(Camper key) throws NoSuchElementException {
    CampTreeNode newroot = deleteHelp(this.root, key);
  	if(newroot != null) this.root = newroot;
    this.size--;
  }

  /**
   * Recursive helper method to delete.
   * 
   * @param current - The "root" of the subtree we are deleting from, ie the
   * node we are currently at.
   * @param key - the camper to be deleted from the tree
   * @return the root of the modified subtree we deleted from
   * @throws NoSuchElementException if the camper is not in the tree
   */
  private CampTreeNode deleteHelp(CampTreeNode current, Camper key) {
    if (current == null)
      throw new NoSuchElementException();

    Camper data = current.getData();

    if (key.compareTo(data) == 0) {
    	// If a node whose leftnode and rightnode are both null, after removed
    	// the structure od tree remains the same.
      if (current.getLeftNode() == null && current.getRightNode() == null)
        return null;
      if (current.getLeftNode() != null && current.getRightNode() == null)
      	return current.getLeftNode();
      if (current.getLeftNode() == null && current.getRightNode() != null)
        return current.getRightNode();

      // If both left and right node is there
      CampTreeNode predecessor = current.getLeftNode();
      while (predecessor.getRightNode() != null)
        predecessor = predecessor.getRightNode();

      Camper predecessorData = predecessor.getData();
      current.setData(predecessorData);
      predecessor = this.deleteHelp(predecessor, predecessorData);
    }
    if (key.compareTo(data) < 0)
      current.setLeftNode(deleteHelp(current.getLeftNode(), key));
    if (key.compareTo(data) > 0)
      current.setRightNode(deleteHelp(current.getRightNode(), key));

    return current;
  }


  // returns an iterator of camper in the correct order as designated
  public Iterator<Camper> traverse(String order) {
    // first time traversing need to initialize LinkedList
    if (traversedLList == null){
      traversedLList = new LinkedList<Camper>();
    } else {
      // clear the list to start over for a new traversal
      traversedLList.clear();
    }
    traverseHelp(root, order);
    return traversedLList.listIterator();
  }

  /**
   * Recursive helper method to traverse. Will take the current CampTreeNode’s data and add it to
   * traversedLList based on the given order. Then continue to recurse on the correct subtree.
   * 
   * @param current - the root of the current subtree we are traversing
   * @param order - the type of traversal to perform
   */
  private void traverseHelp(CampTreeNode current, String order) {
    if (current == null)
      return;

    switch (order) {
      case "PREORDER":
        this.traversedLList.add(current.getData());
        traverseHelp(current.getLeftNode(), order);
        traverseHelp(current.getRightNode(), order);
        break;
      case "POSTORDER":
        traverseHelp(current.getLeftNode(), order);
        traverseHelp(current.getRightNode(), order);
        this.traversedLList.add(current.getData());
        break;
      case "INORDER":
        traverseHelp(current.getLeftNode(), order);
        this.traversedLList.add(current.getData());
        traverseHelp(current.getRightNode(), order);
        break;
    }
  }

  // Prints the contents of this tree in alphabetical order
  // based on the string "lastName, firstName"
  public void print() {
    printHelp(root);
  }

  /**
   * Prints the contents of this tree in alphabetical order based on the string
   * "lastName, firstName"
   * @param current
   */
  private void printHelp(CampTreeNode current) {
    if (current == null) {
      return;
    }
    printHelp(current.getLeftNode());
    System.out.println(current.getData());
    printHelp(current.getRightNode());
  }
}

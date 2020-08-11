//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P07 Study Playlist
// Files:           DoublyLinkedNode.java, Playlist.java, ReversePlaylist.java,
//									Song.java, SongCollection.java
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A collection (doublelinked list) of songs.
 * @author YC Qiu
 * @version 1.0
 * @since 2019-10-30
 */
public class SongCollection implements java.lang.Iterable<Song>{
	
	// Head of the list
	private DoublyLinkedNode<Song> head;
	// Tail of the list
	private DoublyLinkedNode<Song> tail;
	// Direction of Playlist
	private boolean playDirectionForward;
	
	/**
	 * Non-argument constructor
	 */
	public SongCollection() {
		// TODO Auto-generated constructor stub
		
		head = tail = null;
		
		playDirectionForward = true;
		
	}
	
	/**
	 * adds song to the end/tail of this doubly linked list.
	 * @param song the song to add
	 * @throws NullPointerException when song is null
	 */
	public void add(Song song) throws NullPointerException {
		
		if(song == null) throw new NullPointerException("song is null.");
		
		// Create a new DoublyLinkedNode for the added song
		DoublyLinkedNode<Song> NewSong = new DoublyLinkedNode<Song>(song);
		
		// When adding the first element into the list
		if(head == null && tail == null) {
			
			head = tail = NewSong;
			
		}
		else{
			// Add the node to tail
			tail.setNext(NewSong);
			
			NewSong.setPrevious(tail);
			
			tail = NewSong;
			
		}
	}

	/**
	 * removes and returns song from the front/head of this list
	 * @return the song from the head
	 * @throws NoSuchElementException when list is empty
	 */
	public Song remove() throws NoSuchElementException {
		
		if(head == null)
			throw new NoSuchElementException("No elements in the list");
		
		Song SongToReturn = head.getData();
		
		// If the last node is removed, reset tail.
		if(head.getNext() == null) head = tail = null;
		else {
			// if it is not the last node
			head = head.getNext();
			
			head.setPrevious(null);
		}

		return SongToReturn;
		
	}

	/**
	 * Iterator of song playlist
	 * @see java.lang.Iterable#iterator()
	 * @return a Playlist object when playDirectionForward is true, otherwise
	 * return a ReversePlaylist object.
	 */
	@Override
	public Iterator<Song> iterator() {
		// TODO Auto-generated method stub
		if(playDirectionForward) return new Playlist(head);
		else return new ReversePlaylist(tail);
	}
	
	/**
	 * A mutator method to set the play direction
	 * @param isForward whether the play direction is forward
	 */
	public void setPlayDirection(boolean isForward) {
		
		playDirectionForward = isForward;
		
	}
	
}
///////////////////////////////////////////////////////////////////////////////////
//For each of the following big-O time complexity analyses, consider the problem
//size to be the number of Songs that are stored within the argument songs, when
//the method is first called.
//
//For analysisMethodA, the big-O time complexity is ____O(1)________.
//
//For analysisMethodB, the big-O time complexity is ______O(n)______.
//
//For analysisMethodC, the big-O time complexity is _____O(n)_______.
//
///////////////////////////////////////////////////////////////////////////////////

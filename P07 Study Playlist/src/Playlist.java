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
 * An iterator of class SongCollection.
 * @author YC Qiu
 * @version 1.0
 * @since 2019-10-30
 */
public class Playlist implements Iterator<Song> {

	private DoublyLinkedNode<Song> currentSong;
	
	// If the first Song has been played
	private boolean FirstNode;
	
	/**
	 * Construct a Playlist which plays from head to tail
	 * @param FirstSong the first song in the list
	 */
	public Playlist(DoublyLinkedNode<Song> FirstSong) {
		// TODO Auto-generated constructor stub
		currentSong = FirstSong;
		
		// A playlist plays the first song till the last one.
		FirstNode = true;
	}

	/**
	 * @see java.util.Iterator#hasNext()
	 * @return true when there are more songs left for it to return, and false
	 * otherwise
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return (currentSong.getNext() != null); 

	}

	/**
	 * Get the next song.
	 * @see java.util.Iterator#next()
	 * @return the next song in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public Song next() {
		// TODO Auto-generated method stub
		if(!hasNext()) throw new NoSuchElementException("Empty List");
		
		// Plays the next song
		if(FirstNode) FirstNode = false;
		else currentSong = currentSong.getNext();
		
		// Return the current song
		return currentSong.getData();
	}

}

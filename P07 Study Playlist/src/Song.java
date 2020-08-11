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
/**
 * An instances of this class represents a single song.
 * @author YC Qiu
 * @version 1.0
 * @since 2019-10-30
 */
public class Song {
	
	private String title;
	private String artist;
	
	/**
	 * Initializes a new song with the specified information.
	 * @param title or name of this new song
	 * @param artist or musician who performs this song
	 */
	public Song(String title,
    String artist) {
		
		// initiate private fields
		this.title = title;
		
		this.artist = artist;
		
	}
	

	/**
	 * Returns a string representation of this song. This string should be
	 * formatted as follows: "TITLE by ARTIST", where this song's title and
	 * artist are used in place of the TITLE and ARTIST place holders.
	 * @see java.lang.Object#toString()
	 * @return string representation of this song
	 */
	@Override
	public String toString() {
		
		return title + " by " + artist;
		
	}
	
	/**
	 * Returns true when this song's title and artist strings contain the same
	 * contents as the other song's title and artist strings, and false
	 * otherwise. Note that this method takes an Object rather than a Song
	 * argument, so that it Overrides Object.equals(Object). If an object that
	 * is not an instance of Song is ever passed to this method, it should return
	 * false.
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param other Song object to compare this object to
	 * @return true when the two songs have matching title and artist
	 */
	@Override
	public boolean equals(Object other) {
		
		// Judge if two songs are completely equalled
		return  other.toString().equals(this.toString());
		
	}
}

import java.util.Iterator;

public class testSongCollection {
	
	public static void main(String[] args) { 
		SongCollection songs = new SongCollection();
		
		analysisMethodA(songs);
	}
	
	public static void analysisMethodA(SongCollection songs) {
		songs.add(new Song("C is for Cookie.", "Cookie Monster"));
		songs.add(new Song("Rubber Duckie.", "Ernie"));
		songs.add(new Song("Elmo's Song.", "Elmo"));
		songs.setPlayDirection(false);
		for(Song x:songs) {
			System.out.println(x);
		}
	}
	
	public static void analysisMethodB(SongCollection songs) {
		SongCollection copy = new SongCollection();
		for(Song song: songs)
		copy.add(song);
		for(Song song: copy)
		System.out.println(song);
	}
	
	public static void analysisMethodC(SongCollection songs) {
		Iterator<Song> playlist = songs.iterator();
		for(int i=0;i<1000;i++)
		if(playlist.hasNext())
		System.out.println( playlist.next() );
	}

}

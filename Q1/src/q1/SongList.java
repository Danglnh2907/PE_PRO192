package q1;

import java.util.ArrayList;
import java.util.Comparator;

public class SongList {
    //Class attribute
    private final ArrayList<Song> listSong;
    public String info;
    
    //Constructor
    public SongList() {
        this.listSong = new ArrayList<>();
        this.info = "";
    }
    
    //Public methods
    public ArrayList<Song> getListSong() {
        return this.listSong;
    }
     
    public void inputData() {
        Song currentSong = listSong.get(listSong.size() - 1);
        this.info = String.format("Add Song (%s, %d, %s)", currentSong.getName(), 
                                                           currentSong.getDuration(), 
                                                           currentSong.getComposer());
    }
    
    public Song getSongMaxDuration() {
        Song maxSong = listSong.get(0);
        for (Song song : listSong) {
            if (maxSong.getDuration() < song.getDuration()) 
                maxSong = song;
        }
        this.info = String.format("Max Duration Song is %s", maxSong.getName());
        return maxSong;
    }
    
    public ArrayList<Song> getTop3Ranking() {
        ArrayList<Song> top3 = new ArrayList<>(listSong);
        top3.sort(Comparator.comparing(Song::getDuration));
        this.info = String.format("Top 3 Ranking include %s, %s, %s", top3.get(0).getName(), 
                                                                      top3.get(1).getName(),
                                                                      top3.get(2).getName());
        return top3;
    }
    
    public void removeSongMaxDuration() {
        Song maxSong = getSongMaxDuration();
        listSong.remove(maxSong);
        this.info = String.format("Remove Song Max Duration");
    }
    
    public void removeAllData() {
        listSong.clear();
        this.info = String.format("*** Remove All Songs");
    }
}

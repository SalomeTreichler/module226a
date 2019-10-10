package ch.noseryoung;

import java.util.ArrayList;
import java.util.Collections;

public class MusicManager {
    private static MusicManager instance;
    ArrayList<String> playlist;

    private MusicManager(){
        playlist = new ArrayList<>();
        playlist.add("D:\\work\\projects-java\\intellij-projects\\mudule226a\\MP3Player\\audio\\BillieJean.mp3");
        playlist.add("D:\\work\\projects-java\\intellij-projects\\mudule226a\\MP3Player\\audio\\SmoothCriminal.mp3");
        playlist.add("D:\\work\\projects-java\\intellij-projects\\mudule226a\\MP3Player\\audio\\Thriller.mp3");
    }

    public static MusicManager getInstance(){
        if(instance == null) {
            instance = new MusicManager();
        }
        return instance;
    }

    public void checkMenuChoice(int choice) throws WrongCommandException{
        MusicPlayer mp = new MusicPlayer();
        if(choice >= 0 && choice <= 3){
            switch(choice){
                case 1:
                    mp.playPlaylist(playlist);
                    break;
                case 2:
                    ArrayList<String> shuffledList = playlist;
                    Collections.shuffle(playlist);
                    mp.playPlaylist(shuffledList);
                    break;
                case 3:
                    mp.playSpecificSong(playlist);
                    break;
                default:
                    return;
            }
        }else{
            throw new WrongCommandException("You entered a wrong command");
        }
    }
}

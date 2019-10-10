package ch.noseryoung;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class MusicPlayer
{

    private AdvancedPlayer player;

    public MusicPlayer()
    {
        player = null;
    }


    public void playPlaylist(ArrayList<String> playlist){
        for(int i = 0; i< playlist.size(); i++){
            playSong(playlist.get(i));
        }
    }

    public void printPlaylist(ArrayList<String> playlist){
        for(int i = 0; i< playlist.size(); i++){
            playSong(playlist.get(i));
        }
    }

    public void playSpecificSong(ArrayList<String> playlist){
        Scanner scan = new Scanner(System.in);
        printPlaylist(playlist);
        System.out.print("Name of Song to play: ");
        String search = scan.nextLine();
        String suchwort = search.toLowerCase();
        boolean gefunden = false;
        int found =-1;

        for(int i = 0; i < playlist.size() && !gefunden; i++){
            if(playlist.get(i).toLowerCase().contains(suchwort)){
                gefunden = true;
                found = i;
            }
        }

        if(gefunden){
            spieleSongNummer(found, playlist);
        }
        else{
            System.out.println("Kein Song gefunden, der " + search + " beinhaltet.");
        }
    }

    public void spieleSongNummer(int index, ArrayList<String> playlist){
        String dateiname = playlist.get(index);
        playSong(dateiname);
    }


    //API functions
    public void playPreview(String dateiname)
    {
        try {
            preparePlayer(dateiname);
            player.play(500);
        }
        catch(JavaLayerException e) {
            throwError(dateiname);
        }
        finally {
            killPlayer();
        }
    }


    public void playSong(final String dateiname)
    {
        try {
            preparePlayer(dateiname);
            Thread playerThread = new Thread() {
                public void run()
                {
                    try {
                        player.play(5000);
                    }
                    catch(JavaLayerException e) {
                        throwError(dateiname);
                    }
                    finally {
                        killPlayer();
                    }
                }
            };
            playerThread.start();
        }
        catch (Exception ex) {
            throwError(dateiname);
        }
    }

    public void endSong()
    {
        killPlayer();
    }


    private void preparePlayer(String dateiname)
    {
        try {
            InputStream is = getInputStream(dateiname);
            player = new AdvancedPlayer(is, createAudidevice());
        }
        catch (IOException e) {
            throwError(dateiname);
            killPlayer();
        }
        catch(JavaLayerException e) {
            throwError(dateiname);
            killPlayer();
        }
    }


    private InputStream getInputStream(String dateiname)
            throws IOException
    {
        return new BufferedInputStream(
                new FileInputStream(dateiname));
    }


    private AudioDevice createAudidevice()
            throws JavaLayerException
    {
        return FactoryRegistry.systemRegistry().createAudioDevice();
    }


    private void killPlayer()
    {
        synchronized(this) {
            if(player != null) {
                player.stop();
                player = null;
            }
        }
    }


    private void throwError(String dateiname)
    {
        System.out.println("There was a problem with playing " + dateiname);
    }

}

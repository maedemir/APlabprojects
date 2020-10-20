package com.company;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Music> files;
    // A player for the music files.
    private MusicPlayer player;
    private ArrayList<Music> myFavsongs;

    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        files = new ArrayList<Music>();
        player = new MusicPlayer();
        myFavsongs = new ArrayList<Music>();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(Music music)
    {
        files.add(music);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        System.out.println("name of singer :" + files.get(index).getSinger());
        System.out.println("address of file  :" + files.get(index).getAddress());
        System.out.println("publish year :" + files.get(index).getPublishYear());
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for (Music M : files) {
            System.out.println("file :"+M.getAddress());
        }

    }
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)==true)
            files.remove(index);
        else
            System.out.println("no such index");
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        player.startPlaying(files.get(index).getAddress());
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();

    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        if(index<0  | index > files.size()-1){
            return false;
        }
        return true;
        // The return value.
        // Set according to whether the index is valid or not.

    }

    /**
     * add a song that already exists in files(list of all musics) to list of fav songs
     * @param song name of songs
     */
    public void addToFav(String song ){
        for (Music m : files) {
            if(m.getSinger().equals(song)){
                myFavsongs.add(m);
                return;
            }

        }
        return;
    }

    /**
     * it removes a song from fav list
     * @param song name of song to be removed
     * @return true if there is such song , and false if there is not.
     */
    public void removeFromFave(String song){
        for (Music m: myFavsongs) {
            if(m.getSinger().equals(song)){
                myFavsongs.remove(m);
                return;
            }

        }
        return;
    }

    /**
     * show list of favourit songs
     */
    public void listFavsongs(){
        for (Music m: myFavsongs) {
            System.out.println("singer : "+m.getSinger());
            System.out.println("address : "+m.getAddress());
            System.out.println("year: "+m.getPublishYear());

        }
    }

    /**
     * search among addresses and prints matches
     * @param str
     */
    public void showAllfromThisSinger(String str){
        for (Music m: files) {
            if(m.getSinger().equals(str)){
                System.out.println(m.getAddress());
            }
            if(m.getAddress().equals(str)){
                System.out.println(m.getSinger());
            }
        }
    }
}
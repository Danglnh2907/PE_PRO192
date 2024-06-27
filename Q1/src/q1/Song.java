/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

public class Song {
    //Class attribute
    private String name;
    private int duration;
    private String composer;
    
    //Constructor
    public Song(String name, int duration, String composer) {
        this.name = name;
        this.duration = duration;
        this.composer = composer;
    }
    
    //public methods
    public String getName() {
        return this.name;
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    public String getComposer() {
        return this.composer;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Q1 {
    //Change the name of input and output file based on practical paper
    String inputFile = "input.txt";
    String outputFile = "output.txt";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
	
    String result = "";
    int n;
    ArrayList<String> dataLines = new ArrayList<>();


	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
    String fi, fo;
    
    /**
     * Set input and output file for automatic rating
     * @param args path of input file and path of output file
     */
    public void setFile (String[] args){
        fi = args.length>=2? args[0]: inputFile;
        fo = args.length>=2? args[1]: outputFile;
    }
    
    /**
     * Reads data from input file
     */
    public void read(){
        try (Scanner sc  = new Scanner(new File(fi))){
    //--END FIXED PART----------------------------

            //INPUT - @STUDENT: ADD YOUR CODE FOR INPUT HERE:
            n = Integer.parseInt(sc.nextLine().trim());
            while (n > 0) {
                dataLines.add(sc.nextLine());
                n--;
            }

	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
            sc.close();
        }catch(FileNotFoundException ex){
            System.out.println("Input Exception # " + ex);
        }
    }
    //--END FIXED PART----------------------------
    
    //ALGORITHM - @STUDENT: ADD YOUROWN METHODS HERE (IF NEED):
    

    
	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
    /**
     * Main algorithm
     */
    public void solve(){
    //--END FIXED PART----------------------------

        //ALGORITHM - @STUDENT: ADD YOUR CODE HERE:
        SongList list = new SongList();
        String[] data;
        Song song;
        ArrayList<Song> top3;
        
        for (String dataLine : dataLines) {
            data = dataLine.split("\\s+");
            if (data[0].equals("AddSong")) {
                //Create song
                song = new Song(data[1], Integer.parseInt(data[2]), data[3]);
                //Add song to list
                list.getListSong().add(song);
                //Set info
                list.inputData();
            } else if (data[0].equals("MaxSong")) {
                //Set max song to song
                song = list.getSongMaxDuration();
            } else if (data[0].equals("Top3")) {
                //Get top 3 ranking
                top3 = list.getTop3Ranking();
            } else if (data[0].equals("Clear")) {
                //Remove max song duration
                list.removeSongMaxDuration();
            } else if (data[0].equals("ClearAll")) {
                //Clear all data
                list.removeAllData();
            }
            //Append info to result
            result += String.format("%s\n", list.info);
        }

	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART-------------------------- 
    }
    
    /**
     * Write result into output file
     */
    public void printResult(){
	try{
            FileWriter fw = new FileWriter(fo);
	//--END FIXED PART----------------------------
                
            //OUTPUT - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
            fw.write(result);

	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART-------------------------- 
            fw.flush();
            fw.close();
        }catch (IOException ex){
            System.out.println("Output Exception # " + ex);
        }
           
        /*Opening output.txt (REMOVE THIS CODE WHEN SUBMITING)*/
        //Start opening file
        try {
            java.awt.Desktop.getDesktop().open(new File(fo));
        } catch (IOException ex) {
            Logger.getLogger(Q1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //End opening file
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Q1 q = new Q1();
        q.setFile(args);
        q.read();
        q.solve();
        q.printResult();
    }
	//--END FIXED PART----------------------------    
}

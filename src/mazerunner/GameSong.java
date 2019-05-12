/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import javafx.concurrent.Task;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Khalid
 */
public class GameSong {
    public static MediaPlayer mediaplayer;
    public static Media f;
    
    public GameSong(){
	//Play music
	new Thread(new Task(){
	    @Override
	    protected Object call() throws Exception {
		System.out.println("Audio Started");
		f = new Media(Config.songfile);
		mediaplayer = new MediaPlayer(f);
		mediaplayer.play();
		return null;
	    }
	}).start();
    }
}

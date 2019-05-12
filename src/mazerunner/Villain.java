/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Khalid
 */
public class Villain extends Character{
    public char orientation;
    public int inverse = 0;
    public int movedx = 0;
    public int movedy = 0;
    public static Villain[] villains = new Villain[5];
    public static int villainsCount = 0;
    
    public Villain(int posX, int posY, char orientation){
	super(posX, posY, Config.VillainLoc, Config.HeroLeftImage, Config.HeroRightImage ,100);
	this.orientation=orientation;
    }
    
    @Override
    public void moveCharacterBy(int dx, int dy) {
	super.moveCharacterBy(dx, dy);
	super.moveCharacterTo(fx, fy);
    }
    
    public void moveVillain(){
	movedx = 0;
	movedy = 0;
	int delta = 0;
	if(this.inverse == 0){
	    if(Map.maze[this.celly][this.cellx].passThrough == true){
		delta = 3;
	    }else{
		delta = -3;
		inverse = 1;
	    }
	}else{
	    if(Map.maze[this.celly][this.cellx].passThrough == true){
		delta = -3;
	    }else{
		delta = 3;
		inverse = 0;
	    }
	}
	
	if(this.orientation == 'x'){
	    movedx = delta;
	}else{
	    movedy = delta;
	}
	
	if(this.orientation == 'x' && inverse == 1){
	    this.character.setImage(Config.VillainLocLeft);
	}else if(this.orientation == 'x' && inverse == 0){
	    this.character.setImage(Config.VillainLoc);
	}
	
	this.moveCharacterBy(movedx, movedy);
    }
    public static void add(Villain villain){
	Villain.villains[villainsCount] = villain;
    	Villain.villainsCount++;
    }
}

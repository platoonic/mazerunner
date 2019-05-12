/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Khalid
 */
public  class Character{
    int HP;
    //x,y window coordinates
    int x;
    int y;
    //cell coordinates
    int cellx;
    int celly;
    double fx;
    double fy;
    //movement coordinates
    //double movementX;
    //double movementY;
    public Image characterImage,characterLeftImage,characterRightImage;
    public ImageView  character;
    public boolean running, goNorth, goSouth, goEast, goWest;
    
    //Accessors & Mutators

    public int getHP() {
	return HP;
    }

    public void setHP(int HP) {
	this.HP = HP;
    }

    public ImageView getCharacter() {
	return character;
    }
    
    
    //Methods
    public Character(int posX, int posY, Image characterImage , Image characterLeftImage, Image characterRightImage, int HP){
        this.x=posX;
        this.y=posY;
	this.fx = 0;
        this.fy = 0;
	this.characterImage = characterImage;
	this.characterLeftImage = characterLeftImage;
	this.characterRightImage = characterRightImage;
        this.HP = HP;
        character = new ImageView(characterImage);
	//Add 1 to compensate for 0 indexing
        moveCharacterTo((Config.cellSize/2)+posX*Config.cellSize,(Config.cellSize/2)+posY*Config.cellSize);
    }
    
    public void setOrientation(char orientation){
        if(orientation == 'L'){
            character.setImage(characterLeftImage);
        }else{
            character.setImage(characterRightImage);
        }
    }
    public void moveCharacterBy(int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        final double cx = character.getBoundsInLocal().getWidth()/2  ;
        final double cy = character.getBoundsInLocal().getHeight()/2 ;
        //System.out.println(character.getBoundsInLocal().getWidth());
        this.fx = cx + character.getLayoutX() + dx;
        this.fy = cy + character.getLayoutY() + dy;
	
        if(dx<0){
            cellx=(int)(fx-cx)/Config.cellSize;
        }else
	{
            cellx=(int)(fx+cx)/Config.cellSize;
        }
        if(dy<0){
            celly=(int)(fy+cy-5)/Config.cellSize;
        }else{
            celly=(int)(fy+cy)/Config.cellSize;
        }
        if(celly<0)
            celly=0;
        if(cellx<0)
            cellx=0;
        
	
	
    }

    public void moveCharacterTo(double x, double y) {
        final double cx = character.getBoundsInLocal().getWidth()  / 2;
        final double cy = character.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
            x + cx <= Config.Width &&
            y - cy >= 0 &&
            y + cy <= Config.Height ) {
            character.relocate(x - cx, y - cy);
        }
    }
}

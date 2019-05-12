/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

/**
 *
 * @author ahnab
 */
public class Stone extends Cell {
    public String type;
    public Stone (int posX, int posY,String type){
        super(posX, posY, false, true);
	this.type = type;
        if(type.equals("reality"))
            this.image=Config.realityStone;
        else if(type.equals("time")){
            this.image=Config.timeStone;
        }
        else if(type.equals("soul")){
            this.image=Config.soulStone;
        }
        else if (type.equals("power")){
            this.image=Config.powerStone; 
        }
        else if(type.equals("mind")){
            this.image=Config.mindStone;
        }
        else {
            this.image=Config.spaceStone;
        }
    }
}


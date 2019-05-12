/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import javafx.scene.image.ImageView;

/**
 *
 * @author ahnab
 */
public class Gate extends Cell  {
    public Gate(int posX, int posY){
        //Gate
        //Destroyable: false
        //Pass through: quasi-false
        super(posX,posY,false,false,Config.ClosedGateLoc);
    }
    public void getTicket (Hero hero){
        if(hero.shalashCoins>=Config.GatePrice){
            hero.payShalashCoins(Config.GatePrice);
            passThrough=true;
	    Map.mazePane.add(new ImageView(Config.OpenedGateLoc), posX, posY);
        }
    }
}

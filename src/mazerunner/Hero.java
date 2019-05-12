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
public class Hero extends Character{
    public int shalashCoins;
    public boolean realityStone;
    public boolean timeStone;
    public boolean mindStone;
    public boolean soulStone;
    public boolean powerStone;
    public boolean spaceStone;
    
    public Hero(int HP){
        super(Config.startPosition, Config.startPosition, Config.HeroImage, Config.HeroLeftImage, Config.HeroRightImage ,HP);
        shalashCoins = 0;
        realityStone=timeStone=mindStone=soulStone=powerStone=spaceStone=false;
    }
    public void payShalashCoins(int price){
        shalashCoins -= price;
    }
    
    public void takeStone(Stone stone){
        if(stone.type.equals("reality"))
            realityStone=true;
        else if(stone.type.equals("time")){
            timeStone=true;
        }
        else if(stone.type.equals("soul")){
            soulStone=true;
        }
        else if (stone.type.equals("power")){
            powerStone=true;
        }
        else if(stone.type.equals("mind")){
            mindStone=true;
        }
        else {
            spaceStone=true;
        }
        stone.ConsumeCell();
    }
    public void takeShalashCoin(ShalashCoin coin){
        shalashCoins +=coin.value;
        coin.ConsumeCell();
    }
    
    public void moveCharacterBy(int dx, int dy, Hero hero) {
	//System.out.println("cellx: "+cellx+" - celly: "+celly);
	super.moveCharacterBy(dx, dy);
	//System.out.println("x:"+cellx+" y:"+celly);
	//Check if Gate
	if(Map.maze[celly][cellx] instanceof Gate && Map.maze[celly][cellx].passThrough==false){
            Gate gate=(Gate)Map.maze[celly][cellx];
	    gate.getTicket(hero);
	    Map.maze[celly][cellx] = gate;
        }
	//Blocking movement
        if(Map.maze[celly][cellx].passThrough==false)
	    return;
	
	//Consuming Crates
	if(Map.maze[celly][cellx] instanceof HPboost){
	    Map.maze[celly][cellx].ConsumeCell();
	    hero.HP += 50;
            //System.out.println(hero.HP);
	}
        if(Map.maze[celly][cellx] instanceof Stone){
            Stone stone = (Stone)Map.maze[celly][cellx];
            hero.takeStone(stone);
        }
        if(Map.maze[celly][cellx] instanceof ShalashCoin){
            ShalashCoin coin = (ShalashCoin)Map.maze[celly][cellx];
            hero.takeShalashCoin(coin);
        }
        moveCharacterTo(fx, fy);
	
	//Search Map for villains with the same coordinates to invoke gameover scene
	for(int i=0;i<Villain.villainsCount;i++){
	    if(hero.celly == Villain.villains[i].celly && hero.cellx == Villain.villains[i].cellx){
		System.out.println("Dead");
		MazeRunner.primaryStage.setScene(MazeRunner.gameover);
	    }
	}
    }
}

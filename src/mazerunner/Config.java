/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import javafx.scene.image.Image;

/**
 *
 * @author USER
 */
public abstract  class Config {
    public final static String PATH = "file:///Users/apple/Desktop/OOPProject/MazeRunnerV1/";
    public final static int mapRatioX = 6;
    public final static int mapRatioY = 6;
    public final static int numCellsX = (mapRatioX*4+1);
    public final static int numCellsY = (mapRatioY*2+1);
    public final static int cellSize = 48;
    public final static int Width = numCellsX * cellSize;
    public final static int Height = numCellsY * cellSize;
    public final static int startPosition = 1;
    public final static int GatePrice=2;
    //Characters Images Locations
    public final static Image HeroImage = new Image(PATH + "IronmanRight.png");
    public final static Image HeroLeftImage = new Image(PATH + "IronmanLeft.png");
    public final static Image HeroRightImage = new Image(PATH + "IronmanRight.png");
    
    public final static Image VillainLoc= new Image(PATH + "charRight.gif");
    public final static Image VillainLocLeft= new Image(PATH + "charLeft.gif");
    //Map Images Locations
    public final static Image TerrainLoc= new Image(PATH + "terrain.png");
    public final static Image WallLoc= new Image(PATH + "wall.png");
    public final static Image healthBoost = new Image(PATH + "heart.png");
    public final static Image ClosedGateLoc = new Image(PATH+"gate.png");
    public final static Image OpenedGateLoc = new Image(PATH+"terrain.png");
    //infinity stones Images Location
    public final static Image blankStone = new Image(PATH + "stones/blank.png");
    public final static Image realityStone = new Image(PATH+"stones/reality.png");
    public final static Image timeStone = new Image(PATH+"stones/time.png");
    public final static Image spaceStone = new Image(PATH+"stones/space.png");
    public final static Image powerStone = new Image(PATH+"stones/power.png");
    public final static Image mindStone = new Image(PATH+"stones/mind.png");
    public final static Image soulStone = new Image(PATH+"stones/soul.png");
    //shalash coins Image location
    public final static Image shalashCoin= new Image(PATH+"shalashCoin.png");
    //Music Location String
    public final static String songfile = PATH + "gamemusic.mp3";
}

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
public abstract class Cell {
    public int posX;
    public int posY;
    public boolean destroyable;
    public boolean passThrough;
    public Image image;
    
    public Cell(int posX, int posY, boolean destroyable, boolean passThrough){
        this.posX = posX;
        this.posY = posY;
        this.destroyable = destroyable;
        this.passThrough = passThrough;
    }
    public Cell(int posX, int posY, boolean destroyable, boolean passThrough, Image image){
        this.posX = posX;
        this.posY = posY;
        this.destroyable = destroyable;
        this.passThrough = passThrough;
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
    
    public void ConsumeCell(){
	Map.mazePane.add(new ImageView(Config.TerrainLoc), posX, posY);
	Map.maze[posY][posX] = new Terrain(posY, posX);
	Map.m[posY][posX] = 'T';
    }
}

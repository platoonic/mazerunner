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
public class Terrain extends Cell{
    public Terrain(int posX, int posY){
        //Terrain
        //Destroyable: False
        //Pass through: True
        super(posX, posY, false, true, Config.TerrainLoc);
    }
}

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
public class Wall extends Cell{
    public Wall(int posX, int posY){
        //Wall
        //Destroyable: True
        //Pass through: False
        super(posX,posY,true,false,Config.WallLoc);
    }
}

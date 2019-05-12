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
public class HPboost extends Cell{
    public HPboost(int posX, int posY){
	//Crate
	//Destroyable: True
	//Pass through: true
	super(posX, posY, false, true, Config.healthBoost);
    }
    public void applyBoost(){
        
    }
}

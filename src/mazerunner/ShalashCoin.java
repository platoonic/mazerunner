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
public class ShalashCoin extends Cell{
    int value;
    public ShalashCoin(int posX,int posY){
      super(posX, posY, false, true, Config.shalashCoin);
      value=1;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
/**
 *
 * @author Khalid
 */

public class Map {
    public static GridPane mazePane;
    public static Cell[][] maze;
    
    
    //Initialization Array
    //T => Terrain
    //V => Villain
    public static char[][] m = {
     {'W','W','W','W','W','W','W','W','W','W','W','W','W'},
     {'W','T','T','T','W','T','T','T','T','H','T','K','W'},
     {'W','T','T','C','W','T','T','T','T','T','C','T','W'},
     {'W','T','T','T','W','T','T','T','T','T','T','T','W'},
     {'W','W','W','T','W','T','W','W','W','G','W','W','W'},
     {'W','H','T','T','T','T','W','T','T','T','T','T','W'},
     {'W','T','T','T','T','T','W','T','T','T','T','T','W'},
     {'W','T','T','T','T','T','W','T','T','T','T','T','W'},
     {'W','T','W','W','W','W','W','T','W','W','W','T','W'},
     {'W','T','W','J','T','T','W','C','W','O','W','T','W'},
     {'W','C','W','T','T','T','W','T','W','T','W','T','W'},
     {'W','T','W','T','T','T','W','T','W','T','W','N','W'},
     {'W','T','W','W','W','G','W','T','W','T','W','W','W'},
     {'W','T','W','T','T','T','W','T','T','T','T','T','W'},
     {'W','T','W','T','T','T','W','T','T','T','T','T','W'},
     {'W','T','W','T','T','C','W','T','T','T','T','T','W'},
     {'W','T','W','T','W','W','W','W','W','W','W','T','W'},
     {'W','T','W','T','W','T','T','T','H','T','W','C','W'},
     {'W','T','W','T','W','T','T','T','T','T','W','T','W'},
     {'W','T','W','T','W','T','T','T','T','T','W','T','W'},
     {'W','T','W','T','W','G','W','W','W','T','W','T','W'},
     {'W','T','T','T','W','T','T','T','W','T','T','T','W'},
     {'W','T','T','T','W','T','T','T','W','T','T','T','W'},
     {'W','T','T','T','W','T','T','M','W','T','T','L','W'},
     {'W','W','W','W','W','W','W','W','W','W','W','W','W'}
     };
    public Map(char [][]grid){
        maze = new Cell[50][50];
        mazePane = new GridPane();
        String output="{";
        for(int i=0; i<Config.numCellsX; i++){
            output+="{";
            for(int j=0; j<Config.numCellsY; j++){
                addCell(m[i][j], i, j);
                output += "'";
                output += grid[i][j];
                output +="',";
                //m[j][i]=grid[i][j];
            }
            output+="},\n";
        }
        output+="}";
        System.out.println(output);     
    }
    
    public GridPane returnMap(){
        return mazePane;
    }
    
    
    
    public static void addCell(char type, int posX, int posY){
        
        //Create an empty Cell
        Cell cell = null;
        
        //Create an Empty ImageView Object
        ImageView container = null;
        
        //Create Cell for Cells arrray
        if(type == 'W'){
            cell = new Wall(posX, posY);
        }
	else if(type == 'H'){
            cell = new HPboost(posX, posY);
        }
        else if(type== 'G'){
            cell = new Gate(posX,posY);
        }
        else if(type== 'C'){
            cell = new ShalashCoin(posX,posY);
        }
        else if(type=='J'){
            cell = new Stone(posX,posY,"reality");
        }
        else if(type=='K'){
            cell = new Stone(posX,posY,"soul");
        }
        else if(type=='L'){
            cell = new Stone(posX,posY,"space");
        }
        else if(type=='M'){
            cell = new Stone(posX,posY,"time");
        }
        else if(type =='N'){
            cell = new Stone(posX,posY,"power");
        }
        else if(type=='O'){
            cell = new Stone(posX,posY,"mind");
        }
        else{
	    cell = new Terrain(posX, posY);
	}
        container = new ImageView(cell.getImage());
        //Add ImageView object to StackPane
        mazePane.add(container,posX,posY);    
        //Add Cell to Cells array
        maze[posY][posX] = cell;
    }
}

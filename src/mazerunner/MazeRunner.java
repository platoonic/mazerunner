/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;

/**
 *
 * @author Khalid
 */
public class MazeRunner extends Application {
    
    //Cloning primaryStage so it can be used outside MazeRunner scope
    //Mainly done for core main game changes such as Gameover
    public static Stage primaryStage;
    public static Scene gameover;
    public static Scene winScene;
    GameSong song;
    @Override
    public void start(Stage primaryStage) {
	//Initialize Game song
	song = new GameSong();
	
	//Linking MazeRunner's primaryStage with JavaFX one
	this.primaryStage = primaryStage;
	
	//Generator((CellX-1)/4 , (CellY-1)/2 )
        Generator mazeGrid = new Generator(Config.mapRatioX,Config.mapRatioY);
        mazeGrid.solve();
        mazeGrid.draw();
	
	//Initialize Map
        Map maze = new Map(mazeGrid.getMap());
	
	//Initialize Hero
	Hero hero = new Hero(1000);
	
	//Initialize Villains
	Villain villain1 = new Villain(15,3,'y');
	Villain.add(villain1);
        Villain villain2 = new Villain(2,6,'x');
        Villain.add(villain2);
	Villain villain3 = new Villain(13,10,'x');
	Villain.add(villain3);
	
	//Create HP & Score Label
        Label score = new Label("Shalash coins : "+hero.shalashCoins+" - Stamina : "+hero.HP+" - SCORE: 0");
        score.setStyle("-fx-padding:15 15 15 870;-fx-opacity:0.7;-fx-font-weight:bold;");
        score.setTextFill(Color.WHITE);
	
	//Stones Bar
	ImageView blankstone1 = new ImageView(Config.blankStone);
	ImageView blankstone2 = new ImageView(Config.blankStone);
	ImageView blankstone3 = new ImageView(Config.blankStone);
	ImageView blankstone4 = new ImageView(Config.blankStone);
	ImageView blankstone5 = new ImageView(Config.blankStone);
	ImageView blankstone6 = new ImageView(Config.blankStone);
	
	HBox stonesBar = new HBox();
	stonesBar.getChildren().add(blankstone1);
	stonesBar.getChildren().add(blankstone2);
	stonesBar.getChildren().add(blankstone3);
	stonesBar.getChildren().add(blankstone4);
	stonesBar.getChildren().add(blankstone5);
	stonesBar.getChildren().add(blankstone6);
	stonesBar.setStyle("-fx-padding:3 3 3 490;");
	
	//Group Elements into Dungeon
        Group dungeon = new Group(maze.returnMap());
        dungeon.getChildren().add(score);
	dungeon.getChildren().add(stonesBar);
        dungeon.getChildren().add(hero.character);
	dungeon.getChildren().add(villain1.character);
        dungeon.getChildren().add(villain2.character);
	dungeon.getChildren().add(villain3.character);
	
	//Initialize Scene
        Scene scene = new Scene(dungeon,Config.Width,Config.Height);
	
	//Gameover scene
	FlowPane test = new FlowPane();
	test.getChildren().add(new Label("GAME OVER"));
	gameover = new Scene(test,Config.Height,Config.Width);
	
	//Gameover scene
	FlowPane test2 = new FlowPane();
	test2.getChildren().add(new Label("YOU WON!!!"));
	winScene = new Scene(test2,Config.Height,Config.Width);
        
	//
	//Event handlers for movement
        //
	
	scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    hero.goNorth = true; break;
                    case DOWN:  hero.goSouth = true; break;
                    case LEFT:  hero.goWest  = true; hero.setOrientation('L'); break;
                    case RIGHT: hero.goEast  = true; hero.setOrientation('R'); break;
                    case SHIFT: hero.running = true; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    hero.goNorth = false; break;
                    case DOWN:  hero.goSouth = false; break;
                    case LEFT:  hero.goWest  = false; break;
                    case RIGHT: hero.goEast  = false; break;
                    case SHIFT: hero.running = false; break;
                }
                //System.out.println("released");
            }
        });
        
        primaryStage.setTitle("MazeRunner v0.2");
        primaryStage.setScene(scene);
        primaryStage.show();
	//Movement Animation
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
		
		//Hero Movement
                int herodx = 0, herody = 0;

                if (hero.goNorth) herody -= 2;
                if (hero.goSouth) herody += 2;
                if (hero.goEast)  herodx += 2;
                if (hero.goWest)  herodx -= 2;
                if (hero.running && hero.HP > 0) { herodx *= 4; herody *= 4; hero.HP -= 1; }
                hero.moveCharacterBy(herodx, herody, hero);
		System.out.println("Stones: "+hero.mindStone + " "+hero.realityStone + " "+hero.timeStone + " "+hero.powerStone + " ");
		//Stones Check
		if(hero.mindStone == true){
		    blankstone5.setImage(Config.mindStone);
		}if(hero.realityStone == true){
		    blankstone4.setImage(Config.realityStone);
		}if(hero.powerStone == true){
		    blankstone3.setImage(Config.powerStone);
		}if(hero.soulStone == true){
		    blankstone2.setImage(Config.soulStone);
		}if(hero.spaceStone == true){
		    blankstone1.setImage(Config.spaceStone);
		}if(hero.timeStone == true){
		    blankstone1.setImage(Config.timeStone);
		}
		
		if(hero.mindStone == true && hero.realityStone == true && hero.powerStone == true && hero.soulStone == true && hero.spaceStone == true && hero.timeStone == true){
		    MazeRunner.primaryStage.setScene(MazeRunner.winScene);
		}
		score.setText("Shalash coins : "+hero.shalashCoins+" - Stamina : "+hero.HP+" - Time: ");
		
		//Villains Movement
		
		villain1.moveVillain();
		villain2.moveVillain();
		villain3.moveVillain();
		
            }
        };
        timer.start();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
    
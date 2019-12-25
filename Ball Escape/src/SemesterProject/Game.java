/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemesterProject;

/**
 *
 * @author Xam 3xPloiTeR
 */
//=====================imports==================================================
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
//====================body======================================================

public class Game implements ScreenSize
{
    //variables
    public boolean running ;//check if the game is running or not
    Input input;
    LevelOperator levelOperator = new LevelOperator();
    ResourceManager obj;
    //constructors
    public Game() {
    running = true;
    }
  
    //methods
    public void run(Stage primaryStage)
    {
        primaryStage.setTitle("Brick Breaker By Rohan Mumtaz & Xam 3xPloiTeR");       
        Group root = new Group();
        Scene scene = new Scene(root);
        input = new Input(scene);
        primaryStage.setScene(scene);
        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        new AnimationTimer()
        {
            
        @Override
        public void handle(long currentNanoTime)
        {
           
            try {
                tick(input);
                
                render(gc);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }.start();
    }
    public void tick(Input input) throws Exception
    {
        levelOperator.levelTick( input);
    }
    public void render(GraphicsContext gc)
    {
        
        levelOperator.levelRender( gc);
    }
}

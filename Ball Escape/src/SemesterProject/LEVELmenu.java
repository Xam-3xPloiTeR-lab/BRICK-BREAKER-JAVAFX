/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemesterProject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Xam 3xPloiTeR
 */
public class LEVELmenu implements ScreenSize
{
    //variables
    boolean isPlaySelected;
    boolean isActive;
    
    boolean shouldExit;
    boolean toggle;
    //constructor

    public LEVELmenu() {
        this.isPlaySelected = true;
        this.shouldExit = false;
        this.toggle = true;
    }
    
    //methods
    
    public void render(GraphicsContext gc) 
    {//renders the scene
        //Black Background
        if(isActive){
            
            
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        //Render Title
        gc.setFill(Color.CRIMSON);
        gc.setFont(new Font( 30));
        gc.setTextAlign(TextAlignment.CENTER);
        
        gc.fillText("Welcome to home made BRICK BREAKER by Rohan Mumtaz & Xam 3xPloiTeR ", 670, 140);
        
        //renders play and exit signs
        gc.setFont(new Font(50));
        //colors the active choice yellow
        if(isPlaySelected)
        {
            gc.setFill(Color.YELLOW);
        }
        else
        {
            gc.setFill(Color.RED);
        }
        gc.fillText("Play", 400, 500);
        
        if(isPlaySelected)
        {
            gc.setFill(Color.RED);
        }
        else
        {
            gc.setFill(Color.YELLOW);
        }
        gc.fillText("Exit", 940, 500);
        
        if(isPlaySelected)
        {
            gc.setFill(Color.YELLOW);
            gc.fillRect(350, 520, 100, 10);
            
        }
        else
        {
            gc.setFill(Color.YELLOW);
            gc.fillRect(890, 520, 100, 10);
        }
        
        }
        
    }

    public void tick(Input input) 
    {//this is for controlling the cursor that selects which level to display
        if(this.isActive){
        if(input.left && toggle)
        {//select should play
            isPlaySelected = true;
            toggle = false;
            
        }
        else if(input.right && toggle)
        {
            isPlaySelected = false;
            toggle = false;
        }
        else if(input.space)
        {
            System.out.println("exit");
            shouldExit = true;
            
        }
        else if(!input.right && !input.left)
        {
            toggle = true;
        }
        }
        
    }

 
    public boolean exit() 
    {
        return shouldExit;
    }

    public int destination() 
    {
        if(isPlaySelected)
        {//case:If Player Wants to Play the game
            return 2;
        }
        else{//case: If Player Wants to Exit the game
            return 0;
        }
    }
    public void activate()
    {
        this.isActive = true;
        if(shouldExit = true)
        {
            
            this.shouldExit = false;
        }
    }
    public void deactivate()
    {
        this.isActive = false;
    }

   
    
}

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

import java.io.Serializable;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;



public class LevelOperator implements Serializable
{
    //variables
    int levelNumber = 1;
    LEVELmenu menu = new LEVELmenu();
    LEVELone firstLevel = new LEVELone();
    
       
    //constructors
    
    //methods
    public void levelRender( GraphicsContext gc)
    {
         
        switch(levelNumber)
        {
            case 0:
            {//exit
                
                break;
            }
            case 1:
            {//Menu
                menu.render(gc);
                break;
            }
            case 2:
            {//levelOne
                firstLevel.render(gc);
                break;
            }
        }  
    }
    public void levelTick( Input input) throws Exception
    {
        switch(levelNumber)
        {
            case 0: 
            {//exit application
                Platform.exit();
                break;
            }
            case 1:
            {//opeing menu
                menu.activate();
                menu.tick(input);
                if(menu.exit())
                {
                    menu.deactivate();
                    levelNumber = menu.destination();
                }
                break;
            }
            case 2:
            {//first level
                firstLevel.activate();
                
                firstLevel.tick(input);
                if(firstLevel.exit())
                {
                    firstLevel.deactivate();
                    levelNumber = firstLevel.destination();
                }
                break;
                
            }       
        }
    }   
}
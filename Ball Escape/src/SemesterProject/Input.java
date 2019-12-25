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

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;


public class Input 
{
    //variables
    //----determines what values even exist
    boolean up = false;
    boolean n = false;
    boolean left = false;
    boolean right = false;
    boolean space = false;
    boolean m = false;
    
    Scene scene;
    
    //constructor
    public Input(Scene scene)
    {
        this.scene = scene;
        init();
    }
    //methods
    public void init()
    {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP:    up = true; break;
                case N:  n = true; break;
                case LEFT:  left  = true; break;
                case RIGHT: right  = true; break;
                case SPACE: space = true; break;
                case M: m = true; break;
            }
        } //determines when keys are depressed
        );
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP:    up = false; break;
                case N:  n = false; break;
                case LEFT:  left  = false; break;
                case RIGHT: right  = false; break;
                case SPACE: space = false; break;
                case M: m = false; //break;
            }
        } //determines when keys are not depressed
        );
        
    }
}

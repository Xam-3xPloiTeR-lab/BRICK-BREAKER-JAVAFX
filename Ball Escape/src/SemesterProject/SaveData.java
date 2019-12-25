/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemesterProject;

import java.io.Serializable;
import javafx.scene.paint.Color;

/**
 *
 * @author Xam 3xPloiTeR
 */
public class  SaveData implements Serializable {
    private static final long serialVersionUID=11;
    boolean ballOnPaddle;
   boolean shouldExit;
    boolean isActive;
    int score;
    int livesLeft;
    int killed;
    int pxpos;
    int bxpos;
    int bxver;
    int bypos;
    int byver;
    int [][] h;
    boolean [][] nb;
    
    
    

    public void setBallOnPaddle(boolean ballOnPaddle) {
        this.ballOnPaddle = ballOnPaddle;
    }

    public SaveData(boolean ballOnPaddle, boolean shouldExit, boolean isActive, int score, int livesLeft, int killed, int pxpos, int bxpos, int bxver, int bypos, int byver, int[][] health, boolean[][] notBroke, Color[][] clr) {
        this.ballOnPaddle = ballOnPaddle;
        this.shouldExit = shouldExit;
        this.isActive = isActive;
        this.score = score;
        this.livesLeft = livesLeft;
        this.killed = killed;
        this.pxpos = pxpos;
        this.bxpos = bxpos;
        this.bxver = bxver;
        this.bypos = bypos;
        this.byver = byver;
        this.h = health;
        this.nb = notBroke;
    }

   

    
    
    
    
    
}

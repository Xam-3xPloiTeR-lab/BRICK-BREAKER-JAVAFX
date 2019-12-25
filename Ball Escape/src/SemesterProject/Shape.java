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
public class Shape {
     int xPos;
    int yPos;
    int xSize;
    int ySize;
        //sets the bounds of the stage where the paddle is allowed to go
    int xLimRight;
    int xLimLeft;
    
    
        //vector variables
    int xVec;
    int yVec;
    int maxSpeed;
    int minSpeed;

    public Shape() {
    }
    
    public Shape(int xVec, int yVec, int maxSpeed, int minSpeed) {
        this.xVec = xVec;
        this.yVec = yVec;
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
    }
    
}

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

public class Paddle extends Shape implements java.io.Serializable
{
    //constructor
    public Paddle()
    {
        super(0,0,20,-20);
        xPos = 0;
        yPos = 600;
        xSize = 250;
        ySize = 10;
        xLimRight = 1280;
        xLimLeft = 0;
        
    }
    
    void xDelta()
    {//moves player along the x axis
        xPos += xVec;
        if(xPos<0)
        {
            xPos=0;
        }
        if((xPos > 1050))
        {
            xPos=1050;
        }
    }
  
    
   
    void increaseXVec()
    {//increases movment if the momvemt is below max speed
        if(xVec<maxSpeed)
        {
            xVec++;
        }
    }
    
    void decreaseXVec()
    {//decreases the x veleocity
        if(xVec > minSpeed)
        {
            xVec-=2;
        }
    }
   
    void normalizeX()
    {// this applies friction to the paddle slowing it's movment to 
        //zero
        if(xVec<0)
        {
            xVec++;
        }
        else if(xVec >0)
        {
            xVec--;
        }
    }

}

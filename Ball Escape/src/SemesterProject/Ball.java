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

public class Ball extends Shape implements java.io.Serializable
{
    //variables
    boolean free = false;
    int left;
    int right;
    int up;
    int down;
    //constructors
    public Ball()
    {
        super(0,0,20,5);
        this.xPos = 500;
        this.yPos = 300;
        this.xSize = 15;
        this.ySize = 15;
        this.xVec = -minSpeed;
        this.yVec = minSpeed;
    }
    //methods
    void init()
    {//initializes the ball's variables
        this.left = xPos;
        this.right = xPos + xSize;
        this.up = yPos;
        this.down = yPos + ySize;
    }
    void xDelta()
    {//changes positoon aling the x axis 
        xPos += xVec;
        if(xPos <0)
        {
            xPos = 0;
            reflectX();
        }
        else if(xPos >1280)
        {
            xPos = 1280;
            reflectX();
        }
    }
    boolean yDelta(Paddle player)
    {//changes pisiton along the y axis
        yPos += yVec;
        if(yPos <0)
        {
            yPos = 0;
            reflectY();
            return false;
        }
        else if( (xPos >player.xPos) &&(xPos <player.xPos +player.xSize)&& (yPos == player.yPos-ySize))
        {
            
            reflectY();
            return false;
        }
        else if(yPos> 760)
        {
            yPos = 760;
            reflectY();
            return true;
        }
            
        return false;
    }
    boolean Delta(Paddle player, Boolean onPaddle)
    {
        if(onPaddle)
        {
            this.xPos = player.xPos + (player.xSize/2) -(this.xSize/2);
            this.yPos = player.yPos - 20;
            return false;
        }
        else
        {
            xDelta();
            return yDelta(player);
        }
        
    }
    void normalizeX()
    {
        if(xVec < minSpeed)
        {
            xVec = minSpeed;
        }
        else if(xVec > minSpeed)
        {
            xVec--;
        }
    }
    void normalizeY()
    {
        if(yVec < minSpeed)
        {
            yVec = minSpeed;
        }
        else if(yVec >minSpeed)
        {
            yVec--;
        }
    }
    void normalize()
    {
        normalizeX();
        normalizeY();
    }
    void limitVec()
    {
        if(xVec >maxSpeed)
        {
            xVec=maxSpeed;
        }
        if(yVec>maxSpeed)
        {
            yVec = maxSpeed;
        }
    }
    void check()
    {
        limitVec();
        normalize();
    }
    void reflectX()
    {
        xVec = -xVec;
    }
    void reflectY()
    {
        yVec = -yVec;
    }
    void toggleFree()
    {
        this.free = !free;
    }
    
}


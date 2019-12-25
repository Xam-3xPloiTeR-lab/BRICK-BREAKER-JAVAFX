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
import javafx.scene.paint.Color;
public class Brick extends Shape  implements java.io.Serializable
{
    //variables
    int health;
    int sizeX = 40;
    int sizeY = 20;
    int lower;
    int left;
    int right;
    int top;
    Color shade;
    boolean notBroke = true;
    //constructor
    public Brick(int x,int y, int health)
    {
        super();
        this.xPos = x;
        this.yPos = y;
        this.health = health;
        top = yPos;
        lower = yPos+sizeY;
        right = xPos;
        left = xPos + sizeX;
        
    }
    //methods
    Color getShade()
    {
        if(health == 1)
        {
            shade = Color.WHITESMOKE;
        }
        else if(health ==2)
        {
            shade = Color.CRIMSON;
        }
        return shade;
    }
    boolean hit()
    {
        health --;
        if(health <= 0){
            health = 0;
            notBroke = false;
            return true;
        }
        return false;
    }
    boolean ballDetect(Ball ball)
    {
        if(notBroke)
        {
            //detect top or bottom
        if(ball.xPos <left+15 &&ball.xPos >right+15)
        {
            if((ball.yPos+20) ==lower)
            {
                //the ball is attacking from below
                ball.reflectY();
                return hit();
            }
            else if(ball.yPos==top )
            {
                //the ball is attacking from above
                ball.reflectY();
                 return hit();
            }
        }
        //detect left or right
        else if(ball.yPos < lower && ball.yPos>top)
        {
            if(ball.xPos ==right)
            {
                //ball is attacking from the right
                ball.reflectX();
                 return hit();
            }
            else if (ball.xPos == left)
            {
                //ball is attacking from the right
                ball.reflectX();
                 return hit();
            }
        }
        }
        return false;
    }
    boolean detect(Ball ball)
    {
        if(notBroke)
        {
            //detect top or bottom
        if(ball.xPos <left &&ball.xPos >right)
        {
            if(ball.yPos ==lower)
            {
                //the ball is attacking from below
                ball.reflectY();
                return hit();
            }
            else if(ball.yPos ==top )
            {
                //the ball is attacking from above
                ball.reflectY();
                 return hit();
            }
        }
        //detect left or right
        else if(ball.yPos < lower && ball.yPos>top)
        {
            if(ball.xPos ==right)
            {
                //ball is attacking from the right
                ball.reflectX();
                 return hit();
            }
            else if (ball.xPos == left)
            {
                //ball is attacking from the right
                ball.reflectX();
                 return hit();
            }
        }
        }
        return false;
    }
    void kill()
    {
        this.health = 0;
        this.notBroke = false;
    }
}

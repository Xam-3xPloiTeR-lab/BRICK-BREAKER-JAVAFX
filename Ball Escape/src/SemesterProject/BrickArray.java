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


public class BrickArray  implements java.io.Serializable
{
    //variables
    int cross = 25;
    int down = 5;
    Brick bricks[][] = new Brick[down][cross];
    //constructor
    public BrickArray()
    {
        init();
    }
    //methods
    void init()
    {
        for(int i =0; i < down;i++)
        {
            for(int j = 0; j <cross;j++)
            {
                bricks[i][j] = new Brick((j * 50)+15,(i *50)+10,2);
            }
        }
        
    }
    int checkAll(Ball ball)
    {
        int numberKilled = 0;
        for(int i =0; i <down;i++)
        {
            for(int j=0; j<cross;j++)
            {
                if(bricks[i][j].detect(ball))
                {
                    numberKilled++;
                }
                
            }
        }
        return numberKilled;
    }
    void killAll()
    {// for clearing out all the bricks in the event of a defeat
        for(int i=0;i<down;i++)
        {
            for(int j=0; j<cross;j++)
            {
                bricks[i][j].kill();
            }
        }
    }
    
   
    
    
}

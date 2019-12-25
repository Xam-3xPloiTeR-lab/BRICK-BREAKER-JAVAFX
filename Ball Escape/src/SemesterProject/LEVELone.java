/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package SemesterProject;
import java.io.FileNotFoundException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Xam 3xPloiTeR
 */

public class LEVELone implements ScreenSize
{
    //variables
    boolean ballOnPaddle = true;
    boolean shouldExit = false;
    boolean isActive;
    int score = 10;
    int livesLeft = 3;
    Paddle paddle = new Paddle();
    Ball ball = new Ball();
    BrickArray brickArray = new BrickArray();
    Brick tempBrick;
    ResourceManager manager=new ResourceManager();
    int killed = 0;
    //constructor
    
    //methods
    public void render(GraphicsContext gc)
    {
        if(isActive)
        {
        
        //Black Background
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        
        //Render the position of the player's paddle
        gc.setFill(Color.ROYALBLUE);
        gc.fillRect(paddle.xPos, paddle.yPos, paddle.xSize, paddle.ySize);
        //Render the Ball
        gc.fillOval(ball.xPos, ball.yPos, ball.xSize, ball.ySize);
        //Render life 
        gc.setFill(Color.YELLOW);
        gc.fillRect(10, 700, 150, 30);
        gc.setFont(new Font( 25));
        gc.setFill(Color.RED);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("Life Left: "+livesLeft, 70, 724);
        //Render Score
        gc.setFill(Color.YELLOW);
        gc.fillRect(10, 650, 100, 30);
        gc.setFont(new Font( 25));
        gc.setFill(Color.RED);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("Score: "+(killed*score), 55, 673);
        //Render the Brick Array
        for(int i = 0; i<brickArray.down;i++)
        {
            for(int j = 0; j < brickArray.cross; j++)    
            {
                tempBrick = brickArray.bricks[i][j];
                gc.setFill(tempBrick.getShade());
                if(tempBrick.notBroke)
                {
                    gc.fillRect(tempBrick.xPos, tempBrick.yPos, tempBrick.sizeX, tempBrick.sizeY);
                }
                
            }
        }
        }
        
        
    }
    public void tick(Input input) throws Exception 
    {
        if(isActive)
        {
        //update the paddle object
        if(input.left)
        {//the player wishes to move the paddle left
            paddle.decreaseXVec();
        }
        else if(input.right)
        {// the player wishes to move to the right
            paddle.increaseXVec();
            
        }
        if(input.n)
        {//Save Game State Into File
            save();
        }
        if(input.m)
        {//Load Game From SaveFile
            load();
        }
        //check if the ball is on the paddle
        //and if the player presses up the ball is released
        if(input.up)
        {//load ball and fire it
            ballOnPaddle = false;
        }
        //apply friction to paddle
        
            if(!input.left && !input.right)
           {
                paddle.normalizeX();
                
           }
        //update the paddle's position
        paddle.xDelta();
        //decide if the ball should be on the paddle
        
       
        if(ball.Delta(paddle, ballOnPaddle))
        {
            mistake();
        }
        
        
        killed += brickArray.checkAll(ball);
        }
        
        
//         ballOnPaddle, shouldExit, isActive,score,livesLeft,paddle,ball,brickArray,tempBrick,killed
    }
    public void save() throws Exception{
        int[][]  h = new int[5][25];
        Color[][]  clr = new Color[5][25];
        boolean[][]  nb = new boolean[5][25];
        for(int d=0;d<brickArray.bricks.length;d++){
            for(int c=0;c<brickArray.bricks[d].length;c++){
            h[d][c]=brickArray.bricks[d][c].health;
            nb[d][c]=brickArray.bricks[d][c].notBroke;
            }
        }
        
      SaveData datas = new SaveData( ballOnPaddle, shouldExit, isActive,score,livesLeft,killed,paddle.xPos,ball.xPos,ball.xVec,ball.yPos,ball.yVec,h,nb,clr);
      ResourceManager obj = new ResourceManager();
      try
      {
          obj.savedata(datas,"xam.ser");
      }
      catch(Exception e){
      System.out.println("Cannot Save data"+ e.getMessage());
      
    }

    }
    public void load() throws Exception{
        ResourceManager obj = new ResourceManager();
        try{
     SaveData data = (SaveData)obj.loaddata("xam.ser");
      ballOnPaddle = data.ballOnPaddle;
        shouldExit = data.shouldExit;
        isActive = data.isActive;
        score = data.score;
        livesLeft = data.livesLeft;
        paddle.xPos=data.pxpos;
        killed = data.killed;
        ball.xPos=data.bxpos;
        ball.xVec=data.bxver;
        ball.yPos=data.bypos;
        ball.yVec=data.byver;
        for(int d=0;d<brickArray.bricks.length;d++){
            for(int c=0;c<brickArray.bricks[d].length;c++){
            brickArray.bricks[d][c].health=data.h[d][c];
            brickArray.bricks[d][c].notBroke=data.nb[d][c];
            }
        }
      }
      catch(FileNotFoundException e){
      System.out.println("Cannot Load data"+ e.getMessage());
      }
    }
    public boolean exit()
    {
        return shouldExit;
    }
    public void mistake()
    {
        this.livesLeft--;
        if(this.livesLeft == 0)
        {
            shouldExit = true;
        }
        
        
        this.ballOnPaddle = true;
        
    }
    public int destination()
    {
        return 1;
    }
    public void activate()
    {
        this.isActive = true;
        if(this.shouldExit == true)
        {
            this.livesLeft = 3;
            shouldExit = false;
            ballOnPaddle = true;
            this.brickArray = new BrickArray();
            this.score = 0;
            
        }
        
    }
    public void deactivate()
    {
        this.isActive = false;
    }
    
    
}

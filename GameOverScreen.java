import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{
    Label gameOverLabel;
    Label restartLabel;
    Label scoreLabel;
    Label livesLabel;
    MyWorld gameWorld = new MyWorld();
    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public GameOverScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        gameOverLabel = new Label("Game Over" , 100);
        addObject(gameOverLabel, 300, 200);
        
        restartLabel = new Label ("Press <space> to play again!", 40);
        addObject(restartLabel, 300, 275);
        
        //scoreLabel = new Label("Score: " + score, 45);
        //addObject(scoreLabel, 105, 50);
        
        //livesLabel = new Label("Lives: " + lives, 45);
        //addObject(livesLabel, 520, 50);
    }
    
    public void act()
    {   
        if (Greenfoot.isKeyDown("space"))
        {
            removeObject(livesLabel);
            removeObject(scoreLabel);
            Greenfoot.setWorld(gameWorld);
        }
    }
}

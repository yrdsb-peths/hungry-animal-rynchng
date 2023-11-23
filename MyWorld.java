import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * The coolest world
 * 
 * @author ryan chang
 * @version November 2023
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        // Create elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        // Create label
        scoreLabel = new Label(0, 75);
        addObject(scoreLabel, 50, 50);
        
        
        createApple();
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over" , 100);
        addObject(gameOverLabel, 300, 200);
    }
}

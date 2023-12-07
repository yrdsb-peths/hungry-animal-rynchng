import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * The coolest world
 * 
 * @author ryan chang
 * @version November 2023
 */
public class MyWorld extends World
{
    Elephant elephant;
    public int score = 0;
    public int lives = 5;
    Label gameOverLabel;
    Label restartLabel;
    Label scoreLabel;
    Label livesLabel;
    
    Apple apple;
    Bomb bomb;
    boolean sendBombs = false;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        buildGame();
    }
    
    public void buildGame()
    {
        // Create elephant object
        elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        // Create label
        scoreLabel = new Label("Score: " + score, 45);
        addObject(scoreLabel, 105, 50);
        
        livesLabel = new Label("Lives: " + lives, 45);
        addObject(livesLabel, 520, 50);
        
        createApple();
        createBomb();
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue("Score: " + score);
        
        if (score == 10)
        {
            sendBombs = true;
        }
    }
    
    public void decreaseScore(int sco)
    {
        score = score - sco;
        scoreLabel.setValue("Score: " + score);
    }
    
    public void createApple()
    {
        apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    public void gameOver()
    {
        GameOverScreen GameOverWorld = new GameOverScreen();
        Greenfoot.setWorld(GameOverWorld);
    }
    
    public void createBomb()
    {
        bomb = new Bomb();
        int posOrNeg = 1; 
        int x;
        if (Greenfoot.getRandomNumber(1) == 1)
        {
            posOrNeg = 1;
        }
        else
        {
            posOrNeg = -1;
        }
        
        if (sendBombs == true)
        {
            x = apple.getX() + (posOrNeg * (40 + Greenfoot.getRandomNumber(60)));
        }
        else
        {
            x = 900;
        }
        
        int y = -40;
        
        addObject(bomb, x, y);
        
        System.out.println(x);
    }
    
    public void decreaseLives()
    {
        lives--;
        livesLabel.setValue("Lives: "+ lives);
        
        if (lives == 0 || score < 0)
        {
            gameOver();
        }
    }
}

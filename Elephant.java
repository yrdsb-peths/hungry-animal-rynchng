import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant
 * 
 * @author ryan chang
 * @version November 2023
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantNoise.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    GreenfootSound explosion = new GreenfootSound("explosion.mp3");
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Act - do whatever the Elephantt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Elephant()
    {
        for (int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        
        for (int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        
        animationTimer.mark();
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    public void animate()
    {
        if (animationTimer.millisElapsed() < 150)
        {
            return;
        }
        animationTimer.mark();
        if (facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            move(-3);
            facing = "left";
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            move(3);
            facing = "right";
        }
        
        // remove apple if elephant touches it
        eat();
        
        // animates the elephant's movement
        animate();
        
        explode();
        
        border();
    }
    
    public void eat()
    {
        if (isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
    
    public void explode()
    {
        if (isTouching(Bomb.class))
        {
            removeTouching(Bomb.class);
            MyWorld world = (MyWorld) getWorld();
            world.createBomb();
            world.decreaseScore(2);
            world.decreaseLives();
            explosion.play();
        }
    }
    
    public void border()
    {
        int rightBorder = 600;
        
        if (getX() + 40 >= rightBorder)
        {
            setLocation(rightBorder - 40, 300);
        }
        else if (getX() - 40 <= 0)
        {
            setLocation(40, 300);
        }
    }
}

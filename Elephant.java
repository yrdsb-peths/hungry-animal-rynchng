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
    
    /**
     * Act - do whatever the Elephantt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        
        // remove apple if elephant touches it
        eat();
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
}

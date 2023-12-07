import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author Ryan Chang 
 * @version December 2023
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 50);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2 + 40, 80);
        prepare();
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,100,70);
        Label label = new Label("Press <space> to start", 50);
        addObject(label,300,365);
        Label label2 = new Label("Use \u2190 and \u2192 to move", 50);
        addObject(label2,300,150);
        Label label3 = new Label("You have 5 lives", 60);
        addObject(label3,300,210);
        Label label4 = new Label("Dont run out of lives or let ", 50);
        addObject(label4,300,260);
        Label label5 = new Label("your score go below 0!", 50);
        addObject(label5,300,310);
    }
}

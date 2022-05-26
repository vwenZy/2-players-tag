import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Pokemon I don't know the name.
 * 
 * @author Zhang
 * @version May 26
 */
public class bonusForApple extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] size = new GreenfootImage[4];
    
    // Direction the elephant is facing.
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor - The code that gets run one time when object is created.
     */
    public bonusForApple()
    {
        for(int i = 0; i < size.length; i++)
        {
            size[i] = new GreenfootImage("images/cabbage/size" + i + ".png");
            size[i].scale(45, 60);
        }
        
        animationTimer.mark();
        
        // Initial elephant image.
        setImage(size[0]);
    }
    
    /**
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100) {
            return;
        }
        animationTimer.mark();
    }
    
    public void act()
    {
        // Animate the elephant.
        animateElephant();
    }
}

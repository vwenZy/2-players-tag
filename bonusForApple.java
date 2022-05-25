import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Pokemon I don't know the name.
 * 
 * @author Zhang
 * @version May 25
 */
public class bonusForApple extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        // Animate the plant.
        GreenfootImage image = getImage();  
        image.scale(30, 30);
    }
}

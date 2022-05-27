import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Return here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Return extends Actor
{
    /**
     * Act - do whatever the Return wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
         if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
    
    public Return()
    {
        GreenfootImage img = new GreenfootImage("return.png");
        img.scale(img.getWidth()/7, img.getHeight()/7);
        setImage(img);
    }
}

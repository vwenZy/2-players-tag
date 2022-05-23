import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class a here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the a wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        // int x = getX();
        // int y = getY();
        // setLocation(x, y+2);

        if(Greenfoot.isKeyDown("j")){
            move(-2);
        }
        if(Greenfoot.isKeyDown("l")){
            move(2);
        }
        if(Greenfoot.isKeyDown("space")){
            turn(2);
        }
        if(Greenfoot.isKeyDown("k")){
            moveDown();
        }
        if(Greenfoot.isKeyDown("i")){
            moveUp();
        }
    }
    public void moveDown(){
        setLocation(getX(), getY()+2);
    }
    public void moveUp(){
        setLocation(getX(), getY()-2);
    }
}

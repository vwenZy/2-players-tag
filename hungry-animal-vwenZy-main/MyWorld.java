import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Elephant e = new Elephant();
        addObject(e, 300, 350);
        
        // Apple a = new Apple();
        // addObject(a, Greenfoot.getRandomNumber(300), Greenfoot.getRandomNumber(300));
        
        spawnApple();
        
        showText(Elephant.getCount(), 50, 50);
    }
    public void spawnApple()
    {
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(600);
        Apple apple = new Apple();
        addObject(apple, x, y);
    }
}

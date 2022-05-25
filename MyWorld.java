import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 */
public class MyWorld extends World
{
    // can print these on screen later.
    int score = 0;
    int level = 1;
    
    SimpleTimer spawnTime = new SimpleTimer();
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
        
        Apple a = new Apple();
        addObject(a, Greenfoot.getRandomNumber(300), Greenfoot.getRandomNumber(300));
        
        // spawnApple();
    }
    
    public void spawnApple()
    {
        int x = Greenfoot.getRandomNumber(580);
        int y = Greenfoot.getRandomNumber(580);
        Greenfoot.delay(50);
        Elephant elephant = new Elephant();
        addObject(elephant, x, y);
    }
    
    public void increaseScore()
    {
        score++;
        if(score % 10 == 0) {
            level += 1;
            bonusForElephant xiaozhi = new bonusForElephant();
            addObject(xiaozhi, Greenfoot.getRandomNumber(580), Greenfoot.getRandomNumber(580));
        }
        if(score % 13 == 0) {
            bonusForApple plant = new bonusForApple();
            addObject(plant, Greenfoot.getRandomNumber(580), Greenfoot.getRandomNumber(580));
        }
    }
    
    public int getScore()
    {
        return score;
    }
}

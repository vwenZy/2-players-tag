import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 */
public class MyWorld extends World
{
    // can print these on screen later.
    public int score = 0;
    Label scoreLabel;
    Label appleSpeedLabel;
    Label elephantSpeedLabel;
    
    SimpleTimer spawnTime = new SimpleTimer();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 330, 1);
        
        // Create a score label.
        scoreLabel = new Label(0, 50);
        addObject(scoreLabel, 65, 40);

        // Create an apple speed label.
        appleSpeedLabel = new Label(0, 25);
        addObject(appleSpeedLabel, 450, 40);
        
        // Create an elephant speed label.
        elephantSpeedLabel = new Label(0, 25);
        addObject(elephantSpeedLabel, 450, 80);
        
        Elephant e = new Elephant();
        addObject(e, 300, 350);
        
        Apple a = new Apple();
        addObject(a, Greenfoot.getRandomNumber(300), Greenfoot.getRandomNumber(300));
        
        // spawnApple();
    }
    
    public void spawnApple()
    {
        int x = Greenfoot.getRandomNumber(580);
        int y = Greenfoot.getRandomNumber(320);
        Greenfoot.delay(50);
        Elephant elephant = new Elephant();
        addObject(elephant, x, y);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        if(score % 6 == 0) {
            bonusForElephant xiaozhi = new bonusForElephant();
            addObject(xiaozhi, Greenfoot.getRandomNumber(580), Greenfoot.getRandomNumber(320));
        }
        if(score == 32) {
            GameOver gameOverWorld = new GameOver();
            Greenfoot.setWorld(gameOverWorld);
        }
        if(score % 4 == 0) {
            Bomb bomb = new Bomb();
            addObject(bomb, Greenfoot.getRandomNumber(580), 0);
        }
    }
    
    public void increaseAppleSpeed()
    {
        appleSpeedLabel.setValue("Chaser Speed: " + Apple.getSpd());
    }
    
    public void increaseElephantSpeed()
    {
        elephantSpeedLabel.setValue("Runner Speed: " + Elephant.getSpd());
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Pikachu.
 * 
 * @author Zhang
 * @version May 25
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int size = 50;
    
    // GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] runRight = new GreenfootImage[4];
    GreenfootImage[] runLeft = new GreenfootImage[4];
    
    // Direction the elephant is facing.
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor - The code that gets run one time when object is created.
     */
    public Apple()
    {
        for(int i = 0; i < runRight.length; i++)
        {
            runRight[i] = new GreenfootImage("images/pikachu/run" + i + ".png");
            runRight[i].scale(50, 50);
        }
        
        for(int i = 0; i < runLeft.length; i++)
        {
            runLeft[i] = new GreenfootImage("images/pikachu/run" + i + ".png");
            runLeft[i].mirrorHorizontally();
            runLeft[i].scale(50, 50);
        }
        
        animationTimer.mark();
        
        // Initial elephant image.
        setImage(runRight[0]);
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
        if(facing.equals("right")) {
            setImage(runRight[imageIndex]);
            imageIndex = (imageIndex + 1) % runRight.length;
        } else {
            setImage(runLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % runLeft.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("a")) {
            move(-5);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("d")) {
            move(5);
            facing = "right";
        }
        if(Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + 5);
        }
        if(Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - 5);
        }
        
        eat();
        
        // Animate the elephant.
        animateElephant();
    }
    
    public void eat()
    {
        // check if elephant is touching apple
        if(isTouching(Elephant.class)) {
            removeTouching(Elephant.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
            // elephantSound.play();
        }
    }

    public void getSize()
    {
        // check if elephant is touching apple
        if(isTouching(bonusForApple.class)) {
            removeTouching(bonusForApple.class);
            MyWorld world = (MyWorld) getWorld();
            runRight[0].scale(size += 10, size += 10);
            runLeft[0].scale(size += 10, size += 10);
        }
    }
}
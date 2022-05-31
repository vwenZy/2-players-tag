import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Pokemon I don't know the name.
 * 
 * @author Zhang
 * @version May 25
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static int size = 45;
    public static int speed = 3;
    
    // GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[6];
    GreenfootImage[] idleLeft = new GreenfootImage[6];
    
    // Direction the elephant is facing.
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor - The code that gets run one time when object is created.
     */
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/pokemon/idle" + i + ".png");
            idleRight[i].scale(size, size);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/pokemon/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(size, size);
        }
        
        animationTimer.mark();
        
        // Initial elephant image.
        setImage(idleRight[0]);
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
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        } else {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left")) {
            move(-speed);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right")) {
            move(speed);
            facing = "right";
        }
        if(Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + speed);
        }
        if(Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - speed);
        }
        
        // Eat xiaozhi.
        getSpeed();
        
        // Game Over when touches the bomb.
        getBomb();
        
        // Animate the elephant.
        animateElephant();
    }
    
    public void getSpeed()
    {
        // check if elephant - pokemon is touching xiaozhi
        if(isTouching(bonusForElephant.class)) {
            removeTouching(bonusForElephant.class);
            MyWorld world = (MyWorld) getWorld();
            speed += 3;
            world.increaseElephantSpeed();
        }
    }
    
    public void getBomb()
    {
        if(isTouching(Bomb.class)) {
            GameOver gameOverWorld = new GameOver();
            Greenfoot.setWorld(gameOverWorld);
            GameOver.isBomb.setValue("The chaser touches the bomb.");
        }
    }
    
    public static int getSpd()
    {
       return speed;
    }
}

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
    
    public static int size = 70;
    public static int speed = 3;
    
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
            runRight[i].scale(size, size);
        }
        
        for(int i = 0; i < runLeft.length; i++)
        {
            runLeft[i] = new GreenfootImage("images/pikachu/run" + i + ".png");
            runLeft[i].mirrorHorizontally();
            runLeft[i].scale(size, size);
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
            move(-speed);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("d")) {
            move(speed);
            facing = "right";
        }
        if(Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed);
        }
        if(Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed);
        }
        
        // Eat elephant - pokemon
        eat();
        
        // Eat xiaozhi.
        getSpeed();
        
        //Game Over when touches the bomb.
        getBomb();
        
        // Animate the elephant.
        animateElephant();
    }
    
    public void eat()
    {
        // check if apple is touching elephant
        if(isTouching(Elephant.class)) {
            removeTouching(Elephant.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
            // elephantSound.play();
        }
    }

    /*public void getSize()
    {
        // check if apple - pikachu is touching cabbage
        if(isTouching(bonusForApple.class)) {
            removeTouching(bonusForApple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnPower();
        }
    }*/

    public void getSpeed()
    {
        // check if elephant - pokemon is touching xiaozhi
        if(isTouching(bonusForElephant.class)) {
            removeTouching(bonusForElephant.class);
            MyWorld world = (MyWorld) getWorld();
            speed += 3;
            world.increaseAppleSpeed();
        }
    }
    
    public void getBomb()
    {
        if(isTouching(Bomb.class)) {
            GameOver gameOverWorld = new GameOver();
            Greenfoot.setWorld(gameOverWorld);
            System.out.println("The chaser touches your bomb.");
        }
    }
    
    public static int getSpd()
    {
        return speed;
    }
}

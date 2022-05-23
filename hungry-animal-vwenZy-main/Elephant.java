import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor
{
    public static String count = "";
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("a")){
            move(-2);
        }
        if(Greenfoot.isKeyDown("d")){
            move(2);
        }
        if(Greenfoot.isKeyDown("space")){
            turn(2);
        }
        if(Greenfoot.isKeyDown("s")){
            moveDown();
        }
        if(Greenfoot.isKeyDown("w")){
            moveUp();
        }
        if(isTouching(Apple.class)){
            count += "*";
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
        }
    }
    public static String getCount(){
        return count;
    }
    public void moveDown(){
        setLocation(getX(), getY()+2);
    }
    public void moveUp(){
        setLocation(getX(), getY()-2);
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameDes here.
 * 
 * @author Zhang
 * @version May 27
 */
public class GameDes extends World
{
    Label descriptionLabel0 = new Label("Chaser Pikachu", 50);
    Label descriptionLabel1 = new Label("Pikachu is the chaser, catch the grey pokemon !", 20);
    Label descriptionLabel2 = new Label("The grey Pokemon is the runner, run away from Pikachu !", 20);
    Label descriptionLabel3 = new Label("1 score is gained when Pikachu catched the grey Pokemon", 20);
    Label descriptionLabel4 = new Label("Game will ends after 32 scores are gained!", 20);
    Label descriptionLabel5 = new Label("Satoshi will add 3 speed to the character who ate him!", 20);
    Label descriptionLabel6 = new Label("Rememebr, NO ONE can touches the bomb", 20);
    
    /**
     * Constructor for objects of class GameDes.
     * 
     */
    public GameDes()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 330, 1);
        
        addObject(descriptionLabel0, 300, 70);
        addObject(descriptionLabel1, 300, 120);
        addObject(descriptionLabel2, 300, 150);
        addObject(descriptionLabel3, 300, 180);
        addObject(descriptionLabel4, 300, 210);
        addObject(descriptionLabel5, 300, 240);
        addObject(descriptionLabel6, 300, 270);
        
        Return back = new Return();
        addObject(back, 560, 297);
    }
}

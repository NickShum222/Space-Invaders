import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private Button playAgain;
    public static int currentScore;
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground(new GreenfootImage ("background.png"));
       
        Label space = new Label("GAME OVER", 40);
        addObject(space, 305, 50);
        //Gets the final score from the GameWorld
        Label score = new Label("YOUR SCORE IS " + GameWorld.scoreTotal, 40);
        addObject(score, 305, 250);
        
        playAgain = new Button("PLAY AGAIN");
        addObject(playAgain, 305, 150);
        
    }
    public void act(){
          if(Greenfoot.mouseClicked(playAgain)){ //If the user clicked on the button, it will start a new game
             Greenfoot.setWorld(new GameWorld()); 
            }
    }
}

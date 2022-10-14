import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerLives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerLives extends Actor
{ //Just a player image for the counter at the bottom left screen of the gameworld
    private GreenfootImage image;
    private static Color green = new Color (84, 255, 49);
    private int enemySize =3; //pixel size is slightly smaller
    public PlayerLives(){
        image = drawPlayer();
        setImage(image);
        
    }
    
    private GreenfootImage drawPlayer(){
       GreenfootImage temp = new GreenfootImage(enemySize * 15, enemySize * 7);
       temp.setColor(green);
       
       temp.fillRect(enemySize * 7, 0, enemySize * 1, enemySize * 1);
       
       temp.fillRect(enemySize * 6, enemySize * 1, enemySize * 3, enemySize * 2);
       
       temp.fillRect(enemySize * 1, enemySize * 3, enemySize * 13, enemySize * 1);
       temp.fillRect(0, enemySize * 4, enemySize * 15, enemySize * 3);
       return temp;
    }
}

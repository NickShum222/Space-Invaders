import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayerHit extends Actor
{
    private GreenfootImage image;
    private static Color green = new Color (84, 255, 49);
    private int enemySize = 4;
    private int duration = 40; //How long the player hit image will stay on the gameWorld
    boolean startMoving = false;
    public PlayerHit(){
        image = drawPlayerHit();
        setImage(image);   
    }
    public void act() 
    {
        if(duration != 0){
            duration--; 
        }
        if(duration == 0){
           //Once the timer is 0, it will respawn the player and remove the hit image
           getWorld().addObject(new Player(), 355, 700);
           duration = 20;
           getWorld().removeObject(this);
        }
    } 
    private GreenfootImage drawPlayerHit(){
        GreenfootImage temp = new GreenfootImage(enemySize * 15, enemySize * 8);
        temp.setColor(green);
        temp.fillRect(enemySize * 5, 0, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 10, enemySize * 1, enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 5, enemySize * 2, enemySize * 1, enemySize * 2);
        temp.fillRect(enemySize * 7, enemySize * 2, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 9, enemySize * 2, enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 2, enemySize * 3, enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 6, enemySize * 4, enemySize * 2, enemySize * 2);
        temp.fillRect(enemySize * 9, enemySize * 4, enemySize * 2, enemySize * 1);
        
        temp.fillRect(0, enemySize * 5, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 4,enemySize * 5,enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 9, enemySize * 5, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 11, enemySize * 5, enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 2, enemySize * 6, enemySize * 8, enemySize * 1);
        temp.fillRect(enemySize * 12, enemySize * 6, enemySize * 1, enemySize * 2);
        temp.fillRect(enemySize * 1, enemySize * 7, enemySize * 10, enemySize * 1);
        temp.fillRect(enemySize * 14, enemySize * 1, enemySize * 1,enemySize * 1);
        return temp;
    }
}

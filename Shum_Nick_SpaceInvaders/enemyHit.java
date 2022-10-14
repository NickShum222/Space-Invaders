import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class enemyHit extends Actor
{
    private GreenfootImage image;
    private static Color white = new Color (255, 255, 250);
    private int enemySize = 3;
    private int duration = 30;
    public enemyHit(){
        image = drawEnemyHit();
        setImage(image);   
    }
    public void act() 
    {
        if(duration != 0){
         duration--;   //The enemy hitmarker will remain in the world for a period of time
        }
        if(duration == 0){ //Will remove itself when the timer is up
         getWorld().removeObject(this);   
        }
    } 
    
    private GreenfootImage drawEnemyHit(){
        GreenfootImage temp = new GreenfootImage(enemySize * 11, enemySize * 9);
        temp.setColor(white);
        temp.fillRect(enemySize * 3, 0, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 7, 0, enemySize * 1, enemySize * 1);
        
        temp.fillRect(enemySize * 1, enemySize * 1, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 4, enemySize * 1, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 6, enemySize * 1, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 9, enemySize * 1,enemySize * 1,enemySize * 1);
        
        temp.fillRect(enemySize * 2, enemySize * 2, enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 8, enemySize * 2, enemySize * 1,enemySize * 1);
        
        temp.fillRect(enemySize * 3, enemySize * 3, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 7, enemySize * 3, enemySize * 1, enemySize * 1);
        
        temp.fillRect(0, enemySize * 4, enemySize * 3, enemySize * 1);
        temp.fillRect(enemySize * 8, enemySize * 4, enemySize * 3, enemySize * 1);
        
        temp.fillRect(enemySize * 3, enemySize * 5, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 7, enemySize * 5, enemySize * 1, enemySize * 1);
        
        temp.fillRect(enemySize * 2, enemySize * 6, enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 8,enemySize *  6, enemySize * 1,enemySize * 1);
        
        temp.fillRect(enemySize * 1, enemySize * 7, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 4, enemySize * 7, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 6,enemySize * 7, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 9, enemySize * 7,enemySize * 1,enemySize * 1);
        
        temp.fillRect(enemySize * 3, enemySize * 8, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 7, enemySize * 8, enemySize * 1, enemySize * 1);
        return temp;
    }
}

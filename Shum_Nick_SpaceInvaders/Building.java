import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Building extends Actor
{
    private int currentHp = 100;
    private static Color green = new Color (84, 255, 49);
    private GreenfootImage image;
    private int enemySize = 4; //enemy size is the amount of pixels that are in a pixel of the drawing
    private StatBar healthBar = new StatBar(100, currentHp, null, 100, 10,0, Color.GREEN, Color.RED, false, Color.WHITE, 1);
    
    public Building(World world, int x, int y){        
        image = drawBuilding();
        setImage (image);
        world.addObject(healthBar, x, y + 50);
        
    }
    public void act() 
    {
        Actor Eprojectile = getOneIntersectingObject(EProjectile.class);
        if (Eprojectile != null) {
            getWorld().removeObject(Eprojectile);
            currentHp -= 8; //subtract 8 HP everytime the enemy has hit the builidng
            healthBar.update(currentHp);
        }
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null){
         getWorld().removeObject(projectile);
         currentHp -= 10; //Player projectiles will deal more damage to buildings
         healthBar.update(currentHp);
        }
    } 
    public int getCurrentHp(){ //For the gameworld to determine if the building is above 0 hp
     return currentHp;   
    }
    private GreenfootImage drawBuilding(){ //Size of the enemy can be changed
       GreenfootImage temp = new GreenfootImage(enemySize * 23, enemySize * 13);
       temp.setColor(green);
       
       temp.fillRect(enemySize * 4, 0, enemySize * 16, enemySize * 1);
       temp.fillRect(enemySize * 2, enemySize * 1, enemySize * 19, enemySize * 1);
       temp.fillRect(enemySize * 1, enemySize * 2, enemySize * 21, enemySize * 1);
       temp.fillRect(0, enemySize * 3, enemySize * 23, enemySize * 6);
    
       temp.fillRect(0, enemySize * 9, enemySize * 8, enemySize * 1);
       temp.fillRect(enemySize * 14, enemySize * 9, enemySize * 9, enemySize * 1);
       temp.fillRect(0, enemySize * 10, enemySize * 5, enemySize * 1);
       temp.fillRect(enemySize * 3, enemySize * 10, enemySize * 4, enemySize * 1);
       temp.fillRect(0, enemySize * 11, enemySize * 6, enemySize * 2);
       temp.fillRect(enemySize * 16, enemySize * 11, enemySize * 7, enemySize * 2);
       temp.fillRect(enemySize * 15, enemySize *10, enemySize * 8, enemySize);
       
       return temp;
    }
    
}

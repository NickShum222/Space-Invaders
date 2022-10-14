import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EnemyLarge extends SmoothMover
{
    private GreenfootImage image;
    private static Color white = new Color (255, 255, 250);
    private int dir= 1; //The movement will be multiplied by dir to determine if it is going left or right
    private int timer = 0;
    private int row;
    private int enemySize=4;
    private int shootCooldown = 0;
    private int shootChance = 1;
    private int shoot;
    private boolean move; //boolean is used so that the enemies from the welcome screen do not move
    public EnemyLarge(int row, boolean move){
        super();
        dir = 1;
        this.row = row;
        this.move = move;
        image = drawEnemyLarge();
        setImage(image);
   }
   public int getRow(){
     return row;  
    }
    public void act() 
    {
        if(move){
       if(shootCooldown > 0){
           shootCooldown--;
        } //The same enemy cannot shoot in a row to prevent multiple projectiles being spawned
       if(shootCooldown == 0){
           shoot = randomInt(2000, 1);
           if(shoot == 1){
               getWorld().addObject(new EProjectile(), getX(), getY() + 30);
               shootCooldown = 1000;
            }
        }
    }
    }
    private GreenfootImage drawEnemyLarge(){
        GreenfootImage temp = new GreenfootImage(enemySize * 12, enemySize * 8);
        temp.setColor(white);
        temp.fillRect(enemySize * 4, 0, enemySize * 4, enemySize * 1);
        temp.fillRect(enemySize * 1, enemySize * 1, enemySize * 10, enemySize * 1);
        temp.fillRect(0, enemySize * 2, enemySize * 12, enemySize * 1);
        temp.fillRect(0,enemySize * 3, enemySize * 3, enemySize * 1);
        temp.fillRect(enemySize * 5, enemySize * 3, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 9, enemySize * 3, enemySize * 3, enemySize * 1);
        temp.fillRect(0, enemySize * 4, enemySize * 12, enemySize * 1);
        temp.fillRect(enemySize * 3, enemySize * 5, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 7, enemySize * 5, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 2, enemySize * 6, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 5, enemySize * 6, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 8, enemySize * 6, enemySize * 2, enemySize * 1);
        temp.fillRect(0, enemySize * 7, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 10, enemySize * 7, enemySize * 2, enemySize * 1);
        return temp;
    }
    public int getDir(){
     return dir;   
    }
    public void changeDir(){
      dir *= -1;   
    }
    private static int randomInt(int maximum, int minimum){ //This method is called when a random integer is needed and the parameters are the range from what the integer can be
     return ((int)(Math.random() * (maximum - minimum))) + minimum; //Code courtesy of Java67.com    
    }
    public boolean isTouchingProjectile(){
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if (projectile != null) {
            getWorld().removeObject(projectile);            
            return true;
        } else {
            return false;
        }  
    }
}

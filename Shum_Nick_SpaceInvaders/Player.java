    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends SmoothMover
{
    private GreenfootImage image;
    private static Color green = new Color (84, 255, 49);
    private static Color white = new Color (255, 255, 250);
    private int enemySize =4;
    private static int WAIT_TIME = 0; //Reload time to prevent player from shooting mutliple times
    private GreenfootSound[] shootSound;
    private GreenfootSound explosion;
    private int shootSoundIndex;
    private int timer = 20;
    public Player(){
        image = drawPlayer();
        setImage(image);
        shootSound = new GreenfootSound[20];
        for(int i = 0; i < shootSound.length; i++){
         shootSound[i] = new GreenfootSound("shoot.wav");
         shootSound[i].setVolume(80);
         shootSoundIndex = 0;
        }
        explosion = new GreenfootSound("explosion.wav");
        explosion.setVolume(60);
    }
    public void act() 
    {
        if(WAIT_TIME > 0){
         WAIT_TIME--;   
        }
       if (Greenfoot.isKeyDown("d")){
         move(3.0);
        }
        if (Greenfoot.isKeyDown("a")){
         move(-3.0);
        }
        if(Greenfoot.isKeyDown("space")){
         if(WAIT_TIME == 0){
             Shoot();
            }
        }
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
    
    private void Shoot(){
        shootSound[shootSoundIndex].play();
        shootSoundIndex++;
        if(shootSoundIndex >= shootSound.length){
         shootSoundIndex = 0;   
        }
        getWorld().addObject(new Projectile(), getX(), getY() - 30); //Will spawn a projectile 
        
        WAIT_TIME = 50; //Recharge time is reset
    }
    public void reset(){
     explosion.play();
     getWorld().addObject(new PlayerHit(), getX(), getY()); //Add the player hitmarker
     getWorld().removeObject(this); //remove this player 
    }
    public boolean isTouchingEprojectile(){
        Actor projectile = getOneIntersectingObject(EProjectile.class);
        if (projectile != null) {
            getWorld().removeObject(projectile);            
            return true;
        } else {
            return false;
        }  
    }
}

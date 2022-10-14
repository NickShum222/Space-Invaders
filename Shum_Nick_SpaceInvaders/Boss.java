import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Boss extends SmoothMover
{
    private GreenfootImage image;
    private int enemySize=4;
    private boolean move;
    private GreenfootSound ufo;
    private static Color red = new Color (255, 43, 36);
    private int bossScore;
    private GreenfootSound hit;
    public Boss(boolean move){ //boolean is used to determine whether the boss should move. Used for the welcomeworld
        this.move = move;
        image = drawBoss();
        setImage(image);
        ufo = new GreenfootSound("ufo.wav");
        ufo.setVolume(50);
        hit = new GreenfootSound("invaderkilled.wav");        
        hit.setVolume(60);
    }

    public void act() 
    {
        if(move){
            if(!isTouchingProjectile()){
                ufo.playLoop(); //Will loop the sound when it spawns into the world
                move(2.5);
                if(isAtEdge()){
                 getWorld().removeObject(this); 
                 ufo.stop();
                }
            }
            else
            {
            int scoreChance = randomInt(3, 1); //Determines the amount of points
            if(scoreChance == 1){
                bossScore = 50;
            }
            if(scoreChance == 2){
                bossScore = 100;
            }
            else{
                bossScore = 150;
            }
            getWorldOfType(GameWorld.class).increaseScore(bossScore);//Increase the current score from the game world
            hit.play();
            getWorld().removeObject(this);
            ufo.stop();   
            }
        }
    } 

    private GreenfootImage drawBoss(){
        GreenfootImage temp = new GreenfootImage(enemySize * 16, enemySize * 7);
        temp.setColor(red);
        temp.fillRect(enemySize *  5, 0, enemySize *  6, enemySize *  1);
        temp.fillRect(enemySize * 3, enemySize * 1, enemySize * 10, enemySize * 1);
        temp.fillRect(enemySize * 2, enemySize * 2, enemySize * 12, enemySize * 1);
        temp.fillRect(enemySize * 1, enemySize * 3, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 4, enemySize * 3, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 7, enemySize * 3, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 10, enemySize * 3, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 13, enemySize * 3, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 0, enemySize * 4, enemySize * 16, enemySize * 1);
        temp.fillRect(enemySize * 2, enemySize * 5, enemySize * 3, enemySize * 1);
        temp.fillRect(enemySize * 7, enemySize * 5, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 11, enemySize * 5, enemySize * 3, enemySize * 1);
        temp.fillRect(enemySize * 3, enemySize * 6, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 12, enemySize * 6, enemySize * 1, enemySize * 1);
        return temp;   
    }

    public boolean isTouchingProjectile(){
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if (projectile != null) {
            getWorld().removeObject(projectile);
            return true;
        }
        return false;
    }

    private static int randomInt(int maximum, int minimum){ //This method is called when a random integer is needed and the parameters are the range from what the integer can be
        return ((int)(Math.random() * (maximum - minimum))) + minimum; //Code courtesy of Java67.com    
    }
}

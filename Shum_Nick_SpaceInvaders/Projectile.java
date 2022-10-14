import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Projectile extends SmoothMover
{
    private GreenfootImage image;
    private static Color white = new Color (255, 255, 250);
    private int speed = -10; //Speed of the projectile as well as the direction
    public Projectile(){
       image = drawProjectile();
       setImage(image);
    }
    public void act() 
    {
        setLocation(getX(), getY() + speed);
        if(isAtEdge()){
         getWorld().removeObject(this);   
        }
    }
    
  
    private GreenfootImage drawProjectile(){
      GreenfootImage temp = new GreenfootImage(4, 16);
      temp.setColor(white);
      temp.fillRect(0,0,4,16);
       
       return temp;
    }
}

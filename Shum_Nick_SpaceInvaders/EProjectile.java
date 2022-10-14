import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EProjectile extends SmoothMover
{
    private GreenfootImage image;
    private static Color white = new Color (255, 255, 250);
    
    private int speed = 10; //Speed of the projectile
    
    public EProjectile(){
       image = drawEProjectile();
       setImage(image);
    }
    public void act() 
    {
        setLocation(getX(), getY() + speed);
        if(isAtEdge()){
         getWorld().removeObject(this);   
        }
    }    
    private GreenfootImage drawEProjectile(){
      GreenfootImage temp = new GreenfootImage(8, 16);
      temp.setColor(white);
      temp.fillRect(0,0,4,4);
      temp.fillRect(4,4,4,4);
      temp.fillRect(0,8,4,4);
      temp.fillRect(4,12,4,4);
       return temp;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EnemySmall extends EnemyLarge
{
    private GreenfootImage image;
    private static Color white = new Color (255, 255, 250);
    private int enemySize = 4;
    public EnemySmall(int row, boolean move){
        super(row, move);
        image = drawEnemySmall();
        setImage(image);
    } 
    private GreenfootImage drawEnemySmall(){
        GreenfootImage temp = new GreenfootImage(enemySize * 8, enemySize * 8);
        temp.setColor(white);
        
        temp.fillRect(enemySize * 3, 0, enemySize * 2, enemySize * 5);
        temp.fillRect(enemySize * 2, enemySize * 1, enemySize * 1, enemySize * 2);
        temp.fillRect(enemySize * 1, enemySize * 2, enemySize * 1, enemySize * 3);
        temp.fillRect(0, enemySize * 3, enemySize * 1, enemySize * 2);
        temp.fillRect(enemySize * 5, enemySize * 1, enemySize * 1, enemySize * 2);
        temp.fillRect(enemySize * 6, enemySize * 2, enemySize * 1, enemySize * 3);
        temp.fillRect(enemySize * 7,enemySize * 3, enemySize * 1, enemySize * 2);
        temp.fillRect(enemySize * 2, enemySize * 4, enemySize * 1, enemySize * 2);
        temp.fillRect(enemySize * 5, enemySize * 4, enemySize * 1, enemySize * 2);
        temp.fillRect(enemySize * 1, enemySize * 6, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 3, enemySize * 6, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 6, enemySize * 6, enemySize * 1, enemySize * 1);
        temp.fillRect(0, enemySize * 7, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 2, enemySize * 7, enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 5, enemySize * 7, enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 7, enemySize * 7, enemySize * 1,enemySize * 1);
        
        return temp;
    }
    
}

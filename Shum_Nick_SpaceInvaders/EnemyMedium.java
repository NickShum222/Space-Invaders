import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EnemyMedium extends EnemyLarge
{
    private GreenfootImage image;
    private static Color white = new Color (255, 255, 250);
    private static Color black = new Color (0, 0, 0);
    private int enemySize = 4;
    public EnemyMedium(int row, boolean move){
        super(row, move);
        image = drawEnemyMedium();
        setImage(image);
    }
    private GreenfootImage drawEnemyMedium(){
        GreenfootImage temp = new GreenfootImage(enemySize * 13, enemySize * 8);
        temp.setColor(white);
        temp.fillRect(enemySize * 2, 0, enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 8, 0,enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 3, enemySize * 1,enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 7, enemySize * 1,enemySize * 1,enemySize * 1);
        temp.fillRect(enemySize * 2, enemySize * 2, enemySize * 7, enemySize * 1);
        temp.fillRect(enemySize * 1, enemySize * 3, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 4, enemySize * 3, enemySize * 3, enemySize * 1);
        temp.fillRect(enemySize * 8, enemySize * 3, enemySize * 2, enemySize * 1);
        temp.fillRect(0, enemySize * 4, enemySize * 8, enemySize * 1);
        temp.fillRect(0, enemySize * 5, enemySize * 1, enemySize * 2);
        temp.fillRect(enemySize * 2, enemySize * 5, enemySize * 7, enemySize * 1);
        temp.fillRect(enemySize * 10, enemySize * 5, enemySize * 1, enemySize * 2);
        temp.fillRect(enemySize * 2, enemySize * 6, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 8, enemySize * 6, enemySize * 1, enemySize * 1);
        temp.fillRect(enemySize * 3, enemySize * 7, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 6, enemySize * 7, enemySize * 2, enemySize * 1);
        temp.fillRect(enemySize * 8, enemySize * 4, enemySize * 3,enemySize * 1);
        temp.setColor(black);
        //temp.fillRect(0,
        return temp;
    }
}

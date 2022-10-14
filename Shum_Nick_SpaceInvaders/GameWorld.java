import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameWorld extends World
{
    private int currentHp = 100; //The hitpoints of the building
    private int borderLeft = 40; //These values will tell the enemies when to change direction
    private int borderRight = 660; //Esentially the "walls" of the gameworld

    private int timer = 0; //This is a delay for the invaders to start moving
    private int rowNumber = 5; // enemies will move by their row
    private int playerLives = 3; 
    private int bossCoolDown = 1000; //If a boss has spawned, it will go through a cooldown

    private boolean bossSpawn;

    private int enemyX; //For when the enemy is hit and must be replaced with a hitmarker
    private int enemyY;

    public static int scoreTotal = 0; 
    private boolean playerCheck = true;

    private GreenfootSound hit; //Sound when the enemy is killed
    
    private int scoreChance;
    private int bossScore;
    
    Counter score = new Counter("Score: ");
    Counter lives = new Counter("x ");
    Counter wave = new Counter("Wave: ");

    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 800, 1);
        lives.add(3); //Counter to tell the user how many lives they have
        wave.add(1); //Game starts on the first wave
        setBackground(new GreenfootImage ("background.png"));
        addObject(score, 130, 40);
        addObject(lives, 140, 770);
        addObject(wave, 660, 40);
        Player player = new Player();
        addObject(player, 355, 700);
        addObject(new PlayerLives(), 55, 760);

        hit = new GreenfootSound("invaderkilled.wav");        
        hit.setVolume(60);
        //Adds the buildings
        for(int i = 85; i <= 616; i+=177){
            addObject(new Building(this, i, 600), i, 600);   
        }
        addEnemy();
    }

    public void act(){
        if(bossCoolDown != 0){ //If the cooldown is not 0, it will not spawn a boss
            bossCoolDown--;   
        }
        //If there are no enemies left in the game world, it will start a new wave
        if(getObjects(EnemyLarge.class).size() ==0){ 
            wave.add(1);
            addEnemy(); 
            addBuilding(); //Resets the health of the buildings
            lives.add(2); //Players gets 2 additional lives
            playerLives +=2;
        }
        boolean changeDir = false;
        if(timer > 0){ //If the timer is not 0, the enemies will not move
            timer--;   
        } 
        for(int i =0; i < getObjects(EnemyLarge.class).size(); i++){
            EnemyLarge enemy = getObjects(EnemyLarge.class).get(i);
            //If the enemy location touches the walls, it will drop and change direction
            if(enemy.getX() + 1 < borderLeft && enemy.getDir() == -1|| enemy.getX() + 1 > borderRight && 
            enemy.getDir() == 1){
                changeDir = true;
            }
            if(enemy.isTouchingProjectile()){
                if(enemy instanceof EnemySmall){
                    score.add(30); //Score will be added when the player shoots the enemy
                    scoreTotal += 30;
                }
                else if(enemy instanceof EnemyMedium){
                    score.add(20);  
                    scoreTotal += 20;
                }
                else{
                    score.add(10);
                    scoreTotal += 10;
                }
                enemyX = enemy.getX(); //Will get the x and y coordinates of the enemy that has been shot
                enemyY = enemy.getY();
                hit.play(); //play the sound effect
                removeObject(enemy); 
                addObject(new enemyHit(), enemyX, enemyY); //adds the hitmarker
            }
        }
        if(timer == 0 && (!changeDir)){ //If the timer is 0, enemies can move
            move();
            timer = 12; //Timer is reset
        }
        if(changeDir){
            dropRow();
            timer = 12;
        }
        addBoss();
        
        if(getObjects(Player.class).size() !=0){ //If there is a player class in the world, it will go through the act method
            playerCheck = true;
        }

        if(playerCheck){
            Player player = getObjects(Player.class).get(0);
            if(player.isTouchingEprojectile()){
                if(playerLives == 0){
                    player.reset(); 
                    Greenfoot.setWorld(new GameOver()); 
                }
                else{
                    player.reset(); //will add the player hit image
                    playerLives--; //remove a life if the player has been shot
                    lives.add(-1);
                    playerCheck = false; //It will not go through the act method to prevent any errors
                }

            }
            for(int i =0; i < getObjects(Building.class).size(); i++){
                Building building = getObjects(Building.class).get(i);
                int check = building.getCurrentHp();
                if(check <=0){ //if the hp of the building is less than or equal to 0, the game will end
                    removeObject(building);
                    Greenfoot.setWorld(new GameOver());
                }
            }
           
            
        }
    }


    public void dropRow(){
        for(int i =0; i < getObjects(EnemyLarge.class).size(); i++) {
            EnemyLarge enemy = getObjects(EnemyLarge.class).get(i);
            enemy.setLocation(enemy.getX(), enemy.getY() + 20); //drop all the enemies in the world
            enemy.changeDir(); //Will change the direction
            if(enemy.getRow() == 5){ //Due to the enemies on the 5th row being smaller, it will get a small headstart to prevent the enemies from spreading apart
                enemy.setLocation(enemy.getX() + 20 * enemy.getDir(), enemy.getY()); 
            }
            if(enemy.getY() >= 550){
                Greenfoot.setWorld(new GameOver()); 
            }
        }
    }

    public void moveRow(int row){ 
        for(int i =0; i < getObjects(EnemyLarge.class).size(); i++) { 
            EnemyLarge enemy = getObjects(EnemyLarge.class).get(i);
            if(enemy.getRow() == row){ //Move the enemies from the same row at the same time
                enemy.setLocation(enemy.getX() + 8 * enemy.getDir(), enemy.getY());
            }
        }
    }

    public void move(){
        moveRow(rowNumber);
        rowNumber--; //it will go through each row
        if(rowNumber < 0){
            rowNumber = 5; //Once everyone has been moved, it will reset to the 5th row
        }

    }

    public void addEnemy(){ //adds the enemies onto the world
        for(int i = 50; i <=540; i+=60){
            addObject(new EnemyLarge(1, true), i, 350); 
            addObject(new EnemyLarge(2, true), i, 300);
            addObject(new EnemyMedium(3, true), i, 250);
            addObject(new EnemyMedium(4, true), i, 200);
            addObject(new EnemySmall(5, true), i, 150);
        } 
    }

    public void addBuilding(){ //removes existing buildings and adds new buildings
        for(int i =0; i < getObjects(Building.class).size(); i++){
            Building building = getObjects(Building.class).get(i);
            removeObject(building);
        }
        for(int i = 85; i <= 616; i+=177){
            addObject(new Building(this, i, 600), i, 600);   
        }   
    }
    public void addBoss(){
            if(bossCoolDown == 0){ 
                    addObject(new Boss(true), 43, 88);
                    bossCoolDown = 10000;
            }   
    }
    private static int randomInt(int maximum, int minimum){ //This method is called when a random integer is needed and the parameters are the range from what the integer can be
        return ((int)(Math.random() * (maximum - minimum))) + minimum; //Code courtesy of Java67.com    
    }
    
    public void increaseScore(int newScore){
     scoreTotal += newScore;
     score.add(newScore);
    }

}

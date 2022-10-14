/*
 * Nick Shum Space Invaders
 * 
 * Features:
 * - Player that moves along the x-axis
 * - Different types of enemies that can shoot
 * - Buildings with health bars; can be used to take cover
 * - Point system
 * - Mystery UFO that can give random points
 * - Instructions world
 * 
 * Credits
 * - Counter Class: courtesy of Greenfoot
 * - Label Class: courtesy of Greenfoot 
 * - SmoothMover: courtesy of Greenfoot
 * - StatBar: courtesy of Mr. Cohen
 * - Player sound code from Mr. Cohen
 * - All images were inspired from the Space Invaders game
 * - randomInt method by Java67.com
 * - isTouching method from greenfoot.org
 * - moveRow concept from greenfoot.org
 * - All sounds from classicgaming.cc/classics/space-invaders/sounds\
 * - Counter modified with the help of greenfoot.org
 * 
 */




import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WelcomeWorld extends World
{
    private static Color white = new Color(0, 0, 0);
    private GreenfootImage background;
    
    private Button start;
    private Button instructions;
    public WelcomeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1);
        setBackground(new GreenfootImage ("background.png"));
       
        Label space = new Label("SPACE INVADERS", 40);
        addObject(space, 300, 275);
        
        start = new Button ("Play");
        addObject(start, 300, 225);
        
        instructions = new Button("INSTRUCTIONS");
        addObject(instructions, 300, 760);
        
        Label score = new Label("SCORE ADVANCE TABLE", 35);
        addObject(score, 300, 375);
        
        addObject(new EnemySmall(1, false), 230, 470);
        addObject(new EnemyMedium(1, false), 234, 530);
        addObject(new EnemyLarge(1, false), 230, 590);
        addObject(new Boss(false), 230, 425);
        
        Label boss = new Label("=? MYSTERY", 35);
        addObject(boss, 355, 425);
        
        Label small = new Label("= 30 POINTS", 35);
        addObject(small, 350, 470);
        
        Label medium = new Label("= 20 POINTS", 35);
        addObject(medium, 350, 530);
        
        Label large = new Label("= 10 POINTS", 35);
        addObject(large, 350, 590);
     }
     
    public void act (){
         checkMouse(); //Will check if the user wants to start the game or go to the instruction world
         checkKeys();
      }
      
    private void checkMouse(){
          if(Greenfoot.mouseClicked(start)){
             Greenfoot.setWorld(new GameWorld()); 
            }
          if(Greenfoot.mouseClicked(instructions)){
              Greenfoot.setWorld(new InstructionWorld());
            }
              
      }
    private void checkKeys(){
     if(Greenfoot.isKeyDown("enter")){
         Greenfoot.setWorld(new GameWorld());
        }
    }
 }


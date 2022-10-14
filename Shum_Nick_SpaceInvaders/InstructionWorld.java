import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InstructionWorld extends World
{
    private GreenfootImage background;
    
    private Button goBack;
    public InstructionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1);
        setBackground(new GreenfootImage ("background.png"));
        
        Label instruct = new Label("INSTRUCTIONS", 40);
        addObject(instruct, 300, 200);
        
        Label space = new Label("SPACE = SHOOT", 35);
        addObject(space, 300, 275);
        
        Label d = new Label("D = MOVE LEFT", 35);
        addObject(d, 300, 325);
        
        Label a = new Label("A = MOVE RIGHT", 35);
        addObject(a, 300, 375);
        goBack = new Button("GO BACK");
        addObject(goBack, 300, 500);
        addObject(new Player(), 300, 700);
    }
    
    public void act(){
          if(Greenfoot.mouseClicked(goBack)){
              Greenfoot.setWorld(new WelcomeWorld());
            } 
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1help extends World
{
   // private static final int GAME_SPEED = 50; 
   // private GreenfootSound backgroundMusic;  
    //private GifImage gif = new GifImage("blackback.gif");
    private ButtonPlay buttonPlay;
    private ButtonHelp buttonHelp;
    private PlayCommand playCmd;
    private HelpCommand helpCmd;
    protected GreenfootSound clicSound;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Level1help()  
    {    
        super(1130, 720, 1); 
       // backgroundMusic = new GreenfootSound("1.mp3");
        buttonPlay = new ButtonPlay();
        buttonHelp = new ButtonHelp();
        playCmd = new PlayCommand();
        helpCmd = new HelpCommand();
        prepare();
    }
    
    public void act()
    {
       //setBackground(gif.getCurrentImage());
       //backgroundMusic.playLoop();
       //setBackground(new GreenfootImage("nextlevel.jpg"));
        //if(Greenfoot.mouseClicked(buttonPlay) && backgroundMusic.isPlaying())
           // backgroundMusic.stop();
    }
    
    /**
     * Place the buttons in the world
     */
    public void prepare()
    {
        addObject(buttonPlay, 600, 400);
        addObject(buttonHelp, 600, 480);        
        buttonPlay.setCommand(playCmd);
        buttonHelp.setCommand(helpCmd);
        
        playCmd.setReceiver(
      
            new Receiver()
            {
                public void performAction()
                {
                    if(Greenfoot.mouseClicked(buttonPlay)){
                        //clicSound.play();
                        Greenfoot.setWorld(new Level1());
                    }
            }
           });
           
        helpCmd.setReceiver(
        new Receiver()
            {
                public void performAction()
                {
                        if(Greenfoot.mouseClicked(buttonHelp)){
                                //clicSound.play();
                                Help help = buttonHelp.getHelp();
                                addObject(help, getWidth()/2, getHeight()/2);
                                        
                                addObject(new Back(help), 
                                                help.getX() - help.getImage().getWidth()/2,
                                                help.getY() - help.getImage().getHeight()/2);
                                
                            }
                }
           }
        );
    }
}

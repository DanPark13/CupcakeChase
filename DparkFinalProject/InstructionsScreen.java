import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is all the code for the Instructions Screen.
 * It tells the user what to do in this game.
 * 
 * @Daniel Park 
 * @1.0
 */
public class InstructionsScreen extends World
{
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public InstructionsScreen()
    {    
        super(1000, 600, 1); 
        started();
        prepare();
    }

    /**
     * Shows all the text that will be on the Instructions Screen
     **/
    public void prepare(){
        showText("Welcome to 'Don't Get Caught by Your Wife!'",500,125);
        showText("You are a husband suffering from food cravings",500,250);
        showText("Your wife is trying to help you, but you want to eat so badly",500,300);
        showText("So your objective is to eat as 30 cupcakes before a minute to Win!",500,350);
        showText("Don't get caught by your wife, or else you'll lose",500,400);
        showText("Use your arrow keys to move around to get cupcakes and stay away from your wife",500,450);
        showText("Are you ready? Just press Enter to begin!",500,500);
    }
    
    /**
     * Changes screen between the Insturctions Screen and the second Instructions Screen
     **/
    public void act(){
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new InstructionsScreen2());
        }
    }
}
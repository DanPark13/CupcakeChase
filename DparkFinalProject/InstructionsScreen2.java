import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The InstructionsScreen2 is the instructions concerning the Kid
 * 
 * @Daniel Park
 * @version (a version number or a date)
 */
public class InstructionsScreen2 extends World
{
    /**
     * Constructor for objects of class InstructionsScreen2.
     * 
     */
    public InstructionsScreen2()
    {    
        super(1000, 600, 1); 
        prepare();
    }

    /**
     * Shows all the text that will be on the Instructions Screen
     */
    public void prepare(){
        showText("OH WAIT!",500,100);
        showText("Since you are a parent, you know you have kids... right?",500,150);
        showText("Three to be exact!",500,200);
        showText("Those annoying little creatures that live on sweets...",500,250);
        showText("Well they're here and they're ready to gobble up your sweets!",500,300);
        showText("When you eat 15 cupcakes, they're going to eat ALL YOUR CUPCAKES!",500,350);
        showText("Also, they're going to KILL you if they found you eating their cupcakes...",500,400);
        showText("SOOOOO Are you ready now? Just press the space bar this time to begin!",500,500);
    }

    /**
     * Changes screen between the InsturctionsScreen2 and the Game Screen
     **/
    public void act(){
        if (Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new GameWorld());
        }
    }
}

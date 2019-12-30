import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Transparency;

/**
 * The main screen of the game. This is where the gameplay happens.
 * 
 * @Daniel Park 
 * @1.0
 */
public class GameWorld extends World
{
    static Counter counter = new Counter();
    Counter counter2 = new Counter();
    
    SimpleTimer st = new SimpleTimer();
    /**
     * Constructor for objects of class MyWorld.
     */
    public GameWorld()
    {    
        super(1000,800,1);
        
        started();
        
        Husband h1 = new Husband();
        addObject(h1,500,400);
        
        counter.setValue(0);
        st.mark();
        prepare();
    }
    
    /**
     * Tells the cupcakes to generate at random times and random places along the top
     */
    public void act(){
        if(Greenfoot.getRandomNumber(200)<3){
            addObject(new Cupcake(),Greenfoot.getRandomNumber(1000),0);
            
            counter2.setValue(st.millisElapsed()/1000);
        }
        timeLeft();
    }
    
    /**
     * Constructs everything that is not cupcakes and the Husband 
     */
    private void prepare(){
        Wife wife = new Wife();
        addObject(wife,550,40);
        showText("Cupcakes Eaten",100,16);

        addObject(counter,63,36);
        showText("Your Time",300,16);

        addObject(counter2, 548, 382);

        counter2.setLocation(151,43);
        counter.setLocation(63,42);
        counter2.setLocation(157,43);
        counter2.setLocation(157,43);
        wife.setLocation(852,297);
        wife.setLocation(714,311);
        counter2.setLocation(301,46);
        counter.setLocation(98,44);
        wife.setLocation(158,305);
        wife.setLocation(110,255);
        wife.setLocation(96,202);
        Kid kid2 = new Kid();
        addObject(kid2,664,180);
        Kid kid3 = new Kid();
        addObject(kid3,304,467);
        kid2.setLocation(619,136);
        Kid kid = new Kid();
        addObject(kid,784,409);
    }
    
    /**W
     * Displays how much time is left before the game is over
     */
    public void timeLeft(){
        if(counter2.getValue()>=30){
            showText("Thirty Seconds Left!", 500, 500);
        }
        
        if(counter2.getValue()>=45){
            showText("Fifteen Seconds Left!", 500, 500);
        }
        
        if(counter2.getValue()>=60){
            showText("Time is Up! You Lose!", 500, 500);
            stopped();
            Greenfoot.playSound("youlose.wav");
            Greenfoot.stop();
        }
    }
}

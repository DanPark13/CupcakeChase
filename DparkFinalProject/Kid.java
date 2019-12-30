import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static greenfoot.Greenfoot.*;
import java.util.List;
import java.util.ListIterator;

/**
 * This is all the code for the Kid classs.
 * 
 * @Daniel Park
 * @1.0
 */
public class Kid extends Actor
{
    static GreenfootSound backgroundMusic;
    /**
     * Act - do whatever the Kid wants to do. Like all kids.
     * They don't care
     */
    public void act() 
    {
        move(Greenfoot.getRandomNumber(10));
        if(atWorldEdge()){
            turn(getRandomNumber(360));
        }
        eat();
        losingTerms3();
    }    
    
    /**
     * When the Kid class hits the edge of the world, it will turn in a random direction
     */
    public boolean atWorldEdge(){
        if(getY()<20 || getWorld().getHeight() - getY() <20){
            return true;
        }

        if(getX()<20 || getWorld().getWidth() - getX()<20){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void stopped()
    {
        backgroundMusic.pause();
    }
 
    public void started()
    {
        backgroundMusic.playLoop();
    }
    
    /**
     * When Kid meets with a cupcake, he will eat the cupcake
     */
    public void eat(){
        Actor a = getOneIntersectingObject(Cupcake.class);   
        if(a!=null){
            GameWorld.counter.add(1);
            Greenfoot.playSound("eating.wav");
            getWorld().removeObject(a);
        }
    }
    
    /**
     * Third situation where Husband can lose
     */
    public void losingTerms3(){
        if(isTouching(Husband.class)){
            removeTouching(Husband.class);
            GreenfootImage g1 = new GreenfootImage("Your Kids Got You! You're a loser!",60, Color.RED, Color.BLACK);
            setImage(g1);
            setLocation(500,300);
            setRotation(0);
            
            stopped();
            Greenfoot.playSound("ohboy.wav");
            Greenfoot.stop();
        }
    }
}

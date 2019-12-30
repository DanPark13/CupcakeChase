/**
 * Clicked arrow keys will direct the Husband around the screen
 * Collect cupcakes and stay away from his Wife(.class)
 */
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static greenfoot.Greenfoot.*;
import java.util.List;
import java.util.ListIterator;

/**
 * This is all the code for the Wife class. I am very proud of this class.
 * 
 * @Daniel Park 
 * @1.0
 */
public class Wife extends Actor
{
    /**
     * Act - do whatever the Wife wants to do. This method controls the Wife's movement and contains all the methods
     * to make it work
     */

    public void act() 
    { 
        move(Greenfoot.getRandomNumber(5));
        if(atWorldEdge()){
            turn(getRandomNumber(360));
        }
        losingTerms1();
        locateClosest();
    }   

    /**
     * When the Wife class hits the edge of the world, it will turn in a random direction
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

    /**
     * Calculates the distance between the Wife and the Husband in order for the Wife class
     * to track down the Husband class
     */
    public double distance(Actor a){
        int x = getX();
        int y = getY();

        int dx = x - a.getX();
        int dy = y - a.getY();

        return Math.sqrt(dx*dx + dy*dy);
    }

    /**
     * Tells the Wife class to chase the husband class
     */
    public void locateClosest(){
        double distance;
        Husband closest;

        World w = getWorld();
        List<Husband> yourHusband = w.getObjects(Husband.class);
        ListIterator<Husband> iter = yourHusband.listIterator();

        if(yourHusband.isEmpty()){
            return;
        }

        Husband current = iter.next();
        distance = distance(current);
        closest = current;
        while(iter.hasNext()){
            current = iter.next();
            double cDist = distance(current);
            if (cDist < distance){
                distance = cDist;
                closest = current;
            }
        }
        turnTowards(closest.getX(), closest.getY());
    }

    /**
     * What happens when the Wife catches the Husband (Oh no)
     */
    public void losingTerms1(){
        if(isTouching(Husband.class)){
            removeTouching(Husband.class);

            GreenfootImage g1 = new GreenfootImage("Your Wife got You! You're a loser!",60, Color.RED, Color.BLACK);

            setImage(g1);
            setLocation(500,300);
            setRotation(0);
            Greenfoot.playSound("ohboy.wav");
            Greenfoot.stop();
        }
    }
}

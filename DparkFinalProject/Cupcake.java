import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is for the cupcake that the Husband eats to win the game
 * 
 * @Daniel Park 
 * @1.0
 */
public class Cupcake extends Actor
{
    /**
     * Tells the cupcake to create at certain heights and disappear at other heights
     */
    public void act() 
    {
        setLocation(getX(),getY()+2);
        if(getWorld().getHeight()-getY()<20){
            getWorld().removeObject(this);
        }
    }    
}

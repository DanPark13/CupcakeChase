import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class controls the character that the protagonist controls (the Husband)
 * 
 * @Daniel Park 
 * @1.0
 */
public class Husband extends Actor
{
    /**
     * Act - do whatever the Husband wants to do
     */
    public void act() 
    {
        moveAround();
        eat();
        winningTerms();
    }    
    
    /**
     * Clicked arrow keys will direct the Husband around the screen
     * Collect cupcakes and stay away from his Wife(.class)
     */
    public void moveAround(){
        if(Greenfoot.isKeyDown("right")){
            move(5);
        }
        
        if(Greenfoot.isKeyDown("left")){
            move(-5);
        }
        
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-5);
        }
        
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+5);
        }
    }
    
    /**
     * When Husband meets with a cupcake, he will eat the cupcake
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
     * When Husband eats 30 cupcakes, the game will say congratulations and the game will end
     */
    public void winningTerms(){
        if(GameWorld.counter.getValue()>=30){
            GreenfootImage g1 = new GreenfootImage("Congratulations! You Won!", 50, Color.RED, Color.BLACK);
            setImage(g1);
            setLocation(500,400);
            setRotation(0);
            Greenfoot.playSound("youwon!.mp3");
            Greenfoot.stop();
        }
    }
}

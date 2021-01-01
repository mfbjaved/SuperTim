import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    boolean isActive = true;
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
       // checkGrab();
    }    
    
    public void checkGrab()
    {
       Actor player;
       player = getOneIntersectingObject(Tim.class);
       
       if(player != null)
       {
           ((ScrollWorld)getWorld()).updateCoinBoard();
       }
    }
}

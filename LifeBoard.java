import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifeBoard extends Actor
{
    GreenfootImage lifeBoard;
    int numberOfLife;
    String label;
    int fontsize;
    int totalLife;
    Color foreground;
    Color background;
    
    public LifeBoard(String l, int fs ,Color fg, Color bg)
    {
       // totalLife = l;
        label = l;
        fontsize = fs;
        foreground = fg;
        background = bg;
        //numberOfLife = "";
        lifeBoard = new GreenfootImage(label, fontsize, foreground, background);
        
        setImage(lifeBoard);
    }
    
    public void setText(String l)
    {
       label = l;
        //numberOfLife =  numberOfLife - c;
       numberOfLife--;
        // assign value to parameter
       
       //Erase the Board
       lifeBoard.clear();
       //upadate board
       lifeBoard = new GreenfootImage(label, fontsize, foreground, background);
       
       setImage(lifeBoard);
    }
    public void checkLife()
    {
        if (numberOfLife == 0)
        {
            setImage("gameover.jpg");
        }
    }
    /**
     * Act - do whatever the Board wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}

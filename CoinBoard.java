import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class CoinBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinBoard extends Actor
{
    GreenfootImage coinBoard;
    //String numberOfCoins = "0;
    String label;
    int fontsize;
    Color foreground;
    Color background;
    public CoinBoard(String l, int fs ,Color fg, Color bg)
    {
        label = l;
        fontsize = fs;
        foreground = fg;
        background = bg;
        
        coinBoard = new GreenfootImage(label, fontsize, foreground, background);
        
        setImage(coinBoard);
    }
    
    public void setText(String l)
    {
     
        // assign value to parameter
       //numberOfCoins = numberOfCoins + c;
       
       label = l;
       //Erase the Board
       coinBoard.clear();
       //upadate board
       coinBoard = new GreenfootImage(label, fontsize, foreground, background);
       
       setImage(coinBoard);
    }
    
}

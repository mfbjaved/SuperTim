
import greenfoot.World;
import greenfoot.GreenfootImage;

/**
 * CLASS: Scroll
 * AUTHOR: danpost
 * VERSION: March 9, 2015
 * 
 * This support class controls the background image of the world provided;
 * the size of the image supplied determines the scrolling area.
 * 
 * In your world class, create an instance of this class supplying the background image of the
 * scrolling area and also the world itself and keep a reference to the Scroll object created in
 * the world.  Then you can use one of the 'changeScroll' methods below to control the scrolling
 * of the background of your active world.
 */
public class Scroll
{
    private int offX, offY; // the scrolling offsets
    private World w; // the world whose background will scroll
    private GreenfootImage bg; // the image for the scrolling background
    
    /** creates a new Scroll objecct */
    public Scroll(GreenfootImage bgImg, World world)
    {
        // save parameter values
        bg = bgImg;
        w = world;
        // set initial background of view world
        //changeScroll(0, 0);
    }
    
    /** use for horizontal scrolling only; returns the change in scroll value */
    public int changeScrollX(int dScroll)
    {
        if (offX+dScroll >  bg.getWidth()-w.getWidth()) dScroll = bg.getWidth()-w.getWidth()-offX;
        if (offX+dScroll < 0) dScroll = -offX;
        offX += dScroll;
        w.getBackground().drawImage(bg, -offX, 0);
        return dScroll;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skeleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skeleton extends Actor
{
    int speed;//add a speed variable
    boolean makingContact;
    
    int imageCounter;//add an image counter
    int leftFrame;
    int rightFrame;
    int frameDelay;//add a delay for the images
    
    int direction;//variable for direction
    int directionMax;//set a max 
    
    //image walk variables
    //right
    GreenfootImage skeletonRight1;
    GreenfootImage skeletonRight2;
    GreenfootImage skeletonRight3;
    GreenfootImage skeletonRight4;
    GreenfootImage skeletonRight5;
    GreenfootImage skeletonRight6;
    GreenfootImage skeletonRight7;
    GreenfootImage skeletonRight8;
    GreenfootImage skeletonRight9;

    //left
    GreenfootImage skeletonLeft1;
    GreenfootImage skeletonLeft2;
    GreenfootImage skeletonLeft3;
    GreenfootImage skeletonLeft4;
    GreenfootImage skeletonLeft5;
    GreenfootImage skeletonLeft6;
    GreenfootImage skeletonLeft7;
    GreenfootImage skeletonLeft8;
    GreenfootImage skeletonLeft9;

    public Skeleton()
    {
        imageCounter = 0;
        leftFrame = 1;
        rightFrame = 1;
        frameDelay = 5;
        
        speed = 1;

        direction = 0;
        directionMax = 100;

        skeletonRight1 = new GreenfootImage("EnemyRight1.png"); 
        skeletonRight2 = new GreenfootImage("EnemyRight2.png");
        skeletonRight3 = new GreenfootImage("EnemyRight3.png");
        skeletonRight4 = new GreenfootImage("EnemyRight4.png");
        skeletonRight5 = new GreenfootImage("EnemyRight5.png");
        skeletonRight6 = new GreenfootImage("EnemyRight5.png");
        skeletonRight7 = new GreenfootImage("EnemyRight7.png");
        skeletonRight8 = new GreenfootImage("EnemyRight8.png");
        skeletonRight9 = new GreenfootImage("EnemyRight9.png");

        skeletonLeft1 = new GreenfootImage("EnemyLeft1.png");
        skeletonLeft2 = new GreenfootImage("EnemyLeft2.png");
        skeletonLeft3 = new GreenfootImage("EnemyLeft3.png");
        skeletonLeft4 = new GreenfootImage("EnemyLeft4.png");
        skeletonLeft5 = new GreenfootImage("EnemyLeft5.png");
        skeletonLeft6 = new GreenfootImage("EnemyLeft6.png");
        skeletonLeft7 = new GreenfootImage("EnemyLeft7.png");
        skeletonLeft8 = new GreenfootImage("EnemyLeft8.png");
        skeletonLeft9 = new GreenfootImage("EnemyLeft9.png");
    }

    /**
     * Act - do whatever the Skeleton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        changeDirection();
        resetDirection();
        checkResetImageCounter();
    }
    
    public void changeDirection()
    {
        direction++;//add one to direction
        //if direction is less than 50 make him walk towards the right
        if(direction <= 50)
        {
            changeImageRight();
            move(speed);
        }
        //if direction is more than 50 make him walk back towards the left
        if(direction > 50)
        {
            changeImageLeft();
            move(speed* -1);
        }
    }
    
    //reset the direction counter
    public void resetDirection()
    {
        if(direction == directionMax)
        {
            direction = 0;
        }
    }
    
    //change left frames
    public void changeImageLeft()
    {
        imageCounter = imageCounter + 1;//add one to image counter

        if(imageCounter % frameDelay == 0 )
        {
            if(leftFrame == 1)
            {
                setImage(skeletonLeft1);
                leftFrame = 2;
            }

            else if(leftFrame == 2)
            {
                setImage(skeletonLeft2);
                leftFrame = 3;
            }

            else if(leftFrame == 3)
            {
                setImage(skeletonLeft3);
                leftFrame = 4;
            }

            else if(leftFrame == 4)
            {
                setImage(skeletonLeft4);
                leftFrame = 5;
            }

            else if(leftFrame == 5)
            {
                setImage(skeletonLeft5);
                leftFrame = 6;
            }

            else if(leftFrame == 6)
            {
                setImage(skeletonLeft6);
                leftFrame = 7;
            }

            else if(leftFrame == 7)
            {
                setImage(skeletonLeft7);
                leftFrame = 8;
            }

            else if(leftFrame == 8)
            {
                setImage(skeletonLeft8);
                leftFrame = 9;
            }
            else if(leftFrame == 9)
            {
                setImage(skeletonLeft9);
                leftFrame = 1;
            }
        }
    }
    
    //change right frames
    public void changeImageRight()
    {
        imageCounter = imageCounter + 1;//add one to image counter

        if(imageCounter % frameDelay == 0 )
        {
            if(rightFrame == 1)
            {
                setImage(skeletonRight1);
                rightFrame = 2;
            }

            else if(rightFrame == 2)
            {
                setImage(skeletonRight2);
                rightFrame = 3;
            }

            else if(rightFrame == 3)
            {
                setImage(skeletonRight3);
                rightFrame = 4;
            }

            else if(rightFrame == 4)
            {
                setImage(skeletonRight4);
                rightFrame = 5;
            }

            else if(rightFrame == 5)
            {
                setImage(skeletonRight5);
                rightFrame = 6;
            }

            else if(rightFrame == 6)
            {
                setImage(skeletonRight6);
                rightFrame = 7;
            }

            else if(rightFrame == 7)
            {
                setImage(skeletonRight7);
                rightFrame = 8;
            }

            else if(rightFrame == 8)
            {
                setImage(skeletonRight8);
                rightFrame = 9;
            }
            else if(rightFrame == 9)
            {
                setImage(skeletonRight9);
                rightFrame = 1;
            }
        }
    }
    
    //reset the image counter
    public void checkResetImageCounter()
    {
        if(imageCounter > 100)
        {
            imageCounter = 1; 
        }
    }
    public void checkGrab()
    {
       Actor player;
       player = getOneIntersectingObject(Tim.class);
       
       if(player != null)
       {
           ((ScrollWorld)getWorld()).updateLifeBoard();
       }
    }
}

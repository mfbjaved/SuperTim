import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tim here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tim extends Actor
{
    int life;
    private int speed;//set moving speed
    boolean isAlive;

    //image variables
    //image counter for changing sprite images
    int imageCounter;
    //frame counterto display current imageto be shown
    int leftFrame;
    int rightFrame;
    //frame delay is used to slow down animation
    int frameDelay;
    int level;
    int groundLevel = 390;
    boolean isOnGround;

    //jumping variables
    private int vSpeed = 0;//set vertical speed
    private int acceleration = 2;//set acceleration for the falling down
    private boolean jumping;//create jumping boolean to set to true or false
    private int jumpStrength = 30;//set jumpStrength for how high the actor should go up
    private int jumpCounter = 0;
    private int jumpCounterMax = 10;
    //private int fallAcceleration = 3;
    //private boolean isJumping = false;

    // passing health and coin board
    static public  int coinTotal ;
    static  public  int lifeTotal ;

    //coin sound variable
    GreenfootSound eatTheCoin;
    GreenfootSound crash;

    //image variable
    //right and left    
    GreenfootImage walking1;
    GreenfootImage walking2;
    GreenfootImage walking3;
    GreenfootImage walking4;
    GreenfootImage walking5;
    GreenfootImage walking6;
    GreenfootImage walking7;
    GreenfootImage walking8;
    GreenfootImage walking9;
    GreenfootImage walking10;
    GreenfootImage walking11;
    GreenfootImage walking12;
    GreenfootImage walking13;
    GreenfootImage walking14;
    GreenfootImage walking15;
    GreenfootImage walking16;
    GreenfootImage walking17;

    //jump images
    //right
    GreenfootImage jumpRight1;
    GreenfootImage jumpRight2;
    GreenfootImage jumpRight3;
    //left
    GreenfootImage jumpLeft1;
    GreenfootImage jumpLeft2;
    GreenfootImage jumpLeft3;

    public Tim()
    {
        life = 5;
        speed = 2;
        isAlive = true;
        imageCounter = 0;
        leftFrame = 1;
        rightFrame = 1;
        frameDelay = 5;
        level = 1;
        isOnGround = false;

        lifeTotal = 5;
        coinTotal = 0;

        eatTheCoin = new GreenfootSound("coin.mp3");
        crash = new GreenfootSound("crash.mp3");

        walking1 = new GreenfootImage("walking1.fw.png");
        walking2 = new GreenfootImage("walking2.fw.png");
        walking3 = new GreenfootImage("walking3.fw.png");
        walking4 = new GreenfootImage("walking4crossesfeet.fw.png");
        walking5 = new GreenfootImage("walking14.fw.png");
        walking6 = new GreenfootImage("walking15.fw.png");
        walking7 = new GreenfootImage("walking16.fw.png");
        walking8 = new GreenfootImage("startcharacterturned.fw.png");
        walking9 = new GreenfootImage("walking17.fw.png");
        walking10 = new GreenfootImage("walking9.fw.png");
        walking11 = new GreenfootImage("walking10.fw.png");
        walking12 = new GreenfootImage("walking11.fw.png");
        walking13 = new GreenfootImage("walking12.fw.png");
        walking14 = new GreenfootImage("walking18.fw.png");
        walking15 = new GreenfootImage("walking19.fw.png");
        walking16 = new GreenfootImage("walking20.fw.png");
        walking17 = new GreenfootImage("walking21.fw.png");

        jumpRight1 = new GreenfootImage("jumpRight1.png");
        jumpRight2 = new GreenfootImage("jumpRight2.png");
        jumpRight3 = new GreenfootImage("jumpRight3.png");

        jumpLeft1 = new GreenfootImage("jumpLeft1.png");
        jumpLeft2 = new GreenfootImage("jumpLeft2.png");
        jumpLeft3 = new GreenfootImage("jumpLeft3.png");
    }

    /**
     * Act - do whatever the Tim wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        checkNextLevel();
        checkKeyPress();
        checkFall();
        eatCoins();
        eatCoinsTwo();
        eatCoinsThree();
        updateLife();
        updateLifeTwo();
        updateLifeThree();
        checkEdgeOfWorld();
        callScreen();
        //addGameOver();

        //fall();
        //checkGround();
        //checkRight();
        //checkLeft();

    }    

    private void checkNextLevel()
    {
        Actor nearDoor;
        //have it detct the door class
        nearDoor = getOneIntersectingObject(Door.class);

        if(nearDoor != null)
        {
            //System.out.println("it works");

            if(level == 1)//if its level one make it go to level two
            {
                level = 2;

                int y = getY();

                getWorld().removeObject(this);

                Greenfoot.setWorld(new WorldTwo(this, y));
            }
            else if(level == 2)//if level 2 make it go to level three
            {
                level = 3;

                int y = getY();

                getWorld().removeObject(this);

                Greenfoot.setWorld(new WorldThree(this, y));
            }
            else if(level == 3)
            {
                GameOver gameover;

                gameover = new GameOver();

                // add the end screen
                getWorld().addObject(gameover, 300, 200); 
            }

        }
    }

    public void checkKeyPress()
    {
        if(Greenfoot.isKeyDown("right"))
        {

            changeImageRight();

            setLocation(getX() + speed, getY());
            checkResetImageCounter();
            //checkPlatformRight();
        }

        if(Greenfoot.isKeyDown("left"))
        {

            changeImageLeft();

            setLocation(getX() - speed, getY());
            checkResetImageCounter();
            //checkPlatformLeft();
        }

        if(Greenfoot.isKeyDown("up") && jumping == false)
        {
            //setLocation(getX(), getY() - speed);
            jump();
        }

        //if(Greenfoot.isKeyDown("down"))
        //{
        // setLocation(getX(), getY() + speed);
        // }
    }

    public void changeImageLeft()
    {
        imageCounter = imageCounter + 1;

        if(imageCounter % frameDelay == 0)
        {
            if(leftFrame == 1)
            {
                setImage(walking5);

                leftFrame = 2;
            }

            else if(leftFrame == 2)
            {
                setImage(walking6);

                leftFrame = 3;
            }

            else if(leftFrame == 3)
            {
                setImage(walking7);
                leftFrame = 4;
            }

            else if(leftFrame == 4)
            {
                setImage(walking9);
                leftFrame = 5;
            }

            else if(leftFrame == 5)
            {
                setImage(walking14);
                leftFrame = 6;
            }

            else if(leftFrame == 6)
            {
                setImage(walking15);
                leftFrame = 7;
            }

            else if(leftFrame == 7)
            {
                setImage(walking16);
                leftFrame = 8;
            }

            else if(leftFrame == 8)
            {
                setImage(walking17);
                leftFrame = 1;
            }
        }
    }

    public void changeImageRight()
    {
        imageCounter = imageCounter + 1;

        if(imageCounter % frameDelay == 0)
        {
            if(rightFrame == 1)
            {
                setImage(walking1);
                rightFrame = 2;
            }

            else if(rightFrame == 2)
            {
                setImage(walking2);
                rightFrame = 3;
            }

            else if(rightFrame == 3)
            {
                setImage(walking3);
                rightFrame = 4;
            }

            else if(rightFrame == 4)
            {
                setImage(walking4);
                rightFrame = 5;
            }

            else if(rightFrame == 5)
            {
                setImage(walking10);
                rightFrame = 6;
            }

            else if(rightFrame == 6)
            {
                setImage(walking11);
                rightFrame = 7;
            }

            else if(rightFrame == 7)
            {
                setImage(walking12);
                rightFrame = 8;
            }

            else if(rightFrame == 8)
            {
                setImage(walking13);
                rightFrame = 1;
            }
        }
    }

    public void checkResetImageCounter()
    {
        if(imageCounter > 100)
        {
            imageCounter = 1; 
        }
    }

    public void eatCoins()
    {
        Actor nearCoin;

        nearCoin = getOneIntersectingObject(Coin.class);

        if(nearCoin != null && level == 1)
        {
            eatTheCoin.stop();
            eatTheCoin.play();

            coinTotal++;  // Moved coinTotal++ before next line

            ((ScrollWorld)getWorld()).updateCoinBoard();

            getWorld().removeObject(nearCoin);
        }
    }

    public void eatCoinsTwo()
    {
        Actor nearCoin;

        nearCoin = getOneIntersectingObject(Coin.class);

        if(nearCoin != null && level == 2)
        {
            eatTheCoin.stop();
            eatTheCoin.play();
            coinTotal++;

            ((WorldTwo)getWorld()).updateCoinBoard();

            getWorld().removeObject(nearCoin);
        }
    }

    public void eatCoinsThree()
    {
        Actor nearCoin;

        nearCoin = getOneIntersectingObject(Coin.class);

        if(nearCoin != null && level == 3)
        {
            eatTheCoin.stop();
            eatTheCoin.play();
            coinTotal++;

            ((WorldThree)getWorld()).updateCoinBoard();

            getWorld().removeObject(nearCoin);
        }
    }

    public void checkEdgeOfWorld()
    {
        if(getX()>595)
        {
            setLocation(595,getY());
        }

        if(getX() < 5)
        {
            setLocation(5, getY()); 
        }
    }

    //check the fall of the actor
    public void fall()
    {
        //falling back down
        setLocation(getX(), getY()+vSpeed);
        //makes the actor fall faster
        if(vSpeed <=9)
        {
            vSpeed = vSpeed + acceleration;
        }
        //no jump
        jumping = true;
    }

    //checking the ground
    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int lookForGround = (int) (spriteHeight/2) + 5;

        Actor ground = getOneObjectAtOffset(0, lookForGround, Ground.class);

        //check the ground, no jump, returns jump to false to allow jumping
        if(ground == null)
        {
            jumping = true;
            return false;
        }
        //keeps actor from falling through the ground
        else
        {
            moveToGround(ground);
            return true;
        }

    }

    //keeps the actor on the ground 
    public void moveToGround(Actor ground)
    {
        //collects the height from the ground
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        //sets the location to keep the actor on top of the ground
        setLocation(getX(), newY);
        jumping = false;
    }

    //to check if the actor is touching the ground
    public void checkFall()
    {
        //on ground, no vspeed
        if(onGround())
        {
            vSpeed = 0;
        }
        else
        {
            //vSpeed = vSpeed + fallAcceleration;

            fall();
        }

    }

    //starting for jump
    public void jump()
    {
        //setting height for jump
        vSpeed = vSpeed - jumpStrength;
        //making jump ture to jump
        jumping = true;
        //fall backg down to the ground
        fall();
    }

    public void updateLife()
    {
        Actor nearSkeleton;

        nearSkeleton = getOneIntersectingObject(Skeleton.class);

        if(nearSkeleton != null && level == 1)
        {
            lifeTotal--;  // Was reversed
            ((ScrollWorld)getWorld()).updateLifeBoard();

            crash.stop();
            crash.play();
            life--;
            getWorld().removeObject(nearSkeleton);
        }

    }

    public void updateLifeTwo()
    {
        Actor nearSkeleton;

        nearSkeleton = getOneIntersectingObject(Skeleton.class);

        if(nearSkeleton != null && level == 2)
        {
            lifeTotal--;
            ((WorldTwo)getWorld()).updateLifeBoard();

            crash.stop();
            crash.play();
            life--;
            getWorld().removeObject(nearSkeleton);
        }

    }

    public void updateLifeThree()
    {
        Actor nearSkeleton;

        nearSkeleton = getOneIntersectingObject(Skeleton.class);

        if(nearSkeleton != null && level == 3)
        {
            lifeTotal--;

            ((WorldThree)getWorld()).updateLifeBoard();

            crash.stop();
            crash.play();
            life--;
            getWorld().removeObject(nearSkeleton);
        }

    }

    public void callScreen()
    {
        if(life == 0)
        {// create the end screen instance

            GameOver gameover;
      

            gameover = new GameOver();

            // add the end screen
            getWorld().addObject(gameover, 300, 200); 
            //getWorld().removeObject(Tim);
          

        }
    }

    /*
    public void moveJump()
    {
    isJumping = true;
    jumpCounter++;

    if(jumpCounter < jumpCounterMax)
    {
    vSpeed = jumpStrength;

    //checkPlatformAbove();
    //checkPlatformRight();
    //checkPlatformLeft();

    //setLocation(getX(), getY() + vSpeed);
    //setLocation(getX() + speed, getY() + vSpeed);
    }
    else
    {
    jumping = false;
    jumpCounter = 0;
    vSpeed = 0;
    }
    }

    public boolean getOnPlatform()
    {
    int yOffset;

    yOffset = 50;

    Actor below = getOneObjectAtOffset(0, yOffset, Barriers.class);

    if(below != null)
    {
    int y;
    int platformAdjustment;
    int timAdjustment;
    int totalAdjustment;

    platformAdjustment = below.getImage().getHeight()/2;
    timAdjustment = getImage().getHeight()/2;
    totalAdjustment = platformAdjustment + timAdjustment;

    y = below.getY() - totalAdjustment;

    setLocation(getX(), y);

    return true;
    }

    return false;

    }

    public boolean getOnGround()
    {
    if(getY() > groundLevel)
    {
    int y;
    y = getY() - (getY()- groundLevel) + 1;
    setLocation(getX(), y);
    speed = 2;
    return true;
    }
    return false;
    }

    public void checkPlatformAbove()
    {
    if(getUnderPlatform())
    {
    vSpeed = 0;
    }
    }

    public boolean getUnderPlatform()
    {
    Actor below = getOneObjectAtOffset(0, -40, Barriers.class);
    if(below != null)
    {
    return true;
    }

    return false;
    }

    public void checkPlatformLeft()
    {
    if(getLeftPlatform())
    {
    speed = 0;

    }

    getOnGround();
    }

    public boolean getLeftPlatform()
    {
    Actor left = getOneObjectAtOffset(-20,90,Barriers.class);
    if(left != null)
    {
    return true;
    }

    return false;
    }

    public void checkPlatformRight()
    {
    if(getRightPlatform())
    {
    speed = 0;
    }

    getOnGround();
    }

    public boolean getRightPlatform()
    {
    Actor right = getOneObjectAtOffset(20, 0, Barriers.class);

    if(right != null)
    {
    return true;
    }

    return false;
    }*/
}

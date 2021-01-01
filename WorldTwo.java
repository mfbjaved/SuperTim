import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldTwo extends World
{
      //import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


    /** ******************   ADD FIELD   ******************  */
    Scroll scroll; // you need this line here
    /** ***************************************************  */
    Tim tim; // you should have a reference to your main actor here
    Ground ground;
    Door door;
    //Platform platform;
    int coin;
    int skeleton;
    
    // board variables
    CoinBoard coinBoard;
    String coinBoardLabel;
    LifeBoard lifeBoard;
    String lifeBoardLabel;

    int totalCoins;
    int totalLife;
    /**
     * Constructor for objects of class WorldTwo.
     * 
     */
    public WorldTwo(Tim t, int y)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        tim = t;
        
        // Apply Tim's properties to world variables
        totalCoins = Tim.coinTotal;
        totalLife = Tim.lifeTotal;
        addObject(tim, 5, y);
        
              
        GreenfootImage bgImage = getScrollBg(); // create the GreenfootImage for your background here
        /** *******************   ASSIGN FIELD   ******************** */
        scroll  = new Scroll(bgImage, this); // create your Scroll world object
        /** ********************************************************* */
        //tim = new Tim(); // create the main actor
        //addObject(tim, 25, 330); 
        
        ground = new Ground();
        addObject(ground,1250,375);
        
        door = new Door();
        addObject(door, 1900, 174);
        //platform = new Platform();
        //addObject(platform, 333, 305);
        
        setPaintOrder(MainScreen.class, Instructions.class, GameOver.class, LifeBoard.class, CoinBoard.class, Tim.class, Skeleton.class, Coin.class, Door.class, Barriers.class, Ground.class);
        
        coin = 0;
        skeleton = 0;
        createCoins();
        createSkeletons();
        prepareBoards();
        coinBoard();
        //updateLifeBoard();
        //updateCoinBoard();
    }
    
    public void prepareBoards()
    {
        

        lifeBoardLabel = " Life " ;

       lifeBoard = new LifeBoard(lifeBoardLabel + totalLife, 30, Color.BLUE, new Color(3, 55, 73, 1));
        addObject(lifeBoard, 100, 20);
    }
    
    public void coinBoard()
    {
        coinBoardLabel = " Coins ";

        coinBoard = new CoinBoard(coinBoardLabel + totalCoins, 30, Color.YELLOW, new Color(247, 204, 80, 1));
        addObject(coinBoard, 500, 20);
    }
    
    public void updateLifeBoard()
    {

        lifeBoardLabel = " Life " ;
        String l = lifeBoardLabel  + Tim.lifeTotal;
        lifeBoard.setText(l);
        
    }
    
    public void updateCoinBoard()
    {
        coinBoardLabel = " Coins ";
        String l = coinBoardLabel + Tim.coinTotal;
        coinBoard.setText(l);
    }
    
    /*public WorldThree(Tim tim, int y)
    {
        super(600, 400, 1, false);
        
        addObject(tim, 5, y);
    }*/
    
    private GreenfootImage getScrollBg()
    {
        GreenfootImage bg = new GreenfootImage("background2.jpg");
        
        return bg;
    }
    /**
     * Constructor for objects of class WorldTwo.
     * 
     */
    public void act()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        scroll();
    }
    public void scroll()
    {
        int limitX = 100; // how close the main actor can get to side edges of world
        int ds = tim.getX(); // get x of your main actor here
        
        if (ds >= limitX && ds <= getWidth()-limitX) return; // no need to scroll
        if (ds > getWidth()-limitX) ds -= getWidth()-limitX*2;
        ds -= limitX; // this and previous line alter ds to the required change in scroll amount
        /** *********************   SCROLL BACKGROUND   ********************** */
        int scrolledAmt = scroll.changeScrollX(ds); // scrolling the background
        /** ****************************************************************** */
        // the following loop scrolls the actors by the same amount the background scrolled
        for (Object obj : getObjects(null)) // scrolling the actors
        {
            Actor actor = (Actor)obj;
            // /** to prevent certain actor types from scrolling */
            if (actor instanceof LifeBoard|| actor instanceof CoinBoard) continue;
            // /** to allow only specific actor types to scroll */
            // if (actor instanceof Buggy.class && actor instanceof Wheel.class)
            actor.setLocation(actor.getX()-scrolledAmt, actor.getY());
        }
    }
    public void createCoins()
    {
        if(coin == 0)
        {
           int numberOfCoins = Greenfoot.getRandomNumber(8) + 1;
           
           for(int i = 0 ; i < numberOfCoins ; i++)
           {
               Coin coin = new Coin();
               
               int x = Greenfoot.getRandomNumber(1800);
               int y = Greenfoot.getRandomNumber(400);
               
               addObject(coin, x, y);
               
               
           }
        }
    }
    
    public void createSkeletons()
    {
        if(skeleton == 0)
        {
            int numberOfSkeletons = Greenfoot.getRandomNumber(3) + 1;

            for(int i = 0 ; i < numberOfSkeletons ; i++)
            {
                Skeleton skeleton = new Skeleton();

                int x = Greenfoot.getRandomNumber(1800);
                //int y = Greenfoot.getRandomNumber(330);

                addObject(skeleton, x, 330);

            }
        }
    }
}
  


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Megalodon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Megalodon extends Actor
{
    /**
     * Act - do whatever the Megalodon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int count = 0;
    public int lives = 3;
    
    public void act()
    {
        // Add your action code here.
    
        
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY()-2);
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY()+2);
        }
        if(Greenfoot.isKeyDown("left")){
            setImage("Megalodon-IZQUIERDA.png");
            setLocation(getX()-2,getY());
        }
        if(Greenfoot.isKeyDown("right")){
            setImage("Megalodon-DERECHA.png");
            setLocation(getX()+2,getY());
        }
        getTheScoreAccordingToTheSquid();
        enemy();
       // Muestra el número de vidas del jugador
        
        getWorld().showText("Score: "+ count,100,50);
        getWorld().showText("Vidas: " + lives, 250, 50);
    }
    
    public void getTheScoreAccordingToTheSquid()
    {
        Actor getSquid =getOneIntersectingObject(Squid.class);
        if(getSquid != null){
            getWorld().removeObject(getSquid);
            Greenfoot.playSound("shark.mp3");
            Squid squid = new Squid();
            int x = Greenfoot.getRandomNumber(getWorld().getWidth());
            int y = Greenfoot.getRandomNumber(getWorld().getHeight());
            getWorld().addObject(squid, x, y);

            getScore();

        }   
        
    }
    
    public int getScore () 
    {
        count++;
        return this.count;
    }
    
    public int getLives ()
    {
        lives--;
        return this.lives;
    }
    
    public void enemy () 
    {
        Actor getKillerWhale = getOneIntersectingObject(KillerWhale.class);
        if(getKillerWhale != null)
        {
            getWorld().removeObject(getKillerWhale);
            decreaseLives();
            KillerWhale KillerWhale = new KillerWhale();
            int x = Greenfoot.getRandomNumber(getWorld().getWidth());
            int y = Greenfoot.getRandomNumber(getWorld().getHeight());
            getWorld().addObject(KillerWhale, x, y);
        }
    }
    
    public void decreaseLives ()
    {
        getLives();
        if (lives <= 0) {
            // Aquí puedes agregar lógica para manejar la derrota del jugador (game over, reiniciar, etc.).
            closingTheGame();
        }
    }
    
    public void closingTheGame()
    {
        GAMEOVER game_over = new GAMEOVER();
        getWorld().addObject(game_over,300,200);
    }
}

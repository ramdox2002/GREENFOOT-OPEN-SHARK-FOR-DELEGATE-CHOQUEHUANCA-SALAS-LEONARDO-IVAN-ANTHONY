import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GAMEOVER here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GAMEOVER extends Actor
{
    /**
     * Act - do whatever the GAMEOVER wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.        
        GreenfootImage image = new GreenfootImage("GAME-OVER.png");
        setImage(image);
        Megalodon megalodon = new Megalodon();
        getWorld().showText(String.valueOf(megalodon.getScore()), 435, 252);
        Greenfoot.stop();
    }
    
}

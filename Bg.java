import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bg extends World
{

    /**
     * Constructor for objects of class Bg.
     * 
     */
    
    private int elapsedTime = 0;
    private boolean randomObjectsStarted = false;
    public Bg()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    public void act () {
    
        elapsedTime++;
        
        Squid squid = new Squid();
        if (elapsedTime < 300 && !randomObjectsStarted) {
            // Comienza a hacer que aparezcan objetos aleatorios
            if (Greenfoot.getRandomNumber(100) < 5) {
            // La probabilidad de que aparezca un objeto es del 5%
            
            // Coloca el objeto aleatorio en una ubicación aleatoria en el mundo
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            
            addObject(squid, x, y);
            randomObjectsStarted = true;
            }
        }

    }
    
    public void prepare () 
    {
        // EL MEGALODON O TIBURON APARECE ACA
        Megalodon shark = new Megalodon();
        addObject(shark, 100, 100);
        
        // LAS ORCAS APARECEN ACA
        KillerWhale enemy = new KillerWhale();
        addObject(enemy, 300, 300);
        KillerWhale enemy1 = new KillerWhale();
        addObject(enemy1, 500, 200);
        KillerWhale enemy2 = new KillerWhale();
        addObject(enemy2, 400, 100);
        
        // APARECEN LOS CALAMARES
        
        Squid squid = new Squid();
        addObject(squid, 200, 300);
        Squid squid1 = new Squid();
        addObject(squid1, 300, 200);
        Squid squid2 = new Squid();
        addObject(squid2, 400, 100);
        
    }
    
    
}

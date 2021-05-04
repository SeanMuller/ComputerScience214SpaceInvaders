import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    
    //Required variable for a class that extends canvas
    private static final long serialVersionUID = -7803629994015778818L;

    //Constants that will store the width and the height of the screen that the game will be played in
    public static final int WIDTH = 500, HEIGHT = WIDTH/3*4;

    private Thread thread;
    private boolean running = false;

    private GameStateHandler stateHandler;

    public static void main(String[] args) {
        new Game();
    }


    //Constructor method for the Game.
    public Game()
    {
        //Create a Window for the Game to use.
        new Window(WIDTH,HEIGHT,"Cosmic Conquistadors",this);
        //Instantiate the GameStateHandler and set the state to the MainMenu.
        stateHandler = new GameStateHandler(GameState.MainMenu);
    }

    //This method was take from the video https://www.youtube.com/watch?v=1gir2R7G9ws&t=339s at time 12 : 00
    //Method to start the game loop.
    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    //This method was take from the video https://www.youtube.com/watch?v=1gir2R7G9ws&t=339s at time 12 : 36
    //Method to stop the game loop when the game stops running.
    public synchronized void stop()
    {
        try {
            thread.join();
            running = false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }

    //Method where everything will be updated for each game loop.
    public void tick()
    {
        stateHandler.tick();
    }

    //Part of this method was take from the video https://www.youtube.com/watch?v=1gir2R7G9ws&t=339s at time 16 : 30
    //Method for drawing everything to the window.
    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        stateHandler.render(g);

        g.dispose();
        bs.show();
    }

    //This method was take from the video https://www.youtube.com/watch?v=1gir2R7G9ws&t=339s at time 14 : 49
    // Game loop method
    public void run() {
        this.requestFocus();
        System.out.println("Running");
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while (delta >=1){
                tick();
                delta--;
            }
            if (running)
            {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer>1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames=0;
            }
        }
        stop();
    }
}

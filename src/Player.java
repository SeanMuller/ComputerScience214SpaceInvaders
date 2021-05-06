//Code written by Sean Muller 23575786
//This is the class that will represent the player in the game

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
    //Player characteristics
    private int playerSize = 20;
    private int playerSpeed = 4;

    //Constructor for the class
    public Player(float x, float y, ID id) {
        super(x, y, id);
        
    }

    //Tick method to update the players position based on the players velocity
    public void tick() {
        x+=velX;
        y+=velY;
    }

    //Render method to draw the player to the screen
    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillOval((int) x-playerSize/2, (int) y-playerSize/2, playerSize, playerSize);
    }

    //Getter and Setter methods for the player characteristics
    public int getPlayerSize() {
        return playerSize;
    }
    
    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSize(int playerSize) {
        this.playerSize = playerSize;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    
}

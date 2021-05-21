//Code written by Sean Muller 23575786
//This is the class that will represent the player in the game

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
    //Player characteristics
    private int playerSize = 20;
    private int playerSpeed = 4;
    private int delay = 20;
    private int delayCount;
    private double turretAngle;
    
    private boolean isDelaying;

    private GameObjectHandler gameHandler;

    //Constructor for the class
    public Player(float x, float y, ID id, GameObjectHandler handler) {
        super(x, y, id);
        gameHandler = handler;
        delayCount = 0;
        isDelaying = false;
    }

    //Tick method to update the players position based on the players velocity
    public void tick() {
        x+=velX;
        y+=velY;
        if (x-playerSize/2<0){x=playerSize/2;}
        if(x+playerSize>=Game.WIDTH){x=Game.WIDTH-playerSize;}
        setTurretAngle();
        if (isDelaying)
        {
            delayCount++;
            if(delayCount >= delay)
            {
                delayCount = 0;
                isDelaying = false;
            }
        }
        
        
    }

    //Method that will calculate the angle of the turret limits(0 - 180)
    private void setTurretAngle()
    {
        double deltaX = Game.mouseX-(x+5);
        double deltaY = (y+24) - Game.mouseY;
        deltaY = Utility.limitBounds(deltaY, 0, Game.HEIGHT);
        turretAngle = Math.atan(deltaY/deltaX);
        if (deltaX < 0)
        {
            turretAngle += Math.PI;
        }
    }

    //method to create a missile
    public void createMissile()
    {
        if (!isDelaying)
        {
            Missile missile = new Missile(x, y, (float) Math.cos(turretAngle) , (float) -Math.sin(turretAngle) ,ID.Missile);
            gameHandler.addObject(missile);
            isDelaying = true;
        }
    }

    //Render method to draw the player to the screen5
    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillOval((int) x-playerSize/2, (int) y-playerSize/2, playerSize, playerSize);
        g.drawLine((int) x, (int) y, (int) (x+100*Math.cos(turretAngle)), (int) (y-100*Math.sin(turretAngle)));
    }

    //Getter and Setter methods for the player characteristics
    public int getPlayerSize() {
        return playerSize;
    }
    
    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public double getTurretAngle()
    {
        return turretAngle;
    }

    public void setPlayerSize(int playerSize) {
        this.playerSize = playerSize;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    
}

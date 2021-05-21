import java.awt.Graphics;

import java.awt.Color;

public class Missile extends GameObject {
    int missileSize = 8;
    float missileSpeed = 5;

    public Missile(float x, float y, float unitVx, float unitVy, ID id) {
        super(x, y, id);
        this.velX = missileSpeed*unitVx;
        this.velY = missileSpeed*unitVy;
    }

    public void tick() {
        x+=velX;
        y+=velY;
        if (x+missileSize<0 || x - missileSize>Game.WIDTH || y+missileSize<0 || y - missileSize>Game.HEIGHT)
        {
            dead = true;
        }
    }

    public void render(Graphics g) 
    {
        g.setColor(Color.BLUE);
        g.fillOval((int) x-missileSize/2, (int) y-missileSize/2, missileSize, missileSize);
    }
    
}

import java.awt.Color;
import java.awt.Graphics;

public class Invaders extends GameObject
{
    public int xi;
    public int yi;
     public Invaders(float x, float y, ID id)
    {
      super( x, y, id);  
      xi =(int)x;
      yi =(int)y;
     }
     
     //Method that is used to update the object
     public void tick()
     {
     }
    //Method for drawing the object
     public void render(Graphics g)
     {
       g.setColor(Color.BLACK);
       g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
       g.setColor(Color.CYAN);
       g.fillOval(xi,yi,10,10);
     }
 
}
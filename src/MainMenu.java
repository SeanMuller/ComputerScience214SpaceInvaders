//Code written by Sean Muller 23575786

//This is the class to control and draw the main menu

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;

public class MainMenu {
    private Font title = new Font("Title",Font.PLAIN,30);

    //method rendering the main menu
    public void render(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(title);
        drawStringCenteredAtPoint(g, Game.WIDTH/2, Game.HEIGHT/2,"Cosmic Conquistadors", title);
    }

    //method to draw text that is centered at the specified point
    private void drawStringCenteredAtPoint(Graphics g,float x, float y,String text, Font font)
    {
        FontMetrics metrics = g.getFontMetrics(font);
        float x2 = x - metrics.stringWidth(text)/2;
        float y2 = y - metrics.getHeight()/2;
        g.drawString(text, (int) x2, (int) y2);
    }
    
}

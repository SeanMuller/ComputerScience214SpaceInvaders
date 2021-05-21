//Code written by Sean Muller 23575786

//This is the class to control and draw the main menu

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Font;
import java.awt.FontMetrics;

public class MainMenu {
    // Different fonts used in the Menu
    private Font title = new Font("Title", Font.PLAIN, 30);
    private Font body = new Font("Title", Font.PLAIN, 15);

    private int startIntensity = 255;
    private int fadeDirection = -5;
    private Star[] stars = new Star[200];
    private Random r;

    // Constructor for the class to instantiate all the starts
    MainMenu() {
        r = new Random();
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), r.nextInt(Game.HEIGHT), 1.5f);
        }
    }

    // Tick method for the main menu;
    public void tick() {
        // Call the tick method on each star
        for (int i = 0; i < stars.length; i++) {
            stars[i].tick();
        }

        // Change the intesity of the text to make it flash
        startIntensity += fadeDirection;
        if (startIntensity <= 0 || startIntensity >= 255) {
            fadeDirection *= -1;
        }
    }

    // method rendering the main menu
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        // Render all the stars
        for (int i = 0; i < stars.length; i++) {
            stars[i].render(g);
        }

        // Put the text on the screen
        drawStringCenteredAtPoint(g, Game.WIDTH / 2, Game.HEIGHT / 2, "Cosmic Conquistadors", title, Color.WHITE);
        Color temp = new Color(startIntensity, startIntensity, startIntensity);
        drawStringCenteredAtPoint(g, Game.WIDTH / 2, Game.HEIGHT / 2 + 30, "Press enter to start", body, temp);
    }

    // method to draw text that is centered at the specified point
    private void drawStringCenteredAtPoint(Graphics g, float x, float y, String text, Font font, Color color) {
        FontMetrics metrics = g.getFontMetrics(font);
        float x2 = x - metrics.stringWidth(text) / 2;
        float y2 = y - metrics.getHeight() / 2;
        g.setFont(font);
        g.setColor(color);
        g.drawString(text, (int) x2, (int) y2);
    }

    // Class for controlling the starts in backgroud
    private class Star {
        private float x, y, z, vel;
        private int size;
        private int endZ = (int) Math.sqrt(Game.WIDTH * Game.HEIGHT);
        private float projectionDistance = Game.HEIGHT;

        // Constructor for the stars
        Star(float x, float y, float z, float vel) {
            this.vel = vel;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        // Tick method to update the stars z position based on the velocity
        public void tick() {
            z += vel;
            // Reset the stars when they get off screen
            if (z > endZ) {
                z = r.nextFloat();
            }
        }

        public void render(Graphics g) {
            // Set the size of the star base on how "far away" it is from the screen
            size = (int) Utility.limitBounds(7 * z / endZ, 1, 7);

            // create new variables to be used to project the stars correctly
            float x2 = x;
            float y2 = y;

            // Translate the stars to be centered around 0,0
            x2 -= Game.WIDTH / 2;
            y2 -= Game.HEIGHT / 2;

            // Project the stars to make it look like the viewer is moving
            x2 = x2 * (projectionDistance / (projectionDistance - z));
            y2 = y2 * (projectionDistance / (projectionDistance - z));

            // Translate the stars back to the original position
            x2 += Game.WIDTH / 2;
            y2 += Game.HEIGHT / 2;
            g.setColor(Color.WHITE);
            g.fillOval((int) x2 - size / 2, (int) y2 - size / 2, size, size);
        }
    }

}

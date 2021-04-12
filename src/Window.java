//this class was take from the video https://www.youtube.com/watch?v=1gir2R7G9ws&t=339s at time 5 : 00

import java.awt.Canvas;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Window extends Canvas {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Window(int width, int height, String title, Game game)
    {
        JFrame frame = new JFrame(title);
        Dimension dimension = new Dimension(width,height);
        frame.setPreferredSize(dimension);
        frame.setMaximumSize(dimension);
        frame.setMinimumSize(dimension);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }  
}

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxes {
    public static void squareDraw(int squareSize, Color fillColor, Graphics graphics) {
        graphics.setColor(fillColor);
        graphics.fillRect(
                (WIDTH / 2) - (squareSize / 2),
                (HEIGHT / 2) - (squareSize / 2),
                squareSize,
                squareSize
        );
    }


    public static void mainDraw(Graphics graphics) {
        // Create a square drawing function that takes 3 parameters:
        // The square size, the fill color, graphics
        // and draws a square of that size and color to the center of the canvas.
        // Create a loop that fills the canvas with rainbow colored squares (red, orange, yellow, green, blue, indigo, violet).

        Color VIOLET = new Color(238, 130, 238);
        Color INDIGO = new Color(75, 0, 130);

        List<Color> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(INDIGO);
        colors.add(VIOLET);


        for (int i = 0; i < 7; i++) {
            int squareSize = 200 - (i * (200 / 7));
            squareDraw(squareSize, colors.get(i), graphics);
        }


    }

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}
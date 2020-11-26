import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {

    public static void singleLIne(int xCoordinate, int yCoordinate, Graphics graphics) {

        graphics.drawLine(xCoordinate, yCoordinate, WIDTH / 2, HEIGHT / 2);


    }

    public static void mainDraw(Graphics graphics) {
        // Create a function that draws a single line and takes 3 parameters:
        // The x and y coordinates of the line's starting point and the graphics
        // and draws a line from that point to the center of the canvas.
        // Fill the canvas with lines from the edges, every 20 px, to the center.

        int x = 0;
        int y = 0;
        int xMax = WIDTH;
        int yMax = HEIGHT;
        singleLIne(x, y, graphics);

        for (int i = 0; i < 17; i++) {
            singleLIne(x + (i * 20), y, graphics);
            singleLIne(x, y + (i * 20), graphics);
            singleLIne(xMax, yMax - (i * 20), graphics);
            singleLIne(xMax - (i * 20), yMax, graphics);
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
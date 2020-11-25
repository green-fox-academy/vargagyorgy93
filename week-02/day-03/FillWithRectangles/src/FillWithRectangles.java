import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FillWithRectangles {

    public static void mainDraw(Graphics graphics) {
        // draw four different size and color rectangles.
        // avoid code duplication.

        for (int i = 1; i < 5; i++) {
            graphics.setColor(new Color(10 * i, 20 * i, 0 * i, 15 * i));
            graphics.drawRect((WIDTH / 2) - (i * 5), (HEIGHT / 2) - (i * 5), i * 10, i * 10);
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
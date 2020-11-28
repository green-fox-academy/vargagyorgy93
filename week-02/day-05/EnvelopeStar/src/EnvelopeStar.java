import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {
    public static void mainDraw(Graphics graphics) {
        
        graphics.setColor(Color.GREEN);

        int step = 10;

        for (int i = 0; i < 16; i++) {


            graphics.drawLine(WIDTH / 2, (i * step), (WIDTH / 2) + (i * step), HEIGHT / 2);
            graphics.drawLine(WIDTH / 2, (i * step), (WIDTH / 2) - (i * step), HEIGHT / 2);

            graphics.drawLine(WIDTH / 2, HEIGHT - (i * step), (WIDTH / 2) - (i * step), HEIGHT / 2);
            graphics.drawLine(WIDTH / 2, HEIGHT - (i * step), (WIDTH / 2) + (i * step), HEIGHT / 2);
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
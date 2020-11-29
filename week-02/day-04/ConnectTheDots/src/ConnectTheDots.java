import javax.swing.*;

import java.awt.*;
import java.util.HashMap;

import static com.sun.tools.attach.VirtualMachine.list;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots {
    public static void mainDraw(Graphics graphics) {
        // Create a function that takes 2 parameters:
        // An array of {x, y} points and graphics
        // and connects them with green lines.
        // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
//         Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
//         {120, 100}, {85, 130}, {50, 100}}


        graphics.setColor(Color.GREEN);


        int[][] box = {{10, 10}, {290, 10}, {290, 290}, {10, 290}};

        int[] x = new int[box.length];
        int[] y = new int[box.length];
        for (int i = 0; i < box.length; i++) {
            x[i] = box[i][0];
            y[i] = box[i][1];
        }
        graphics.drawPolygon(x, y, box.length);

        int[][] fox = {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
                {120, 100}, {85, 130}, {50, 100}};

        int[] x2 = new int[fox.length];
        int[] y2 = new int[fox.length];
        for (int i = 0; i < fox.length; i++) {
            x2[i] = fox[i][0];
            y2[i] = fox[i][1];
        }
        graphics.drawPolygon(x2, y2, fox.length);


//        int[] xCoords = {10, 290, 290, 10};
//        int[] yCoords = {10, 10, 290, 290};
//        int lenght = 4;
//        int[] box = {10, 10, 290, 10, 290, 290, 10, 290};
//
//        int[] x2Coords = {50, 70, 80, 90, 100, 120, 85, 50,};
//        int[] y2Coords = {100, 70, 90, 90, 70, 100, 130, 100};
//        int lenght2 = 8;
//
//        graphics.drawPolygon(xCoords, yCoords, lenght);
//        graphics.drawPolygon(x2Coords, y2Coords, lenght2);


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
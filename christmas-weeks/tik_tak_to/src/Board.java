import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel {
    protected void paintComponent(Graphics grap) {
        super.paintComponent(grap);
        this.setBackground(Color.WHITE);

        grap.setColor(Color.BLACK);
        grap.drawRect(25, 25, 300, 300);
        grap.drawLine(125, 25, 125, 325);
        grap.drawLine(225, 25, 225, 325);
        grap.drawLine(25, 125, 325, 125);
        grap.drawLine(25, 225, 325, 225);

        grap.setColor(Color.BLACK);
        grap.setFont(new Font("TimesRoman", Font.PLAIN, 50));
//        if (usedNumbers.contains(1)) {
//            grap.drawString("X", 60, 95);
//        }
//        if (usedNumbers.contains(2)) {
//            grap.drawString("X", 160, 95);
//        }
//        if (usedNumbers.contains(3)) {
//            grap.drawString("X", 260, 95);
//        }
//        if (usedNumbers.contains(4)) {
//            grap.drawString("X", 60, 195);
//        }
//        if (usedNumbers.contains(5)) {
//            grap.drawString(" ", 160, 195);
//        }
//        if (usedNumbers.contains(6)) {
//            grap.drawString("X", 260, 195);
//        }
//        if (usedNumbers.contains(6)) {
//            grap.drawString("X", 60, 295);
//        }
//        if (usedNumbers.contains(6)) {
//            grap.drawString("X", 160, 295);
//        }
//        if (usedNumbers.contains(6)) {
//            grap.drawString("X", 260, 295);
//        }

    }
//    public static void gameBoard(){
//        JFrame f = new JFrame("Million Dollar Game");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Board tikTakTo = new Board();
//        f.add(tikTakTo);
//        f.setSize(400, 400);
//        f.setVisible(true);
//    }

//    public static void drawString(Graphics grap, List<Integer> usedNums){
//        if (usedNums.contains(1)) {
//            grap.drawString("X", 60, 95);
//        }
//        if (usedNums.contains(2)) {
//            grap.drawString("X", 160, 95);
//        }
//    }



}

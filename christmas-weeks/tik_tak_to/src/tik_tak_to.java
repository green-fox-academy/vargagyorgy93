import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class tik_tak_to {
    public static void main(String[] args) {
        tikTakTo();
    }

    public static void tikTakTo() {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> board = new HashMap<>();
        board.put(1, " ");
        board.put(2, " ");
        board.put(3, " ");
        board.put(4, " ");
        board.put(5, " ");
        board.put(6, " ");
        board.put(7, " ");
        board.put(8, " ");
        board.put(9, " ");
        String winner = "";
        List<Integer> usedNumbers = new ArrayList<>();
        int step;
        boolean weHaveAWinner = false;
//        Board.gameBoard();
        System.out.println(" |_ " + board.get(1) + " _|_ " + board.get(2) + " _|_ " + board.get(3) + " _| ");
        System.out.println(" |_ " + board.get(4) + " _|_ " + board.get(5) + " _|_ " + board.get(6) + " _| ");
        System.out.println(" |_ " + board.get(7) + " _|_ " + board.get(8) + " _|_ " + board.get(9) + " _| ");
        while (!weHaveAWinner) {
            System.out.println("Player X, please enter your move!");
            step = scanner.nextInt();
            if (usedNumbers.contains(step) || step > 9){
                while (usedNumbers.contains(step)) {
                    step = checkUsedMoves();
                }
            }
            usedNumbers.add(step);
            board.put(step, "X");
            System.out.println(" |_ " + board.get(1) + " _|_ " + board.get(2) + " _|_ " + board.get(3) + " _| ");
            System.out.println(" |_ " + board.get(4) + " _|_ " + board.get(5) + " _|_ " + board.get(6) + " _| ");
            System.out.println(" |_ " + board.get(7) + " _|_ " + board.get(8) + " _|_ " + board.get(9) + " _| ");
            winner = checkForWinner(board, winner);
            if (winner.equals("X")) {
                System.out.println();
                System.out.println("Winner is player " + winner);
                weHaveAWinner = true;
            } else {
                System.out.println("Player O, please enter your move!");
                step = scanner.nextInt();
                if (usedNumbers.contains(step) || step > 9){
                    while (usedNumbers.contains(step)) {
                        step = checkUsedMoves();
                    }
                }
                usedNumbers.add(step);
                board.put(step, "O");
                System.out.println(" |_ " + board.get(1) + " _|_ " + board.get(2) + " _|_ " + board.get(3) + " _| ");
                System.out.println(" |_ " + board.get(4) + " _|_ " + board.get(5) + " _|_ " + board.get(6) + " _| ");
                System.out.println(" |_ " + board.get(7) + " _|_ " + board.get(8) + " _|_ " + board.get(9) + " _| ");
                winner = checkForWinner(board, winner);
                if (winner.equals("O")) {
                    System.out.println();
                    System.out.println("Winner is player " + winner);
                    weHaveAWinner = true;
                }
            }
        }
    }


    public static String checkForWinner(HashMap<Integer, String> map, String winner) {
        List<Integer> resultX = new ArrayList<>();
        List<Integer> resultO = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals("X")) {
                resultX.add(entry.getKey());
            } else if (entry.getValue().equals("O")) {
                resultO.add(entry.getKey());
            }
        }
        if (checkBoard(resultO, "O").equals("O")) {
            winner = "O";
        } else if (checkBoard(resultX, "X").equals("X")) {
            winner = "X";
        }
        return winner;
    }

    public static String checkBoard(List<Integer> result, String player) {
        String winner = "";
        if (result.contains(1)) {
            if (result.contains(2) && result.contains(3)) {
                winner = player;
            } else if (result.contains(4) && result.contains(7)) {
                winner = player;
            } else if (result.contains(5) && result.contains(9)) {
                winner = player;
            }
        } else if (result.contains(9)) {
            if (result.contains(8) && result.contains(7)) {
                winner = player;
            } else if (result.contains(6) && result.contains(3)) {
                winner = player;
            }
        } else if (result.contains(5)) {
            if (result.contains(3) && result.contains(7)) {
                winner = player;
            } else if (result.contains(6) && result.contains(4)) {
                winner = player;
            } else if (result.contains(2) && result.contains(8)) {
                winner = player;
            }
        }
        return winner;
    }

    public static int checkUsedMoves() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wrong move, please enter another move!");
        return scanner.nextInt();
    }

//    public static void gameBoard(){
//        JFrame f = new JFrame("Million Dollar Game");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Board tikTakTo = new Board();
//        f.add(tikTakTo);
//        f.setSize(400, 400);
//        f.setVisible(true);
//    }

}

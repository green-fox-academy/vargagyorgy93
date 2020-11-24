// - Create (dynamically*) a two dimensional array
//   with the following matrix**. Use a loop!
//
//   1 0 0 0
//   0 1 0 0
//   0 0 1 0
//   0 0 0 1
//
// - Print this two dimensional array to the output
// * length should depend on a variable
// ** Relax, a matrix is just like an array

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {

        int a = 4;

        int[][] matrix = {
                {0},
                {1},
        };

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (j == i) {
                    System.out.print(matrix[1][0] + " ");
                } else {
                    System.out.print(matrix[0][0] + " ");
                }
            }
            System.out.println();
        }
    }
}


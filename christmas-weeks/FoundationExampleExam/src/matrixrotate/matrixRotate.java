package matrixrotate;

import java.util.Arrays;

public class matrixRotate {
    public static void main(String[] args) {
        matrixRotate matrix = new matrixRotate();
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(matrix.rotateMatrix(input)));
    }

    public int[][] rotateMatrix(int[][] givenMatrix) {
        int[][] result = givenMatrix;
        int counter = 0;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[j][(result.length - 1) - i] = (counter += 1);
            }
        }
        return result;
    }
}

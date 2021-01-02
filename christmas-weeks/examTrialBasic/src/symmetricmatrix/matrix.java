package symmetricmatrix;

public class matrix {
    public static void main(String[] args) {
        matrix matrix = new matrix();
        int[][] givenMatrix = {
                {1, 0, 1},
                {0, 2, 2},
                {1, 2, 5}
        };
        System.out.println(matrix.isSymmetric(givenMatrix));

    }

    public boolean isSymmetric(int[][] givenMatrix) {
        for (int i = 0; i < givenMatrix.length; i++) {
            for (int j = 0; j < givenMatrix.length; j++) {
                if (givenMatrix[i][j] != givenMatrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

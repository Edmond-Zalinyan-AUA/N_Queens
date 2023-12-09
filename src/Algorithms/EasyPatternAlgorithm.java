package Algorithms;

import Manager.UIManager;

public class EasyPatternAlgorithm {

    public static int[][] n_queens() {
        int n = UIManager.N;
        int[][] matrix = new int[n][n];
        if (n % 6 != 2 && n % 6 != 3) {
            int col = 0;
            for (int i = 1; i < n; i += 2) {
                matrix[i][col] = 1;
                col++;
            }
            for (int i = 0; i < n; i += 2) {
                matrix[i][col] = 1;
                col++;
            }
            return matrix;
        }
        if (n % 6 == 2) {
            int col = 0;
            for (int i = 1; i < n; i += 2) {
                matrix[i][col] = 1;
                col++;
            }
            matrix[2][col] = 1;
            col++;
            matrix[0][col] = 1;
            col++;
            for (int i = 6; i < n; i += 2) {
                matrix[i][col] = 1;
                col++;
            }
            matrix[4][col] = 1;
            return matrix;
        }
        int col = 0;
        for (int i = 3; i < n; i += 2) {
            matrix[i][col] = 1;
            col++;
        }
        matrix[1][col] = 1;
        col++;
        for (int i = 4; i < n; i += 2) {
            matrix[i][col] = 1;
            col++;
        }
        matrix[0][col] = 1;
        col++;
        matrix[2][col] = 1;
        return matrix;
    }
}

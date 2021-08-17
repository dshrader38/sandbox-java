package com.shrader.algorithms.solutions;

import com.shrader.algorithms.SolutionBase;

public class Search2DMatrix implements SolutionBase {
    public void run() {
        int[][] matrix = { {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60} };

        boolean result = searchMatrix(matrix, 16);
        System.out.printf( "Search2DMatrix: %s%n", result );

        result = searchMatrix(matrix, 38);
        System.out.printf( "Search2DMatrix: %s%n", result );
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        System.out.printf("Rows:%d Cols:%d%n", rows, cols);

        outerloop:
        for (int i = 0; i < rows; i++) {
            int[] row = matrix[i];

            for (int j = 0; j < row.length; j++) {
                int value = row[j];
                System.out.printf( "i:%d j:%d%n", i, j );

                if ( value == target) {
                    result = true;
                    break outerloop;
                }
            }
        }

        return result;
    }
}
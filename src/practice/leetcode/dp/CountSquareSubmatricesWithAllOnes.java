package practice.leetcode.dp;

import java.util.Arrays;

public class CountSquareSubmatricesWithAllOnes {
    /**
     * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
     * LeetCode 1277. Count Square Submatrices with All Ones
     *
     * My Solution : dp
     * result : 7ms
     */

    public int countSquares(int[][] matrix) {
        int count = Arrays.stream(matrix[0]).sum();

        for (int i = 1; i < matrix.length; i++) {
            count += matrix[i][0];

            for (int j = 1; j < matrix[0].length; j++) {
                int n = Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                int min = Math.min(matrix[i][j - 1], n);
                if (matrix[i][j] == 1) matrix[i][j] += min;
                count += matrix[i][j];
            }
        }

        return count;
    }
}

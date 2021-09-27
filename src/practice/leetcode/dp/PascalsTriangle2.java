package practice.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    /**
     * https://leetcode.com/problems/pascals-triangle-ii/
     * LeetCode 119. Pascal's Triangle II
     *
     * My Solution : dp
     * result : 1ms
     */

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(1));
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> integers = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    integers.add(1);
                    continue;
                }
                int n = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                integers.add(n);
            }
            triangle.add(integers);
        }
        return triangle.get(rowIndex);
    }
}

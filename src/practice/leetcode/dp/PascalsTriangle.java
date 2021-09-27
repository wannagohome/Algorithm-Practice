package practice.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    /**
     * https://leetcode.com/problems/pascals-triangle/
     * LeetCode 118. Pascal's Triangle
     *
     * My Solution : dp
     * result : 0ms
     */

    public static void main(String[] args) {
        PascalsTriangle instance = new PascalsTriangle();
        for (List<Integer> list : instance.generate(5)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
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
        return triangle;
    }
}

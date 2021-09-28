package practice.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortArrayByParity2 {
    /**
     * https://leetcode.com/problems/sort-array-by-parity-ii/
     * LeetCode 922. Sort Array By Parity II
     *
     * My Solution : sort
     * result : 3ms
     */

    public int[] sortArrayByParityII(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int evenIndex = 0;
        int oddIndex = 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                res[evenIndex] = num;
                evenIndex += 2;
            } else {
                res[oddIndex] = num;
                oddIndex += 2;
            }
        }
        return res;
    }
}

package practice.leetcode.sort;

import java.util.Arrays;

public class SortColors {
    /**
     * https://leetcode.com/problems/sort-colors/
     * LeetCode 75. Sort Colors
     *
     * My Solution :
     * Counting Sort 에 대해 알게되었다.
     * 이름 그대로 각 element들의 개수를 counting해 value크기 순으로 나열하는
     * O(n)의 복잡도를 가진 알고리즘.
     * https://www.cs.miami.edu/home/burt/learning/Csc517.091/workbook/countingsort.html
     *
     * counting array를 만들어 각 element의 빈도수를 저장하고 난 뒤 출력한다.
     *
     * Time Complexity : O(n)
     * result : 0ms
     */

    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {nums[i] = 0;}
            else if (i < count0 + count1) {nums[i] = 1;}
            else {nums[i] = 2;}
        }
    }
}

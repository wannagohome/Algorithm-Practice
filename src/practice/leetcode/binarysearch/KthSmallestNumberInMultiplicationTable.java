package practice.leetcode.binarysearch;

public class KthSmallestNumberInMultiplicationTable {
    /**
     * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
     * LeetCode 668. Kth Smallest Number in Multiplication Table
     *
     *
     *
     * result : 15ms 77%
     */

    public int findKthNumber(int m, int n, int k) {
        int low = 0, high = m * n;
        while (low < high) {
            int mid = (low + high) / 2, count = 0;
            for (int i = 1; i <= m; i++)
                count += Math.min(n, mid / i);
            if (count >= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}

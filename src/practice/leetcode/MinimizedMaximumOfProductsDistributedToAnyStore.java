package practice.leetcode;

public class MinimizedMaximumOfProductsDistributedToAnyStore {
    /**
     * https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
     * LeetCode 2064. Minimized Maximum of Products Distributed to Any Store
     *
     * Solution :
     * binary search
     *
     * result : 30ms
     *
     */

    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 100000;

        while (left < right) {
            int mid = (left + right) / 2, sum = 0;
            for (int quantity : quantities) sum += (quantity + mid - 1) / mid;
            if (sum > n) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

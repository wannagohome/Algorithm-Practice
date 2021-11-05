package practice.leetcode;

public class ArrangingCoins {
    /**
     * https://leetcode.com/problems/arranging-coins/
     * LeetCode 441. Arranging Coins
     *
     * My Solution :
     * 하나씩 카운팅
     *
     * result : 7ms
     *
     * Faster Solution :
     * 중간 값을 이용한 binary search
     *
     * Time Complexity : O(log(n))
     * result : 1ms
     *
     */

    public int arrangeCoins(int n) {
        int ans = 0;
        for (int i = 1; n > 0; i++) {
            n -= i;
            if (n >= 0) ans ++;
            else break;
        }
        return ans;
    }

    public int faster(int n) {
        int left = 0, right = n;
        int mid, currSum;
        while (left <= right) {
            mid = (right + left) / 2;
            currSum = mid * (mid + 1) / 2;

            if (currSum == n) return mid;

            if (n < currSum) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}

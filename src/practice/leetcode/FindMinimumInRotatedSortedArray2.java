package practice.leetcode;

public class FindMinimumInRotatedSortedArray2 {
    /**
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
     * LeetCode 154. Find Minimum in Rotated Sorted Array II
     *
     * My Solution :
     * 이상한 문제...
     * 난이도도 hard 이고 operation step을 최대한 줄이라고 되어 있어서
     * binary search로 풀어보려 했으나, 예외사항들을 잡기가 어려워
     * 그냥 하나씩 조회해 보는 식으로 돌려 봤더니 0ms...
     * 이상하다
     *
     * Time Complexity : O(n)
     * result : 0ms
     *
     */
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) break;
            if (nums[i] > nums[i + 1]) return nums[i + 1];
        }
        return nums[0];
    }
}

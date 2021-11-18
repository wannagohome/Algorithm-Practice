package practice.leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    /**
     * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
     * LeetCode 448. Find All Numbers Disappeared in an Array
     *
     * HashTable은 필요하지도 않다
     *
     * result : 3ms 100%
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[nums.length];

        for (int num : nums) count[num - 1] = 1;
        for (int i = 0; i < count.length; i++)
            if (count[i] == 0) ans.add(i + 1);

        return ans;
    }
}

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    /**
     * https://leetcode.com/problems/find-all-duplicates-in-an-array/
     * LeetCode 442. Find All Duplicates in an Array
     *
     * My Solution :
     * 그냥 array문제 medium난이도가 이해가지 않는 문제
     * 상위 40% 정도의 빠르기로 좀더 빠른 해법이 있지만 굳이 필요성을 느끼지 못하겠다.
     *
     * Time Complexity : O(n)
     * result : 11ms
     *
     */

    public List<Integer> findDuplicates(int[] nums) {
        int[] counts = new int[nums.length + 1];
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (counts[num] == 1) ans.add(num);
            else counts[num]++;
        }

        return ans;
    }
}

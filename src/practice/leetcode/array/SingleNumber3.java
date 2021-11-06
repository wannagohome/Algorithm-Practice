package practice.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

public class SingleNumber3 {
    /**
     * https://leetcode.com/problems/single-number-iii/
     * LeetCode 260. Single Number III
     *
     * Time Complexity : O(n)
     * result : 5ms
     *
     */

    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) map.remove(num);
            else map.put(num, 0);
        }

        return Arrays.stream(map.keySet().toArray(Integer[]::new))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

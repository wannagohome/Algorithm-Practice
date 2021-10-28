package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    /**
     * https://leetcode.com/problems/3sum/
     * LeetCode 15. 3Sum
     *
     * My Solution :
     * 답이 떠오르지 않아서 돌려본 브루트 포스는 시간초과가 났다.
     *
     * Time Complexity : O(n^3)
     * result : Time Limit Exceeded
     *
     * Better Solution :
     * two pointer 알고리즘에 대해 알게 되었다.
     * 말 그대로 두 개의 포인터(j,k)를 활용해 탐색하는 것이다.
     * 먼저는 배열을 정렬해 각 element 들의 합을 통해 쉽게 포인터들을 조절해가며
     * n^2의 복잡도로 풀 수 있다.
     *
     * Time Complexity : O(n^2)
     * result : Time Limit Exceeded
     *
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums)  hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);

        Integer[] keys = hashMap.keySet().toArray(new Integer[0]);
        System.out.println(Arrays.toString(keys));
        for (int i = 0; i < keys.length - 2; i++) {
            for (int j = i + 1; j < keys.length - 1; j++) {
                for (int k = j + 1; k < keys.length; k++) {
                    if (keys[i] + keys[j] + keys[k] != 0) continue;
                    ans.add(new ArrayList<>(Arrays.asList(keys[i], keys[j], keys[k])));
                }
            }
        }

        for (int key : keys) {
            System.out.println("key = " + key);
            System.out.println("hashMap.get(key) = " + hashMap.get(key));
            if (hashMap.get(key) >= 2 && hashMap.containsKey(-key * 2)) {
                if (key == 0) continue;
                ans.add(new ArrayList<>(Arrays.asList(key, key, -key * 2)));
            }
        }

        if (hashMap.getOrDefault(0, 0) >= 3 )
            ans.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        return ans;
    }

    public List<List<Integer>> better(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}

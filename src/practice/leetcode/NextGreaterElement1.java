package practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    /**
     * https://leetcode.com/problems/next-greater-element-i/
     * LeetCode 496. Next Greater Element I
     *
     * My Solution :
     * 완전 탐색
     * 이상하게 1ms 짜리 풀이도 나의 풀이와 크게 다르지 않다
     *
     * Time Complexity : O(n*m)
     * result : 4-8ms
     *
     * Better Solution :
     * Stack을 이용해 next greater element를 미리 구해놓고 map에 저장해 놓는다
     * (key의 next greater element는 value)
     * 어떻게 이런 생각을 했을까
     * 실행 속도가 분명 더 빠를 것이라 생각했지만 이상하게 차이가 나진 않았다
     *
     * Time Complexity : O(n)
     * result : 4-8ms
     */

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < nums1.length; i++) {
            int index = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    index = j;
                    break;
                }
            }
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }

        return ans;
    }

    public int[] better(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}

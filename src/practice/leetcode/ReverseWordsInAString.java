package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString {
    /**
     * https://leetcode.com/problems/reverse-words-in-a-string/
     * LeetCode 151. Reverse Words in a String
     *
     * My Solution :
     * 싫어요 3500개가 이해되는 문제
     *
     * Time Complexity : O(n)
     * result : 10-17ms
     *
     */

    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        String[] split = s.split(" ");

        for (int i = split.length - 1; i >= 0; i--)
            if (!split[i].isBlank()) list.add(split[i]);

        return String.join(" ", list);
    }
}

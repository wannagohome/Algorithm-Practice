package practice.leetcode;

import java.util.*;

public class SortCharactersByFrequency {
    /**
     * https://leetcode.com/problems/sort-characters-by-frequency/
     * LeetCode 451. Sort Characters By Frequency
     *
     * Solution :
     * bucket sort 라는 개념을 접하게 되었다.
     * 빈도수 map에 저장해 둔 후 sorting하는 것은
     * sort에 드는 비용 때문에 비효율 적이라고 생각했었는데
     * 단순히 충분한 크기의 bucket을 만들어 두고 각 빈도 수를 저장해 두면 될 문제였다.
     *
     * Time Complexity : O(n)
     * result : 9-30ms
     *
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
            if (bucket[pos] != null)
                for (char c : bucket[pos])
                    for (int i = 0; i < pos; i++)
                        sb.append(c);

        return sb.toString();
    }
}

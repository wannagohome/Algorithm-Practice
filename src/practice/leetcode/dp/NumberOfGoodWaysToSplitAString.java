package practice.leetcode.dp;

import java.util.*;

public class NumberOfGoodWaysToSplitAString {
    /**
     * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
     * LeetCode 1525. Number of Good Ways to Split a String
     *
     * My Solution :
     * 각 인덱스를 기점으로 나눈 두 string의 character들을
     * set에 넣어서 갯수 비교
     * result : 시간초과
     *
     * Better Solution :
     * 왼쪽에서 부터 세엇을 때, 오른쪽에서 부터 세엇을 때 두 경우의
     * index 마다 character 개수를 계산해놓고 저장, index마다 비교
     * result : 25ms
     *
     * Faster :
     * Better solution의 왼쪽에서 부터 세엇을 경우를 미리 계산하지 않고
     * 마지막 비교에서 계산하는 식으로 for문 하나를 제거
     * result : 23ms
     *
     * More Faster :
     * Faster의 로직을 그대로 사용하되 set을 사용하지 않고
     * boolean 배열로 알파벳 갯수 카운트
     * 자료구조 하나 바꾸었을 뿐인데 4-5배가 빨라졌다.
     * result : 4ms
     */

    public int numSplits(String s) {
        int ans = 0;
        Set<Character> left = new HashSet<>();
        Character[] array = s.chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);
        List<Character> list = new ArrayList<>(Arrays.asList(array));

        for (int i = 0; i < s.length(); i++) {
            left.add(s.charAt(i));
            list.remove(0);
            Set<Character> right = new HashSet<>(list);

            if (left.size() == right.size()) ans++;
        }
        return ans;
    }

    public int better(String s) {
        int ans = 0;
        int[] pref = new int[s.length()];
        int[] suf = new int[s.length()];
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            pref[i] = set.size();
        }
        set.clear();
        for (int i = s.length() - 1; i >= 0; i--) {
            set.add(s.charAt(i));
            suf[i] = set.size();
        }

        for (int i = 1; i < s.length(); i++) {
            if (pref[i - 1] == suf[i]) ans++;
        }

        return ans;
    }

    public int faster(String s) {
        int ans = 0;
        int[] suf = new int[s.length()];
        Set<Character> set = new HashSet<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            set.add(s.charAt(i));
            suf[i] = set.size();
        }
        set.clear();

        for (int i = 1; i < s.length(); i++) {
            set.add(s.charAt(i - 1));
            if (set.size() == suf[i]) ans++;
        }

        return ans;
    }

    public int moreFaster(String s) {
        int ans = 0;
        int[] suf = new int[s.length()];
        boolean[] contain = new boolean[26];
        contain[s.charAt(s.length() - 1) - 'a'] = true;
        suf[s.length() - 1] = 1;

        for (int i = s.length() - 2; i >= 0; i--) {
            suf[i] = suf[i + 1];
            if (!contain[s.charAt(i) - 'a']) {
                contain[s.charAt(i) - 'a'] = true;
                suf[i]++;
            }
        }
        Arrays.fill(contain, false);
        int preCount = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (!contain[s.charAt(i) - 'a']) {
                contain[s.charAt(i) - 'a'] = true;
                preCount++;
            }
            if (preCount == suf[i+1]) ans++;
        }

        return ans;
    }
}

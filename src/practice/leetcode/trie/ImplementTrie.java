package practice.leetcode.trie;

import java.util.Arrays;

public class ImplementTrie {
    /**
     * https://leetcode.com/problems/implement-trie-prefix-tree/
     * 208. Implement Trie (Prefix Tree)
     *
     * My Solution :
     * Tire 라는 자료구조를 처음 배웠다.
     * 문자열 탐색에 상수 복잡도를 가지는 아주 기가막힌 자료구조였다.
     * 개념 자체는 쉬웠다. 각 알파벳에 해당하는 노드를 트리구조로 만들면 끝
     *
     * result : 28-32ms 99.66%
     *
     */

    class Trie {
        boolean isLeaf;
        Trie[] node = new Trie[26];

        public Trie() {}

        public void insert(String word) {
            Trie node = this;
            char[] chars = word.toCharArray();

            for (char c : chars) {
                if (node.node[c - 'a'] == null) node.node[c - 'a'] = new Trie();
                node = node.node[c - 'a'];
            }

            node.isLeaf = true;
        }

        public boolean search(String word) {
            Trie node = this;
            char[] chars = word.toCharArray();

            for (char c : chars) {
                if (node.node[c - 'a'] == null) return false;
                node = node.node[c - 'a'];
            }

            return node.isLeaf;
        }

        public boolean startsWith(String prefix) {
            Trie node = this;
            char[] chars = prefix.toCharArray();

            for (char c : chars) {
                if (node.node[c - 'a'] == null) return false;
                node = node.node[c - 'a'];
            }

            return true;
        }
    }
}

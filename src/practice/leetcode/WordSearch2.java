package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordSearch2 {
    /**
     * https://leetcode.com/problems/word-search-ii/
     * LeetCode 212. Word Search II
     *
     * Solution :
     * 로직은 전 문제와 크게 차이가 있지 않다.
     * 다만 한 가지 이해가 가지 않는 것은 word의 마지막 글자 부터 맞추기 시작하는 것과
     * 첫 글자 부터 맞추기 시작하는 코드 사이에 실행시간 차이다.
     * 어떻게 마지막 글자 부터 매칭을 시작했다고 해서 1440ms가 1ms가 되지???
     * 도저히 이해가 가지 않는다.
     *
     * 1ms 풀이는 다른 풀이를 참고한 것이다.
     *
     * result : 1, 1440ms
     *
     * Other Solution :
     * trie를 이용한 풀이도 있었다.
     *
     * result : 74ms
     */

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();

        for (String word : words)
            if (isContain(word, board)) ans.add(word);

        return ans;
    }

    public boolean isContain(String word, char[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (search(word, i, j, word.length() - 1, board))
                    return true;

        return false;
    }

    public boolean search(String word, int x, int y, int index, char[][] board) {
        if (index < 0) return true;
        if (x < 0 || y < 0 || x == board.length || y == board[0].length) return false;
        if (board[x][y] != word.charAt(index)) return false;

        board[x][y] = '#';
        boolean result = search(word, x + 1, y, index - 1, board)
                || search(word, x, y + 1, index - 1, board)
                || search(word, x - 1, y, index - 1, board)
                || search(word, x, y - 1, index - 1, board);
        board[x][y] = word.charAt(index);
        return result;
    }

    /**
     * ==============================================
     */

    public List<String> trieSolution(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}

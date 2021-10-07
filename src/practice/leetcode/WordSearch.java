package practice.leetcode;

import java.util.Arrays;

public class WordSearch {
    /**
     * https://leetcode.com/problems/word-search/
     * LeetCode 79. Word Search
     *
     * Solution :
     * 해답과 로직에 차이는 없다.
     * 처음엔 visited를 매번 깊은 복사후 인자로 넘겨주었는데
     * 이 부분 하나만 빼고 나니 10배 이상 빨라졌다. (108ms)
     *
     * result : 108, 1926ms
     *
     * Better :
     * visited를 xor연산으로 대체해 변태같이 풀었다.
     *
     * result : 72ms
     */

    char[][] board;
    char[] word;
    int[][] dXdY = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        WordSearch instance = new WordSearch();
        instance.better(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'E', 'S'},
                        {'A', 'D', 'E', 'E'}},
                "ABCESEEEFS");
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word.toCharArray();

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == word.charAt(0))
                    if (search(new boolean[board.length][board[0].length], i, j, 0))
                        return true;

        return false;
    }

    public boolean search(boolean[][] visited, int x, int y, int length) {
        if (visited[x][y]) return false;
        if (word.length == length + 1
                && board[x][y] == word[length]) return true;
        if (board[x][y] != word[length]) return false;
        visited[x][y] = true;


        for (int[] xy : dXdY) {
            int dx = x + xy[0];
            int dy = y + xy[1];
            if (dx < 0 || dx >= board.length) continue;
            if (dy < 0 || dy >= board[0].length) continue;

            if (board[dx][dy] == word[length + 1]
                    && search(visited, dx, dy, length + 1))
                return true;
        }
        visited[x][y] = false;
        return false;
    }


    public boolean better(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (exist(board, x, y, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, char[] word, int i) {
        if (i == word.length) return true;
        if (x < 0 || y < 0 || x == board.length || y == board[x].length) return false;
        if (board[x][y] != word[i]) return false;
        board[x][y] ^= 256;
        boolean exist = exist(board, x, y + 1, word, i + 1)
                || exist(board, x, y - 1, word, i + 1)
                || exist(board, x + 1, y, word, i + 1)
                || exist(board, x - 1, y, word, i + 1);
        board[x][y] ^= 256;
        return exist;
    }
}

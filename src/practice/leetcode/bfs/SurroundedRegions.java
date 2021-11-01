package practice.leetcode.bfs;

public class SurroundedRegions {
    /**
     * https://leetcode.com/problems/surrounded-regions/
     * LeetCode 130. Surrounded Regions
     *
     * My Solution :
     * 모든 element를 탐색하면서 'O'가 나오면 bfs로 이어져 있는 'O'들을 탐색하고,
     * surrounded라면 'X'로 바꾸는 식으로 풀었다.
     * bfs는 queue로, bfs로 탐색하는 과정에서 방문한 위치들은 list에 넣고 한꺼 번에 변환
     *
     * result : 47ms 95%
     *
     * Better Solution :
     * 먼저 surround 되어 있지 않은 'O' region을 찾아 마킹한다('*')
     * 후에 완전탐색으로 변환
     *
     * result : 1ms 99.8%
     */

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') markRegion(board, i, 0);
            if (board[i][board[0].length - 1] == 'O') markRegion(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') markRegion(board, 0, i);
            if (board[board.length - 1][i] == 'O') markRegion(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    public void markRegion(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1) return;
        if (board[x][y] != 'O') return;
        board[x][y] = '*';

        markRegion(board, x + 1, y);
        markRegion(board, x - 1, y);
        markRegion(board, x, y + 1);
        markRegion(board, x, y - 1);
    }
}

package practice.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    /**
     * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/submissions/
     * LeetCode 1926. Nearest Exit from Entrance in Maze
     *
     * My Solution :
     * bfs
     *
     * Time Complexity : O(n)
     * result : 5ms
     *
     */
    public static void main(String[] args) {
        NearestExitFromEntranceInMaze instance = new NearestExitFromEntranceInMaze();
        instance.nearestExit(new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}}, new int[]{1,2});
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true;
        queue.offer(entrance);
        int distance = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            while (size > 0) {
                int[] current = queue.poll();
                int row = current[0], col = current[1];
                size--;
                if ((row == 0 || col == 0
                        || row == maze.length - 1
                        || col == maze[0].length - 1)
                        && (row != entrance[0] || col != entrance[1]))
                    return distance;

                if (row < maze.length - 1
                        && maze[row + 1][col] != '+'
                        && !visited[row + 1][col]) {
                    visited[row + 1][col] = true;
                    queue.offer(new int[]{row + 1, col});
                }

                if (row > 0
                        && maze[row - 1][col] != '+'
                        && !visited[row - 1][col]) {
                    visited[row - 1][col] = true;
                    queue.offer(new int[]{row - 1, col});
                }

                if (col < maze[0].length - 1
                        && maze[row][col + 1] != '+'
                        && !visited[row][col + 1]) {
                    visited[row][col + 1] = true;
                    queue.offer(new int[]{row, col + 1});
                }

                if (col > 0
                        && maze[row][col - 1] != '+'
                        && !visited[row][col - 1]) {
                    visited[row][col - 1] = true;
                    queue.offer(new int[]{row, col - 1});
                }
            }
        }
        return -1;
    }
}

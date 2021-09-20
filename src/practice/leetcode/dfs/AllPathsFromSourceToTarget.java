package practice.leetcode.dfs;

import java.util.*;

public class AllPathsFromSourceToTarget {
    /**
     * https://leetcode.com/problems/all-paths-from-source-to-target/submissions/
     * LeetCdoe 797. All Paths From Source to Target
     *
     * My Solution :
     * 1. 각 경우의 수를 dfs 로 하나 하나 찾아 들어간다
     * 2. 각 경로에 대한 List 를 각각 생성해 합친다
     * result : 5-16ms
     *
     * Other Solution : 다른 사람들의 풀이고 크게 다르진 않았다.
     * 다만 객체생성이 덜 이루지기 때문에 조금 더 빠른것 같다
     *
     * result : 3-5ms
     */
    public static void main(String[] args) {
        int[][] array = {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(array));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> joined = new ArrayList<>();
        Arrays.stream(graph[0])
                .mapToObj(i -> findPath(graph, i, new ArrayList<>(List.of(0))))
                .forEach(joined::addAll);
        return joined;
    }

    public static List<List<Integer>> findPath(int[][] graph, int index, List<Integer> path) {
        List<Integer> addedPath = new ArrayList<>(path);
        addedPath.add(index);
        if (index == graph.length - 1)  return new ArrayList<>(List.of(addedPath));


        List<List<Integer>> joined = new ArrayList<>();
        for (int i : graph[index]) {
            List<List<Integer>> findPath = findPath(graph, i, addedPath);
            joined.addAll(findPath);
        }
        return joined;
    }
}

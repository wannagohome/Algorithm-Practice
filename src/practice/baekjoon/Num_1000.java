package practice.baekjoon;

import java.io.*;
import java.util.Arrays;

public class Num_1000 {
    /**
     * https://www.acmicpc.net/problem/1000
     * BaekJoon 1000. A+B
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();
        int ans = Arrays.stream(s.split(" "))
                .map(Integer::parseInt).mapToInt(i -> i).sum();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}

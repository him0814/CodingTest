package Baekjoon;

//백준 1932번 정수삼각형

import java.io.*;
import java.util.*;

public class Baekjoon_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<=i; j++)
                dp[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] += dp[i-1][0];
            dp[i][i] += dp[i-1][i-1];
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }
        Arrays.sort(dp[n-1]);
        System.out.println(dp[n-1][n-1]);
    }
}

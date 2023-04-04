package Baekjoon;

//백준 9465번 스티커

import java.io.*;
import java.util.*;

public class Baekjoon_9465 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int[][] dp = new int[2][n+1];
            dp[0][1] = Integer.parseInt(st.nextToken());
            dp[1][1] = Integer.parseInt(st2.nextToken());

            for(int j=2; j<=n; j++){
                dp[0][j] = Math.max(dp[1][j-1] , dp[1][j-2])+Integer.parseInt((st.nextToken()));
                dp[1][j] = Math.max(dp[0][j-1] , dp[0][j-2])+Integer.parseInt((st2.nextToken()));
            }
            int res = Math.max(dp[0][n], dp[1][n]);
            sb.append(res).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }
}

package Baekjoon;

import java.io.*;

//백준 1463번 1로 만들기

public class Baekjoon_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + 1;
            if(i%3 == 0){
                dp[i] = Math.min(dp[i/3]+1, dp[i]);
            }
            if(i%2 == 0){
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}

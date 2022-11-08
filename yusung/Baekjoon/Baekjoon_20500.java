package Baekjoon;

import java.io.*;
import java.util.*;

//백준 20500번 Ezreal 여눈부터 가네 ㅈㅈ

public class Baekjoon_20500 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[1514][3];
		
		dp[0][0] = 0;		
		dp[0][1] = 1;
 		dp[0][2] = 1;
				
		if (N == 1) {
			System.out.println(0);
		} else {
			for (int i = 1; i < N-1; i++) {
				dp[i][0] = (dp[i - 1][1] + dp[i - 1][2])%1000000007;
				dp[i][1] = (dp[i - 1][0] + dp[i - 1][2])%1000000007;
				dp[i][2] = (dp[i - 1][0] + dp[i - 1][1])%1000000007;
			}
			System.out.println(dp[N-2][1]);
		}		
	}
}

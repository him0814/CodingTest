package BOJ;

/*
백준 #20500 이즈리얼 여눈부터 가네

3의 배수이면서 5의 배수여야만 15의 배수
맨 뒷자리는 무조건 5 고정
______5 이런 숫자인데 앞에가 1과 5로만 구성
앞의 각자리 숫자들의 합을 3으로 나누었을때 나머지는 0 1 2 중 하나
0 1 2 와 5를 더했을 때 3의 배수인 것은 1+5 
따라서 일의 자리 숫자가 5이면서  앞의 숫자들의 합 / 3의 나머지가 1인 숫자를 찾으면됌



 */

import java.io.*;
import java.util.*;

public class boj_20500 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[3][n+1];
		
		if(n == 1) {
			System.out.println(0);
			return;
		}
		
		dp[0][0] = 0;
		dp[0][1] = 1;
		dp[0][2] = 1;
		dp[1][0] = 2;
		dp[1][1] = 1;
		dp[1][2] = 1;
		for(int i = 3; i <= n; i++) {
			dp[0][i] = (dp[1][i-1] + dp[2][i-1]) % 1000000007;
			dp[1][i] = (dp[0][i-1] + dp[2][i-1]) % 1000000007;
			dp[2][i] = (dp[0][i-1] + dp[1][i-1]) % 1000000007;
		}
		
 		System.out.println(dp[0][n]);
	}
}

package BOJ;

/*
���� #20500 ����� �������� ����

3�� ����̸鼭 5�� ������߸� 15�� ���
�� ���ڸ��� ������ 5 ����
______5 �̷� �����ε� �տ��� 1�� 5�θ� ����
���� ���ڸ� ���ڵ��� ���� 3���� ���������� �������� 0 1 2 �� �ϳ�
0 1 2 �� 5�� ������ �� 3�� ����� ���� 1+5 
���� ���� �ڸ� ���ڰ� 5�̸鼭  ���� ���ڵ��� �� / 3�� �������� 1�� ���ڸ� ã�����



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

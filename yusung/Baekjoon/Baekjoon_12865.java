package Baekjoon;

import java.io.*;
import java.util.*;

//백준 12865 평범한 배낭
public class Baekjoon_12865 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 버틸수 있는 무게
		
		int[][] dp = new int[N+1][K+1];
		dp[0][0] = 0;
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken()); // 물건의 무게
			V[i] = Integer.parseInt(st.nextToken()); // 물건의 가치
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.print(W[i]+",");
//			System.out.print(V[i]+",");
//		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				dp[i][j] = dp[i-1][j];
				int nw = j-W[i]; // 더 담을수 있는 무게 (현재 배낭무게 - 현재 물건 무게)
				if(nw >= 0) {					
					dp[i][j] = Math.max(dp[i][j], (dp[i-1][nw])+V[i]);
				}
			}
		}
		System.out.println(dp[N][K]);
//		for(int i=0; i<N+1; i++) {
//			for(int j=0; j<K+1; j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}
	}
}

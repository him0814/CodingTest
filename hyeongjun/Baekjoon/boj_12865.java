package BOJ;

/*
백준 #12865 평범한 배낭

고른 물품의 무게의 합 < n
그 물품들의 가치가 최댓값이 되어야함

n = 1 일 때 
n = 2 일 때
...
n = 7 일 때

 */

import java.io.*;
import java.util.*;

public class boj_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[n+1];
		int[] value = new int[n+1];
		int[] bag = new int[k+1]; // 무게는 7까지 이므로 k+1
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			// k = 7부터 최대 무게 초과 안 할 때 까지 for문
			for(int j = k; 0 <= j - weight[i]; j--) {
				bag[j] = Math.max(bag[j], bag[j - weight[i]] + value[i]);
			}
		}
		
		System.out.println(bag[k]);
	}
}

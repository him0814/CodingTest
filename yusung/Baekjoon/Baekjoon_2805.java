package Baekjoon;

import java.io.*;
import java.util.*;

//백준 2805번 나무 자르기

public class Baekjoon_2805 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 나무의 개수
		int M = Integer.parseInt(st.nextToken()); // 가져갈 나무의 길이의 합
		
		int[] tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		// 10 15 17 20
		// 0 0 2 5 -> 7
		int left = 0;//0
		int right = tree[N-1];//tree[3] 20				
		
		while(left <= right) {
			
			int mid = (left+right)/2;
			long sum =0;
			
			for(int i=0; i<N;i++) {
				if(tree[i] > mid) {
					sum += tree[i] - mid;
				}
			}	
			if(sum == M) {				
				right = mid;
				break;
			}
			if(sum >= M) {
				left = mid+1;
			}
			else {
				right = mid-1;
			}			
		}	
		System.out.println(right);
	}
}

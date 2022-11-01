package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1654번 랜선 자르기

public class Baekjoon_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
		int[] arr = new int[K];

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		long left = 1;
		long right = arr[K-1];	
		
		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;

			for (int i = 0; i < K; i++) {
				sum += arr[i] / mid;				
			}	
			
			if (sum >= N) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(right);
	}
}

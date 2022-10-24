package baekjoon;
//백준 1654 랜선 자르기

import java.io.*;
import java.util.*;

public class LAN_cable_cut {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		
		long left = 0;
		long mid = 0;
		long right = 0;
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, arr[i]);
		}
		right += 1;
		
		while(left < right) {
			mid = (left + right) / 2;
			long sum = 0;
			
			for(int cnt: arr) {
				sum += (cnt / mid);
			}
			
			if(sum >= N) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		System.out.println(left - 1);
	}
}

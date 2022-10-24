package BOJ;

/*
백준 #1653 랜선자르기
 */

import java.io.*;
import java.util.*;

public class boj_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		long[] arr = new long[k];
		
		for(int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long left = 1;
		long right = arr[k-1];
		
		while(left <= right) {
			long mid = (left+right)/2;
			long sum = 0;
			
			for(int i = 0; i < k; i++) {
				sum += arr[i] / mid;
			}
			
			if(sum >= n) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);
	}
}

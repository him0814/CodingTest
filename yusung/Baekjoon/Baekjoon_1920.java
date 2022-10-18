package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1920번 수 찾기

public class Baekjoon_1920 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		int[] arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<M; i++) {
			if(binarySearch(arr, arr2[i], 0, N-1)) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	static boolean binarySearch(int[] A, int target, int left, int right) {
		while(left <= right) {
			int mid = (left+right)/2;
			
			if(A[mid] == target) {
				return true;
			}
			
			if(A[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid-1;
			}
		}
		return false;		
	}
	
}

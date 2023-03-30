package baekjoon;
//백준 11053 가장 긴 증가하는 부분 수열

import java.io.*;
import java.util.*;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		} 
		
		for(int i=0; i<N; i++) {
			arr2[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr1[j] < arr1[i] && arr2[i] < arr2[j] + 1) {
					arr2[i] = arr2[j] + 1;
				}
			}
		}
		 
		int res = -1;
		for(int i=0; i<N; i++) {
			res = Math.max(arr2[i], res);
		}
		System.out.println(res);
	}
}

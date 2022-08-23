package baekjoon;
//연속합 백준 1912

import java.io.*;
import java.util.*;

public class ConsecutiveSum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] tmp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		tmp[0] = arr[0];
		int max = arr[0];
		
		for(int i=1; i<n; i++) {
			tmp[i] = Math.max(tmp[i-1] + arr[i], arr[i]);
			max = Math.max(tmp[i], max);
		}
		System.out.println(max);
	}
}

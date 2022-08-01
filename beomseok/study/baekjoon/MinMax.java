package baekjoon;

// 백준 최소,최대 10818
// 정수 N개. 최소,최대값 구하기
//--------입력 예제-------
// 첫째줄 정수의 개수  N (1 ≤ N ≤ 1,000,000)
// 둘째줄 N개의 정수 공백으로 구분 

import java.io.*;
import java.util.*;

public class MinMax {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[0] + " " +arr[n-1]);
	}
}

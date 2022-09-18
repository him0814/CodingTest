package study1;

// 백준 #1081
// N개 정수 중 최솟값, 최댓값 구하기
// 첫째 줄에 정수 N(1<=N<=1,000,000)
// 둘째 줄 N개의 정수를 공백으로 구분해서 주어짐
// 첫째 줄에 주어진 정수 N개의 최솟값, 최댓값 출력하기

import java.io.*;
import java.util.*;

public class boj_10818 {

	public static void main(String[] args) throws IOException {
		
		// BufferedReader -> 입력을 한 줄 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열 합치기
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); // br.readLine() br에 저장된 한 줄을 읽어옴
		
		// 문자열을 공백 기준으로 자름
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); //
		}
		
		
		Arrays.sort(arr);  // 배열 오름차순 정렬
		
//		문자열을 공백 기준으로 잘렸는지 확인하기 위함		
//		for(int i = 0; i<n; i++) {
//			System.out.println(arr[i]);
//		}
//		
//		System.out.println(arr[0] + " " + arr[n-1]); 
		
		
		int min = arr[0]; // int max = Integer.MIN_VALUE; 
		int max = arr[0]; // int min = Integer.MAX_VALUE;
		
		for(int i = 1; i<n; i++) {
			if(arr[i] > max)
				max = arr[i];
			if(arr[i] < min)
				min = arr[i];
		}
		
		// StringBuilder로 문자열 합침
		sb.append(arr[0] + " " + arr[n-1]); // 7 35
		System.out.println(sb.toString());  // 출력
		
	}
	
}

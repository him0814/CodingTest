package Baekjoon;

import java.io.*;
import java.util.*;

// 백준 13164번 행복 유치원
// 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이만큼 티셔츠비용이 듬
// 비용의 합을 최소로 하고싶음

public class Baekjoon_13164 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 유치원 원생의 수
		int K = Integer.parseInt(st.nextToken()); // 조의 개수
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());			
		}	
		int[] arr2 = new int[N-1];
		for(int i=0; i<N-1; i++) {
			arr2[i] = arr[i+1] - arr[i];
		}
		Arrays.sort(arr2);
		int sum = 0;
		for(int i=0; i<N-K; i++) {
			sum += arr2[i];
		}
		System.out.println(sum);
		
	}
}

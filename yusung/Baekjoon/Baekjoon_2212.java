package Baekjoon;

import java.io.*;
import java.util.*;

//백준 2212 센서

public class Baekjoon_2212 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int[] dis = new int[N];
		
		for(int i=0; i<N-1; i++) {
			dis[i] = arr[i+1] - arr[i];
		}		
		
		Arrays.sort(dis);
		int sum = 0;
		for(int i=0; i<=N-K; i++) {
			sum+=dis[i];
		}
		
		System.out.println(sum);
	}
}

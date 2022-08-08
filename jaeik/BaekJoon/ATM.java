package BaekJoon;

// N명의 사람 줄
// 기다리는 시간의 합이 최소

import java.io.*;
import java.util.*;

public class ATM {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int result = 0;
		int time = 0;
		for(int i = 0; i < N; i++) {
			time += arr[i];
			result += time;
		}
		
		System.out.print(result);
	}
}

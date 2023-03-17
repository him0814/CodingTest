package baekjoon;

//백준 2212 센서

import java.io.*;
import java.util.*;

public class Sensor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int[] distance = new int[N-1];
		for(int i=0; i<N-1; i++) {
			distance[i] = arr[i+1] - arr[i];
		}
		
		Arrays.sort(distance);
		
		int res = 0;
		for(int i=0; i<N-K; i++) {
			res += distance[i];
		}
		
		System.out.println(res);
	}
}

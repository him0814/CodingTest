package Baekjoon;

import java.util.*;
import java.io.*;

//백준 10818번 최소, 최대

public class Baekjoon_10818 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//min, max값 지정 후 for문을 통해 비교
		int min = arr[0];
		int max = arr[0];
		
		for(int i=1; i<n; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		System.out.println(min + " " + max);

		//배열 정렬후 0번쨰 n-1값 출력(최소값 최대값 출력)
		//Arrays.sort(arr);
		//System.out.println(arr[0] + " " + arr[n - 1]);
	}
}
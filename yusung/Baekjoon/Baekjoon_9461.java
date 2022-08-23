package Baekjoon;

import java.io.*;

//백준 9461번 파도반 수열
//1 1 1 2 2 3 4 5 7 9
//arr[n] = arr[n-3]+arr[n-2]

public class Baekjoon_9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long arr[] = new long[100];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n > 3) {
				for (int j = 3; j <= n - 1; j++) {
					arr[j] = arr[j - 2] + arr[j - 3];
				}
			}
			sb.append(arr[n - 1] + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}

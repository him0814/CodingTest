package Baekjoon;

import java.io.*;
import java.util.*;

//백준 15650 N과 M(2)
//중복 허용X 1 4랑 4 1은 같은거로 취급 -> 4 1 은 출력하지 않음

public class Baekjoon_15650 {

	static int N;
	static int M;
	static int arr[];
	// static boolean visit[];

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		// visit = new boolean[N];
		dfs(0, 1);
		System.out.println(sb.toString());
	}

	public static void dfs(int depth, int at) {
		if (depth == M) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			System.out.println("depth : " + depth + " // arr[" +depth+"] : " + arr[depth]);
			dfs(depth + 1, i+1);
		}
		
	}
}

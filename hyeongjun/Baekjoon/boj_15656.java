package BOJ;

/*
¹éÁØ #15656 n°úm (7)
 */

import java.io.*;
import java.util.*;

public class boj_15656 {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		input = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);

		dfs(0);
		
		System.out.println(sb.toString());
	}

	public static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
				arr[depth] = input[i];
				dfs(depth + 1);
		}
	}
}

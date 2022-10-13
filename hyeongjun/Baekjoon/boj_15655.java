package BOJ;

/*
¹éÁØ #15655 n°úm (6)
 */

import java.io.*;
import java.util.*;

public class boj_15655 {

	static int N;
	static int M;
	static int[] arr;
	static int[] input;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		input = new int[N];
		visit = new boolean[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);

		dfs(0, 0);
		
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

		for (int i = at; i < N; i++) {
			if (!visit[depth]) {
				visit[depth] = true;
				arr[depth] = input[i];
				dfs(depth + 1, i+1);
				visit[depth] = false;
			}
		}
	}
}

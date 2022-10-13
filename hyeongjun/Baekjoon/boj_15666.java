package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
¹éÁØ #15666 n°úm (12)
 */

public class boj_15666 {
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

		dfs(0, 0);

		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth, int at) {
		if(depth == M) {
			for(int i = 0; i < arr.length; i++) {
				sb.append(arr[i]+ " ");
			}
			sb.append("\n");
			return;
		}
		
		int tmp = 0;
		
		for(int i = at; i < N; i++) {
			if(tmp != input[i]) {
				arr[depth] = input[i];
				tmp = input[i];
				dfs(depth+1, i);
			}
		}
	}
}

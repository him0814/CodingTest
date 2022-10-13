package BOJ;

/*
¹éÁØ #15663 n°úm (9)
 */

import java.io.*;
import java.util.*;

public class boj_15663 {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] input;
	static boolean[] visit;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		input = new int[N];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		dfs(0);
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth) {
		if(depth == M) {
			for(int i = 0; i < arr.length; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		int tmp = 0;
		
		for(int i = 0; i < N; i++) {
			if(visit[i]) {
				continue;
			}
			if(tmp != input[i]) {
				visit[i] = true;
				arr[depth] = input[i];
				tmp = input[i];
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}
}

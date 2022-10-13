package BOJ;

/*
백준 #15654 n과m (5)
 */

import java.io.*;
import java.util.*;

public class boj_15654 {
	static int N;
	static int M;
	static int[] input;
	static int[] arr;
	static boolean[] visit;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 입력예제를 담을 배열
		input = new int[N];
		// 출력을 담을 배열
		arr = new int[M];
		// 방문했는지 안했는지 알기 위한 배열
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
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
		
		for(int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = input[i];
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}
}

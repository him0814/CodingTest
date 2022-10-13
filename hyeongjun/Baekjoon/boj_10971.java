package BOJ;

/*
백준 #10971 외판원순회2
 */

import java.io.*;
import java.util.*;

public class boj_10971 {
	
	static int N;
	static int[][] travel;
	static boolean[] visit;
//	static int cost;
	static int min;
	static int tmp = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		travel = new int[N][N];
		visit = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				travel[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			visit[i] = true;
			dfs(0, i, i, 0);
		}
		
		System.out.println(tmp);
	}
	
	public static void dfs(int depth, int x, int y, int cost) {
		if(depth == N - 1) {
			if(travel[y][x] != 0) { // 다시 되돌아 왔을 때
				tmp = Math.min(tmp, cost + travel[y][x]);
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visit[i] && travel[y][i] != 0) {
				visit[i] = true;
				//cost += travel[y][i]
				dfs(depth+1, x, i, cost + travel[y][i]);
				visit[i] = false;
			}
		}
	}
}
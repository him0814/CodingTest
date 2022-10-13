package BOJ;


/*
백준 #2606 바이러스

0 1 0 0 1 0 0
1 0 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 0 1
1 1 0 0 0 1 0
0 0 0 0 1 0 0
0 0 0 1 0 0 0

 */

import java.io.*;
import java.util.*;

public class boj_2606 {
	
	static int n;
	static int pair;
	static int[][] arr;
	static boolean visit[];
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		pair = Integer.parseInt(br.readLine());
		visit = new boolean[n+1];
		
		for(int i = 0; i < pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		dfs(1);
		System.out.println(count);
	}
	
	public static void dfs(int x) {
		visit[x] = true;
		for(int i = 1; i <= n; i++) { // 1번 컴퓨터부터 n번 컴퓨터까지
			if(arr[x][i] == 1 && !visit[i]) {
				count++;
				dfs(i);
			}
		}
	}
}

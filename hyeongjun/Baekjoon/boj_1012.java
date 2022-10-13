package BOJ;

/*
백준 #1012 유기농 배추
 */

import java.io.*;
import java.util.*;

public class boj_1012 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int m; //가로길이
	static int n; //세로길이
	static int k; //배추 갯수
	static int[][] map; //배추map
	static boolean[][] visit;
	static int count;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_cnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[m][n];
			visit = new boolean[m][n];
			
			// 배추 있는 곳 '1'
			for(int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
			}
			
			count = 0;
			
			for(int k = 0; k < m; k++) {
				for(int l = 0; l < n; l++) {
					if(!visit[k][l] && map[k][l] == 1) {
						visit[k][l] = true;
						dfs(0, k, l);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth, int x, int y) {
		
//		visit[x][y] = true;
		
		if(depth == k) {
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
				continue;
			}
			
			if(!visit[nx][ny] && map[nx][ny] == 1) {
				visit[nx][ny] = true;
				dfs(depth+1, nx, ny);
			}
		}
	}
}

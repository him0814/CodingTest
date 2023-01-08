package BOJ;

/*
백준 #18428 감시피하기
*/

import java.io.*;
import java.util.*;

public class boj_2573 {
	
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int iceberg_area = 0;
		int year = 0;
		
		while(true) {
			// 빙산 녹이기
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] != 0 && !visit[i][j]) {
						dfs(i, j);
						iceberg_area++;
					}
				}
			}
			
			if(iceberg_area == 0) {
				System.out.println(0);
			}
			
			if(iceberg_area >= 2) {
				System.out.println(year);
				break;
			} 
			
			year++;
		}
	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
				continue;
			}
			
			if(map[nx][ny] != 0 && !visit[nx][ny]) {
				dfs(nx, ny);
			}
		}
		
	}
}

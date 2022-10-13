package BOJ;

/*
백준 #4963 섬의 개수
 */

import java.io.*;
import java.util.*;

public class boj_4963 {
	
	static int w;
	static int h;
	static int[][] map;
	static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
	static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
	static boolean[][] visit;
	static int count;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			visit = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			count = 0;
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
				continue;
			}
			
			if(map[nx][ny] == 1 && !visit[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
}

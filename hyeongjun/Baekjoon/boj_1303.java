package BOJ;

/*
백준 #1303 전쟁-전투
 */

import java.io.*;
import java.util.*;

public class boj_1303 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n;
	static int m;
	static int count;
	static char[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[m][n];
		visit = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int w_sum = 0;
		int b_sum = 0;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visit[i][j]) {
					count = 1;
					visit[i][j] = true;
					bfs(i, j);
					
					if(map[i][j] == 'W') {
						w_sum += count*count;
					} else {
						b_sum += count*count;
					}
				}
			}
		}
		
		System.out.println(w_sum+" "+b_sum);
		
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			x = now[0];
			y = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
					continue;
				}
				
				if(!visit[nx][ny] && map[nx][ny] == map[x][y]) {
					count++;
					visit[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
}

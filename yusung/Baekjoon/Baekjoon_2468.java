package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2468 {
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		int maxHeight = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > maxHeight) {
					maxHeight = map[i][j];
				}
			}
		}

		int max = 0;		
		for (int height = 0; height < maxHeight + 1; height++) {
			visit = new boolean[n][n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {					
					if (!visit[i][j] && map[i][j] > height) {
						cnt += dfs(i, j, height); 
					}

				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);

	}

	public static int dfs(int x, int y, int height) {
		visit[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x +dx[i];
			int ny = y +dy[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
				if(map[nx][ny]> height) {
					dfs(nx,ny, height);
				}
			}			
		}
		return 1;
	}
}

package BOJ;

/*
백준 #7576 토마토
 */

import java.io.*;
import java.util.*;

public class boj_7576 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<>();
	static int day = 0; // 최소 걸리는 일 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					visit[i][j] = true;
					q.offer(new int[] { i, j });
				}
			}
		}

		System.out.println(bfs());

	}

	public static int bfs() {
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int now_x = now[0];
			int now_y = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = now_x + dx[i];
				int ny = now_y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				
				if(!visit[nx][ny] && map[nx][ny] == 0) {
					visit[nx][ny] = true;
					map[nx][ny] = map[now_x][now_y] + 1;
					q.offer(new int[] {nx,ny});
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					return -1;
				}
				
				if(day < map[i][j]) {
					day = map[i][j];
				}
			}
		}
		
		if(day == 1) {
			return 0;
		} else {
			return day - 1;
		}
	}
}

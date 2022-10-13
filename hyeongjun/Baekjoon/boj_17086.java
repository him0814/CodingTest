package BOJ;

/*
백준 #17086 아기상어2

0 0 S 0
0 0 0 0
S 0 0 0
2 0 0 0
1 1 2 S
상어가 없는 곳에서 상어가 있는 곳까지의 최대 거리를 구하는 문제

 */

import java.io.*;
import java.util.*;

public class boj_17086 {

	static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visit;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

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
				if (map[i][j] == 0) {
					visit[i][j] = true;
					bfs(i, j);
				}
			}
		}

		System.out.println(answer);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		int cnt = 0;

		while (!q.isEmpty()) {
			// for문이 없으면 bfs 시작점에서 1을 만날 때 까지의 최대값
			// for문이 있으면 8방향을 탐색하면서 1을 만나면 return -> 특정 위치에서 가장 인접한 1을 만났을때 return
			for (int i = 0; i < q.size(); i++) { 
				int[] now = q.poll();
				int now_x = now[0];
				int now_y = now[1];

				if (map[now_x][now_y] == 1) {
					answer = Math.max(answer, cnt);
					return;
				}

				for (int j = 0; j < 8; j++) {
					int nx = now_x + dx[j];
					int ny = now_y + dy[j];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) {
						continue;
					}

					visit[nx][ny] = true;
					q.offer(new int[] { nx, ny });

				}
			}
			cnt++;
		}
	}
}

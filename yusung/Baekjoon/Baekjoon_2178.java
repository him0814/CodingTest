package Baekjoon;

import java.util.*;
import java.io.*;

//백준 2178번 미로탐색

public class Baekjoon_2178 {
	static int[][] arr;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0);
		System.out.println(arr[N - 1][M - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		q.offer(new int[] { x, y });
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int now[] = q.poll();
			int nowx = now[0];
			int nowy = now[1];

			for (int i = 0; i < 4; i++) {
				int nx = nowx + dx[i];
				int ny = nowy + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}

				if (!visit[nx][ny] && arr[nx][ny] == 1) {
					q.offer(new int[] { nx, ny });
					visit[nx][ny] = true;
					arr[nx][ny] = arr[nowx][nowy] + 1;
				}
			}
		}
	}
}

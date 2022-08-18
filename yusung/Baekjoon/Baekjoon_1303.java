package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1303번 전투

public class Baekjoon_1303 {
	static int N;
	static int M;
	static int wnum = 0;
	static int bnum = 0;
	static boolean[][] visit;
	static char[][] soldier;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		soldier = new char[M][N];

		// 예제 입력받기
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			char c = ' ';
			for (int j = 0; j < N; j++) {
				c = str.charAt(j);
				soldier[i][j] = c;
			}
		}

		visit = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == false && soldier[i][j]=='B') {
					visit[i][j] = true;
					bfs(i, j, 'B');
				}
				if (visit[i][j] == false && soldier[i][j]=='W') {
					visit[i][j] = true;
					bfs(i, j, 'W');
				}
			}
		}

		System.out.println(wnum+" "+bnum);	
	}

	static void bfs(int x, int y, char color) {
		int count = 1;
		Queue<int[]> q = new LinkedList<>();

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		q.offer(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N || visit[nx][ny]) {
					continue;
				}
				if (color == soldier[nx][ny]) {
					visit[nx][ny] = true;
					q.offer(new int[] { nx, ny });
					count++;
				}
			}
		}
		if (color == 'W') {
			wnum += count * count;
		} else if (color == 'B') {
			bnum += count * count;
		}
	}
}

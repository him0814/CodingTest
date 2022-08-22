package baekjoon;
//토마토 백준 7576

import java.io.*;
import java.util.*;

public class Tomato {
	static int n, m;
	static int arr[][];
	static boolean visit[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] == 1) {
					q.offer(new int[] {i, j});
				}
			}
		}
		System.out.println(bfs());
	}

	public static int bfs() {
		while (!q.isEmpty()) {
			int now[] = q.poll();
			int x = now[0];
			int y = now[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (arr[nx][ny] == 0 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new int[] { nx, ny });
						arr[nx][ny] = arr[x][y] + 1;
					}
				}
			}
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					return -1;
				}
				res = Math.max(arr[i][j], res);
			}
		}
		if (res == 1) {
			return 0;
		} else {
			return res - 1;
		}

	}
}

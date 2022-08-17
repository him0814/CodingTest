package baekjoon;
//미로 탐색 백준 2178

import java.io.*;
import java.util.*;

public class MazeExploration {
	static int n, m;
	static int arr[][];
	static boolean visit[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		visit[0][0] = true;
		bfs(0, 0);
		System.out.println(arr[n - 1][m - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });

		while (!q.isEmpty()) {
			int now[] = q.poll();
			x = now[0];
			y = now[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (arr[nx][ny] == 1 && !visit[nx][ny]) {
						q.offer(new int[] { nx, ny });
						arr[nx][ny] = arr[x][y] + 1;
						visit[nx][ny] = true;
					}
				}
			}
		}
	}
}

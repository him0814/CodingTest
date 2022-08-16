package baekjoon;
//전쟁 - 전투 백준 1303

import java.io.*;
import java.util.*;

public class War_Battle {
	static int n, m;
	static int b, w;
	static int res;
	static char arr[][];
	static boolean visit[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new char[m][n];
		visit = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		w = 0;
		b = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					res = 1;
					visit[i][j] = true;
					bfs(i, j);
					if (arr[i][j] == 'W') {
						w += res * res;
					} else {
						b += res * res;
					}
				}
			}
		}
		System.out.println(w + " " + b);
	}

	public static void bfs(int x, int y) {
		q.offer(new int[] { x, y });
		res = 1;
		while (!q.isEmpty()) {
			int tmp[] = q.poll();
			x = tmp[0];
			y = tmp[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= m || ny >= n)
					continue;
				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
					if (arr[nx][ny] == arr[x][y] && !visit[nx][ny]) {
						q.offer(new int[] { nx, ny });
						visit[nx][ny] = true;
						res += 1;
					}
				}
			}
		}
	}
}

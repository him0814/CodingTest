package baekjoon;
//아기 상어2 백준 17086

import java.io.*;
import java.util.*;

public class BabyShark2 {
	static int n, m;
	static int max = 0;
	static int res = 0;
	static int arr[][];
	static boolean visit[][];
	static int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit = new boolean[n][m];
				if(arr[i][j] == 0) {
					max = bfs(i, j);
					res = Math.max(max, res);
				}
			}
		}
		System.out.println(res);
	}

	public static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y, 0 });
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int now[] = q.poll();
			x = now[0];
			y = now[1];
			int z = now[2];

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (!visit[nx][ny]) {
						if(arr[nx][ny] == 1) {
							return z+1;
						}
						visit[nx][ny] = true;
						q.offer(new int[] { nx, ny, z+1 });	
					}
				}
			}
		}
		return 0;
	}
}

package BOJ;

/*
���� #1261 �˰���

bfs

0�� �� wall_cnt �״�� 
1�� �� wall_cnt++ 

0�� ���� offerLast
1�� ���� offerFisrt 
-> 0�� ���� ���� �湮�ϵ��� ����

0�� �� ��� �湮 �� 1 �湮
 */

import java.io.*;
import java.util.*;

public class boj_1261 {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map;
	static int[][] wall_cnt;
	static boolean[][] visit;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// ������ �迭�� �� �� ���� ����
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visit = new boolean[n][m];
		wall_cnt = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs();

		System.out.println(wall_cnt[n - 1][m - 1]);
	}

	private static void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offerLast(new int[] {0, 0});
		visit[0][0] = true;
		
		while (!dq.isEmpty()) {
			int[] tmp = dq.pollLast();
			int x = tmp[0];
			int y = tmp[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				
				if (map[nx][ny] == 0 && !visit[nx][ny]) {
					wall_cnt[nx][ny] = wall_cnt[x][y];
					dq.offerLast(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
				if (map[nx][ny] == 1 && !visit[nx][ny]) {
					wall_cnt[nx][ny] = wall_cnt[x][y] + 1;
					dq.offerFirst(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
		}
	}
}
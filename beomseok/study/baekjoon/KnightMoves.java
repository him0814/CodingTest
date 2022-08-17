package baekjoon;
//나이트의 이동 백준 7562

import java.io.*;
import java.util.*;

public class KnightMoves {
	static int t, l;
	static int nowA, nowB;
	static int nextA, nextB;
	static int arr[][];
	static boolean visit[][];
	static int dx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int dy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			l = Integer.parseInt(br.readLine());
			arr = new int[l][l];
			visit = new boolean[l][l];

			StringTokenizer st = new StringTokenizer(br.readLine());
			nowA = Integer.parseInt(st.nextToken());
			nowB = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			nextA = Integer.parseInt(st.nextToken());
			nextB = Integer.parseInt(st.nextToken());

			bfs(nowA, nowB);
			sb.append(arr[nextA][nextB]).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int now[] = q.poll();
			x = now[0];
			y = now[1];

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (x == nx && y == ny)
					continue;
				if (nx >= 0 && ny >= 0 && nx < l && ny < l) {
					if (!visit[nx][ny]) {
						q.offer(new int[] { nx, ny });
						visit[nx][ny] = true;
						arr[nx][ny] = arr[x][y] + 1;
					}
				}
			}
		}
	}
}

package baekjoon;
//섬의 개수 백준 4963

import java.io.*;
import java.util.*;

public class NumberOfIslands {
	static int w, h;
	static int cnt;
	static int arr[][];
	static boolean visit[][];
	static int row[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int col[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			arr = new int[h][w];
			visit = new boolean[h][w];
			cnt = 0;

			if (w == 0 && h == 0)
				break;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int a = 0; a < h; a++) {
				for (int b = 0; b < w; b++) {
					if (arr[a][b] == 1 && !visit[a][b]) {
						dfs(a, b);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	public static void dfs(int r, int c) {
		visit[r][c] = true;

		for (int i = 0; i < 8; i++) {
			int nr = r + row[i];
			int nc = c + col[i];
			if (nr < 0 || nc < 0 || nr >= h || nc >= w)
				continue;
			if (nr >= 0 && nc >= 0 && nr < h && nc < w) {
				if (arr[nr][nc] == 1 && !visit[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}
}

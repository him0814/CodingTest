package baekjoon;
//유기농 배추 백준 1012

import java.io.*;
import java.util.*;

public class OrganicCabbage {
	static int t;
	static int n, m, k;
	static int x, y;
	static int cnt;
	static int arr[][];
	static boolean visit[][];
	static int row[] = { -1, 1, 0, 0 };
	static int col[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			arr = new int[m][n];
			visit = new boolean[m][n];
			cnt = 0;

			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}

			for (int a = 0; a < m; a++) {
				for (int b = 0; b < n; b++) {
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

		for (int i = 0; i < 4; i++) {
			int nr = r + row[i];
			int nc = c + col[i];
			if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
				if (arr[nr][nc] == 1 && !visit[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}
}

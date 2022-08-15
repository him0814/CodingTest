package baekjoon;
//안전 영역 백준 2468

import java.io.*;
import java.util.*;

public class SafeArea {
	static int n;
	static int arr[][];
	static boolean visit[][];
	static int row[] = { -1, 1, 0, 0 };
	static int col[] = { 0, 0, -1, 1 };
	static int cnt;
	static int maxheight;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		maxheight = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (maxheight < arr[i][j]) {
					maxheight = arr[i][j];
				}
			}
		}

		max = 0;
		for (int h = 0; h < maxheight; h++) {
			visit = new boolean[n][n];
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] > h && !visit[i][j]) {
						cnt++;
						dfs(i, j, h);
					}
				}
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
	}

	public static void dfs(int r, int c, int h) {
		visit[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + row[i];
			int nc = c + col[i];
			if(nr < 0 || nc < 0 || nr >= n|| nc >= n)
				continue;
			if (arr[nr][nc] <= h && visit[nr][nc])
				continue;
			if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
				if (arr[nr][nc] > h && !visit[nr][nc]) {
					dfs(nr, nc, h);
				}
			}
		}
	}
}

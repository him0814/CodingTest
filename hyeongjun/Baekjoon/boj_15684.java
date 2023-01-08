package BOJ;

/*
백준 #15684 사다리 조작

가로선 오른쪽 1
가론선 왼쪽 -1

가로선 x / x+1 사이 가로선은 무조건 짝수개 여야함
  -> 갔다가 돌아와야하기 때문에



 */

import java.io.*;
import java.util.*;

public class boj_15684 {

	static int n, m, h;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[a][b + 1] = -1;
		}

		// map 출력
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		// 추가 사다리 갯수가 0,1,2,3 개일때 모두 봐줘야함
		for (int i = 0; i <= 3; i++) {
			if (dfs(0, 0, i)) {
				return;
			}
		}
		System.out.println(-1);
	}

	public static boolean dfs(int x, int cnt, int depth) {
		if (cnt == depth) {
			if (check()) {
				System.out.println(depth);
				return true;
			}
			return false;
		}

		for (int i = x; i <= h; i++) {
			for (int j = 1; j < n; j++) {
				if (map[i][j] != 0 || map[i][j + 1] != 0) {
					continue;
				}

				// map[i][j] == 0 / ap[i][j+1] == 0 일때만
				// 즉, 가로선이 없을 때
				map[i][j] = 1;
				map[i][j + 1] = -1;
				// 연속으로 가로선이 있으면 안되니까 j+2
				if (dfs(i, cnt + 1, depth)) {
					return true;
				}
				map[i][j] = 0;
				map[i][j + 1] = 0;
			}
		}
		return false;
	}

	public static boolean check() {
		for (int i = 1; i <= n; i++) {
			int nx = 1;
			int ny = i;

			while (nx <= h) {
				if (map[nx][ny] == 1) {
					ny++;
				} else if (map[nx][ny] == -1) {
					ny--;
				}
				nx++;
			}
			if (ny != i) {
				return false;
			}
		}
		return true;
	}
}

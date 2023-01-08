package BOJ;

/*
���� #15684 ��ٸ� ����

���μ� ������ 1
���м� ���� -1

���μ� x / x+1 ���� ���μ��� ������ ¦���� ������
  -> ���ٰ� ���ƿ;��ϱ� ������



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

		// map ���
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		// �߰� ��ٸ� ������ 0,1,2,3 ���϶� ��� �������
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

				// map[i][j] == 0 / ap[i][j+1] == 0 �϶���
				// ��, ���μ��� ���� ��
				map[i][j] = 1;
				map[i][j + 1] = -1;
				// �������� ���μ��� ������ �ȵǴϱ� j+2
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

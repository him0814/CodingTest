package baekjoon;

//น้มุ 3055 ลปรโ

import java.io.*;
import java.util.*;

public class SLIKAR {
	static int R, C;
	static Character arr[][];
	static Queue<int[]> h = new LinkedList<>();
	static Queue<int[]> w = new LinkedList<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new Character[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'S') {
					h.add(new int[] { i, j, 0 });
				} else if (arr[i][j] == '*') {
					w.add(new int[] { i, j });
				}
			}
		}

		bfs();

		if (res == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(res);
		}
	}

	public static void bfs() {
		while (!h.isEmpty()) {
			int ws = w.size();
			for (int i = 0; i < ws; i++) {
				int[] dw = w.poll();
				for (int j = 0; j < 4; j++) {
					int nx = dw[0] + dx[j];
					int ny = dw[1] + dy[j];
					if (nx < 0 || nx >= R || ny < 0 || ny >= C || arr[nx][ny] != '.') {
						continue;
					}
					arr[nx][ny] = '*';
					w.add(new int[] { nx, ny });
				}
			}
			int hs = h.size();
			for (int i = 0; i < hs; i++) {
				int[] ds = h.poll();
				for (int j = 0; j < 4; j++) {
					int nx = ds[0] + dx[j];
					int ny = ds[1] + dy[j];
					int min = ds[2];
					if (nx < 0 || nx >= R || ny < 0 || ny >= C || arr[nx][ny] == '*' || arr[nx][ny] == 'X') {
						continue;
					}
					if (arr[nx][ny] == 'D') {
						res = Math.min(res, min + 1);
						return;
					} else if (arr[nx][ny] == '.') {
						arr[nx][ny] = 'S';
						h.add(new int[] { nx, ny, min+1 });
					}

				}
			}
		}
	}
}

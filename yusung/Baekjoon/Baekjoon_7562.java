package Baekjoon;

import java.io.*;
import java.util.*;

//백준 7562번 나이트의 이동
//나이트는 한칸가고 대각으로 한칸이동함
//입력 첫째줄에 테스트케이스의 수가 주어짐
//각 테스트 케이스는 3줄로 첫째줄에 체스판의 길이, 둘째줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려는 칸이다.
//8방향으로 디렉션을 선언해야함

public class Baekjoon_7562 {
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[][] map;
	static boolean[][] visit;
	static int nowx;
	static int nowy;
	static int newx;
	static int newy;
	static int l;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			l = Integer.parseInt(br.readLine());
			map = new int[l][l];
			visit = new boolean[l][l];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			nowx = Integer.parseInt(st.nextToken());
			nowy = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			newx = Integer.parseInt(st.nextToken());
			newy = Integer.parseInt(st.nextToken());

			bfs(nowx, nowy);
			sb.append(map[newx][newy] + "\n");
		}
		System.out.println(sb.toString());
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

				if (x == nx && y == ny) {
					continue;
				}
				if (nx >= 0 && ny >= 0 && nx < l && ny < l) {
					if (!visit[nx][ny]) {
						q.offer(new int[] { nx, ny });
						visit[nx][ny] = true;
						map[nx][ny] = map[x][y] + 1;
					}
				}
			}
		}
	}
}

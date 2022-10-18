package Baekjoon;

import java.io.*;
import java.util.*;

//백준 2667번 단지번호붙이기

public class Baekjoon_2667 {

	private static int dx[] = { 0, 0, 1, -1 };
	private static int dy[] = { 1, -1, 0, 0 };
	private static ArrayList<Integer> total = new ArrayList<>();
	private static int n;
	private static int count = 0;
	private static boolean[][] visited = new boolean[25][25];
	private static int[][] map = new int[25][25];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					count=1;
					dfs(i, j);
					total.add(count);
				}
			}
		}

		Collections.sort(total);
		sb.append(total.size()).append("\n");
		for(int n : total) {
			sb.append(n).append("\n");
		}
		System.out.println(sb.toString());		
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;		

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
					count++;
				}
			}
		}
	}
}

package Baekjoon;

import java.io.*;
import java.util.*;

public class test {

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int n;
	static int[][] apart;
	static ArrayList<Integer> total = new ArrayList<>();
	static boolean[][] visit;
	static int count = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		apart = new int[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				apart[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (apart[i][j] == 1 && !visit[i][j]) {
					count = 1;
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

	public static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if(apart[nx][ny] == 1 && !visit[nx][ny]) {
					dfs(nx, ny);
					count++;
				}
			}
		}
	}

}

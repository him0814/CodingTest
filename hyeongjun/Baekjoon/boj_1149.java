package BOJ;

/*
백준 #1149 RGB거리
 */

import java.io.*;
import java.util.*;

public class boj_1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3]; // 입력예제
		int[][] tmp = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		tmp[0][0] = cost[0][0];
		tmp[0][1] = cost[0][1];
		tmp[0][2] = cost[0][2];

		/*
		 * 26 40 83 
		 * 49 60 57 
		 * 13 89 99
		 */

		for (int i = 1; i < N; i++) {
			tmp[i][0] = Math.min(tmp[i - 1][1], tmp[i - 1][2]) + cost[i][0];
			tmp[i][1] = Math.min(tmp[i - 1][0], tmp[i - 1][2]) + cost[i][1];
			tmp[i][2] = Math.min(tmp[i - 1][0], tmp[i - 1][1]) + cost[i][2];
		}

		Arrays.sort(tmp[N - 1]);
		System.out.println(tmp[N - 1][0]);
	}
}

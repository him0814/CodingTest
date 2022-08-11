package baekjoon;
//사탕게임 백준 3085

//가장 처음에 N×N크기에 사탕을 채워 놓음. 사탕의 색은 모두 같지 않을 수도 있음.
//사탕의 색이 다른 인접한 두 칸을 고르고 고른 칸에 들어있는 사탕을 서로 교환.
//두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹음.
//상근이가 먹을 수 있는 사탕의 최대 개수 출력.

//첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)
//다음 N개 줄에는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y

import java.io.*;

public class BOMBONI {
	static char[][] candy;
	static int n;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		candy = new char[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				candy[i][j] = str.charAt(j);
			}
		}
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n - 1; i++) {
				if (candy[i][j] != candy[i + 1][j]) {
					char tmp = candy[i][j];
					candy[i][j] = candy[i + 1][j];
					candy[i + 1][j] = tmp;
					res = Math.max(res, value());
					char tmp2 = candy[i][j];
					candy[i][j] = candy[i + 1][j];
					candy[i + 1][j] = tmp2;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (candy[i][j] != candy[i][j + 1]) {
					char tmp = candy[i][j];
					candy[i][j] = candy[i][j + 1];
					candy[i][j + 1] = tmp;
					res = Math.max(res, value());
					char tmp2 = candy[i][j];
					candy[i][j] = candy[i][j + 1];
					candy[i][j + 1] = tmp2;
				}
			}
		}
		System.out.println(res);
	}
	
	public static int value() {
		int max = 1;
		for (int k = 0; k < n; k++) {
			int cnt = 1;
			for (int l = 1; l < n; l++) {
				if (candy[k][l] == candy[k][l - 1]) {
					cnt++;
				} else {
					max = Math.max(cnt, max);
					cnt = 1;
				}
			}
			max = Math.max(cnt, max);
		}
		for (int l = 0; l < n; l++) {
			int cnt = 1;
			for (int k = 1; k < n; k++) {
				if (candy[k][l] == candy[k - 1][l]) {
					cnt++;
				} else {
					max = Math.max(cnt, max);
					cnt = 1;
				}
			}
			max = Math.max(cnt, max);
		}
		return max;
	}
}

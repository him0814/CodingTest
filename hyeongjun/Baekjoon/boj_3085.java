package BOJ;

/*
백준 #3085 사탕 게임

이차원 배열에 입력 예제 받고
1. 행 기준 인접 사탕 바꾸기 (좌,우) -> n-1번째까지 검사
1-1. 행에서 같은 사탕 있으면 count++ -> count 값들 중 가장 큰 값 선택
1-2. 열에서 같은 사탕 있으면 count++ -> count 값들 중 가장 큰 값 선택
1-3. 1-1과 1-2 중 최댓값 선택
1-4. 바꿨던 사탕 다시 원래대로


2. 열 기준 인접 사탕 바꾸기 (상,하) -> n-2번째까지 검사
2-1. 행에서 같은 사탕 있으면 count++ -> count 값들 중 가장 큰 값 선택
2-2. 열에서 같은 사탕 있으면 count++ -> count 값들 중 가장 큰 값 선택
2-3. 1-1과 1-2 중 최댓값 선택
2-4. 바꿨던 사탕 다시 원래대로
 */

import java.io.*;

public class boj_3085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[][] candy_arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				candy_arr[i][j] = str.charAt(j);
			}
		}

		int res = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				// if()
				// (행) 인접 사탕 바꾸기
				char tmp = candy_arr[i][j];
				candy_arr[i][j] = candy_arr[i][j + 1];
				candy_arr[i][j + 1] = tmp;

				// 행 검사
				for (int k = 0; k < N; k++) {
					int count = 1;
					for (int m = 1; m < N; m++) {
						if (candy_arr[k][m] == candy_arr[k][m - 1]) {
							count++;
						} else {
							// k행에서 이어져있는 특정 사탕 최댓값 선택
							res = Math.max(count, res);
							count = 1;
						}
					}
					// 각 행마다의 최댓값을 선택
					res = Math.max(res, count);
				}

				// 열 검사
				for (int k = 0; k < N; k++) {
					int count = 1;
					for (int m = 1; m < N; m++) {
						if (candy_arr[m][k] == candy_arr[m - 1][k]) {
							count++;
						} else {
							// k열에서 이어져있는 특정 사탕 최댓값 선택
							res = Math.max(count, res);
							count = 1;
						}
					}
					// 각 열마다의 최댓값을 선택
					res = Math.max(res, count);
				}

				// 원상태로 되돌리기
				tmp = candy_arr[i][j + 1];
				candy_arr[i][j + 1] = candy_arr[i][j];
				candy_arr[i][j] = tmp;

				/////////////////////////////////////////////

				// if()
				// (열) 인접 사탕 바꾸기
				char tmp2 = candy_arr[j][i];
				candy_arr[j][i] = candy_arr[j + 1][i];
				candy_arr[j + 1][i] = tmp2;

				// 행 검사
				for (int k = 0; k < N; k++) {
					int count = 1;
					for (int m = 1; m < N; m++) {
						if (candy_arr[k][m] == candy_arr[k][m - 1]) {
							count++;
						} else {
							res = Math.max(count, res);
							count = 1;
						}
					}
					res = Math.max(res, count);
				}

				// 열 검사
				for (int k = 0; k < N; k++) {
					int count = 1;
					for (int m = 1; m < N; m++) {
						if (candy_arr[m][k] == candy_arr[m - 1][k]) {
							count++;
						} else {
							res = Math.max(count, res);
							count = 1;
						}
					}
					res = Math.max(res, count);
				}

				// 원상태로 되돌리기
				tmp2 = candy_arr[j + 1][i];
				candy_arr[j + 1][i] = candy_arr[j][i];
				candy_arr[j][i] = tmp2;

			}
		}
		System.out.println(res);
	}
}

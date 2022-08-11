package Baekjoon;

import java.io.*;

//백준 3085번 사탕게임
//행을 먼저 교환하고(가로), 열을 비교해서 최대값을찾기(세로)
//N은 (3~50) 즉 3*3 ~ 50*50
//빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y
//이차원 배열?

public class Baekjoon_3085 {
	static char[][] arr;
	static int N;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		// 이차원배열에 값 넣기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		char tmp = ' ';

		//가로 체크 후 교환한 다음 원래로 돌림
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] != arr[i][j + 1]) {
					tmp = arr[i][j];
					arr[i][j] = arr[i][j + 1];
					arr[i][j + 1] = tmp;
					check();
					tmp = arr[i][j];
					arr[i][j] = arr[i][j + 1];
					arr[i][j + 1] = tmp;
				}
			}
		}

		//세로 체크 후 교환한 다음 원래로 돌림
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (arr[j][i] != arr[j + 1][i]) {
					tmp = arr[j][i];
					arr[j][i] = arr[j + 1][i];
					arr[j + 1][i] = tmp;
					check();
					tmp = arr[j][i];
					arr[j][i] = arr[j + 1][i];
					arr[j + 1][i] = tmp;
				}
			}
		}
		System.out.println(result);
	}

	//바꿧을때 최대인지 확인하는 메소드
	static void check() {

		int count = 1;

		for (int i = 0; i < N; i++) {
			count = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					count++;
				} else {
					count = 1;
				}
				result = Math.max(result, count);
			}
		}

		for (int i = 0; i < N; i++) {
			count = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[j][i] == arr[j + 1][i]) {
					count++;
				} else {
					count = 1;
				}
				result = Math.max(result, count);
			}
		}
	}
}

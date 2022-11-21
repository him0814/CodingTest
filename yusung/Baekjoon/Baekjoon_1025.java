package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1025번 제곱수 찾기

public class Baekjoon_1025 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		char[][] arr = new char[N][M];
		int res = -1;

		// 이차원배열 입력
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = -N; k < N; k++) {
					for (int t = -M; t < M; t++) {
						sb.setLength(0);
						if(k == 0 && t == 0) {
							continue;
						}						
						int num = 0;
						int ni = i;
						int nj = j;						
						while (ni >= 0 && ni < N && nj >= 0 && nj < M) {	
							sb.append(arr[ni][nj]);
							num = Integer.parseInt(sb.toString());							
							double num1 = (double) num;
							if ((int)Math.round(Math.sqrt(num1)) * (int)Math.round(Math.sqrt(num1)) == num) {
								res = Math.max(res, num);
							}
							ni += k;
							nj += t;							
						}						
					}
				}
			}
		}
		System.out.println(res);
	}
}

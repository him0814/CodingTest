package BaekJoon;

import java.util.*;
import java.io.*;

public class Bomboni {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] candy = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				candy[i][j] = s.charAt(j);
			}
		}
		int result = 0;
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N - 1; j++) {
				char tmp = candy[i][j];
				candy[i][j] = candy[i][j + 1];
				candy[i][j + 1] = tmp;
				
				int count = 1;
				int maxcount = 0;

				for (int k = 1; k < N; k++) {
					if (candy[i][k - 1] == candy[i][k]) {
						count++;
					}
					else {
						maxcount = Math.max(maxcount, count);
						count = 1;
					}
				}
				
				maxcount = Math.max(maxcount, count);
				count = 1;
				
				for (int k = 1; k < N; k++) {
					if (candy[k - 1][j] == candy[k][j]) {
						count++;
					}
					else {
						maxcount = Math.max(maxcount, count);
						count = 1;
					}
				}
				
				maxcount = Math.max(maxcount, count);
				count = 1;

				for (int k = 1; k < N; k++) {
					if (candy[k - 1][j + 1] == candy[k][j + 1]) {
						count++;
					}
					else {
						maxcount = Math.max(maxcount, count);
						count = 1;
					}
				}
				
				maxcount = Math.max(maxcount, count);
				result = Math.max(maxcount, result);

				tmp = candy[i][j];
				candy[i][j] = candy[i][j + 1];
				candy[i][j + 1] = tmp;
				
			}
		}

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N - 1; j++) {
				char tmp = candy[j][i];
				candy[j][i] = candy[j + 1][i];
				candy[j + 1][i] = tmp;
				
				int count = 1;
				int maxcount = 0;

				for (int k = 1; k < N; k++) {
					if (candy[k - 1][i] == candy[k][i]) {
						count++;
					}
					else {
						maxcount = Math.max(maxcount, count);
						count = 1;
					}
				}
				
				maxcount = Math.max(maxcount, count);
				count = 1;

				for (int k = 1; k < N; k++) {
					if (candy[j][k - 1] == candy[j][k]) {
						count++;
					}
					else {
						maxcount = Math.max(maxcount, count);
						count = 1;
					}
				}

				maxcount = Math.max(maxcount, count);
				count = 1;
				
				for (int k = 1; k < N; k++) {
					if (candy[j + 1][k - 1] == candy[j + 1][k]) {
						count++;
					}
					else {
						maxcount = Math.max(maxcount, count);
						count = 1;
					}
				}

				maxcount = Math.max(maxcount, count);
				result = Math.max(maxcount, result);

				tmp = candy[j][i];
				candy[j][i] = candy[j + 1][i];
				candy[j + 1][i] = tmp;
				
			}
		}
		System.out.print(result);
	}
}

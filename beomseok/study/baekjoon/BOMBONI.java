package baekjoon;
//�������� ���� 3085

//���� ó���� N��Nũ�⿡ ������ ä�� ����. ������ ���� ��� ���� ���� ���� ����.
//������ ���� �ٸ� ������ �� ĭ�� ���� �� ĭ�� ����ִ� ������ ���� ��ȯ.
//�� ���� ������ �̷���� �ִ� ���� �� ���� �κ�(�� �Ǵ� ��)�� �� ���� �� ������ ��� ����.
//����̰� ���� �� �ִ� ������ �ִ� ���� ���.

//ù° �ٿ� ������ ũ�� N�� �־�����. (3 �� N �� 50)
//���� N�� �ٿ��� ������ ������ �־�����. �������� C, �Ķ����� P, �ʷϻ��� Z, ������� Y

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

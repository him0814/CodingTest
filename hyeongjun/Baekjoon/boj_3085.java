package BOJ;

/*
���� #3085 ���� ����

������ �迭�� �Է� ���� �ް�
1. �� ���� ���� ���� �ٲٱ� (��,��) -> n-1��°���� �˻�
1-1. �࿡�� ���� ���� ������ count++ -> count ���� �� ���� ū �� ����
1-2. ������ ���� ���� ������ count++ -> count ���� �� ���� ū �� ����
1-3. 1-1�� 1-2 �� �ִ� ����
1-4. �ٲ�� ���� �ٽ� �������


2. �� ���� ���� ���� �ٲٱ� (��,��) -> n-2��°���� �˻�
2-1. �࿡�� ���� ���� ������ count++ -> count ���� �� ���� ū �� ����
2-2. ������ ���� ���� ������ count++ -> count ���� �� ���� ū �� ����
2-3. 1-1�� 1-2 �� �ִ� ����
2-4. �ٲ�� ���� �ٽ� �������
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
				// (��) ���� ���� �ٲٱ�
				char tmp = candy_arr[i][j];
				candy_arr[i][j] = candy_arr[i][j + 1];
				candy_arr[i][j + 1] = tmp;

				// �� �˻�
				for (int k = 0; k < N; k++) {
					int count = 1;
					for (int m = 1; m < N; m++) {
						if (candy_arr[k][m] == candy_arr[k][m - 1]) {
							count++;
						} else {
							// k�࿡�� �̾����ִ� Ư�� ���� �ִ� ����
							res = Math.max(count, res);
							count = 1;
						}
					}
					// �� �ึ���� �ִ��� ����
					res = Math.max(res, count);
				}

				// �� �˻�
				for (int k = 0; k < N; k++) {
					int count = 1;
					for (int m = 1; m < N; m++) {
						if (candy_arr[m][k] == candy_arr[m - 1][k]) {
							count++;
						} else {
							// k������ �̾����ִ� Ư�� ���� �ִ� ����
							res = Math.max(count, res);
							count = 1;
						}
					}
					// �� �������� �ִ��� ����
					res = Math.max(res, count);
				}

				// �����·� �ǵ�����
				tmp = candy_arr[i][j + 1];
				candy_arr[i][j + 1] = candy_arr[i][j];
				candy_arr[i][j] = tmp;

				/////////////////////////////////////////////

				// if()
				// (��) ���� ���� �ٲٱ�
				char tmp2 = candy_arr[j][i];
				candy_arr[j][i] = candy_arr[j + 1][i];
				candy_arr[j + 1][i] = tmp2;

				// �� �˻�
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

				// �� �˻�
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

				// �����·� �ǵ�����
				tmp2 = candy_arr[j + 1][i];
				candy_arr[j + 1][i] = candy_arr[j][i];
				candy_arr[j][i] = tmp2;

			}
		}
		System.out.println(res);
	}
}

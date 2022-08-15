package baekjoon;
//������ȣ���̱� ���� 2667

//������, �� ������ ���ϴ� ���� �� �������� ���� �� ���.

//ù ��° �ٿ��� ������ ũ�� N(���簢���̹Ƿ� ���ο� ������ ũ��� ������ 5��N��25)
//�� ���� N�ٿ��� ���� N���� �ڷ�(0Ȥ�� 1)�� �Է�

import java.io.*;
import java.util.*;

public class ComplexNumbering {
	static int n;
	static int cnt;
	static int complex;
	static int arr[][];
	static boolean visit[][];
	static int row[] = { -1, 1, 0, 0 };
	static int col[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> al = new ArrayList<>();

		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == 1 && !visit[i][j]) {
				cnt = 0;
				dfs(i,j);
				al.add(cnt);
				}
			}
		}
		Collections.sort(al);
		System.out.println(al.size());
		for(int a: al) {
			System.out.println(a);
		}

	}
	public static void dfs(int r, int c) {
		visit[r][c] = true;
		cnt++;
		for(int i=0; i<4; i++) {
			int nr = r + row[i];
			int nc = c + col[i];
			
			if(nr < 0 || nc < 0 || nr >= n|| nc >= n)
				continue;
			if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
				if(arr[nr][nc] == 1 && !visit[nr][nc]) {
					dfs(nr,nc);
				}
			}
		}
	}
}

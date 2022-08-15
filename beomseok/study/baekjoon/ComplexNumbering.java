package baekjoon;
//단지번호붙이기 백준 2667

//단지수, 각 단지에 속하는 집의 수 오름차순 정렬 후 출력.

//첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)
//그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력

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

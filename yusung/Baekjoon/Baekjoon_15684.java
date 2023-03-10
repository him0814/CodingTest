package Baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_15684 {
	static int[][] arr;
	static int N;
	static int M;
	static int H;
	static int res = 0;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[H + 1][N + 1];

		if (M != 0) {
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[a][b] = 1;
				arr[a][b + 1] = 2;
			}
		}
		for (int i = 0; i <=3; i++) {
			res = i;
			dfs(1,0);
			if(flag) {
				break;
			}
		}

		if(flag) {
			System.out.println(res);
			return;
		}
		if(res > 3) {
			System.out.println(-1);
		}
		else {
			System.out.println(-1);
		}
	}

	private static void dfs(int x, int depth) {		
		if (res == depth) {
			if(check()) {
				flag = true;				
			}
			return;
		}
		
		for(int i=x; i<= H;i++) {
			for(int j=1; j<N; j++) {
				if(arr[i][j] == 0 && arr[i][j+1] == 0) {
					arr[i][j] = 1;
					arr[i][j+1] = 2;
					
					dfs(i,depth+1);
					
					arr[i][j] = 0;
					arr[i][j+1] = 0;
				}
			}
		}

	}

	private static boolean check() {
		for (int i = 1; i <= N; i++) {
			int nx = i;
			int ny = 1;
			while (ny <= H) {
				if (arr[ny][nx] == 1) {
					nx++;
				} else if (arr[ny][nx] == 2) {
					nx--;
				}
				ny++;
			}
			if (nx != i) {
				return false;
			}
		}
		return true;		
	}
}

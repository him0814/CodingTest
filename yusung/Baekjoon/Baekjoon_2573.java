package Baekjoon;

import java.io.*;
import java.util.*;

//백준 2573 빙산

public class Baekjoon_2573 {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] visit;
	static int N;
	static int M;
	static int[][] iceberg;
	static int[][] iceberg2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		iceberg = new int[N][M];
		iceberg2 = new int[N][M];
		visit = new boolean[N][M];
		int answer = 0;
		int res = 0;
		boolean flag = false;
		

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				iceberg[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			
			if(answer >= 2) {			
				break;
			}			
			if(flag) {
				res = 0;
				break;
			}
			flag = true;
			visit = new boolean[N][M];
			iceberg2 = new int[N][M];
			answer = 0;
			melt();
			res++;
			for (int i = 0; i < N; i++) {				
				for (int j = 0; j < M; j++) {
					if(iceberg[i][j] == 0) {
						continue;
					}	
					flag = false;
					if(!visit[i][j]) {
						dfs(i,j);
						answer++;
					}					
				}
			}
		}
		
		System.out.println(res);

	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if(iceberg[nx][ny] !=0 && !visit[nx][ny]) {
					dfs(nx,ny);
				}
			}			
		}
		
	}

	private static void melt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = dx[k] + i;
					int ny = dy[k] + j;
					if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
						if (iceberg[nx][ny] == 0) {
							cnt++;
						}
					}
				}
				iceberg2[i][j] = cnt;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(iceberg[i][j] - iceberg2[i][j] < 0) {
					iceberg[i][j] = 0;
				}
				else {
					iceberg[i][j] -= iceberg2[i][j];
				}										
			}
		}
		
	}
}

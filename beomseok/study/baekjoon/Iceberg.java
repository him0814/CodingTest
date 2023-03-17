package baekjoon;

//น้มุ 2573 บ๙ป๊

import java.io.*;
import java.util.*;

public class Iceberg {
	static int N, M;
	static int[][] arr;
	static int[][] melt;
	static int cnt;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		while(true) {
			visit = new boolean[N][M];
			melt = new int[N][M];
			cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(!visit[i][j] && arr[i][j] != 0) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			arr = melt;
			year++;
			
			if(cnt == 0) {
				year = 0;
				break;
			} else if(cnt >= 2) {
				year--;
				break;
			}
		}
		System.out.print(year);
	}
	
	public static void dfs(int x, int y) {
		if(visit[x][y] && arr[x][y] == 0) {
			return;
		}
		
		int sea = 0;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if(arr[nx][ny] == 0) {
					sea++;
				}
			}
		}
		
		int tmp = arr[x][y] - sea;
		if(tmp >= 0) {
			melt[x][y] = tmp;
		} else {
			melt[x][y] = 0;
		}
		
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if(!visit[nx][ny] && arr[nx][ny] != 0) {
					dfs(nx, ny);
				}
			}
					
		}
	}
}

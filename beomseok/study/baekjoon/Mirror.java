package baekjoon;
//백준 2344 거울

import java.io.*;
import java.util.*;

public class Mirror {
	static int N, M;
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[1005][1005];
		
		for (int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					arr[i][j] = -1;
				}
			}
		}
		
		for (int i=1; i<=N; i++) {
			arr[i][0] = i;
			arr[N+1 - i][M+1] = N + M + i;
		}
		for (int i=1; i<=M; i++){
			arr[N+1][i] = N + i;
			arr[0][M+1 - i] = N*2 + M+i;
		}
		
		StringBuilder sb = new StringBuilder();
		
	}
	public static int dfs(int y, int x, int idx) {
		int ny = y + dy[idx];
		int nx = x + dx[idx];
		
		if(arr[ny][nx] >= 1) {
			return arr[ny][nx];
		} else {
			if(arr[ny][nx] == -1) {
				return dfs(ny, nx, change(idx));
			} else {
				return dfs(ny, nx, idx);
			}
		}
	}
	public static int change(int idx) {
	    if (idx == 0) return 3;
	    else if (idx == 1) return 2;
	    else if (idx == 2) return 1;
	    else return 0;
	}
}

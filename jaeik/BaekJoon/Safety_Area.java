package BaekJoon;
// N*N의 행렬
// 높이별 안전 영역 갯수 비교 후 가장 높은 수

import java.util.*;
import java.io.*;

public class Safety_Area {
	static int N;
	static int[][] area;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int count;
	static int max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		visit = new boolean[N][N];
		
		max = 1;
		int hmax = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				hmax = Math.max(hmax, area[i][j]);
			}
		}
		
		for(int k = 1; k < hmax; k++) {
			visit = new boolean[N][N];
			count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(area[i][j] > k && !visit[i][j]) {
						dfs(i, j, k);
						count++;
					}
				}
			}
			max = Math.max(max, count);
			
		}
		
		System.out.print(max);
	}
	
	static void dfs(int r, int c, int h) {
		visit[r][c] = true;
		for(int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if(area[nr][nc] > h && !visit[nr][nc]) {
					dfs(nr, nc, h);					
				}
			}
		}
	}
}

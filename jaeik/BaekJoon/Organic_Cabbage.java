package BaekJoon;
// 첫째 줄에 테스트 케이스 개수 T
// 각 테스트 케이스 첫째 줄에 가로길이 M, 세로길이 N, 배추가 심어진 위치 개수 K

import java.util.*;
import java.io.*;
public class Organic_Cabbage {
	static int T;
	static int M;
	static int N;
	static int K;
	static int[][] cab;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cab = new int[M][N];
			visit = new boolean[M][N];
			int count = 0;
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				cab[n][m] = 1;
			}
			for(int k = 0; k < M; k++) {
				for(int l = 0; l < N; l++) {
					if(cab[k][l] != 0 && !visit[k][l]) {
						
						dfs(k,l);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
	
	static void dfs(int r, int c) {
		visit[r][c] = true;
		for(int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(nr >= 0 && nc >= 0 && nr < M && nc < N && cab[nr][nc] != 0 && !visit[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
}

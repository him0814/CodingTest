package BaekJoon;
// 0 0 종료
// 각 테스트 케이스 첫째 줄 너비w와 높이h
// 다음 줄부터 지도
// 1 땅 0 바다
// 대각선도 가능
import java.util.*;
import java.io.*;

public class Islands {
	static int w;
	static int h;
	static int[][] island;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			island = new int[h][w];
			visit = new boolean[h][w];
			int count = 0;
			if(w == 0 && h == 0) {
				break;
			}
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					island[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(island[i][j] != 0 && !visit[i][j]) {
						dfs(i, j);
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
		
		for(int i = 0; i < 8; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(nr >= 0 && nc >= 0 && nr < h && nc < w && island[nr][nc] != 0 && !visit[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
}

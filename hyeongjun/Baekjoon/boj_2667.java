package BOJ;

/*
백준 #2667 단지번호붙이기


 */

import java.io.*;
import java.util.*;

public class boj_2667 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N;
	static int[][] apt; // 입력 : 아파트 (0,1) 을 담을 배열
	static boolean[][] visit;
	static int count; // 아파트 갯수
	static ArrayList<Integer> al = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		apt = new int[N][N];
		visit = new boolean[N][N];
		
		// 입력
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				apt[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 방문한 적 없고 1이면
				if(!visit[i][j] && apt[i][j] == 1) {
					count = 1; // 이미 1인 곳을 들어감
					dfs(i, j);
					al.add(count);
				}
			}
		}
		
		Collections.sort(al);
		sb.append(al.size() + "\n");
		
		for(int n: al) {
			sb.append(n + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) { // 상하좌우 4방향이기 때문
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(!visit[nx][ny] && apt[nx][ny] == 1) {
					dfs(nx, ny);
					count++;
				}
			}
		}
		
	}
}

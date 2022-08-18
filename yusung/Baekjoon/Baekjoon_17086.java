package Baekjoon;

import java.io.*;
import java.util.*;

//백준 17086번 아기상어2
//첫줄에 공간의 크기인 N과 M이 주어진다.
//둘째줄부터 N개의 공간의 상태가 주어지며 0은 빈칸, 1은 아기상어가 있는 칸이다.
//안전거리는 아기상어가 있는 칸과 가장 거리가 가까운 아기상어의 거리로, 칸의 거리는 하나의 칸에서 다른 칸으로 가기 위해서 지나야 하는 칸의 수이다.
//이동은 8방향(대각선) 까지가능하다.

public class Baekjoon_17086 {
	static int N;
	static int M;
	static int[][] space;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		space = new int[N][M];		

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(space[i][j] == 1) {
				continue;
				}
				max = bfs(i, j);				
				answer = Math.max(answer, max);
			}
		}
		System.out.println(answer);
	}

	public static int bfs(int x, int y) {
		boolean visit[][] = new boolean[N][M];
		Queue<int[]> q = new LinkedList<int[]>();		
		q.offer(new int[] { x, y, 0 });
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int now[] = q.poll();			
			
			for(int i=0; i<8; i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];				
				int tmp = now[2];
				
				if(nx<0 || ny<0 || nx>=N|| ny>=M || visit[nx][ny]) {
					continue;
				}
				if(space[nx][ny] == 1) {					
					return tmp+1;
				}
				visit[nx][ny] = true;
				q.offer(new int[]{nx, ny, tmp+1});			
			}
		}		
		return 0;
	}
}

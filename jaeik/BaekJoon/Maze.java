package BaekJoon;

import java.util.*;
import java.io.*;

public class Maze {
	static int N;
	static int M;
	static int[][] maze;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
		System.out.print(maze[N-1][M-1]);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if(!visit[nx][ny] && maze[nx][ny] == 1) {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					maze[nx][ny] = maze[now[0]][now[1]] + 1;
				}
			}
		}
	}
}

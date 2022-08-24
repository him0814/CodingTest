package BaekJoon;

import java.util.*;
import java.io.*;

public class Knight_Moves {
	static int I;
	static int[][] chess;
	static boolean[][] visit;
	static int[] dx = {-2, -1, -2, -1, 2, 1, 2, 1};
	static int[] dy = {-1, -2, 1, 2, -1, -2, 1, 2};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			I = Integer.parseInt(br.readLine());
			chess = new int[I][I];
			visit = new boolean[I][I];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			
			bfs(startX, startY);
			
			sb.append(chess[endX][endY]).append("\n");
			
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visit[x][y] = true;
		chess[x][y] = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 8; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx < 0 || ny < 0 || nx >= I || ny >= I) {
					continue;
				}
				if(!visit[nx][ny]) {
					visit[nx][ny] = true;
					q.offer(new int[] {nx, ny});
					chess[nx][ny] = chess[now[0]][now[1]] + 1;
				}
				
			}
		}
	}
}

package BaekJoon;

import java.util.*;
import java.io.*;
public class Baby_Shark {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] distance;
	static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					visit = new boolean[N][M];
					distance = new int[N][M];
					max = Math.max(max, bfs(i,j));
				}
				
			}
		}
		
		System.out.print(max);
	}
	
	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x ,y});
		visit[x][y] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 1) {
					return distance[now[0]][now[1]] + 1;
				}
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0 && !visit[nx][ny]) {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					distance[nx][ny] = distance[now[0]][now[1]] + 1;
				}
			}
		}
		return 0;
	}
}

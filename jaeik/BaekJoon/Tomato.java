package BaekJoon;

import java.util.*;
import java.io.*;

public class Tomato {
	static int[][] tomato;
	static boolean[][] visit;
	static int[][] day;
	static int N;
	static int M;
	static int[] dx = {-1, 1 ,0, 0};
	static int[] dy = {0, 0 ,-1, 1};
	static Queue<int[]> q = new LinkedList<>();;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tomato = new int[M][N];
		visit = new boolean[M][N];
		day = new int[M][N];
		for(int i = 0; i < M; i++) {
			Arrays.fill(day[i], M*N);
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] == 1) {
					q.offer(new int[] {i, j});
					visit[i][j] = true;
					day[i][j] = 0;
				}
			}
		}
		
		bfs();
		
		boolean flag = false;
		int max = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(day[i][j] == M*N && tomato[i][j] != -1) {
					flag = true;
				}
				else if(tomato[i][j] != -1){
					max = Math.max(max, day[i][j]);
				}
			}
		}
		if(flag) {
			System.out.print(-1);
		}
		else {
			System.out.print(max);
		}
	}
	
	static void bfs() {
			
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx < 0 || ny < 0 || nx >= M || ny >= N || visit[nx][ny]) {
					continue;
				}
				if(tomato[nx][ny] == 0) {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					day[nx][ny] = Math.min(day[nx][ny], day[now[0]][now[1]] + 1);
				}
			}
		}
	}
	
//	static int[][] tomato;
//	static boolean[][] visit;
//	static int[][] day;
//	static int N;
//	static int M;
//	static int[] dx = {-1, 1 ,0, 0};
//	static int[] dy = {0, 0 ,-1, 1};
//	
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		tomato = new int[M][N];
//		for(int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j = 0; j < N; j++) {
//				tomato[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		day = new int[M][N];
//		for(int i = 0; i < M; i++) {
//			Arrays.fill(day[i], M*N);
//		}
//		
//		for(int i = 0; i < M; i++) {
//			
//			for(int j = 0; j < N; j++) {
//				if(tomato[i][j] == 1) {
//					visit = new boolean[M][N];
//					bfs(i, j);
//				}
//			}
//		}
//		boolean flag = false;
//		int max = 0;
//		for(int i = 0; i < M; i++) {
//			for(int j = 0; j < N; j++) {
//				if(day[i][j] == M*N && tomato[i][j] != -1) {
//					flag = true;
//				}
//				else if(tomato[i][j] != -1){
//					max = Math.max(max, day[i][j]);
//				}
//			}
//		}
//		if(flag) {
//			System.out.print(-1);
//		}
//		else {
//			System.out.print(max);
//		}
//	}
//	
//	static void bfs(int x, int y) {
//		Queue<int[]> q = new LinkedList<>();
//		q.offer(new int[] {x, y});
//		visit[x][y] = true;
//		day[x][y] = 0;
//		while(!q.isEmpty()) {
//			int[] now = q.poll();
//			for(int i = 0; i < 4; i++) {
//				int nx = now[0] + dx[i];
//				int ny = now[1] + dy[i];
//				if(nx < 0 || ny < 0 || nx >= M || ny >= N || visit[nx][ny]) {
//					continue;
//				}
//				if(tomato[nx][ny] == 0) {
//					q.offer(new int[] {nx, ny});
//					visit[nx][ny] = true;
//					day[nx][ny] = Math.min(day[nx][ny], day[now[0]][now[1]] + 1);
//				}
//			}
//		}
//	}
}

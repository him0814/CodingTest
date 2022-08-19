package Baekjoon;

import java.io.*;
import java.util.*;

// 백준 7576번 토마토
// 상하좌우 네방향에 영향을 줌, 창고에 보관된 토마토들이 며칠이 지나면 익는지 최소일수 출력
// 첫줄 상자 크기 N : 세로수, M : 가로수(2~1000)
// 둘째줄부터 토마토의 정보, 1 -> 익은거, 0 -> 익지않은거, -1 -> 토마토없는거

public class Baekjoon_7576 {

	static int M;
	static int N;
	static int[][] box;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();		
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) {
					q.offer(new int[] { i, j, 0 });
					visit[i][j] = true;
				}
			}
		}		
		while (!q.isEmpty()) {
			int now[] = q.poll();
			result = now[2];			
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) {
					continue;
				}

				if (box[nx][ny] == 0) {		
					box[nx][ny] = 1; // -1 출력을 위해 방문한 0을 1로 바꿔줌
					q.offer(new int[] { nx, ny, result+1 });
					visit[nx][ny] = true;
				}				
			}			
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(result);
	}
}

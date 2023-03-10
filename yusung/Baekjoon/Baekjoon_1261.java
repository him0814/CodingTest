package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1451 직사각형으로 나누기
public class Baekjoon_1261 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] arr; 
	static boolean[][] visit;
	static int M;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int res = bfs(0, 0);
		
		System.out.println(res);

//		출력 테스트
//		for(int i=0; i<N; i++) {			
//			for(int j=0; j<M; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
	}

	private static int bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] { x, y, 0});
		visit = new boolean[N][M];
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int bx = q.peek()[0];
			int by = q.peek()[1];
			int cnt = q.pollFirst()[2];
			
			if (bx == N - 1 && by == M - 1) {
				return cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nx = bx + dx[i];
				int ny = by + dy[i];
				
				if(nx >=0 && nx <= N-1 && ny>=0 && ny<=M-1) {
					if(arr[nx][ny] == 0 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offerFirst(new int[] {nx, ny, cnt});
					}
					
					if(arr[nx][ny] == 1 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offerLast(new int[] {nx, ny, cnt+1});
					}
				}
			}
		}
		return 0;

	}

}

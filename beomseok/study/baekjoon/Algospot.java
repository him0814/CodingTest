package baekjoon;
//백준 1261 알고스팟

import java.io.*;
import java.util.*;

public class Algospot {
	static int N, M;
    static int[][] arr;
    static int[][] map;
    static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		map = new int[N+1][M+1];
		visit = new boolean[N+1][M+1];
		
		for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
		
		bfs(0, 0);
		System.out.println(map[N-1][M-1]);
	}
	
	public static void bfs(int x, int y) {
		Deque<int[]> dq = new LinkedList<>();
		dq.offerLast(new int[] {x, y});
		visit[0][0] = true;
		
		while (!dq.isEmpty()) {
			int now[] = dq.pollLast();
			int p = now[0];
			int q = now[1];
			
			for (int i=0; i<4; i++) {
				int nx = p + dx[i];
				int ny = q + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (arr[nx][ny] == 0  && !visit[nx][ny]) {
						visit[nx][ny] = true;
						map[nx][ny] = map[p][q];
						dq.offerLast(new int[] {nx, ny});
					} 
					if (arr[nx][ny] == 1  && !visit[nx][ny]) {
						visit[nx][ny] = true;
						map[nx][ny] = map[p][q] + 1;
						dq.offerFirst(new int[] {nx, ny});
					}
				}
			}
		}
	}
}

package Baekjoon;

import java.io.*;
import java.util.*;

//백준 3055 탈출
public class Baekjoon_3055 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static int R;
	static int C;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		visit = new boolean[R][C];

		Queue<int[]> q1 = new LinkedList<int[]>(); // 고슴도치 위치 옮길때 쓰는 큐
		Queue<int[]> q2 = new LinkedList<int[]>(); // 물 위치 옮길때 쓰는 큐

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'S') {
					q1.offer(new int[] { i, j, 0 });
					visit[i][j] = true;
				}
				else if (arr[i][j] == '*') {
					q2.offer(new int[] { i, j });
				}
			}
		}

		int answer = bfs(q1, q2);
		
		if(answer != Integer.MAX_VALUE) {
			System.out.println(answer);			
		}
		else {
			System.out.println("KAKTUS");
		}		

	}

	private static int bfs(Queue<int[]> q1, Queue<int[]> q2) {
		int res = Integer.MAX_VALUE;
		while (!q1.isEmpty()) {	
			int dis = q2.size();
			for (int j = 0; j < dis; j++) {
				int[] xy = q2.poll();
				int x = xy[0];
				int y = xy[1];
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && ny >= 0 && nx < R && ny < C && arr[nx][ny] == '.') {
						arr[nx][ny] = '*';
						q2.offer(new int[] { nx, ny });
						visit[nx][ny] = true;						
					}
				}
			}
			
			int dis2 = q1.size();
			for (int j = 0; j < dis2; j++) {
				int[] xy = q1.poll();
				int x = xy[0];
				int y = xy[1];
				int cnt = xy[2];
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && ny >= 0 && nx < R && ny < C ) {
						if(arr[nx][ny] == 'D') {
							res = Math.min(res, cnt+1);
							return res;
						}
						else if(arr[nx][ny] == '.' && !visit[nx][ny]) {
							arr[nx][ny] = 'S';
							visit[nx][ny] = true;
							q1.offer(new int[] {nx, ny, cnt+1});							
						}
					}
				}
			}
		}
		return res;
	}

}

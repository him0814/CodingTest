package BaekJoon;

import java.io.*;
import java.util.*;
public class War {
	static int N;
	static int M;
	static char[][] arr;
	static boolean[][] visit;
	static int[] dx = {-1, 1 ,0, 0};
	static int[] dy = {0, 0 ,-1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[M][N];
		visit = new boolean[M][N];
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		int resultW = 0;
		int resultB = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 'W' && !visit[i][j]) {
					int tmp = bfs('W',i, j, 1);
					resultW += tmp*tmp;
				}
				else if(arr[i][j] == 'B' && !visit[i][j]) {
					int tmp = bfs('B',i, j, 1);
					resultB += tmp*tmp;
				}
			}
		}
		System.out.print(resultW + " " + resultB);
	}
	
	static int bfs(char color, int x, int y, int count) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nx;
			int ny;
			for(int i = 0; i < 4; i++) {
				nx = now[0] + dx[i];
				ny = now[1] + dy[i];
				if(nx >= 0 && ny >= 0 && nx < M && ny < N && color == arr[nx][ny] && !visit[nx][ny]) {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					count++;
				}
			}
		}
		
		return count;
	}
}

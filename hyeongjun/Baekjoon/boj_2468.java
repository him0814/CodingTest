package BOJ;

/*
백준 #2468 안전영역

2 <= n <= 100
1 <= 높이 <= 100
입력값 중 최댓값까지 for문 돌면서 안전지대면 count++
count 를 arraylist에 담고 정렬 후 마지막 인덱스 값 출력 
 */

import java.io.*;
import java.util.*;

public class boj_2468 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n;
	static int[][] high;
	static boolean[][] visit;
	static int count;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		high = new int[n][n];
		
		StringTokenizer st;

		// 입력값 중 가장 큰 값
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				high[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, high[i][j]);
			}
		}
		
		// 안전지대 갯수가 몇 개인지 모르기 때문에 arraylist
		ArrayList<Integer> al = new ArrayList<>();
		
		for(int i = 1; i <= max; i++) {
			count = 0;
			visit = new boolean[n][n]; // Arrays.fill(visit, false);
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(!visit[j][k] && high[j][k] >= i) {
						visit[j][k] = true;
						dfs(j, k, i);
						count++;
					}
				}
			}
			al.add(count);
		}
		Collections.sort(al);
		System.out.println(al.get(al.size()-1));
	}
	
	public static void dfs(int x, int y, int max) {
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
				continue;
			}
			if(high[nx][ny] >= max && !visit[nx][ny]) {
				visit[nx][ny] = true;
				dfs(nx, ny, max);
			}
		}
	}
}
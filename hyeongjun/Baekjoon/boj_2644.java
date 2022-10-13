package BOJ;

/*
백준 #2644 촌수계산
 */

import java.io.*;
import java.util.*;

public class boj_2644 {
	
	static int n;
	static int start, target;
	static int relation;
	static int[][] map;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		relation = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		cnt = new int[n+1];
		
		for(int i = 0; i < relation; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		bfs(start);
		
		if(cnt[target] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(cnt[target]);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i = 1; i <= n; i++) {
				if(map[now][i] == 1 && cnt[i] == 0) {
					cnt[i] = cnt[now] + 1;
					q.offer(i);
				}
			}
		}
	}
}

package BaekJoon;

// 첫째 줄에 테이스 케이스 수 t
// 각 테스트 첫째 줄 편의점의 개수 n
// 집, 편의점n개, 페스티벌 좌표순으로 입력
import java.util.*;
import java.io.*;

public class Beer_Walking {
	
	static int n;
	static int[][] con;
	static boolean[] visit;
	static int[] dx = {-1, 1 ,0, 0};
	static int[] dy = {0, 0 ,-1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int homeX = Integer.parseInt(st.nextToken());
			int homeY = Integer.parseInt(st.nextToken());
			
			con = new int[n][2];
			visit = new boolean[n];
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				con[j][0] = Integer.parseInt(st.nextToken());
				con[j][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int fesX = Integer.parseInt(st.nextToken());
			int fesY = Integer.parseInt(st.nextToken());
			sb.append(bfs(homeX, homeY, fesX, fesY)).append("\n");
			
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
		
	}
	static String bfs(int x, int y, int end_x, int end_y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int endX = Math.abs(now[0] - end_x);
			int endY = Math.abs(now[1] - end_y);
			if(endX + endY <= 1000) {
				return "happy";
			}
			for(int i = 0; i < n; i++) {
//				Math.abs(now[0] - con[i][0]);
//				Math.abs(now[1] - con[i][1]);
				if(Math.abs(now[0] - con[i][0]) + Math.abs(now[1] - con[i][1]) <= 1000 && !visit[i]) {
					q.offer(new int[] {con[i][0], con[i][1]});
					visit[i] = true;
				}
			}
		}
		return "sad";
	}
}

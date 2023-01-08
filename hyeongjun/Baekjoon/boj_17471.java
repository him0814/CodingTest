package BOJ;

/*
백준 #17471 게리맨더링

map[n][n] = 1 연결 / = 0 연결x
people[] -> 인구수
zone[] -> 선거구역 1,2 로 나눔
 */

import java.io.*;
import java.util.*;

public class boj_17471 {
	
	static int n;
	static int[][] map;
	static int[] people; // 인구수
	static int[] zone; // 선거구역 1,2
	static boolean[] visit;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		people = new int[n+1];
		zone = new int[n+1];
				
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int tmp = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j <= tmp; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][num] = 1;
				map[num][i] = 1;
			}
		}
		
		dfs(1);
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	private static void dfs(int depth) {
		// 종료 조건
		if(depth == n+1) {
			visit = new boolean[n+1];
			int zone_cnt = 0;
			
			for(int i = 1; i <= n; i++) {
				// i번째 구역이 zone[i]끼리 연결되었는지 확인
				if(!visit[i]) {
					check_zone(i, zone[i]);
					zone_cnt++;
				}
			}
			
			// 구역이 2개로 성공적으로 나뉘어 연결되어 있으면
			if(zone_cnt == 2) {
				int zone1_sum = 0;
				int zone2_sum = 0;
				
				for(int i = 1; i <= n; i++) {
					// 선거구역 1이면, 선거구역 1인 인구수들의 합
					if(zone[i] == 1) {
						zone1_sum += people[i];
					} else { // 선거구역 2이면, 선거구역 2인 인구수들의 합
						zone2_sum += people[i];
					}
				}
				
				answer = Math.min(answer, Math.abs(zone1_sum - zone2_sum));
			}
			
			return;
		}
		
		zone[depth] = 1;
		dfs(depth+1);
		
		zone[depth] = 2;
		dfs(depth+1);
	}

	private static void check_zone(int idx, int num) {
		visit[idx] = true;
		
		for(int i = 1; i <= n; i++) {
			if(!visit[i]) {
				if(map[idx][i] == 1 && zone[i] == num) {
					check_zone(i, num);
				}
			}
		}
	}
}

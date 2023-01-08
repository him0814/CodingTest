package BOJ;

/*
���� #17471 �Ը��Ǵ���

map[n][n] = 1 ���� / = 0 ����x
people[] -> �α���
zone[] -> ���ű��� 1,2 �� ����
 */

import java.io.*;
import java.util.*;

public class boj_17471 {
	
	static int n;
	static int[][] map;
	static int[] people; // �α���
	static int[] zone; // ���ű��� 1,2
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
		// ���� ����
		if(depth == n+1) {
			visit = new boolean[n+1];
			int zone_cnt = 0;
			
			for(int i = 1; i <= n; i++) {
				// i��° ������ zone[i]���� ����Ǿ����� Ȯ��
				if(!visit[i]) {
					check_zone(i, zone[i]);
					zone_cnt++;
				}
			}
			
			// ������ 2���� ���������� ������ ����Ǿ� ������
			if(zone_cnt == 2) {
				int zone1_sum = 0;
				int zone2_sum = 0;
				
				for(int i = 1; i <= n; i++) {
					// ���ű��� 1�̸�, ���ű��� 1�� �α������� ��
					if(zone[i] == 1) {
						zone1_sum += people[i];
					} else { // ���ű��� 2�̸�, ���ű��� 2�� �α������� ��
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

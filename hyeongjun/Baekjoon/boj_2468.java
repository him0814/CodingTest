package BOJ;

/*
���� #2468 ��������

2 <= n <= 100
1 <= ���� <= 100
�Է°� �� �ִ񰪱��� for�� ���鼭 ��������� count++
count �� arraylist�� ��� ���� �� ������ �ε��� �� ��� 
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

		// �Է°� �� ���� ū ��
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				high[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, high[i][j]);
			}
		}
		
		// �������� ������ �� ������ �𸣱� ������ arraylist
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
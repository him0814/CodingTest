package BOJ;

/*
백준 #18428 감시피하기
*/

import java.io.*;
import java.util.*;

public class boj_18428 {
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int n;
	static char[][] map;
	static ArrayList<int[]> al = new ArrayList<>();
	static boolean flag = false; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				map[i][j] = st.nextToken().charAt(0);
				
				if(map[i][j] == 'T') {
					al.add(new int[]{i, j});
				}
			}
		}
		
		dfs(0, 0, 0);
		
		if(flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static void dfs(int cnt, int x, int y) {
		if(cnt == 3) {
			if(meet()) {
				flag = true;
			}
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 'X') {
					map[i][j] = 'O';
					// 한 줄에 장애물을 두개 세울 필요 x -> j+1;
					dfs(cnt+1, i, j + 1);
					map[i][j] = 'X';
				}
			}
			y = 0;
		}
	}

	private static boolean meet() {
		for(int i = 0; i < al.size(); i++) {
			int[] t_point = al.get(i);
			for(int j = 0; j < 4; j++) {
				int nx = t_point[0];
				int ny = t_point[1];
				
				// whlie 쓴 이유 -> 상하좌우 한 줄에 있을 때만 확인해야 하기 때문
				while(true) {
					nx += dx[j];
					ny += dy[j];
					
					// map 범위 넘어가면
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
						break;
					}
					
					// 선생과 학생 사이 장애물이 있으면
					if(map[nx][ny] == 'O') {
						break;
					}
					
					// 선생이 학생을 발견
					if(map[nx][ny] == 'S') {
						return false;
					}
				}
			}
		}
		return true;
	}
}

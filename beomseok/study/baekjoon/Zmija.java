package baekjoon;
//น้มุ 3190 น์

import java.io.*;
import java.util.*;

public class Zmija {
	static int N, K, L;
	static int r, c;
	static int[][] arr;
	static List<int[]> snake;
	static Map<Integer, String> changeDir;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		snake = new ArrayList<int[]>();
		snake.add(new int[] {1,1});
		
		for (int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr[r][c] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		changeDir = new HashMap<>();
		for (int i=0; i<L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			changeDir.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		dfs(0, 0, 0);
		System.out.println(cnt);
	}
	public static int dfs(int x, int y, int dir) {
		cnt = 0;
		while(true) {
			cnt++;
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
				break;
			}
			
			for (int i=0; i<snake.size(); i++) {	
				if(nx == snake.get(i)[1] && ny == snake.get(i)[0]) {
					return cnt;
				}
			}
			
			if(arr[ny][nx] == 1) {
				arr[ny][nx] = 0;
				snake.add(new int[] {ny, nx}); 
			}else {
				snake.add(new int[] {ny, nx}); 
				snake.remove(0); 
			}
			
			x = nx; 
			y = ny;
			
			if(changeDir.containsKey(cnt)) { 
				if(changeDir.get(cnt).equals("D")) { 
					dir++;
					if(dir == 4) {
						dir = 0;
					}
				} else if(changeDir.get(cnt).equals("L")) { 
					dir--;
					if(dir == -1) {
						dir = 3;
					}
				}
			}
		}
		return cnt;
	}
}

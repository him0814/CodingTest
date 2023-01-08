package BOJ;

/*
백준 #3190 뱀
 */

import java.io.*;
import java.util.*;

public class boj_3190 {
	
	/*
	index = 0 -> 동
	index = 1 -> 남
	index = 2 -> 서
	index = 3 -> 북
	 */
	static int[] dx = {0, 1, 0, -1}; // 동 남 서 북
	static int[] dy = {1, 0, -1, 0};
	static int index = 0; // 뱀은 처음에 오른쪽으로 움직이기 때문에
	static int n, k, l;
	static int time = 0;
	static int[][] map;
	static HashMap<Integer, String> hm = new HashMap<>(); // key: 시간 / value: 방향(D,L)
	static List<int[]> snake = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row][col] = 1;
		}
		
//		예제 출력
//		for(int i = 1; i < n+1; i++) {
//			for(int j = 1; j < n+1; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		l = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			hm.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		snake.add(new int[] {1, 1});
		
		solve();
		
		System.out.println(time);
	}

	private static void solve() {
		// 뱀 처음 위치 좌표
		int x = 1;
		int y = 1;
		
		while(true) {
			time++;
			int nx = x + dx[index];
			int ny = y + dy[index];
			
			// 종료 조건 -> 1. 벽에 부딪혔을 때  / 2. 뱀 자신에게 부딪혔을 때
			if(finsh(nx, ny)) {
				break;
			}
			
			// 뱀이 사과를 먹었을 때
			if(map[nx][ny] == 1) {
				map[nx][ny] = 0;
				// 뱀 머리 좌표 추가
				snake.add(new int[] {nx, ny});
			} else {
			// 뱀이 사과를 안 먹었을 때
				snake.add(new int[] {nx, ny});
				// 꼬리 컷
				snake.remove(0);
			}
			
			// 좌표 갱신
			x = nx;
			y = ny;
 			
			// 특정 시간 후 방향 전환
			if(hm.containsKey(time)) {
				/*
				index = 0 -> 동
				index = 1 -> 남
				index = 2 -> 서
				index = 3 -> 북
				 */
				
				// value: D -> 동->남 / 남 -> 서 / 서 -> 북 / 북 -> 동
				if(hm.get(time).equals("D")) {
					index++;
					// 북 -> 동 일 때
					if(index == 4) {
						index = 0;
					}					
				}
				// value: L -> 서 -> 남 / 남 -> 동 / 동 -> 북 / 북 -> 서
				if(hm.get(time).equals("L")) {
					index--;
					// 동 -> 북 일 때
					if(index == -1) {
						index = 3;
					}
				}
			}
		}
	}

	static boolean finsh(int nx, int ny) {
		// 1. 벽에 부딪혔을 때
		if(nx < 1 || ny < 1 || nx >= n+1 || ny >= n+1) {
			return true;
		}
		
		// 2. 뱀 자신에게 부딪혔을 때
		// -> 리스트 snake 크기만큼 돌면서 nx,ny가 snake 리스트 좌표랑 같을 때
		for(int i = 0; i < snake.size(); i++) {
			if(nx == snake.get(i)[0] && ny == snake.get(i)[1]) {
				return true;
			}
		}
		return false;
	}
}

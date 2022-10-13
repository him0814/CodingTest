package BOJ;


/*
���� #7562 ����Ʈ�� �̵�
lxl ü���� / ���� ����Ʈ ��ġ / ����Ʈ�� �̵��Ϸ��� ��ġ

dx dy �� �� ��ĭ �밢�� ��ĭ�̹Ƿ�

 x y
(1,2)
(1,-2)
(-1,2)
(-1,-2)
(2,1)
(2,-1)
(-2,1)
(-2,-1)
 */

import java.io.*;
import java.util.*;

public class boj_7562 {
	
	// ����Ʈ�� ������ ��ĭ �밢�� ��ĭ �����̹Ƿ�
	static int[] dx = {-2, -2, 2, 2, 1, 1, -1, -1}; 
	static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
	static int l;
	static int now_x, now_y;
	static int target_x, target_y;
	static int[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_cnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_cnt; i++) {
			l = Integer.parseInt(br.readLine());
			
			map = new int[l][l];
			visit = new boolean[l][l];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			now_x = Integer.parseInt(st.nextToken());
			now_y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			target_x = Integer.parseInt(st.nextToken());
			target_y = Integer.parseInt(st.nextToken());
			
			if(!visit[now_x][now_y] && map[now_x][now_y] == 0) {
				visit[now_x][now_y] = true;
				bfs(now_x, now_y);
			}
						
			System.out.println(map[target_x][target_y]);
		}
	} 
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int now_x = now[0];
			int now_y = now[1];
			
			for(int i = 0; i < 8; i++) {
				int nx = now_x + dx[i];
				int ny = now_y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= l || ny >= l) {
					continue;
				}
				
				if(!visit[nx][ny] && map[nx][ny] == 0) {
					visit[nx][ny] = true;
					map[nx][ny] = map[now_x][now_y] + 1;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
	}
}

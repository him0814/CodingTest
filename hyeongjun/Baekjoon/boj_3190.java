package BOJ;

/*
���� #3190 ��
 */

import java.io.*;
import java.util.*;

public class boj_3190 {
	
	/*
	index = 0 -> ��
	index = 1 -> ��
	index = 2 -> ��
	index = 3 -> ��
	 */
	static int[] dx = {0, 1, 0, -1}; // �� �� �� ��
	static int[] dy = {1, 0, -1, 0};
	static int index = 0; // ���� ó���� ���������� �����̱� ������
	static int n, k, l;
	static int time = 0;
	static int[][] map;
	static HashMap<Integer, String> hm = new HashMap<>(); // key: �ð� / value: ����(D,L)
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
		
//		���� ���
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
		// �� ó�� ��ġ ��ǥ
		int x = 1;
		int y = 1;
		
		while(true) {
			time++;
			int nx = x + dx[index];
			int ny = y + dy[index];
			
			// ���� ���� -> 1. ���� �ε����� ��  / 2. �� �ڽſ��� �ε����� ��
			if(finsh(nx, ny)) {
				break;
			}
			
			// ���� ����� �Ծ��� ��
			if(map[nx][ny] == 1) {
				map[nx][ny] = 0;
				// �� �Ӹ� ��ǥ �߰�
				snake.add(new int[] {nx, ny});
			} else {
			// ���� ����� �� �Ծ��� ��
				snake.add(new int[] {nx, ny});
				// ���� ��
				snake.remove(0);
			}
			
			// ��ǥ ����
			x = nx;
			y = ny;
 			
			// Ư�� �ð� �� ���� ��ȯ
			if(hm.containsKey(time)) {
				/*
				index = 0 -> ��
				index = 1 -> ��
				index = 2 -> ��
				index = 3 -> ��
				 */
				
				// value: D -> ��->�� / �� -> �� / �� -> �� / �� -> ��
				if(hm.get(time).equals("D")) {
					index++;
					// �� -> �� �� ��
					if(index == 4) {
						index = 0;
					}					
				}
				// value: L -> �� -> �� / �� -> �� / �� -> �� / �� -> ��
				if(hm.get(time).equals("L")) {
					index--;
					// �� -> �� �� ��
					if(index == -1) {
						index = 3;
					}
				}
			}
		}
	}

	static boolean finsh(int nx, int ny) {
		// 1. ���� �ε����� ��
		if(nx < 1 || ny < 1 || nx >= n+1 || ny >= n+1) {
			return true;
		}
		
		// 2. �� �ڽſ��� �ε����� ��
		// -> ����Ʈ snake ũ�⸸ŭ ���鼭 nx,ny�� snake ����Ʈ ��ǥ�� ���� ��
		for(int i = 0; i < snake.size(); i++) {
			if(nx == snake.get(i)[0] && ny == snake.get(i)[1]) {
				return true;
			}
		}
		return false;
	}
}

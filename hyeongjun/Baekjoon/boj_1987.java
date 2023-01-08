package BOJ;

/*
���� #1987 ���ĺ�

dfs / dx dy
�̹� ������ ���ĺ� ó�� -> hashset

-----------------------------------
map[i][j] = str.charAt(j) - 'A';
boolean[] visit = new visit[26]; // ���ĺ��� 26��
visit[0] = ture;

 */

import java.io.*;
import java.util.*;

public class boj_1987 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int r, c;
	static char[][] map;
	// �ߺ� Ȯ���� ���� hashset
	static HashSet<Character> set = new HashSet<>();
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		
		// map[y][x]
		for(int i = 0; i < r; i++) {
			String str = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		dfs(0, 0);
		System.out.println(max);
	}

	private static void dfs(int x, int y) {
		// �̹� ������ ���ĺ��̸� return;
		if(set.contains(map[x][y])) {
			return;
		}
		
		set.add(map[x][y]);
		max = Math.max(max, set.size());
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// map ���� ���̸� continue;
			if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
				continue;
			}
			// ���ο� ��ǥ�� �̹� ������ ���ĺ��̸� continue;
			if(set.contains(map[nx][ny])) {
				continue;
			}
			
			dfs(nx, ny);
			set.remove(map[nx][ny]);
		}
		
	}
}

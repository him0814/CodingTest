package BOJ;

/*
백준 #1987 알파벳

dfs / dx dy
이미 지나온 알파벳 처리 -> hashset

-----------------------------------
map[i][j] = str.charAt(j) - 'A';
boolean[] visit = new visit[26]; // 알파벳이 26개
visit[0] = ture;

 */

import java.io.*;
import java.util.*;

public class boj_1987 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int r, c;
	static char[][] map;
	// 중복 확인을 위한 hashset
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
		// 이미 지나온 알파벳이면 return;
		if(set.contains(map[x][y])) {
			return;
		}
		
		set.add(map[x][y]);
		max = Math.max(max, set.size());
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// map 범위 밖이면 continue;
			if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
				continue;
			}
			// 새로운 좌표가 이미 지나간 알파벳이면 continue;
			if(set.contains(map[nx][ny])) {
				continue;
			}
			
			dfs(nx, ny);
			set.remove(map[nx][ny]);
		}
		
	}
}

package BOJ;

/*
���� #2239 ������
*/

import java.io.*;

public class boj_2239 {
	
	static int[][] map;
	static boolean flag = false;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		map = new int[9][9];
		String str= br.readLine();

		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		dfs(0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static boolean dfs(int depth) {
		if(depth == 81) {
			return true;
		}
		
		int row = depth / 9;
		int col = depth % 9;
		
		// map�� 0�� �ƴϸ� ���
		if(map[row][col] != 0) {
			return dfs(depth+1);
		} else {
			for(int i = 1; i <= 9; i++) {
				// ��, ��, 3x3�� ��ġ�� ���ڰ� �ִ��� Ȯ��
				if(!check(row, col, i)) {
					continue;
				}
				map[row][col] = i;
				if(dfs(depth+1)) {
					return true;
				}
				map[row][col] = 0;
			}
		}
		return false;
	}

	public static boolean check(int row, int col, int num) {
		// ��, �� Ȯ��
		for(int i = 0; i < 9; i++) {
			if(map[i][col] == num || map[row][i] == num) {
				return false;
			}
		}
		
		// 3x3 Ȯ��
		int nrow = row/3 * 3;
		int ncol = col/3 * 3;
		
		for(int i = nrow; i < nrow+3; i++) {
			for(int j = ncol; j < ncol+3; j++) {
				if(map[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}
}

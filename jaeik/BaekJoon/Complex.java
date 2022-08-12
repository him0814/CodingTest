package BaekJoon;

import java.util.*;
import java.io.*;

public class Complex {
	
	static int N;
	static int[][] arr;
	static boolean[][] visit;
	static List<Integer> answer;
	static int count = 0;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		answer = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		answer.add(count, 0);
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 1 && !visit[i][j]) {
					dfs(i, j);
					count++;
					answer.add(count, 0);
				}
			}
		}
		answer.remove(count);
		System.out.println(count);
		Collections.sort(answer);
		for(int i : answer) {
			System.out.println(i);
		}
	}
	
	static void dfs(int r, int c) {
		visit[r][c] = true;
		answer.set(count, answer.get(count) + 1);
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if(arr[nr][nc] == 1 && !visit[nr][nc]) {
					dfs(nr, nc);
				}
			}			
		}
	}
}

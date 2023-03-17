package baekjoon;
//백준 2239 스도쿠

import java.io.*;
import java.util.*;

public class Sudoku {
	static int[][] arr = new int[9][9];;
	static List<int[]> al = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			String str = br.readLine();
			for(int j=0; j<9; j++) {
				arr[i][j] = str.charAt(j) - '0';
				if(arr[i][j] == 0) {
					al.add(new int[] {i, j});
				}
			}
		}
		
		dfs(0);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	private static boolean dfs(int depth) {
		if(depth == al.size()) {
			return true;
		}
		
		int nx = al.get(depth)[0];
		int ny = al.get(depth)[1];
		
		for(int i=1; i<10; i++){
			arr[nx][ny] = i;
			if(check(nx, ny) && dfs(depth+1)){
				return true;
			}
		}
		
		arr[nx][ny] = 0;
		return false;
	}
	
	private static boolean check(int nx, int ny) {
		for(int i=0; i<9; i++){
			if(nx!=i && arr[i][ny] == arr[nx][ny]) {
				return false;
			}
			if(ny!=i && arr[nx][i] == arr[nx][ny]) {
				return false;
			}
		}

		for (int i=(nx/3)*3,k=0; k<3; k++,i++) {
			for (int j=(ny/3)*3,l=0; l<3; l++,j++) {
				if (i != nx && j != ny && arr[i][j] == arr[nx][ny]) {
					return false;
				}
			}
		}
		return true;
	}
}

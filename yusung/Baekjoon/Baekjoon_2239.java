package Baekjoon;

import java.io.*;

//백준 2239 스도쿠
public class Baekjoon_2239 {
	static StringBuilder sb;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		sb = new StringBuilder();		
		arr = new int[9][9];
		char[] arr2 = new char[9];		
		
		for (int i = 0; i < 9; i++) {
			arr2 = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = arr2[j] - '0';				
			}
		}			
		dfs(0,0);		
	}

	private static void dfs(int x, int y) {
		if(y == 9) {
			dfs(x+1, 0);
			return;
		}
		else if(x==9) {
			print();
		}		
		if(arr[x][y] == 0) {
			for(int i=1; i<=9; i++) {
				if(check(x,y,i)) {
					arr[x][y] = i;
					dfs(x,y+1);
				}
			}
			arr[x][y] = 0;
			return;
		}
		dfs(x,y+1);		
	}
	private static void print() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		System.exit(0);
	}

	private static boolean check(int x, int y, int cnt) {
		for(int i=0; i<9; i++) {
			if(arr[x][i] == cnt) {
				return false;
			}
		}
		for(int i=0; i<9; i++) {
			if(arr[i][y] == cnt) {
				return false;
			}
		}
		int x3 = x/3*3;
		int y3 = y/3*3;
		for(int i=x3; i<x3+3; i++) {
			for(int j=y3; j<y3+3; j++) {
				if(arr[i][j] == cnt) {
					return false;
				}
			}
		}
		return true;
	}
}

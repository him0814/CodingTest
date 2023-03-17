package baekjoon;
//백준 18428 감시 피하기

import java.io.*;
import java.util.*;

public class AvoidSurveillance {
	static int N;
	static char[][] arr;
	static List<int[]> al;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		al = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = st.nextToken().charAt(0);
				if(arr[i][j] == 'T') {
					al.add(new int[] {i,j});
				}
			}
		}
		flag = false;
		dfs(0, 0);
		if(flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	public static void dfs(int at, int depth) {
		if(flag) return;
		if(at == N*N) return;
		if(depth == 3) {
			if(student()) {
				flag = true;
			}
			return;
		}
		
		int row = at / N;
		int col = at % N;
		
		if(arr[row][col] == 'X') {
			arr[row][col] = 'O';
			dfs(at+1, depth+1);
			arr[row][col] = 'X';
		}
		dfs(at+1, depth);
	}

	public static boolean student() {
		for (int[] t : al) {
			for (int i = 0; i < 4; i++) {
				int nr = t[0];
				int nc = t[1];
				while (true) {
					int nx = nr + dx[i];
					int ny = nc + dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 'O') {
						break;
					} 
					if (arr[nx][ny] == 'S') {
						return false;
					}
					nr = nx;
					nc = ny;
				}
			}
		}
		return true;
	}
}

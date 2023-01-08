package BOJ;

/*
백준 #9663 N-Queen

한 열에는 하나의 퀸만 존재 -> 일차원 배열 사용 가능
ex) map = {4,3,2,1,0}  ->  0행4열, 1행3열, 2행2열, 3행1열, 4행0열

< / 대각선 >       -> 행 + 열
  
 0 1 2 3 4 5
 1 2 3 4 5 6
 2 3 4 5 6 7
 3 4 5 6 7 8
 4 5 6 7 8 9
 5 6 7 8 9 10

< \ 대각선 >        -> 행 - 열

 0 -1 -2 -3 -4 -5
 1  0 -1 -2 -3 -4
 2  1  0 -1 -2 -3
 3  2  1  0 -1 -2
 4  3  2  1  0 -1
 5  4  3  2  1  0

음수,,,,,,,,처리,,,,,,,,,
특정 숫자 더해주면 

-> 행 - 열 + n -1 -> / 대각선처럼 만들어짐
 5 4 3 2 1 0
 6 5 4 3 2 1
 7 6 5 4 3 2
 8 7 6 5 4 3
 9 8 7 6 5 4
10 9 8 7 6 5

 */

import java.io.*;

public class boj_9663 {
	
	static int n;
	static int count;
	static boolean[] column_visit; // 열
	static boolean[] R_diag_visit; //   / 대각선
	static boolean[] L_diag_visit; //   \ 대각선
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		column_visit = new boolean[n];
		R_diag_visit = new boolean[2*n - 1];
		L_diag_visit = new boolean[2*n - 1];
		
		dfs(0);
		
		System.out.println(count);
	}

	private static void dfs(int row) {
		// n행이면
		if(row == n) {
			count++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(column_visit[i] || R_diag_visit[i + row] || L_diag_visit[i-row+n-1]) {
				continue;
			}
			
			column_visit[i] = true;         //  열 
			R_diag_visit[i + row] = true;   //  / 대각선
			L_diag_visit[i-row+n-1] = true; //  \ 대각선
			dfs(row+1);
			column_visit[i] = false;
			R_diag_visit[i + row] = false;
			L_diag_visit[i-row+n-1] = false;
		}
	}
}

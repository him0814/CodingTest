package BaekJoon;

// M * N 크기의 보드 8 * 8 체스판으로
// 검 흰 번갈아서 두 가지 경우 맨 왼위 흰 or 검
// 8 <= N, M <= 50

import java.io.*;
import java.util.*;

public class Chess_drow {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		int min = 100;
		
		for(int i = 0; i <= N - 8; i++) {
			
			for(int j = 0; j <= M - 8; j++) {
				int startB = 0;
				int startW = 0;
				
				for(int k = 0; k < 8; k++) {
					for(int l = 0;  l < 8; l++) {
						if((k + l) % 2 == 0 && board[i+k][j+l] == 'B') {
							startW++;
						}
						if((k + l) % 2 == 0 && board[i+k][j+l] == 'W') {
							startB++;
						}
						if((k + l) % 2 == 1 && board[i+k][j+l] == 'B') {
							startB++;
						}
						if((k + l) % 2 == 1 && board[i+k][j+l] == 'W') {
							startW++;
						}
					}
					
				}
				min = Math.min(min, Math.min(startB, startW));
			}
		}
		
		System.out.print(min);
	}
}

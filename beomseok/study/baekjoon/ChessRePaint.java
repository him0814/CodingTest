package baekjoon;
//체스판 다시 칠하기 백준 1018

//체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 함.
//8*8 체스판 만큼 잘라서 다시 칠해야 할 정사각형 최소 개수 출력
//첫째 줄에 N과 M
//N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수
//둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색

import java.io.*;
import java.util.*;

public class ChessRePaint {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] chessBoard = new String[n];
		String[] chessBoard_W = new String[8];
		String[] chessBoard_B = new String[8];

		for (int i = 0; i < n; i++) {
			chessBoard[i] = br.readLine();
		}
		for (int j = 0; j < 8; j++) {
			if(j%2==0) {
				chessBoard_W[j] = "WBWBWBWB";
			} else {
				chessBoard_W[j] = "BWBWBWBW";
			}
		}
		for (int k = 0; k < 8; k++) {
			if(k%2==0) {
				chessBoard_B[k] = "BWBWBWBW";
			} else {
				chessBoard_B[k] = "WBWBWBWB";
			}
		}
		
		int board = 64;
		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				int cnt_W = 0;
				int cnt_B = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if(chessBoard_W[k].charAt(l) != chessBoard[k+i].charAt(l+j)) {
							cnt_W++;
						}
						if(chessBoard_B[k].charAt(l) != chessBoard[k+i].charAt(l+j)) {
							cnt_B++;
						}
					}
				}
				board = Math.min(Math.min(cnt_W, cnt_B), board);
			}
		}
		System.out.println(board);
	}
}

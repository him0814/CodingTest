package baekjoon;
//ü���� �ٽ� ĥ�ϱ� ���� 1018

//ü������ �������� ����� �����Ƽ� ĥ���� �־�� ��.
//8*8 ü���� ��ŭ �߶� �ٽ� ĥ�ؾ� �� ���簢�� �ּ� ���� ���
//ù° �ٿ� N�� M
//N�� M�� 8���� ũ�ų� ����, 50���� �۰ų� ���� �ڿ���
//��° �ٺ��� N���� �ٿ��� ������ �� ���� ���°� �־�����. B�� �������̸�, W�� ���

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

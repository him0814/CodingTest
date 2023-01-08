package BOJ;

/*
���� #7573 �������

 */

import java.io.*;
import java.util.*;

public class boj_7573 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		
		ArrayList<int[]> al = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			al.add(new int[] {x,y});
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 1; k < l/2; k++) {
					int tmp = 0; // ������ ����� ������
					for(int p = 0; p < m; p++) {
						if(al.get(i)[0] <= al.get(p)[0] && al.get(p)[0] <= al.get(i)[0]+k && al.get(j)[1] <= al.get(p)[1] && al.get(p)[1] <= al.get(j)[1]+l/2-k) {
							tmp++;
						}
					}
					if(max < tmp) {
						max = tmp;
					}
				}
			}
		}
		
		System.out.println(max);
		
//		boolean[][] map = new boolean[n + 1][n + 1];
//
//		for (int i = 0; i < m; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
//		}
//
//		for (int i = 1; i < l / 2; i++) {
//			int x = i; // ����
//			int y = (l / 2) - i; // ����
//
//			for (int j = 1; j <= n - x; j++) {// �Ʒ��� �̵��ϸ鼭
//				for (int k = 1; k <= n - y; k++) {// ������ �̵��ϸ鼭
//					int cnt = 0;
//					for (int p = j; p <= j + x; p++) {// ������ ����� ��
//						for (int q = k; q <= k + y; q++) {
//							if (map[p][q]) {
//								cnt++;
//							}
//						}
//					}
//					if (max < cnt) {
//						max = cnt;
//					}
//				}
//			}
//		}
//		
//		System.out.println(max);
	}
}

package Baekjoon;

import java.io.*;
import java.util.*;

//백준 7573번 고기잡이
// 2<= n <= 10000
// 4<= l <= 100
// 1<= m <= 100

public class Baekjoon_7573 {

	static int cnt = Integer.MIN_VALUE;
	static ArrayList<int[]> al;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		al = new ArrayList<int[]>();
		// 물고기 위치 리스트에 넣기
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			al.add(new int[] { a, b });
		}

		// 그물의 크기 구하는거
		for (int j = 0; j < m; j++) {
			for (int k = 0; k < m; k++) {
				for (int i = 1; i < (l / 2); i++) {
					int width = i;
					int length = (l / 2) - i;
					search(width, length, j, k);
				}
			}
		}
		System.out.println(cnt);

//		배열에 들어갔나 출력확인
//		for(int i=1; i<=m+1; i++) {
//			for(int j=1; j<=m+1; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}

	}

	private static void search(int width, int length, int x, int y) {
		int count = 0;

		int[] p = al.get(x); // al.get(0)
		int[] q = al.get(y); // al.get(0)
		int dx = Math.min(p[0], q[0]);
		int dy = Math.min(p[1], q[1]);

		for (int i = 0; i < al.size(); i++) {
			int[] fish = al.get(i);
			int nx = fish[0];
			int ny = fish[1];
			if (nx >= dx && ny >= dy && nx <= dx + width && ny <= dy + length) {
				count++;
			}
			cnt = Math.max(cnt, count);
		}
	}
}

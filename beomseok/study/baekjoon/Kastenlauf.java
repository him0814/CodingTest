package baekjoon;
//맥주 마시면서 걸어가기 백준 9205

import java.io.*;
import java.util.*;

public class Kastenlauf {
	static int t, n;
	static int nowA, nowB;
	static int nextA, nextB;
	static int arr[][];
	static boolean visit[][];
	static int dx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int dy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			
		}
		arr = new int[n][n];
		visit = new boolean[n+2][n+2];
	}
}

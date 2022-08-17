package baekjoon;
//촌수계산 백준 2644

import java.io.*;
import java.util.*;

public class KinshipCalculation {
	static int n, num1, num2, m;
	static int x, y;
	static int arr[][];
	static int chonsu[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());

		arr = new int[n + 1][n + 1];
		chonsu = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		bfs(num1, num2);
		if (chonsu[num2] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(chonsu[num2]);
		}
	}

	public static void bfs(int a, int b) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(a);
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == b)
				break;
			for (int i = 1; i <= n; i++) {
				if (arr[now][i] == 1 && chonsu[i] == 0) {
					chonsu[i] = chonsu[now] + 1;
					q.offer(i);
				}
			}
		}
	}
}

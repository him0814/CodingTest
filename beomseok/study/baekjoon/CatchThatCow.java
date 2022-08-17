package baekjoon;
//숨바꼭질 백준 1697

import java.io.*;
import java.util.*;

public class CatchThatCow {
	static int n, k;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n>=k) {
			System.out.println(n-k);
		} else {
			System.out.println(bfs(n,k));
		}

	}

	static int bfs(int a, int b) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(a);
		arr = new int[100001];
		arr[a] = 1;

		while (!q.isEmpty()) {
			int x = q.poll();

			for (int i = 0; i < 3; i++) {
				int next = 0;
				if (i == 0) {
					next = x - 1;
				} else if (i == 1) {
					next = x + 1;
				} else if (i == 2) {
					next = x * 2;
				}
				if(next == b) {
					return arr[x];
				}
				if (0 <= next && next <= 100000) {
					if (arr[next] == 0) {
						q.offer(next);
						arr[next] = arr[x] + 1;
					}
				}
			}
		}
		return 0;
	}
}

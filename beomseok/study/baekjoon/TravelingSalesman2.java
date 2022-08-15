package baekjoon;
//외판원 순회 백준 10971

import java.io.*;
import java.util.*;

public class TravelingSalesman2 {
	static int n;
	static int min;
	static int arr[][];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visit = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			dfs(i,i,0,0);
		}
		System.out.println(min);
	}
	public static void dfs(int start, int now, int cnt, int cost) {
		if (cnt == n && start == now) {
			min = Math.min(min, cost);
			return;
		}
		for (int i = 0; i < n; i++) {
			if(arr[now][i] == 0)
				continue;
			if (arr[now][i] > 0 && !visit[now]) {
				visit[now] = true;
				cost += arr[now][i];
				dfs(start, i, cnt+1, cost);
				cost -= arr[now][i];
				visit[now] = false;
			}
		}
	}
}

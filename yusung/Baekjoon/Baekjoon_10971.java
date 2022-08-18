package Baekjoon;

import java.io.*;
import java.util.*;

//백준 10971번 외판원순회2
//첫째줄에 도시의 수 N개가 주어짐, 그 다음 N개의 줄에는 비용행렬이 주어진다.
//이때 W[i][j]는 도시 i에서 j로 가기 위한 비용을 나타내고, 이는 대칭적이지 않다 따라서 w[j][i]랑 w[i][j]랑 다를 수 있다.
//W[i][i]는 항상 0이다.
//외판원이 모든 도시를 순회하고 다시 원래도시로 돌아올 때 가장 적은 비용이 들이는 여행계획을 세우려고하고, 이때 최소비용을 출력한다.

public class Baekjoon_10971 {

	static int N;
	static int arr[][];
	static boolean visit[];
	static int answer;
	static int at;
	static int sum;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			dfs(i, i, 0, 0);
		}
		System.out.println(min);
	}

	public static void dfs(int start, int now, int cnt, int cost) {
		if (cnt == N && start == now) {
			min = Math.min(min, cost);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (arr[now][i] == 0)
				continue;
			if (arr[now][i] > 0 && !visit[now]) {
				visit[now] = true;
				cost += arr[now][i];
				dfs(start, i, cnt + 1, cost);
				cost -= arr[now][i];
				visit[now] = false;
			}
		}
	}
}

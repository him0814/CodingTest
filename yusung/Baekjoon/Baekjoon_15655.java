package Baekjoon;

import java.io.*;
import java.util.*;

//백준 15655 N과 M(6)
//dfs 
//첫째줄에 N과 M이 주어짐(1<=M<=N<=8)
//둘째줄에 N개의 수가 주어짐(1<=num<=10000)
//시간제한 1초
//N개의 자연수 중에서 M개를 고른 수열 출력
//입력받은 N개의 자연수가 주어짐 이때 M개를 고르는 수열 출력
//사전순으로 출력해야되므로 배열에 넣고 정렬하면될듯

public class Baekjoon_15655 {

	static int N;
	static int M;
	static int answer[];
	static boolean visit[];
	static int now[];

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		now = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			now[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(now);

		answer = new int[M];
		visit = new boolean[N];
		
		//앞에 문제와 다르게 at을 0으로 넘겨줘야됨 왜 why? now배열의 index로 i가 들어가야되기때문
		dfs(0, 0);
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	public static void dfs(int depth, int at) {
		if (depth == M) {
			for (int i = 0; i < answer.length; i++) {
				sb.append(answer[i] + " ");
			}
			sb.append("\n");
			return;
		}

		//따라서 for문도 범위가 달라져야함
		for (int i = at; i <N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				answer[depth] = now[i];
				dfs(depth+1, i);
				visit[i] = false;
			}
		}
	}
}
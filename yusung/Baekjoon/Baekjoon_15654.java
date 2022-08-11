package Baekjoon;

import java.io.*;
import java.util.*;

//백준 15654 N과 M(5)
//dfs 
//첫째줄에 N과 M이 주어짐(1<=M<=N<=8)
//둘째줄에 N개의 수가 주어짐(1<=num<=10000)
//시간제한 1초
//N개의 자연수 중에서 M개를 고른 수열 출력
//입력받은 N개의 자연수가 주어짐 이때 M개를 고르는 수열 출력
//사전순으로 출력해야되므로 배열에 넣고 정렬하면될듯

public class Baekjoon_15654 {

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
		st=new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			now[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(now);
		
		answer = new int[M];
		visit = new boolean[N];
		dfs(0);
		System.out.println(sb.toString());
	}

	public static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < answer.length; i++) {
				sb.append(answer[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				answer[depth] = now[i];
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
}
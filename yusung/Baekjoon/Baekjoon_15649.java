package Baekjoon;

import java.io.*;
import java.util.*;

//백준 15649 N과 M(1)
//dfs visit으로 방문한 노드의 상태를 바꿔준다
//첫째줄에 N과 M이 주어짐(1<=M<=N<=8)
//시간제한 1초
//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 출력
//nPm -> n!/(n-m)!
//4P2 -> 4!/2!

public class Baekjoon_15649 {

	static int N;
	static int M;
	static int arr[];
	static boolean visit[];

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visit = new boolean[N];
		dfs(0);
		System.out.println(sb.toString());
	}

	public static void dfs(int depth) {
		if(depth==M) {			
			for(int i=0; i<arr.length; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}
}

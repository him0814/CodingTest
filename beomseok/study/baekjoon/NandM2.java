package baekjoon;
//N과M(2) 백준 15650

//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
//고른 수열은 오름차순이어야 한다.

import java.io.*;
import java.util.*;

public class NandM2 {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visit = new boolean[n];
		
		dfs(0, 1);
		System.out.println(sb);
	}
	public static void dfs(int depth, int at) {
		if(depth == m) {
			for(int i: arr) {
				sb.append(i).append(' ');
			}
			sb.append("\n");
			return;
		}
		for(int i=at; i<=n; i++) {
				arr[depth] = i;
				dfs(depth+1, i+1);
		}
	}
}

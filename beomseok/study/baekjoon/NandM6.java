package baekjoon;
//N과M(6) 백준 15655

//N개의 자연수 중에서 M개를 고른 수열
//고른 수열은 오름차순이어야 한다.

import java.io.*;
import java.util.*;

public class NandM6 {
	static int n;
	static int m;
	static int[] arr;
	static int[] num;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		arr = new int[m];
		visit = new boolean[n];
		
		Arrays.sort(num);
		dfs(0,0);
		System.out.println(sb);
	}
	public static void dfs(int depth, int at) {
		if(depth == m) {
			for(int a: arr) {
				sb.append(a).append(' ');
			}
			sb.append("\n");
			return;
		}
		for(int i=at; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = num[i];
				dfs(depth+1, i+1);
				visit[i] = false;
			}
		}
	}
}

package baekjoon;
//N과M(7) 백준 15656

//N개의 자연수 중에서 M개를 고른 수열
//같은 수를 여러 번 골라도 된다.

import java.io.*;
import java.util.*;

public class NandM7 {
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
		dfs(0);
		System.out.println(sb);
	}
	public static void dfs(int depth) {
		if(depth == m) {
			for(int a: arr) {
				sb.append(a).append(' ');
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<n; i++) {
				arr[depth] = num[i];
				dfs(depth+1);
		}
	}
}

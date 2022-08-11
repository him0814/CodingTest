package baekjoon;
//N과M(5) 백준 15654

//N개의 자연수 중에서 M개를 고른 수열

//첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8), N개의 자연수는 모두 다른 수이다.
//둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

import java.io.*;
import java.util.*;

public class NandM5 {
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
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = num[i];
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}
}

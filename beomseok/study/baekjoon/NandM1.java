package baekjoon;
//N��M(1) ���� 15649

//1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����

import java.io.*;
import java.util.*;

public class NandM1 {
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
		
		dfs(0);
		System.out.println(sb);
	}
	public static void dfs(int depth) {
		if(depth == m) {
			for(int i: arr) {
				sb.append(i).append(' ');
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}
}

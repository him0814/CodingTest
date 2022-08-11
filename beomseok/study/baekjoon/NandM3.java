package baekjoon;
//N��M(3) ���� 15651

//1���� N���� �ڿ��� �߿��� M���� �� ����
//���� ���� ���� �� ��� �ȴ�.

import java.io.*;
import java.util.*;

public class NandM3 {
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
		for(int i=1; i<=n; i++) {
				arr[depth] = i;
				dfs(depth+1);
		}
	}
}

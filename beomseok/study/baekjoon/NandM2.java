package baekjoon;
//N��M(2) ���� 15650

//1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
//�� ������ ���������̾�� �Ѵ�.

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

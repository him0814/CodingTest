package baekjoon;
//N��M(5) ���� 15654

//N���� �ڿ��� �߿��� M���� �� ����

//ù° �ٿ� N�� M�� �־�����. (1 �� M �� N �� 8), N���� �ڿ����� ��� �ٸ� ���̴�.
//��° �ٿ� N���� ���� �־�����. �Է����� �־����� ���� 10,000���� �۰ų� ���� �ڿ����̴�.

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

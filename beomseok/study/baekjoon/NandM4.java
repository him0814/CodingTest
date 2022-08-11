package baekjoon;
//N��M(4) ���� 15652

//1���� N���� �ڿ��� �߿��� M���� �� ����
//���� ���� ���� �� ��� �ȴ�.
//�� ������ �񳻸������̾�� �Ѵ�.
//(���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.)

import java.io.*;
import java.util.*;

public class NandM4 {
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
		
		dfs(1,0);
		System.out.println(sb);
	}
	public static void dfs(int at, int depth) {
		if(depth == m) {
			for(int a: arr) {
				sb.append(a).append(' ');
			}
			sb.append("\n");
			return;
		}
		for(int i=at; i<=n; i++) {
				arr[depth] = i;
				dfs(i, depth+1);
		}
	}
}

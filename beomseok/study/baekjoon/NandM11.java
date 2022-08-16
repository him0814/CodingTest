package baekjoon;
//N��M(11) ���� 15665

//N���� �ڿ��� �߿��� M���� ���� ����
//���� ���� ���� �� ��� �ȴ�.

import java.io.*;
import java.util.*;

public class NandM11 {
	static int n;
	static int m;
	static int[] arr;
	static int[] num;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		arr = new int[m];

		Arrays.sort(num);
		dfs(0);
		System.out.println(sb);
	}

	public static void dfs(int depth) {
		if (depth == m) {
			for (int a : arr) {
				sb.append(a).append(' ');
			}
			sb.append("\n");
			return;
		}
		int past = 0;
		for (int i = 0; i < n; i++) {
			if (num[i] != past) {
				arr[depth] = num[i];
				past = num[i];
				dfs(depth + 1);
			}
		}
	}
}
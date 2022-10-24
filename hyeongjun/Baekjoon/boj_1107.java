package BOJ;


/*
���� #1107 ������

n -> Ÿ��ä��
m -> ���峭 ��ư��

ä�� �ִ� 500,000
���� ä�� 100


 */

import java.io.*;
import java.util.*;

public class boj_1107 {
	
	static boolean[] error;
	static int n, m;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		error = new boolean[10];
		min = Integer.MAX_VALUE;
		
		if(m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// ���峭 ä�� -> true
			// ���� �� �ִ� ä�� -> false
			for(int i = 0; i < m; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				error[tmp] = true;
			}
		}
		
		// Ÿ��ä���� 100�̸� 0 ���
		if(n == 100) {
			System.out.println(0);
			return;
		}
		
		// ä�� n���� +.- ��ư���θ� �̵����� ��
		int pmb = Math.abs(100-n);
		if(min > pmb) {
			min = pmb;
		}
		// Math.min(min, pmb);
		// min = min > pmb ? pmb : min;
		
		dfs(0, "");
		
		System.out.println(min);
	}
	private static void dfs(int idx, String button) {
		for(int i = 0; i < 10; i++) {
			if(!error[i]) {
				String str = button + Integer.toString(i);
				// ���� ��ư ���� Ƚ�� + (+,- ��ư������ �̵��� Ƚ��)
				int count = Math.abs(n - Integer.parseInt(str)) + str.length();
				if(min > count) {
					min = count;
				}
				
				// ä���� �ִ� 500,000 -> �����ڸ���
				if(idx < 6) {
					dfs(idx+1, str);
				} 
			}
		}
	}
}

package BOJ;

/*
���� #2138 ������ ����ġ

i��° ���� ����ġ ������ i-1, i , i+1 �� �ٲ�

���� ���� �ٲٴ� ���..
-> start = start ^ 1;
 
0 ^ 0 = 0
0 ^ 1 = 1
1 ^ 0 = 1
1 ^ 1 = 0

ù��° ����ġ ������ ���� -> �ι�° ����ġ ������ ���� -> ����° ����ġ ������ ����
ó�� dfs ���� ù��° ����ġ ������ ����
i) ù��° ����ġ �� ������
ii) ù��° ����ġ  ������

 */

import java.io.*;

public class boj_2138 {
	
	static int n;
	static int[] start;
	static int[] target;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		start = new int[n];
		target = new int[n];
		
		for(int i = 0; i < 2; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				if(i == 0) {
					start[j] = str.charAt(j) - '0';
				} else {
					target[j] = str.charAt(j) - '0';
				}
			}
		}
		
		// ù��°�Ÿ� ��Ű�� ���°�
		dfs(1,0);
		
		// ù��°�Ÿ� Ű�� ���°�
		start[0] = start[0] ^ 1;
		start[1] = start[1] ^ 1;
		dfs(1,1);
		
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void dfs(int idx, int cnt) {
		if(idx == start.length - 1) {
			// n-1��° ����ġ�� ������ �ʾƵ� ���� ���
			if(start[idx] == target[idx] && start[idx - 1] == target[idx - 1]) {
				min = Math.min(min, cnt);
				return;
			}
			// n-1��° ����ġ�� ������ �������� ���
			if((start[idx]^1) == target[idx] && (start[idx - 1]^1) == target[idx - 1]) {
				min = Math.min(min, cnt+1);
				return;
			} else {
				return;
			}
		}
		
		if(start[idx - 1] == target[idx - 1]) { // idx-1��° ������ ���°� ������ ����ġ ���� �ʿ� x
			dfs(idx+1, cnt);
		} else {
			// idx��° ����ġ�� ���� ���
			start[idx] = start[idx] ^ 1;
			start[idx - 1] = start[idx - 1] ^ 1;
			start[idx + 1] = start[idx + 1] ^ 1;
			dfs(idx + 1, cnt + 1);
			start[idx] = start[idx] ^ 1;
			start[idx - 1] = start[idx - 1] ^ 1;
			start[idx + 1] = start[idx + 1] ^ 1;
		}
		return;
	}
	
	
}

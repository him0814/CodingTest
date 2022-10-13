package BOJ;

/*
���� #1697 ���ٲ���

����, ���� ���� N, K�� ��ġ
���� -> ������  N+1 or N-1 / �����̵��ϸ� 2*N

let's) 5 17
  5 10 9 18 17
  
now = 5
count[5] = 1

tmp = 6 / 4 / 10
count[10] = 2


tmp = 11 / 9 / 20
count[9] = 3

tmp = 10 / 8 / 18
count[18] = 4

tmp = 19 / 17 / 36 

*/

import java.io.*;
import java.util.*;

public class boj_1697 {

	static int n;
	static int k;
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		count = new int[100001]; // 0 <= n <= 100000
		
		if(n == k) { // ó������ n==k �� ���� �ֱ� ����
			System.out.println("0");
		} else {
			bfs(n, k);
		}
	}

	public static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		count[n] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();
			
			for(int i = 0; i < 3; i++) {
				int tmp = 0;
				
				if(i == 0) {
					tmp = now + 1;
				} else if (i == 1) {
					tmp = now - 1;
				} else if (i == 2) {
					tmp = now * 2;
				}
				
				if(tmp == k) {
					System.out.println(count[now]);
					return;
				}
				
				// tmp�� �翬�� 0~100000 ���� ���ڿ�����. count[tmp] == 0 -> ��ü�� visit ����
				if(tmp >= 0 && tmp <= 100000 && count[tmp] == 0) {
					q.offer(tmp);
					count[tmp] = count[now] + 1;
				}
			}
		}
	}
}

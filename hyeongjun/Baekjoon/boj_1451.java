package BOJ;

/*
���� #1451 ���簢������ ������

n x m ���簢���� 3���� ���簢������ �߶�
�� ���簢���� ���� ���� �� �յ��� ���� ���ϴ� ����

(n x m) ���簢���� �ڸ��� ����� �� -> 6��


 */

import java.io.*;
import java.util.*;

public class boj_1451 {
	
	static int n, m;
	static int[][] map;
	static int[][] sum;
	static long answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		sum = new int[n+1][m+1];
		
		// ���簢�� ä���
		for(int i = 1; i <= n; i++) {
			String str = " " + br.readLine();
			for(int j = 1; j <= m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		// (n x m) ���簢�� �� ���ϱ�
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				 sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + map[i][j];
			}
		}

		// ����3��
		for(int i = 1; i <= n-2; i++) {
			for(int j = i+1; j <= n-1; j++) {
				long sum1 = sum(1, 1, i, m);
				long sum2 = sum(i+1, 1, j, m);
				long sum3 = sum(j+1, 1, n, m);
				check(sum1, sum2, sum3);
			}
		}
		
		// ���� 3��
		for(int i = 1; i <= m-2; i++) {
			for(int j = i+1; j <= m-1; j++) {
				long sum1 = sum(1, 1, n, i);
				long sum2 = sum(1, i+1, n, j);
				long sum3 = sum(1, j+1, n, m);
				check(sum1, sum2, sum3);
			}
		}
		
		// ����1 ����2 or ����2 ����1 ����
		for(int i = 1; i <= n-1; i++) {
			for(int j = 1; j <= m-1; j++) {
				long sum1 = sum(1, 1, n, j);
				long sum2 = sum(1, j+1, i, m);
				long sum3 = sum(i+1, j+1, n, m);
				check(sum1, sum2, sum3);
				
				sum1 = sum(1, 1, i, j);
				sum2 = sum(i+1, 1, n, j);
				sum3 = sum(1, j+1, n, m);
				check(sum1, sum2, sum3);
				
				sum1 = sum(1, 1, i, j);
                sum2 = sum(1, j+1, i, m);
                sum3 = sum(i+1, 1, n, m);
                check(sum1, sum2, sum3);
				
                sum1 = sum(1, 1, i, m);
                sum2 = sum(i+1, 1, n, j);
                sum3 = sum(i+1, j+1, n, m);
                check(sum1, sum2, sum3);
			}
		}
		
		System.out.println(answer);
		
	}
	
	public static long sum(int x1, int y1, int x2, int y2) {
		long total = sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
		return total;
	}
	
	public static void check(long sum1, long sum2, long sum3) {
		if(answer < sum1 * sum2 * sum3) {
			answer = sum1 * sum2 * sum3;
		}
	}
}

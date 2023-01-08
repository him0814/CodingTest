package BOJ;

/*
���� #9663 N-Queen

�� ������ �ϳ��� ���� ���� -> ������ �迭 ��� ����
ex) map = {4,3,2,1,0}  ->  0��4��, 1��3��, 2��2��, 3��1��, 4��0��

< / �밢�� >       -> �� + ��
  
 0 1 2 3 4 5
 1 2 3 4 5 6
 2 3 4 5 6 7
 3 4 5 6 7 8
 4 5 6 7 8 9
 5 6 7 8 9 10

< \ �밢�� >        -> �� - ��

 0 -1 -2 -3 -4 -5
 1  0 -1 -2 -3 -4
 2  1  0 -1 -2 -3
 3  2  1  0 -1 -2
 4  3  2  1  0 -1
 5  4  3  2  1  0

����,,,,,,,,ó��,,,,,,,,,
Ư�� ���� �����ָ� 

-> �� - �� + n -1 -> / �밢��ó�� �������
 5 4 3 2 1 0
 6 5 4 3 2 1
 7 6 5 4 3 2
 8 7 6 5 4 3
 9 8 7 6 5 4
10 9 8 7 6 5

 */

import java.io.*;

public class boj_9663 {
	
	static int n;
	static int count;
	static boolean[] column_visit; // ��
	static boolean[] R_diag_visit; //   / �밢��
	static boolean[] L_diag_visit; //   \ �밢��
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		column_visit = new boolean[n];
		R_diag_visit = new boolean[2*n - 1];
		L_diag_visit = new boolean[2*n - 1];
		
		dfs(0);
		
		System.out.println(count);
	}

	private static void dfs(int row) {
		// n���̸�
		if(row == n) {
			count++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(column_visit[i] || R_diag_visit[i + row] || L_diag_visit[i-row+n-1]) {
				continue;
			}
			
			column_visit[i] = true;         //  �� 
			R_diag_visit[i + row] = true;   //  / �밢��
			L_diag_visit[i-row+n-1] = true; //  \ �밢��
			dfs(row+1);
			column_visit[i] = false;
			R_diag_visit[i + row] = false;
			L_diag_visit[i-row+n-1] = false;
		}
	}
}

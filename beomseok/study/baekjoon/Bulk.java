package baekjoon;
//��ġ ���� 7568

//(x, y), (p, q)��� �� �� x > p �׸��� y > q ��ġ  "�� ũ��"
//�� �� �Ѱ����� �� Ŭ�� ��ġ �� ũ�ٰ� ����.
//��ġ ����� ��ġ�� �� Ŭ ���� ����.
//n�� ���ܿ��� ��ġ ��� ���.

import java.io.*;
import java.util.*;

public class Bulk {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<n; j++) {
			int cnt = 1;
			for(int k=0; k<n; k++) {
				if(j == k)
					continue;
				if(arr[j][0] < arr[k][0] && arr[j][1] < arr[k][1]) {
					cnt++;
				}
			}
			sb.append(cnt + " ");
		}
		System.out.println(sb);
	}
}

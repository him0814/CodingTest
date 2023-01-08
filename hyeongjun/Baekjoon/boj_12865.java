package BOJ;

/*
���� #12865 ����� �賶

�� ��ǰ�� ������ �� < n
�� ��ǰ���� ��ġ�� �ִ��� �Ǿ����

n = 1 �� �� 
n = 2 �� ��
...
n = 7 �� ��

 */

import java.io.*;
import java.util.*;

public class boj_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[n+1];
		int[] value = new int[n+1];
		int[] bag = new int[k+1]; // ���Դ� 7���� �̹Ƿ� k+1
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			// k = 7���� �ִ� ���� �ʰ� �� �� �� ���� for��
			for(int j = k; 0 <= j - weight[i]; j--) {
				bag[j] = Math.max(bag[j], bag[j - weight[i]] + value[i]);
			}
		}
		
		System.out.println(bag[k]);
	}
}

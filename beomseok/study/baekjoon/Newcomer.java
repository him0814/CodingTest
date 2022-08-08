package baekjoon;
//���Ի�� ���� 1946

//�ٸ� ��� �����ڿ� ������ �� �����ɻ� ������ �������� ���� �� 
//��� �ϳ��� �ٸ� �����ں��� �������� �ʴ� �ڸ� ����

//ù° �ٿ��� �׽�Ʈ ���̽��� ���� T(1 �� T �� 20)
//�׽�Ʈ ���̽��� ù° �ٿ� �������� ���� N(1 �� N �� 100,000)
//��° �ٺ��� N�� �ٿ��� ������ �������� �����ɻ� ����, ���� ������ ����(���̿� ����)
//1������ N������ ������ ����

import java.util.*;
import java.io.*;

public class Newcomer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n+1];
			
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int rank = Integer.parseInt(st.nextToken());
				arr[rank] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 1;
			int first = arr[1];
			for(int k=1; k<n; k++) {
				if(arr[k] < first) {
					cnt++;
					first = arr[k];				
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
}

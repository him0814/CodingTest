package baekjoon;
//ATM ���� 11399
//N: ATM�տ� ���ִ� ����� ��
//i: 1������ N������ ��ȣ
//Pi: i�� ����� ���� �����ϴµ� �ɸ��� �ð�
//�� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� �ּڰ�
//ù° �ٿ� ����� �� N(1 �� N �� 1,000)
//��° �ٿ��� �� ����� ���� �����ϴµ� �ɸ��� �ð� Pi(1 �� Pi �� 1,000)

import java.io.*;
import java.util.*;

public class ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int front = 0; // �� �� ���
		int sum = 0; // �ּ� ��
		
		for(int j=0; j<n; j++) {
			front += arr[j];
			sum += front;
		}
		System.out.println(sum);
	}

}

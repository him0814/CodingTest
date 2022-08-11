package baekjoon;
//������ ���� 2231

//�ڿ��� N�� �������� N�� N�� �̷�� �� �ڸ����� ��
//�ڿ��� M�� �������� N�� ���, M�� N�� ������
//ù° �ٿ� �ڿ��� N(1 �� N �� 1,000,000)
//�ڿ��� N�� �־����� ��, N�� ���� ���� ������ ���
//�����ڰ� ���� ��� 0 ���

import java.io.*;

public class DigitGenerator {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = 0;
		
		for(int i=0; i<n; i++) {
			int sum = 0;
			int num = i;
			
			while(num > 0) {
				sum += num%10;
				num /= 10;
			}
			if(sum + i == n) {
				m = i;
				break;
			}
		}
		System.out.println(m);
	}		
}

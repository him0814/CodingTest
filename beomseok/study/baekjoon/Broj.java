package baekjoon;
//�� �̾�� ���� 1748

//1���� N������ ���� �̾ ��
//������� ���ο� ���� �� �ڸ� ������ ���

//ù° �ٿ� N(1 �� N �� 100,000,000)

import java.io.*;

public class Broj {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int tmp = 10;
		int cnt = 1;
		int nOfd = 0; //�ڸ� ��
		
		for(int i=1; i<=n; i++) {
			if(i == tmp) { //�ڸ� �� ���ڸ� ���� �÷��ֱ�
				cnt++;
				tmp *= 10;
			}
			nOfd += cnt;
		}
		System.out.println(nOfd);
	}
}

package baekjoon;
//������ ���� 13305

//ù ��° �ٿ��� ������ ������ ��Ÿ���� ���� N(2 �� N �� 100,000)
//���� �ٿ��� ������ �� ���ø� �����ϴ� ������ ���̰� ���� ���� ���κ��� N-1���� �ڿ���
//���� �ٿ��� �������� ���ʹ� ������ ���� ���� ���ú��� ������� N���� �ڿ���
//���� ���� ���ú��� ���� ������ ���ñ����� �Ÿ��� 1�̻� 1,000,000,000 ������ �ڿ���


import java.io.*;
import java.util.*;

public class GasStation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] len = new long[n-1];
		long[] price = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n-1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int j=0; j<n; j++) {
			price[j] = Integer.parseInt(st.nextToken());
		}
		
		long costSum = 0;
		long cheapPrice = price[0];
		
		for(int k=0; k<n-1; k++) {
			if(price[k] < cheapPrice) {
				cheapPrice = price[k];
			}
			costSum += cheapPrice * len[k];
		}
		System.out.println(costSum);
	}
}

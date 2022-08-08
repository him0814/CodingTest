package baekjoon;
//�ֽ� ���� 11501

//�ֽ� �ϳ��� ��, ���ϴ� ��ŭ ������ �ִ� �ֽ��� ��, �ƹ��͵� ����.
//�� ������ �� �� �ൿ�� ��.
//�� ���� �ֽ��� ������ �˷��־��� ��, �ִ� ������ �󸶳� �Ǵ��� ���.

//�Է� ù �� �׽�Ʈ���̽� �� T
//�׽�Ʈ���̽� ���� ù �ٿ��� ���� ���� ��Ÿ���� �ڿ��� N(2 �� N �� 1,000,000)
//��° �ٿ��� �� �� �ְ��� ��Ÿ���� N���� �ڿ������� �������� ���еǾ� ������� �־���.
//�� �� �ְ��� 10,000����

import java.io.*;
import java.util.*;

public class Stock {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> stockPrice = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				stockPrice.add(Integer.parseInt(st.nextToken()));
			}
			
			int maxPrice = 0;
			long profit = 0;
			for (int k=n-1; k>=0; k--) {
				if (stockPrice.get(k) > maxPrice) {
					maxPrice = stockPrice.get(k);
				} else {
					profit += (maxPrice - stockPrice.get(k));
				}
			}
			sb.append(profit + "\n");
		}
		System.out.println(sb);
	}
}

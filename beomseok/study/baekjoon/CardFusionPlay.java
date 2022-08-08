package baekjoon;
//ī�� ��ü ���� ���� 15903

//n: �ڿ����� ������ ī�� ���
//i: i�� ī�忣 ai
//x�� ī��� y�� ī�带 ��� �� �� �忡 ������ ���� ���� ���� ���. (x �� y)
//����� ���� x�� ī��� y�� ī�� �� �� ��ο� ���� ��.
//m���� ��ü�� ��� ���� ��, n���� ī�忡 �����ִ� ���� ��� ���� ���� �ּڰ� ���.

//ù ��° �ٿ� ī���� ������ ��Ÿ���� �� n(2 �� n �� 1,000)
//ī�� ��ü�� �� �� �ϴ����� ��Ÿ���� �� m(0 �� m �� 15*n)

import java.io.*;
import java.util.*;

public class CardFusionPlay {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Long> al = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			al.add(Long.parseLong(st.nextToken()));
		}
		
		for(int j=0; j<m; j++) {
			Collections.sort(al);
			long sum = al.get(0) + al.get(1);
			al.set(0, sum);
			al.set(1, sum);
		}
		
		long min = 0;
		for(int k=0; k<n; k++) {
			min += al.get(k);
		}
		System.out.println(min);
	}

}

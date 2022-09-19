package BOJ;

/*
���� #13305 ������
�ð����� 2�� -> 20�ﰳ

  2   3   1
5---2---4---1               -> 18

  3   3   4
1---1---1---1               -> 10

ó���� �⸧�� �����Ƿ� ù���� �����ҿ��� ù ���� ���� ��ŭ �־������
(�� ��° �⸧��)���� (������ �⸧��-1) ���� ���Ͽ� ���� �� �⸧������ ���� ���� ���̸�ŭ�� �����ؾ���
��, ���� �� �����Ҹ� �鸮�� ������ �� ���ÿ��� ���� ���ñ����� ���� ���� ��ŭ�� ����
 */

import java.io.*;
import java.util.*;

public class boj_13305 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
						
		int city_cnt = Integer.parseInt(br.readLine());
		
		long[] street = new long[city_cnt - 1];
		long[] oil_price = new long[city_cnt];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < city_cnt - 1; i++) {
			street[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < city_cnt; i++) {
			oil_price[i] = Long.parseLong(st.nextToken());
		}
		
		// long = int * int �ȵ�
		// long = int * long      or        long = long * long
//		long num = 1000000 * 1000000;
//		long num1 = 1000000 * (long)1000000;
//		
//		System.out.println(num+" "+num1);
				
		// ù ��° ���ÿ��� ������ ù ���� ���̸�ŭ �����ؾ���
		long total = oil_price[0] * street[0]; // 10��x10�� = int (-21��~21��) ������ �Ѿ
		long min = oil_price[0];
								
		for(int i = 1; i < city_cnt - 1; i++) {
			// 2 ~ n-1 �� �����鼭 min���� ������ ������ oil_price * street
			if(oil_price[i] < min) {
				total += oil_price[i] * street[i];
				min = oil_price[i];
			} else {
				total += min * street[i];
			}
 		}
		System.out.println(total);
	}
}

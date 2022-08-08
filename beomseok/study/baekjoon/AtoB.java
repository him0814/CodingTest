package baekjoon;
//A �� B ���� 16953

//2�� ���Ѵ�.
//1�� ���� ���� �����ʿ� �߰��Ѵ�.

//ù° �ٿ� A, B (1 �� A < B �� 10�� 9��)
//A�� B�� �ٲٴµ� �ʿ��� ������ �ּڰ� + 1 ���, ���� �� ���� �� -1 ���
//-> 2�� ���, 1�� ������
//-> B�� 2�� �����ų� ���� ������ 1�� ������
//-> ������ �������� �˻� �� �� ���� �ݺ�
//-> ���������� �� ���� A�� �������� �Ϸ�, A���� �۾����� -1 ����

import java.io.*;
import java.util.*;

public class AtoB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cnt = 1; // 1 ������� ��

		while (a != b) {
			if (a > b) {
				cnt = -1;
				break;
			}
			if (b % 10 == 1) {
				b /= 10;
			} else if (b % 2 == 0) {
				b /= 2;
			} else {
				cnt = -1;
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}

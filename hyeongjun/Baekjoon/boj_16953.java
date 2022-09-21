package BOJ;

/*
���� #16953 A -> B
�ð�����: 2�� -> 20��
A,B -> 10��

1. B�� 2�� �� ������ �� �� ���� ���� ��,
2. �� �������� ���� �������� 1�� ����
3. �ٽ� B�� 2�� �� ������ �� �� ���� ������
4. �ϴ� ���� A�� ������ ���� Ƚ�� ��� ( ��, �ȳ����� -1 ���)
 */

import java.io.*;
import java.util.*;

public class boj_16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int tmp = B;
		int count = 1;
		
		while(true) {
			if(tmp == A) { // tmp = A �̸� ����
				break;
			}
			if(A > tmp) { // 4. �ϴ� ���� A�� ������ ���� Ƚ�� ��� ( ��, �ȳ����� -1 ���)
				count = -1;
				break;
			}
			if(tmp % 2 == 0) { // 1. B�� 2�� �� ������ �� �� ���� ���� ��,
				tmp /= 2;
				count++;
			} else if(tmp % 10 == 1) { // 2. �� �������� ���� �������� 1�� ����
				tmp = tmp / 10;
				count++;
			} else {
				count = -1; // 1�� ���
				break;
			}
		}
		System.out.println(count);
	}
	
}
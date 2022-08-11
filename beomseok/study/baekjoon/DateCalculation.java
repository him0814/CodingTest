package baekjoon;
//��¥ ��� ���� 1476

//������ ��Ÿ���� ���� E, �¾��� ��Ÿ���� ���� S, ���� ��Ÿ���� ���� M
//(1 �� E �� 15, 1 �� S �� 28, 1 �� M �� 19)
//1���� �ر԰� ����ִ� ���󿡼��� 1 1 1
//1���� ���� ������, �� ���� ��� 1�� ����
//� ���� ������ �Ѿ�� ��쿡�� 1
//�ر԰� ��� ���󿡼� E S M�� �츮�� �˰� �ִ� ������ �� ������ ���
//ù° �ٿ� �� �� E, S, M

import java.io.*;
import java.util.*;

public class DateCalculation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());;
		int S = Integer.parseInt(st.nextToken());;
		int M = Integer.parseInt(st.nextToken());;
		int e = 1;
		int s = 1;
		int m = 1;
		int ourYear = 1;
		
		
		while(true) {
			if(e>15) e=1;
			if(s>28) s=1;
			if(m>19) m=1;
			
			if(e==E && s==S && m==M) break;
			
			e++; s++; m++; ourYear++;
		}
		System.out.println(ourYear);
	}
}

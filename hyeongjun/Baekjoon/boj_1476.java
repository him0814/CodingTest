package BOJ;

/*
���� #1476 ��¥ ���

1 �� E �� 15
1 �� S �� 28
1 �� M �� 19

ex)
1�� -> 1 1 1
15�� -> 15 15 15
16�� -> 1 16 16

e m s �� ������ ���ǿ� �°� ������Ű�鼭 year++
EMS�� ������ year ���
 */

import java.io.*;
import java.util.*;

public class boj_1476 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int e = 1;
		int s = 1;
		int m = 1;
		int year = 1;
		
		
		while(true) {
			
			if(e == E && s == S && m == M) {
				break;
			}
			
			e++;
			s++;
			m++;
			
			if(e == 16) {
				e = 1;
			}
			if(s == 29) {
				s = 1;
			}
			if(m == 20) {
				m = 1;
			}
			
			year++;			
		}
		System.out.println(year);
	}
}

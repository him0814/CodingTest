package BOJ;

/*
백준 #1476 날짜 계산

1 ≤ E ≤ 15
1 ≤ S ≤ 28
1 ≤ M ≤ 19

ex)
1년 -> 1 1 1
15년 -> 15 15 15
16년 -> 1 16 16

e m s 를 선언해 조건에 맞게 증가시키면서 year++
EMS와 같으면 year 출력
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

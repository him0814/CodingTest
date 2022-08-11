package baekjoon;
//날짜 계산 백준 1476

//지구를 나타내는 수를 E, 태양을 나타내는 수를 S, 달을 나타내는 수를 M
//(1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
//1년은 준규가 살고있는 나라에서는 1 1 1
//1년이 지날 때마다, 세 수는 모두 1씩 증가
//어떤 수가 범위를 넘어가는 경우에는 1
//준규가 사는 나라에서 E S M이 우리가 알고 있는 연도로 몇 년인지 출력
//첫째 줄에 세 수 E, S, M

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

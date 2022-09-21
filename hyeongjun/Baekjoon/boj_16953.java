package BOJ;

/*
백준 #16953 A -> B
시간제한: 2초 -> 20억
A,B -> 10억

1. B를 2로 안 나누어 질 때 까지 나눈 후,
2. 안 나눠지면 가장 오른쪽의 1을 제거
3. 다시 B를 2로 안 나누어 질 때 까지 나누기
4. 하는 도중 A가 나오면 연산 횟수 출력 ( 단, 안나오면 -1 출력)
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
			if(tmp == A) { // tmp = A 이면 종료
				break;
			}
			if(A > tmp) { // 4. 하는 도중 A가 나오면 연산 횟수 출력 ( 단, 안나오면 -1 출력)
				count = -1;
				break;
			}
			if(tmp % 2 == 0) { // 1. B를 2로 안 나누어 질 때 까지 나눈 후,
				tmp /= 2;
				count++;
			} else if(tmp % 10 == 1) { // 2. 안 나눠지면 가장 오른쪽의 1을 제거
				tmp = tmp / 10;
				count++;
			} else {
				count = -1; // 1인 경우
				break;
			}
		}
		System.out.println(count);
	}
	
}
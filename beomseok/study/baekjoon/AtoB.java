package baekjoon;
//A → B 백준 16953

//2를 곱한다.
//1을 수의 가장 오른쪽에 추가한다.

//첫째 줄에 A, B (1 ≤ A < B ≤ 10의 9승)
//A를 B로 바꾸는데 필요한 연산의 최솟값 + 1 출력, 만들 수 없을 때 -1 출력
//-> 2의 배수, 1로 끝나기
//-> B를 2로 나누거나 가장 오른쪽 1을 빼내기
//-> 나머지 연산으로 검사 후 위 과정 반복
//-> 최종적으로 그 수가 A와 같아지면 완료, A보다 작아지면 -1 츨력

import java.io.*;
import java.util.*;

public class AtoB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cnt = 1; // 1 더해줘야 됨

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

package baekjoon;
//분해합 백준 2231

//자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합
//자연수 M의 분해합이 N인 경우, M을 N의 생성자
//첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)
//자연수 N이 주어졌을 때, N의 가장 작은 생성자 출력
//생성자가 없는 경우 0 출력

import java.io.*;

public class DigitGenerator {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = 0;
		
		for(int i=0; i<n; i++) {
			int sum = 0;
			int num = i;
			
			while(num > 0) {
				sum += num%10;
				num /= 10;
			}
			if(sum + i == n) {
				m = i;
				break;
			}
		}
		System.out.println(m);
	}		
}

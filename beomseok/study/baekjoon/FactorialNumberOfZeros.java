package baekjoon;
//백준 1676 팩토리얼 0의 개수

import java.io.*;

public class FactorialNumberOfZeros {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		 
		while (N >= 5) {
			sum += N/5;
			N /= 5;
		}
		
		System.out.println(sum);
	}
}

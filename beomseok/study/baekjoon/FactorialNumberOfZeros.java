package baekjoon;
//���� 1676 ���丮�� 0�� ����

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

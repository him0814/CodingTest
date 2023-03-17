package baekjoon;
//백준 1003 피보나치 함수

import java.io.*;

public class FibonacciFunction {
	static int a;
	static int b;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);			
			sb.append(a).append(" ").append(b).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void fibonacci(int N) {
		a = 1;
		b = 0;
		sum = 1;
		
		for (int i = 0; i < N; i++) {
			a = b;
			b = sum;
			sum = a + b;
		}
	}
}

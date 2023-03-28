package baekjoon;
//백준 2407 조합

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Combination {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		BigInteger res = new BigInteger("0");
		res = check(M+1, N).divide(check(1, N-M));
		
		System.out.println(res);
	}
	
	public static BigInteger check(int a, int b) {
		BigInteger fac = new BigInteger("1");
		for (int i=a; i<=b; i++) {
			fac = fac.multiply(new BigInteger(String.valueOf(i)));
		}
		return fac;
	}
}

package BOJ;

/*
백준 #1456 거의 소수

어떤 수가 소수의 n제곰 (n>=2) -> 거의 소수

1 <= a <= b <= 10^14
b = 10^7 일 때, b^2 = 10^14 이므로 10^7까지가 범위임
 */

import java.io.*;
import java.util.*;

public class boj_1456 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int max = 10000000;
		
		boolean[] prime = new boolean[max+1];
		
		for(int i = 2; i <= max; i++) {
			for(int j = 2; j <= max; j += i) {
				prime[j] = true;
			}
		}
		
	}
}

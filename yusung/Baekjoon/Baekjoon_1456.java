package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1456번 거의 소수

public class Baekjoon_1456 {
	static int max = 10000000;
	static boolean[] bol = new boolean[max + 1];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		prime_Check();
		int cnt = 0;
		for (long i = 2; i <= max; i++) {
			if (bol[(int) i]) {
				for (long j = i; j <=B; j *= i) {
					// long j = i*i이면 i*i*i를 하는순간 long범위를 넘어가게됨 따라서
					// 밑에서 A/i를 통해 j=i*i랑 같은 식을 만들어줌
					if ((A/(double)i) > j || (B/(double)i) < j) {
						continue;
					}
					if ((A/(double)i) <= j && (B/(double)i) >= j) {
						cnt++;
					}
				}
			}
		}		
		System.out.println(cnt);
	}

	static void prime_Check() {
		bol[0] = false;
		bol[1] = false;
		
//		for(int i=2; i<=Math.sqrt(bol.length); i++) {
//			for(int j = i*i; j<bol.length; j+=i) {
//				bol[j] = true;
//			}
//		}	
		
		for (int i = 2; i <= max; i++) {
			bol[i] = true;// 전체 true로 초기화
		}

		for (int i = 2; i * i <= max; i++) {
			if (!bol[i]) {
				continue;
			}
			for (int j = i * i; j <= max; j += i) {
				bol[j] = false;// 소수아닌거 false로바꿈 -> 소수는 true로 남아있음
			}
		}
		
	}
}

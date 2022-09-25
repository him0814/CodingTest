package Baekjoon;

import java.io.*;

//백준 1436번 영화감독 숌
//666 1666 2666 3666 4666 5666 -> 6661 6662
//666부터 숫자를 돌면서 1씩 증가시켜주고, 666이 포함되어있으면 카운트를 올림
//카운트랑 입력받은 N값이랑 같아지면 이떄의 숫자를 출력

public class Baekjoon_1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int num = 666;

//		while(cnt!=N) {
//			num++;			
//			if(Integer.toString(num).contains("666")) {
//				cnt++;				
//			}
//		}
//		System.out.println(num);

		while (cnt != N) {
			num++;
			int tmp = num;
			while (true) {
				if (tmp < 666) {
					break;
				}
				if (tmp % 1000 == 666) {
					cnt++;
					break;
				} else {
					tmp /= 10;
				}
			}

		}
		System.out.println(num);
	}
}

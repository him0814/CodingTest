package Baekjoon;

import java.io.*;
import java.util.*;

//백준 11501번 주식
//첫줄 테스트케이스의 수 T
//테스트케이스별 첫줄 -> 날의 수 N(1~백만)
//테스트케이스별 둘째줄 -> 날별 주가를 나타내는 N개의 자연수들이 공백으로 주어짐

//주식구매/판매/아무것도안함 위 세가지행동중 한행동을 매일 함
//이때 최대이익을 나타내는 정수 리턴

public class Baekjoon_11501 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int price[] = new int[N];
			for (int j = 0; j < N; j++) {
				price[j] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			long result = 0;
			// 10 7 6
			// 3 5 9 -> 10
			for (int k = N - 1; k >= 0; k--) { // 배열에 뒤에서부터 보면서
				if (max > price[k]) {// 맥스가 현재가격보다 크면 가격이 떨어진다는소리
					result += max - price[k];
				} else if (max < price[k]) {
					max = price[k];
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}

package Baekjoon;

import java.util.*;
import java.io.*;
//백준 11399번 ATM

//첫째줄에 도시개수 N
//둘째줄에 도로길이 N-1개의 자연수
//셋째줄에 도시마다 주유소의 리터당가격 N개의 자연수
//도시사이의 길이의 총합은 1~10억
//리터당가격은 1~10억이하의 자연수
//10억*10억 이니까 출력값은 double형으로 선언해야됨

public class Baekjoon_13305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int road[] = new int[N - 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N - 1; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		// 로드(렝스) -> 2 3 1

		int cost[] = new int[N - 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < N - 1; j++) {
			cost[j] = Integer.parseInt(st.nextToken());
		}
		// 코스트 -> 5 2 4

		long result = 0;
		long min = cost[0];
		for (int k = 0; k < N - 1; k++) {
			if (cost[k] < min) {
				min = cost[k];
			}
			result += min * road[k];
		}

		System.out.println(result);
	}
}

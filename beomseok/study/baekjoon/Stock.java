package baekjoon;
//주식 백준 11501

//주식 하나를 삼, 원하는 만큼 가지고 있는 주식을 팜, 아무것도 안함.
//위 세가지 중 한 행동을 함.
//날 별로 주식의 가격을 알려주었을 때, 최대 이익이 얼마나 되는지 계산.

//입력 첫 줄 테스트케이스 수 T
//테스트케이스 별로 첫 줄에는 날의 수를 나타내는 자연수 N(2 ≤ N ≤ 1,000,000)
//둘째 줄에는 날 별 주가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어짐.
//날 별 주가는 10,000이하

import java.io.*;
import java.util.*;

public class Stock {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> stockPrice = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				stockPrice.add(Integer.parseInt(st.nextToken()));
			}
			
			int maxPrice = 0;
			long profit = 0;
			for (int k=n-1; k>=0; k--) {
				if (stockPrice.get(k) > maxPrice) {
					maxPrice = stockPrice.get(k);
				} else {
					profit += (maxPrice - stockPrice.get(k));
				}
			}
			sb.append(profit + "\n");
		}
		System.out.println(sb);
	}
}

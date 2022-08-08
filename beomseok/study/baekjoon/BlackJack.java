package baekjoon;
//블랙잭 백준 2798

//첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100), M(10 ≤ M ≤ 300,000)
//둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수
//합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력
//첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력

import java.io.*;
import java.util.*;

public class BlackJack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer> al = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			al.add(Integer.parseInt(st.nextToken()));
		}
		int sum = 0;
		int tmp = 0;
		for (int j = 0; j < n; j++) {
			for (int k = j + 1; k < n; k++) {
				for (int l = k + 1; l < n; l++) {
					sum = al.get(j) + al.get(k) + al.get(l);
					if (tmp < sum && sum <= m) {
						tmp = sum;
					}
				}
			}
		}
		System.out.println(tmp);
	}
}

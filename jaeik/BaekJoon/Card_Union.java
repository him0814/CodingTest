package BaekJoon;

// 자연수가 쓰여진 카드를 n장
// 1. x번 카드와 y번 카드를 골라 그 두 장에 쓰여진 수를 더한 값을 계산, x != y
// 2. x= x+y, y=x+y
// 합체 총 m번후 n장의 카드에 쓰여있는 수를 모두 더한 값, 점수를 가장 작게 만드는 것이 목표
// 첫째 줄 2 <= n <= 100 와 합체 m
// 둘째 줄 카드 상태

import java.util.*;
import java.io.*;

public class Card_Union {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		long[] card = new long[n];
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		
		for(int i = 0; i < m; i++) {
			long tmp = card[0] + card[1];
			card[0] = tmp;
			card[1] = tmp;
			Arrays.sort(card);
		}
		long sum = 0;
		for(int i = 0; i < n; i++) {
			sum += card[i];
		}
		
		System.out.print(sum);
	}
}

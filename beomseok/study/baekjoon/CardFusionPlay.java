package baekjoon;
//카드 합체 놀이 백준 15903

//n: 자연수가 쓰여진 카드 장수
//i: i번 카드엔 ai
//x번 카드와 y번 카드를 골라 그 두 장에 쓰여진 수를 더한 값을 계산. (x ≠ y)
//계산한 값을 x번 카드와 y번 카드 두 장 모두에 덮어 씀.
//m번의 합체를 모두 끝낸 뒤, n장의 카드에 쓰여있는 수를 모두 더한 값의 최솟값 출력.

//첫 번째 줄에 카드의 개수를 나타내는 수 n(2 ≤ n ≤ 1,000)
//카드 합체를 몇 번 하는지를 나타내는 수 m(0 ≤ m ≤ 15*n)

import java.io.*;
import java.util.*;

public class CardFusionPlay {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Long> al = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			al.add(Long.parseLong(st.nextToken()));
		}
		
		for(int j=0; j<m; j++) {
			Collections.sort(al);
			long sum = al.get(0) + al.get(1);
			al.set(0, sum);
			al.set(1, sum);
		}
		
		long min = 0;
		for(int k=0; k<n; k++) {
			min += al.get(k);
		}
		System.out.println(min);
	}

}

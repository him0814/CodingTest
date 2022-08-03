package baekjoon;
//중복 빼고 정렬하기 백준 10867

import java.io.*;
import java.util.*;

//N개의 정수, 오름차순으로 정렬
//첫째 줄에 수의 개수 N (1 ≤ N ≤ 100,000)
//둘째 줄에 절댓값이 1,000보다 작거나 같은 정수

public class Sort_by_subtracting_duplicates {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();

		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		ArrayList<Integer> al = new ArrayList<>(set);
		Collections.sort(al);
		for (int num : al) {
			System.out.print(num + " ");
		}

	}
}

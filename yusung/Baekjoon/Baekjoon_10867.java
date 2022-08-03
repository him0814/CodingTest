package Baekjoon;

import java.util.*;
import java.io.*;

//백준 10867번 중복빼고정렬하기
//시간제한 1초
//첫째줄에 N개의 정수(최대 10만) 둘째줄에 숫자(절댓값이 1000이하인 정수)
//셋에 넣고 어레이리스트에 옮긴다음 정렬후 출력하면 될거같음

public class Baekjoon_10867 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Set<Integer> hs = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			int M = Integer.parseInt(st.nextToken());
			hs.add(M);
		}

		ArrayList<Integer> al = new ArrayList<>(hs);
		Collections.sort(al);
		for (int j : al) {
			sb.append(j + " ");
		}
		
		sb.setLength(sb.length() - 1);

		System.out.println(sb.toString());
	}
}

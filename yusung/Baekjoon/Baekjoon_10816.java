package Baekjoon;

import java.util.*;
import java.io.*;

//백준 10816번 숫자 카드2
//시간제한 1초 -> 데이터셋 10억개

public class Baekjoon_10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Map<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		for (int j = 0; j < M; j++) {
			int checkkey = Integer.parseInt(st.nextToken());
			if (map.containsKey(checkkey) == true) {
				sb.append(map.get(checkkey) + " ");
			} else {
				sb.append("0" + " ");
			}
		}
		sb.setLength(sb.length() - 1); // sb 마지막 공백제거
		System.out.println(sb.toString());

		// sb,setLength(0) SB초기화 새로 초기화하는 것보다 length(0)으로 초기화 하는게 더 빠름
	}
}

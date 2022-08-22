package Baekjoon;

import java.io.*;
import java.util.*;

//백준 11279번 최대 힙
//priority queue를 이용한 풀이

public class Baekjoon_11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//역정렬 -> 최대힙 내림차순정렬

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());			
			if (num == 0) {
				if (pq.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(pq.poll() + "\n");
				}
			}
			else {
				pq.offer(num);
			}
		}		
		System.out.println(sb.toString());
	}
}

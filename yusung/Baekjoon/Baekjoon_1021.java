package Baekjoon;

import java.util.*;
import java.io.*;

//백준 1021번 회전하는 큐

public class Baekjoon_1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> dq = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		int count = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			dq.offer(i);
		}

		int[] seq = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int idx_target = dq.indexOf(seq[i]);
			int idx_half;
			if (dq.size() % 2 == 0) {
				idx_half = dq.size() / 2 - 1;
			} else {
				idx_half = dq.size() / 2;
			}

			if (idx_target <= idx_half) {
				for (int j = 0; j < idx_target; j++) {
					int temp = dq.pollFirst();
					dq.offerLast(temp);
					count++;					
				}
			} else {
				for (int j = 0; j < dq.size() - idx_target; j++) {
					int temp = dq.pollLast();
					dq.offerFirst(temp);
					count++;
					
				}
			}
			dq.pollFirst();
		}
		System.out.println(sb.append(count).toString());
	}
}
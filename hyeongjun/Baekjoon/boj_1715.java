package BOJ;

/*
백준 #1715 카드 정렬하기
 */

import java.util.*;
import java.io.*;

public class boj_1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		int min = 0;
		while(pq.size() != 1) {
			int fst_q = pq.poll();
			int scd_q = pq.poll();
			int tmp = fst_q + scd_q;
			min += tmp;
			pq.offer(tmp);
		}
		
		System.out.println(min);
	}
}

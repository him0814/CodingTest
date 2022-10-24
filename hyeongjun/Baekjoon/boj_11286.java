package BOJ;

/*
백준 #11286 절댓값 힙
 */

import java.io.*;
import java.util.*;

public class boj_11286 {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer num1, Integer num2) {
				int n1 = Math.abs(num1);
				int n2 = Math.abs(num2);
				
				if(n1 == n2) {
					// 오름차순
					return num1 - num2;
				} else {
					// 오름차순
					return n1 - n2;
				}
			}
		});
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_cnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_cnt; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			if(tmp == 0) {
				if(!pq.isEmpty()) {
					sb.append(pq.poll()+"\n");
				} else {
					sb.append(0+"\n");
				}
			} else {
				pq.offer(tmp);
			}
		}
		
		System.out.println(sb.toString());
	}
}

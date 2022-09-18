package Baekjoon;

import java.io.*;
import java.util.*;

//백준 11279번 절대값 힙

public class Baekjoon_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {				
				if(Math.abs(o1) > Math.abs(o2)) {
					return 1;	// 바꿈 			
				}else if(Math.abs(o1) < Math.abs(o2)) {
					return -1; // 그대로냅둔다
				}else {
					if (o1 > o2) {
						return 1; // 바꿈
					} 
					else if (o1 < o2) {
						return -1; 	// 그대로 냅둔다
					} 
					else {
						return 0; //바꾸지않음
					}
				}
			}
		});

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
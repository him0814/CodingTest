package BOJ;

/*
백준 #11279 최대 힙
 */

import java.io.*;
import java.util.*;

public class boj_11279 {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
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

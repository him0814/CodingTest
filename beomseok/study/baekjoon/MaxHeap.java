package baekjoon;
//최대 힙 백준 11279

import java.io.*;
import java.util.*;

public class MaxHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(q.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(q.poll() + "\n");
				}
			} else {
				q.offer(num);
			}
		}
		System.out.println(sb);
	}
}

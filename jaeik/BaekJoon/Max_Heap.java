package BaekJoon;

import java.util.*;
import java.io.*;
public class Max_Heap {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			if(M == 0) {
				if(pq.isEmpty()) {
					sb.append("0").append("\n");
				}
				else {
					sb.append(pq.poll()).append("\n");
				}
			}
			else {
				pq.offer(M);
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}

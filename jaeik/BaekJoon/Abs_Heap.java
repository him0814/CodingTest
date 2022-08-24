package BaekJoon;

import java.util.*;
import java.io.*;

public class Abs_Heap {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> pq_neg = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			if(M == 0) {
				if(pq.isEmpty() && pq_neg.isEmpty()) {
					sb.append("0").append("\n");
				}
				else if(pq.isEmpty()){
					sb.append(pq_neg.poll()).append("\n");
				}
				else if(pq_neg.isEmpty()){
					sb.append(pq.poll()).append("\n");
				}
				else if(pq.peek() >= Math.abs(pq_neg.peek())){
					sb.append(pq_neg.poll()).append("\n");
				}
				else if(pq.peek() < Math.abs(pq_neg.peek())){
					sb.append(pq.poll()).append("\n");
				}
			}
			else if(M > 0) {
				pq.offer(M);
			}
			else if(M < 0) {
				pq_neg.offer(M);
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}

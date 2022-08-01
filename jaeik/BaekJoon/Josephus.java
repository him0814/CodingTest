package BaekJoon;

import java.util.*;
import java.io.*;

public class Josephus {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Deque<Integer> deq = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			deq.offer(i);
		}
		sb.append("<");
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < K; j++) {
				deq.offer(deq.poll());
			}
			sb.append(deq.poll() + ", ");
		}
		sb.append(deq.peek() + ">");
		System.out.print(sb);
	}
}
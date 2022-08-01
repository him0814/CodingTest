package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1158번 요세푸스

public class Baekjoon_1158 {
	public static void main (String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			dq.offer(i);
		}
		
		for(int j=0; j<N-1; j++) {
			for(int k=1; k<K; k++) {
			dq.offerLast(dq.poll());			
			}
			sb.append(dq.poll()+", ");
		}
		sb.append(dq.poll());
		System.out.println("<" + sb.toString() + ">");
	}
}

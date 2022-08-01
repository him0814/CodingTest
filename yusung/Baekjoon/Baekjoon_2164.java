package Baekjoon;

import java.io.*;
import java.util.*;

//백준 2164번 카드2

public class Baekjoon_2164 {
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i=1; i<=N ;i++) {
			dq.offer(i);
		}
		
		while(dq.size()!=1) {
		dq.pollFirst();
		int p = dq.poll();
		dq.offerLast(p);
		}
		
		System.out.println(sb.append(dq.poll()).toString());
	}
}

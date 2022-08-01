package BaekJoon;

import java.util.*;
import java.io.*;

public class lotate_que {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		
		Deque<Integer> deq = new ArrayDeque<>();
		for(int i = 1; i <= n; i++) {
			deq.offerLast(i);
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		for(int i = 1; i <= m; i++) {
			int x = Integer.parseInt(st2.nextToken());
			int count = 0;
			while(deq.peekFirst() != x) {
				deq.offer(deq.poll());
				count++;
			}
			int rcount = deq.size() - count;
			deq.pollFirst();
			if(count <= rcount) {
				sum += count;
			} else {
				sum += rcount;
			}
		}
		System.out.print(sum);
	}
}

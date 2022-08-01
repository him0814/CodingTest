package baekjoon;
//µ¦ ¹éÁØ 10866

//µ¦ ±¸Çö ¹®Á¦

import java.io.*;
import java.util.*;

public class Deque_example {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deq = new ArrayDeque<>(); 
		StringBuilder sb = new StringBuilder();
		
		while(N-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			switch(str) {
			case "push_front":
				deq.offerFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deq.offerLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(deq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(deq.pollFirst() + "\n");
				}break;
			case "pop_back":
				if(deq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(deq.pollLast() + "\n");
				}break;
			case "size":
				sb.append(deq.size() + "\n");
				break;
			case "empty":
				if(deq.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}break;
			case "front":
				if(deq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(deq.peekFirst() + "\n");
				} break;
			case "back":
				if(deq.isEmpty()) {
					sb.append(-1 + "\n");
				}else {
					sb.append(deq.peekLast()+ "\n");
				} break;
			}
		}
		System.out.println(sb);
	}
}

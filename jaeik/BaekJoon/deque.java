package BaekJoon;

import java.util.*;
import java.io.*;

public class deque {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deq = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			if(str.equals("push_front")) {
				deq.offerFirst(Integer.parseInt(st.nextToken()));
			} else if(str.equals("push_back")){
				deq.offerLast(Integer.parseInt(st.nextToken()));
			} else if(str.equals("pop_front")){
				if(deq.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deq.pollFirst()).append("\n");
				}
			} else if(str.equals("pop_back")){
				if(deq.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deq.pollLast()).append("\n");
				}
			} else if(str.equals("size")){
				sb.append(deq.size()).append("\n");
			} else if(str.equals("empty")){
				if(deq.isEmpty()) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			} else if(str.equals("front")){
				if(deq.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deq.peekFirst()).append("\n");
				}
			} else if(str.equals("back")){
				if(deq.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deq.peekLast()).append("\n");
				}
			}
		}
		System.out.print(sb.toString());
	}
}

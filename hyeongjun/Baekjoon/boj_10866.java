package BOJ;

import java.io.*;
import java.util.*;

public class boj_10866 {
	
	public static void main (String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> deque = new ArrayDeque<>();
				
		int testnum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testnum; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
		
			switch (command) {
				case "push_front":
					int offerF = Integer.parseInt(st.nextToken());
					deque.offerFirst(offerF);
					break;
					
				case "push_back":
					int offerB = Integer.parseInt(st.nextToken());
					deque.offerLast(offerB);
					break;
					
				case "pop_front":
					if(deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						int pollF = deque.pollFirst();
						sb.append(pollF).append("\n");						
					}		
					break;
					
				case "pop_back":
					if(deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						int pollB = deque.pollLast();
						sb.append(pollB).append("\n");
					}	
					break;
					
				case "size":
					int dequeSize = deque.size();
					sb.append(dequeSize).append("\n");
					break;
					
				case "empty":
					if(deque.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
					
				case "front":
					if(deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						int peekF = deque.peekFirst();
						sb.append(peekF).append("\n");
					}
					break;
					
				case "back":
					if(deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						int peekB = deque.peekLast();
						sb.append(peekB).append("\n");
					}
					break;
			}
		}
			
		System.out.println(sb.toString());
		
	}
}

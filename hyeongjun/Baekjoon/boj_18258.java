package study1;

import java.io.*;
import java.util.*;

public class boj_18258 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		
		int testcnt = Integer.parseInt(br.readLine());
		int last = 0;
		
		// switch()µµ °¡´É
		for(int i = 0; i < testcnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
						
			if(str.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
				last = num;
			} else if (str.equals("pop")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					int poll = queue.poll();
					sb.append(poll).append("\n");
				}
			} else if (str.equals("size")) {
				int size = queue.size();
				sb.append(size).append("\n");
			} else if (str.equals("empty")) {
				if(queue.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (str.equals("front")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					int frtnum = queue.peek();
					sb.append(frtnum).append("\n");
				}
			} else if(str.equals("back")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(last).append("\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
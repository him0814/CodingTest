package study1;

import java.io.*;
import java.util.*;

public class boj_10828 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int testcnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testcnt; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			
			switch(command) {
				case "push":
					int pushnum = Integer.parseInt(st.nextToken());
					stack.push(pushnum);
					break;
					
				case "pop":
					if(stack.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						int popnum = stack.pop();
						sb.append(popnum).append("\n");
					}
					break;
					
				case "size":
					int sizenum = stack.size();
					sb.append(sizenum).append("\n");
					break;
					
				case "empty":
					if(stack.isEmpty()) {
						sb.append(1).append("\n");;
					} else {
						sb.append(0).append("\n");
					}
					break;
					
				case "top":
					if(stack.isEmpty()) {
						sb.append(-1).append("\n");;
					} else {
						int topnum = stack.peek();
						sb.append(topnum).append("\n");
					}
					break;
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
}

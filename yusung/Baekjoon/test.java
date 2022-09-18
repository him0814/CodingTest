package Baekjoon;

import java.io.*;
import java.util.*;

public class test {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			
			if(str.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}
			else if(str.equals("pop")) {
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {					
					sb.append(stack.pop()).append("\n");
				}
			}
			else if(str.equals("size")) {
				int size = stack.size();
				sb.append(size).append("\n");
			}
			else if(str.equals("empty")) {
				if(stack.size() == 0) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			}
			else if(str.equals("top")) {
				if(stack.size() == 0) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(stack.peek()).append("\n");
				}
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}

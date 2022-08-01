package Baekjoon;

import java.io.*;
import java.util.Stack;

//백준 9012번 괄호

public class Baekjoon_9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (c == '(') {
					stack.push(c);
				} else {
					if (stack.size() == 0) {
						stack.push(c);
						break;
					} else {
						stack.pop();
					}
				}
			}
			if (stack.isEmpty()) {				
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");				
			}	
			stack.clear();
		}		
		System.out.println(sb.toString());
	}
}

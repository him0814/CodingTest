package BOJ;

/*
백준 #9935 문자열 폭발

 */

import java.io.*;
import java.util.*;

public class boj_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		String boom = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			
			// stack.size() 가 boom.lenth()보다 길면 boom 단어를 가지고 있음
			if(stack.size() >= boom.length()) {
				boolean flag = true;
				for(int j = 0; j < boom.length(); j++) {
					// boom 단어 없으면 
					if(stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				// boom 단어 가지고 있으면
				if(flag) {
					for(int j = 0; j < boom.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		for(char c: stack) {
			sb.append(c);
		}
		
		if(sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb.toString());
		}
	}
}

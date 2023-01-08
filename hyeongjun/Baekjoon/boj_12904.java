package BOJ;

/*
백준 #12904 a와b

@ stringbuilder 자르기
	stringbuilder -> sb.setLength(길이)
	sb.setLength(0) -> stringbuilder(0) 초기화
	
@ stringbuilder 뒤집기
	sb.reverse();

@ string 자르기
	str.substring(0, 1);
 */

import java.io.*;
import java.util.*;

public class boj_12904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();
		
		String s = br.readLine();
		String t = br.readLine();
		
		for(int i = 0; i < t.length(); i++) {
			stack.add(t.charAt(i));
		}
		//System.out.println(1);
		while(s.length() < t.length()) {
			if(t.charAt(t.length()-1) == 'A') {
				if(!stack.isEmpty()) {
					stack.pop();
					t = t.substring(0,t.length()-1);
				}
			} else if(t.charAt(t.length()-1) == 'B') {
				String tmp = "";
				// 마지막 b를 없애고 
				if(!stack.isEmpty()) {
					stack.pop();
				}
				// 단어 뒤집기
				// stack -> AB
				// tmp -> BA
				while(!stack.isEmpty()) {
					tmp += stack.pop();
				}
				t = tmp;
				for(int i = 0; i < tmp.length(); i++) {
					stack.add(tmp.charAt(i));
				}
			}
		}
		//System.out.println(11);
		
		if(t.equals(s)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}

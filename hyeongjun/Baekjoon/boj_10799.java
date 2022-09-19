package BOJ;

/*
백준 #10799
쇠막대기 문제
괄호 문제랑 맥락 똑같음
 */

import java.io.*;
import java.util.*;

public class boj_10799 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		int count = 0;
				
		for(int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			if(str.charAt(i) == '(') {
				stack.push('(');
			} else {
				if(!stack.isEmpty()) {
					stack.pop();
				}
				
				if(now == str.charAt(i-1)) { // '))' 일 때는 1개 생기기때문 
					count++;
				} else {
					count += stack.size();
				}
			}
		}
		System.out.println(count);
	}
}

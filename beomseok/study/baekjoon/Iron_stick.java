package baekjoon;
//쇠막대기 백준 10799

//기존 스택이용한 괄호 문제와 비슷
//레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( )’ 으로 표현 
//모든 ‘( )’는 반드시 레이저를 표현

import java.io.*;
import java.util.*;

public class Iron_stick {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		int cnt = 0;
		
		for (int i=0; i<str.length(); i++) {
			char p = str.charAt(i);
			if(p == '(') {
				stack.push(p);
			} else if(p == ')') {
				stack.pop();
				if(str.charAt(i-1) == '(') {
					cnt += stack.size();
				} else {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}

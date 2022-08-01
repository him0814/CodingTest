package baekjoon;
//백준 괄호 9012

//괄호가 올바른 상태가 VPS
//VPS인 괄호에 문자열 x를 넣어도 VPS
//VPS x에 y를 접합시켜도 VPS
// --> 괄호의 짝이 모두 맞아야 VPS

//첫번째 줄: 테스트 데이터 T
//그 이후 : T만큼 줄, 2 <= 괄호 문자열 길이 <= 50 
// --> 여는 괄호 push, 닫는 괄호 pop


import java.io.*;
import java.util.*;

public class Parenthesis {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			String string = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for(int j=0; j<string.length(); j++){
				char p = string.charAt(j);
				if(p == '(') {
					stack.push(p);
				} else if(stack.empty()) {
					stack.push(p);
					break;
				}
				else
					stack.pop();
			}
			if(stack.empty())
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}
}

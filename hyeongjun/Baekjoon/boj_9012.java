package BOJ;

import java.util.*;
import java.io.*;

public class boj_9012 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testcnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testcnt; i++) {
			
			Stack<Character> stack = new Stack<>(); // �� Stack �������̽�, �� Stack Ŭ����, <> ���׸�(����ȯ ������ ���ʿ� �����ϴ�..)
			String str = br.readLine();
			
			for(int j = 0; j < str.length(); j++) {
				// char �� ' ' 
				if(str.charAt(j) == '(') {
					stack.push(str.charAt(j));
				} else {
					if(stack.isEmpty()) {
						stack.push(str.charAt(j));
					} else {
						if(stack.peek() == '(') {
							stack.pop();
						} else {
							stack.push(str.charAt(j));
						}
					}
				}
			}
			
			if(stack.size() == 0) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
			
		}
				
		System.out.println(sb.toString());
		
	}
}
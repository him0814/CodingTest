package BOJ;

/*
���� #9935 ���ڿ� ����

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
			
			// stack.size() �� boom.lenth()���� ��� boom �ܾ ������ ����
			if(stack.size() >= boom.length()) {
				boolean flag = true;
				for(int j = 0; j < boom.length(); j++) {
					// boom �ܾ� ������ 
					if(stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				// boom �ܾ� ������ ������
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

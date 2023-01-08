package BOJ;

/*
���� #12904 a��b

@ stringbuilder �ڸ���
	stringbuilder -> sb.setLength(����)
	sb.setLength(0) -> stringbuilder(0) �ʱ�ȭ
	
@ stringbuilder ������
	sb.reverse();

@ string �ڸ���
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
				// ������ b�� ���ְ� 
				if(!stack.isEmpty()) {
					stack.pop();
				}
				// �ܾ� ������
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

package BOJ;

/*
���� #17413
�ܾ������ 2
���ڿ� S�� �޴´�
S�� �ҹ���, ����, ����, Ư������ < >���θ� �̷����
<> ���� �ܾ�� �״�� ��� �������� �ܾ� ������ ���
 */

import java.io.*;
import java.util.*;

public class boj_17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		
		String sentence = br.readLine();
		
		int standard = 1; //true false
		
		for (int i = 0; i < sentence.length(); i++) {
			if(sentence.charAt(i) == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				standard = 0;
			} else if(sentence.charAt(i) == '>') {
				standard = 1;
				sb.append(">");
				continue;
			}
						
			if(standard == 0) {
				sb.append(sentence.charAt(i));
			} else if (standard == 1) {
				if(sentence.charAt(i) == ' ') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(" ");
					stack.clear();
				} else {
					stack.add(sentence.charAt(i));
				}
			}
			
			if (i == sentence.length() - 1) {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			}
		}
		System.out.println(sb.toString());
	}
}
